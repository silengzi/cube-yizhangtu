<template>
  <div class="layerList">
    <dv-border-box-12
      class="mask"
      backgroundColor="rgb(4, 47, 84, 0.7)"
    >
      <div>
        <div class="title">
          <img
            src="@/assets/layers.png"
            alt=""
          >
          <span>图层列表</span>
        </div>
        <div class="layerContent">
          <el-collapse v-model="layerName">
            <el-collapse-item
              class="item"
              title="基础图层"
              name="1"
            >
              <el-checkbox-group v-model="basicLayer">
                <el-checkbox
                  label="底图"
                  checked
                ></el-checkbox>
                <el-checkbox
                  label="行政区"
                  checked
                ></el-checkbox>
                <el-checkbox
                  label="路网"
                  checked
                ></el-checkbox>
                <el-checkbox
                  label="林区"
                  checked
                ></el-checkbox>
              </el-checkbox-group>
            </el-collapse-item>
            <el-collapse-item
              class="item"
              title="巡护"
              name="2"
            >
              <el-radio-group v-model="patrol" @change="handleChangePatrolLayer">
                <el-radio label="巡护员"></el-radio>
                <el-radio label="巡护路线"></el-radio>
                <el-radio label="巡护区域"></el-radio>
              </el-radio-group>
            </el-collapse-item>
            <el-collapse-item
              class="item"
              title="监控设备"
              name="3"
            >
              <el-radio-group v-model="monitor" @change="handleChangeMonitorLayer">
                <el-radio label="云台"></el-radio>
                <el-radio label="卡口"></el-radio>
                <el-radio label="摄像头"></el-radio>
                <el-radio label="红外相机"></el-radio>
                <el-radio label="声光报警器"></el-radio>
                <el-radio label="气体检测器"></el-radio>
                <el-radio label="无人机"></el-radio>
              </el-radio-group>
            </el-collapse-item>
            <el-collapse-item
              class="item"
              title="动植物保护"
              name="4"
            >
              <el-radio-group v-model="protect" @change="handleChangeProtectLayer">
                <el-radio label="野生动物"></el-radio>
                <el-radio label="野生植物"></el-radio>
              </el-radio-group>
            </el-collapse-item>
            <el-collapse-item
              class="item"
              title="告警"
              name="5"
            >
              <el-radio-group v-model="alarm" @change="handleChangeAlarmLayer">
                <el-radio label="火灾告警"></el-radio>
                <el-radio label="非法活动"></el-radio>
              </el-radio-group>
            </el-collapse-item>
            <el-collapse-item
              class="item"
              title="古树名木"
              name="6"
            >
              <el-radio-group v-model="plant" @change="handleChangePlantLayer">
                <el-radio label="乔木"></el-radio>
                <el-radio label="灌木"></el-radio>
                <el-radio label="草本"></el-radio>
              </el-radio-group>
            </el-collapse-item>
          </el-collapse>
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
      layerName: ['1'],
      basicLayer: [], // 基础图层
      patrol: '', // 巡护
      monitor: '', // 监控
      protect: '', // 动植物保护
      alarm: '', // 告警
      plant: '', // 古树名木
    };
  },
  methods: {
    // 监听所有图层的修改
    handleChangeLayer() {
      const layerList = {
        basicLayer: this.basicLayer,
        patrol: this.patrol,
        monitor: this.monitor,
        protect: this.protect,
        alarm: this.alarm,
        plant: this.plant,
      }
      this.$EventBus.$emit("handleChangeLayer", layerList)
    },
    /**
     * 用于处理图层类别修改
     * @param {*} val
     */
    handleChangePatrolLayer(val) {
      this.handleChangeLayer()
    },
    handleChangeMonitorLayer(val) {
      this.handleChangeLayer()
    },
    handleChangeProtectLayer(val) {
      this.handleChangeLayer()
    },
    handleChangeAlarmLayer(val) {
      this.handleChangeLayer()
    },
    handleChangePlantLayer(val) {
      this.handleChangeLayer()
    },
    // 处理修改基础图层
    handleChangeBasicLayer(layers) {
      // console.log('选择了:', layers)
      this.handleChangeLayer()
    }
  }
};
</script>

<style scoped lang="less">
.layerList {
  z-index: 2;
  position: absolute;
  top: 67px;
  left: calc(100vw - 20% - 220px);
  width: 200px;
  height: 500px;
  .dv-border-box-12 {
    padding: 10px;
    .title {
      height: 30px;
      display: flex;
      justify-content: left;
      align-items: center;
      img {
        height: 100%;
      }
      span {
        margin-left: 5px;
        color: #fff;
      }
    }
    .layerContent {
      width: 100%;

      .el-collapse {
        border-bottom: 0;
        margin-top: 10px;
        padding: 10px;

        .el-checkbox-group,
        .el-radio-group {
          margin-left: 10px;
        }
      }
      ::v-deep .el-collapse-item__content {
        padding-bottom: 0;
      }
      ::v-deep .el-collapse-item__header {
        color: #fff;
        background-color: transparent; // 背景色变为透明，即不显示任何颜色
        border-bottom: none;
        font-size: 16px;
        height: 30px;
      }
      ::v-deep .el-collapse-item__wrap {
        background-color: transparent; // 背景色变为透明，即不显示任何颜色
        border-bottom: none;
      }
      ::v-deep .el-checkbox__label {
        color: #fff;
        font-size: 15px;
      }
      ::v-deep .el-checkbox__input.is-checked + .el-checkbox__label {
        color: #409eff;
      }
      ::v-deep .el-checkbox,
      .el-checkbox__input {
        display: block;
      }
      .el-radio {
        display: block;
        margin-bottom: 5px;
      }
      ::v-deep .el-radio__label {
        color: #fff;
      }
    }
  }
}
</style>
