<template>
  <div class="home">
    <div class="legend">
      <dv-border-box-12 backgroundColor="rgb(4, 47, 84, 0.7)">
        <span>图例</span>
      </dv-border-box-12>
    </div>
  </div>
</template>

<script>
export default {
  name: "Legend",
  components: {},
  data() {
    return {};
  },
  methods: {},
};
</script>

<style lang="less" scoped>
.legend {
  position: relative;
  .dv-border-box-12 {
    width: 200px;
    height: 150px;
    z-index: 2;
    position: absolute;
    top: calc(100vh - 220px);
    left: 20%;

    span {
      color: #fff;
      position: absolute;
      top: 15px;
      left: 18px;
    }
  }
}
</style>
