<template>
  <div
    id="map"
    class="map"
  ></div>
</template>

<script>
import Map from 'ol/Map.js';
import XYZ from 'ol/source/XYZ.js';
import TileLayer from 'ol/layer/Tile.js';
import VectorLayer from 'ol/layer/Vector.js';
import VectorSource from 'ol/source/Vector.js';
import View from 'ol/View.js';
import { fromLonLat } from "ol/proj"
import { WKT } from 'ol/format'
import { reqLayerList } from '@/api/index'

// 定义所有需要加载图层列表接口的类型数组
const ALL_TYPE = ["云台", "卡口", "摄像头", "红外相机", "声光报警器", "气体检测器", "无人机", "野生动物", "野生植物", "火灾告警", "非法活动", "乔木", "灌木", "草本"]
export default {
  name: 'Map',
  data() {
    return {
      checkList: [],
      layerListSource: null,  // 该变量用于专门加载图层列表的数据
    }
  },
  mounted() {
    this.initMap()

    // 接收图层列表修改事件
    this.$EventBus.$on("handleChangeLayer", (checkList) => {
      this.checkList = JSON.parse(JSON.stringify(checkList))
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
      // map.addLayer(img_w)
      // map.addLayer(cia_w)
      // map.setView(view)

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
    },

    handleChangeLayer() {
      // 先清除一下所有点（这样就不需要判断取消勾选了哪个，直接把所有的点都删掉就行了，省事）
      this.clearPoints()

      // 再加载勾选的图层
      // 判断是否勾选了需要加载接口的图层
      if (ALL_TYPE.some(item => this.checkList.includes(item))) {
        // 调用接口获取图层数据
        const params = {
          type: '无人机',
        }
        reqLayerList(params).then(res => {
          if (res.data.status == 1) {
            const data = res.data.data
            data.forEach(item => {
              this.createPoint(item)
            })
          }
        })
      }
    },

    /* 
      地图打点
    */
    createPoint(item) {
      // 使用 ol.format.WKT 解析 WKT 数据
      const wktFormat = new WKT()
      const pointFeature = wktFormat.readFeature(item.the_geom, {
        dataProjection: 'EPSG:4326',
        featureProjection: 'EPSG:3857',
      })
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
      console.log(feature)
      console.log(feature.getProperties())
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
