<template>
  <div id="map" class="map"></div>
</template>

<script>
import Map from 'ol/Map.js';
import OSM from 'ol/source/OSM.js';
import TileLayer from 'ol/layer/Tile.js';
import View from 'ol/View.js';
export default {
  name: 'Map',
  mounted() {
    const map = new Map ({
        layers: [
            new TileLayer({
                source: new OSM()
            })
        ],
        target: 'map',
        view: new View({
            center: [12951000, 4853000],
            zoom: 11
        })
    })
  }
};
</script>

<style scoped lang="less">
    .map {
        width: 100%;
        height: calc(100vh - 67px);
    }
</style>
