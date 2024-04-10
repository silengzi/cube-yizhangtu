<template>
  <div>
    <!-- <LayerList /> -->
    <AMap />
  </div>
</template>

<script>
import LayerList from "./components/Layer.vue"
import AMap from "./components/AMap.vue"
export default {
  components: {
    LayerList,
    AMap
  }
}
</script>
