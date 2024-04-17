<template>
  <div class="home">
    <div class="legend">
      <dv-border-box-12 backgroundColor="rgb(4, 47, 84, 0.7)">
        <div class="title">图例</div>
        <div
          class="legend-item"
          v-for="item in radioList"
          :key="item"
          v-show="checkList.includes(item)"
        ><i class="icon"><img
              :src="require('@/assets/legend/' + item + '.png')"
              alt=""
            ></i><span>{{ item }}</span></div>
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
      radioList: ['云台', '卡口', '摄像头', '红外相机', '声光报警器', '气体检测器', '无人机', '野生动物', '野生植物', '火灾告警', '非法活动', '乔木', '灌木', '草本'],
      checkList: [], // 勾选的图层，需要显示对应的图例
    };
  },
  methods: {},
  mounted() {
    // 接收
    this.$EventBus.$on("handleChangeLayer", (layerList) => {
      console.log(layerList, "layerList")
      this.checkList = JSON.parse(JSON.stringify([...layerList.baseLayer, layerList.radio]))
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
