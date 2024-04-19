<template>
  <div class="home">
    <div class="main">
      <div class="center">
        <div class="select">
          <el-cascader
            v-model="value"
            :options="options"
            :props="{ expandTrigger: 'hover' }"
            clearable
          ></el-cascader>
        </div>
        <div class="date">
          <el-date-picker v-model="dateValue" type="year" placeholder="选择年">
          </el-date-picker>
        </div>
        <div class="layerList">
          <dv-border-box-12 ref="border-box" class="mask"  backgroundColor="rgb(4, 47, 84, 0.7)">
            <div>
              <div class="title">
                <img src="@/assets/layers.png" alt="" />
                <span>图层列表</span>
              </div>
              <div class="layerContent">
                <el-collapse v-model="layerName" @click.native="handleClickLayerList">
                  <el-collapse-item class="item" title="基础图层" name="1">
                    <el-checkbox-group v-model="checkboxLayer" @change="handleChangeLayer">
                      <el-checkbox label="底图" checked></el-checkbox>
                      <el-checkbox label="行政区" checked></el-checkbox>
                      <el-checkbox label="路网" checked></el-checkbox>
                      <el-checkbox label="林区" checked></el-checkbox>
                    </el-checkbox-group>
                  </el-collapse-item>
                  <el-collapse-item class="item" title="巡护" name="2">
                    <el-checkbox-group v-model="checkboxLayer" @change="handleChangeLayer">
                      <el-checkbox label="巡护员"></el-checkbox>
                      <el-checkbox label="巡护路线"></el-checkbox>
                      <el-checkbox label="巡护区域"></el-checkbox>
                    </el-checkbox-group>
                  </el-collapse-item>
                  <el-collapse-item class="item" title="监控设备" name="3">
                    <el-radio-group v-model="radioLayer" @change="handleChangeLayer">
                      <el-radio label="云台"></el-radio>
                      <el-radio label="卡口"></el-radio>
                      <el-radio label="摄像头"></el-radio>
                      <el-radio label="红外相机"></el-radio>
                      <el-radio label="声光报警器"></el-radio>
                      <el-radio label="气体检测器"></el-radio>
                      <el-radio label="无人机"></el-radio>
                    </el-radio-group>
                  </el-collapse-item>
                  <el-collapse-item class="item" title="动植物保护" name="4">
                    <el-radio-group v-model="radioLayer" @change="handleChangeLayer">
                      <el-radio label="野生动物"></el-radio>
                      <el-radio label="野生植物"></el-radio>
                    </el-radio-group>
                  </el-collapse-item>
                  <el-collapse-item class="item" title="告警" name="5">
                    <el-radio-group v-model="radioLayer" @change="handleChangeLayer">
                      <el-radio label="火灾告警"></el-radio>
                      <el-radio label="非法活动"></el-radio>
                    </el-radio-group>
                  </el-collapse-item>
                  <el-collapse-item class="item" title="古树名木" name="6">
                    <el-radio-group v-model="radioLayer" @change="handleChangeLayer">
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
      </div>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: "LayerList",
  components: {},
  data() {
    return {
      value: [],
      options: [
        {
          value: "shandongsheng",
          label: "山东省",
          children: [
            {
              value: "jinanshi",
              label: "济南市",
              children: [
                {
                  value: "lixiaqu",
                  label: "历下区",
                },
                {
                  value: "gaoxinqu",
                  label: "高新区",
                },
              ],
            },
            {
              value: "weifangshi",
              label: "潍坊市",
              children: [
                {
                  value: "shouguangshi",
                  label: "寿光市",
                },
                {
                  value: "weichengqu",
                  label: "潍城区",
                },
              ],
            },
          ],
        },
        {
          value: "shanxisheng",
          label: "山西省",
          children: [
            {
              value: "taiyuanshi",
              label: "太原市",
              children: [
                {
                  value: "jiancaopingqu",
                  label: "尖草坪区",
                },
                {
                  value: "xiaodianqu",
                  label: "小店区",
                },
              ],
            },
            {
              value: "yangquanshi",
              label: "阳泉市",
              children: [
                {
                  value: "yuxian",
                  label: "盂县",
                },
                {
                  value: "chengqu",
                  label: "城区",
                },
              ],
            },
          ],
        },
      ],
      dateValue: "",
      layerName: ["1"],
      checkboxLayer: [], // 多选图层
      radioLayer: "", // 图层类别
    };
  },
  methods: {
    handleClickLayerList() {
      this.$refs["border-box"] && this.$refs["border-box"].initWH()
    },
    /**
     * 监听所有图层的修改
     */
    handleChangeLayer() {
      const checkList = [...this.checkboxLayer]
      this.radioLayer && checkList.push(this.radioLayer)
      this.$EventBus.$emit("handleChangeLayer", checkList);
    },
  },
};
</script>

<style lang="less" scoped>
.home {
  position: relative;

  .mainMap {
    width: 100%;
    height: calc(100vh - 67px);
    position: absolute;
    top: 67px;
    left: 0;
    z-index: 1;
  }
  .select {
    position: relative;
    .el-cascader {
      // width: 200px;
      // height: 150px;
      z-index: 2;
      position: absolute;
      top: 5px;
      left: 21%;
    }
  }
  .date {
    position: absolute;
    // width: 200px;
    // height: 150px;
    z-index: 2;
    position: absolute;
    top: 72px;
    left: calc(222px + 21%);
  }
  .layerList {
    // position: relative;
    z-index: 2;
    position: absolute;
    top: 67px;
    left: calc(100vw - 20% - 220px);
    // background-color: red;
    width: 200px;
    min-height: 480px;
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
          // line-height: 0;
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
}
</style>
