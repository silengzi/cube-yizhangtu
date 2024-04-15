<template>
  <div
    id="map"
    class="map"
  ></div>
</template>

<script>
import Map from 'ol/Map.js';
import OSM from 'ol/source/OSM.js';
import TileLayer from 'ol/layer/Tile.js';
import View from 'ol/View.js';
export default {
  name: 'Map',
  mounted() {
    this.initMap()
  },
  methods: {
    initMap() {
      // 天地图密钥
      let key = '82e71d5db720df2f8151b77b76a720c9'
  
      // _w表示球面墨卡托投影，_c表示经纬度投影
      // 如img_w：影像底图球面墨卡托投影，img_c：影像底图经纬度投影
      var img_w = new ol.layer.Tile({
        title: '影像图',
        source: new ol.source.XYZ({
          url: "http://t{0-7}.tianditu.gov.cn/DataServer?T=img_w&x={x}&y={y}&l={z}&tk=" + key + "",
        })
      })
  
      var cia_w = new ol.layer.Tile({
        title: "影像图文字标注",
        source: new ol.source.XYZ({
          url: "http://t{0-7}.tianditu.gov.cn/DataServer?T=cia_w&x={x}&y={y}&l={z}&tk=" + key + "",
        }),
      });
  
      let view = new ol.View({
        center: ol.proj.fromLonLat([116.4074, 39.9042]),
        zoom: 12,
        // minZoom: 12,
        // maxZoom: 18.5,
      })
  
      let map = new ol.Map({
        target: 'map',
        // layer: [img_w, cia_w],
        // view: view,
      })
      map.addLayer(img_w)
      map.addLayer(cia_w)
      map.setView(view)
    },
  }
};
</script>

<style scoped lang="less">
.map {
  width: 100%;
  height: calc(100vh - 67px);
}
</style>
