<template>
  <div class="legend">
    <!-- 仅有一个-底图 时，也不显示图例 -->
    <dv-border-box-12
      backgroundColor="rgb(4, 47, 84, 0.7)"
      v-show="!(checkList.length == 1 && checkList[0] == '底图')"
    >
      <div class="title">图例</div>
      <div
        class="legend-item"
        v-for="item in legendList"
        :key="item.name"
        v-show="checkList.includes(item.name)"
      >
        <div
          class="legend-polygon"
          v-if="item.type == 'polygon'"
        >
          <i :style="{'border': `1px solid ${item.color}`}"></i>
          <span>{{item.name}}</span>
        </div>
        <div
          class="legend-line"
          v-else-if="item.type == 'line'"
        >
          <i :style="{'background-color': item.color}"></i>
          <span>{{item.name}}</span>
        </div>
        <div
          class="legend-polygon-fill"
          v-else-if="item.type == 'polygon-fill'"
        >
          <i :style="{'background-color': item.color}"></i>
          <span>{{item.name}}</span>
        </div>
        <div
          class="legend-icon"
          v-else-if="item.type == 'radio'"
        >
          <i class="icon">
            <img
              :src="require('@/assets/legend/' + item.url + '.png')"
              alt=""
            >
          </i>
          <span>{{item}}</span>
        </div>
      </div>
    </dv-border-box-12>
  </div>
</template>

<script>
export default {
  name: '',
  data() {
    return {
      checkList: [],   // 勾选的图层，需要显示对应的图例
      legendList: [
        {name: "行政区", type: "polygon", color: "#56b7ff"},
        {name: "路网", type: "line", color: "#56b7ff"},
        { name: "林区", type: "polygon-fill", color: "#4e9b16" },
        { name: "巡护员", type: "radio", url: "巡护员" },
        { name: "巡护路线", type: "line", color: "#7bfb7b" },
        { name: "巡护区域", type: "polygon-fill", color: "#90c11e" },
        { name: "云台", type: "radio", url: "云台" },
        { name: "卡口", type: "radio", url: "卡口" },
        { name: "摄像头", type: "radio", url: "摄像头" },
        { name: "红外相机", type: "radio", url: "红外相机" },
        { name: "声光报警器", type: "radio", url: "声光报警器" },
        { name: "气体检测器", type: "radio", url: "气体检测器" },
        { name: "无人机", type: "radio", url: "无人机" },
        { name: "野生动物", type: "radio", url: "野生动物" },
        { name: "野生植物", type: "radio", url: "野生植物" },
        { name: "火灾告警", type: "radio", url: "火灾告警" },
        { name: "非法活动", type: "radio", url: "非法活动" },
        { name: "乔木", type: "radio", url: "乔木" },
        { name: "灌木", type: "radio", url: "灌木" },
        { name: "草本", type: "radio", url: "草本" },
      ]
    };
  },
  methods: {},
  mounted() {
    // 接收
    this.$EventBus.$on("handleChangeLayer", (checkList) => {
      // console.log(layerList, "layerList")
      // this.checkList = JSON.parse(JSON.stringify([...layerList.basicLayer, layerList.patrol, layerList.monitor, layerList.protect, layerList.alarm, layerList.plant]))
      this.checkList = JSON.parse(JSON.stringify(checkList))
    })
  },
  beforeDestroy() {
    this.$EventBus.$off("handleChangeLayer") // 销毁
  }
};
</script>

<style scoped lang="less">
.legend {
  position: relative;
  .dv-border-box-12 {
    width: 200px;
    height: 150px;
    z-index: 2;
    position: absolute;
    top: calc(100vh - 257px);
    left: 20%;
    color: #fff;
    padding: 20px;

    .title {
      height: 30px;
    }

    .legend-item {
      margin-top: 5px;
      .icon {
        vertical-align: middle;
        img {
          width: 20px;
          height: 20px;
          margin-right: 10px;
        }
      }
    }
  }
}
</style>
