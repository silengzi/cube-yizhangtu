<template>
  <div
    id="map"
    class="map"
  >
    <Popup
      ref="popup"
      :popupData="popupData"
    ></Popup>
  </div>
</template>

<script>
import Map from 'ol/Map.js';
import XYZ from 'ol/source/XYZ.js';
import TileLayer from 'ol/layer/Tile.js';
import VectorLayer from 'ol/layer/Vector.js';
import VectorSource from 'ol/source/Vector.js';
import View from 'ol/View.js';
import { Style, Icon } from 'ol/style.js'
import { fromLonLat } from "ol/proj"
import { WKT } from 'ol/format'
import Overlay from 'ol/Overlay.js';

import { reqLayerList } from '@/api/index'

import Popup from './Popup.vue'

// 定义所有需要加载图层列表接口的类型数组
const ALL_TYPE = ["云台", "卡口", "摄像头", "红外相机", "声光报警器", "气体检测器", "无人机", "野生动物", "野生植物", "火灾告警", "非法活动", "乔木", "灌木", "草本"]
export default {
  name: 'Map',
  components: { Popup },
  data() {
    return {
      checkList: [],
      layerListSource: null,  // 该变量用于专门加载图层列表的数据
      map: null,  //  地图
      overlay: null,  //  弹窗
      popupData: null,  // 弹窗数据
    }
  },
  mounted() {
    this.initMap()

    // 接收图层列表修改事件
    this.$EventBus.$on("handleChangeLayer", (checkList) => {
      this.checkList = JSON.parse(JSON.stringify(checkList))
      // console.log(this.checkList)
      this.handleChangeLayer()
    })
  },
  methods: {
    initMap() {
      // 天地图密钥
      let key = '82e71d5db720df2f8151b77b76a720c9'

      // _w表示球面墨卡托投影，_c表示经纬度投影
      // 如img_w：影像底图球面墨卡托投影，img_c：影像底图经纬度投影
      var img_w = new TileLayer({
        title: '影像图',
        source: new XYZ({
          url: "http://t{0-7}.tianditu.gov.cn/DataServer?T=img_w&x={x}&y={y}&l={z}&tk=" + key + "",
        })
      })

      var cia_w = new TileLayer({
        title: "影像图文字标注",
        source: new XYZ({
          url: "http://t{0-7}.tianditu.gov.cn/DataServer?T=cia_w&x={x}&y={y}&l={z}&tk=" + key + "",
        }),
      });

      let view = new View({
        center: fromLonLat([116.4074, 39.9042]),
        zoom: 12,
        // minZoom: 12,
        // maxZoom: 18.5,
      })

      let map = new Map({
        target: 'map',
        layers: [img_w, cia_w],
        view: view,
      })
      this.map = map
      // map.addLayer(img_w)
      // map.addLayer(cia_w)
      // map.setView(view)

      this.createOverlay()

      // 创建一个向量源并添加特性
      const layerListSource = new VectorSource({
        features: []
      })
      // 创建一个向量图层
      const layerListLayer = new VectorLayer({
        source: layerListSource,
      })
      map.addLayer(layerListLayer)  // 添加图层到地图（该图层并没有添加任何数据，是用来添加后续的图层列表勾选加载的点位数据的）
      this.layerListSource = layerListSource

      // 添加点击事件监听器
      map.on('singleclick', (evt) => {
        // 获取点击位置的要素
        const feature = map.forEachFeatureAtPixel(evt.pixel, function (feature) {
          return feature
        })

        // 如果点击位置有要素
        if (feature) {
          // 获取要素的属性
          const properties = feature.getProperties()
          // console.log(properties)
          this.popupData = properties

          const coordinate = evt.coordinate

          this.overlay.setPosition(coordinate)
        } else {
          this.$refs.popup.show = false
        }
      })
    },

    /* 
      给地图加弹窗
    */
    createOverlay() {
      const container = this.$refs.popup.$el

      const overlay = new Overlay({
        element: container,
        autoPan: {
          animation: {
            duration: 250,
          }
        }
      })
      this.overlay = overlay
      this.map.addOverlay(overlay)
    },

    handleChangeLayer() {
      // 先清除一下所有点（这样就不需要判断取消勾选了哪个，直接把所有的点都删掉就行了，省事）
      this.clearPoints()

      // 再加载勾选的图层
      this.checkList.forEach(layerType => {

        // 判断是否勾选了需要加载接口的图层
        if (ALL_TYPE.some(item => item == layerType)) {
          // 调用接口获取图层数据
          const params = {
            type: layerType,
          }
          console.log(params)
          reqLayerList(params).then(res => {
            if (res.data.status == 1) {
              const data = res.data.data
              data.forEach(item => {
                this.createPoint(item)
              })
            }
          })
        }
      })
    },

    /* 
      地图打点
    */
    createPoint(item) {
      // 使用 ol.format.WKT 解析 WKT 数据
      const wktFormat = new WKT()
      const pointFeature = wktFormat.readFeature(item.the_geom, {
        dataProjection: 'EPSG:4326',  // WKT 数据的坐标系
        featureProjection: 'EPSG:3857', // 地图使用的坐标系
      })

      // 遍历 item 对象的所有属性，并将它们赋值给点要素
      for (const key in item) {
        if (item.hasOwnProperty(key) && key != 'the_geom') {
          pointFeature.set(key, item[key])
        }
      }

      pointFeature.setStyle(this.getStyle(pointFeature))

      this.layerListSource.addFeature(pointFeature)
    },
    /* 
      清除图层列表加载的所有点
    */
    clearPoints() {
      this.layerListSource.clear()
    },
    /* 
      获取要素打点所需的样式(图标)
    */
    getStyle(feature) {
      // 获取该要素的 'type' 属性值
      const type = feature.get('type')

      // 创建并返回一个新的样式
      return new Style({
        image: new Icon({
          anchor: [0.5, 1],
          scale: 0.15,
          src: require(`@/assets/legend/${type}.png`)
        })
      })
    }
  }
};
</script>

<style scoped lang="less">
.map {
  width: 100%;
  height: calc(100vh - 67px);
}
</style>
