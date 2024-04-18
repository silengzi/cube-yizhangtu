<template>
  <div>
    <!-- <LayerList /> -->
    <!-- <Legend /> -->
    <AMap />
  </div>
</template>

<script>
import LayerList from "./components/Layer.vue" // 图层列表
import Legend from "./components/Legend.vue" // 图例
import AMap from "./components/AMap.vue"
export default {
  components: {
    LayerList,
    Legend,
    AMap
  }
}
</script>
