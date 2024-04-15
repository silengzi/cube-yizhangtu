<template>
  <div class="home">
    <div class="legend">
      <dv-border-box-12 backgroundColor="rgb(4, 47, 84, 0.7)">
        <div class="title">图例</div>
        <div class="legend-item" v-if="radio == '野生动物'"><i class="icon"><img src="~@/assets/legend/野生保护动物.png" alt=""></i><span>野生动物</span></div>
        <div class="legend-item" v-if="radio == '野生植物'"><i class="icon"><img src="~@/assets/legend/野生保护植物.png" alt=""></i><span>野生植物</span></div>
      </dv-border-box-12>
    </div>
  </div>
</template>

<script>
export default {
  name: "Legend",
  components: {},
  data() {
    return {
      radio: '', // 单选
    };
  },
  methods: {},
  mounted() {
    // 接收
    this.$EventBus.$on("handleChangeLayer", (layerList) => {
      console.log(layerList, "layerList")
      this.radio = layerList.radio
    })
  },
  beforeDestroy() {
    this.$EventBus.$off("handleChangeLayer") // 销毁
  }
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
    color: #fff;
    padding: 20px;

    .title {
      // position: absolute;
      // top: 15px;
      // left: 18px;
      height: 30px;
    }

    .legend-item {
      margin-top: 5px;
      i {
        vertical-align: middle;
        img {
          width: 20px;
          height: 20px;
          margin-right: 10px;
        }
      }
      span {
        // display: inline-block;
        // height: 30px;
        // line-height: 30px;
      }
    }
  }
}
</style>
