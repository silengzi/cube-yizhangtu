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
          <dv-border-box-12 class="mask" backgroundColor="rgb(4, 47, 84, 0.7)">
            <div>
              <div class="title">
                <img src="@/assets/layers.png" alt="" />
                <span>图层列表</span>
              </div>
              <div class="layerContent">
                <el-collapse v-model="layerName">
                  <el-collapse-item class="item" title="行政区划" name="1">
                    <el-checkbox-group
                      v-model="administration"
                      @change="handleChangeBaseLayer"
                    >
                      <el-checkbox label="行政区划" checked></el-checkbox>
                      <el-checkbox label="底图" checked></el-checkbox>
                    </el-checkbox-group>
                  </el-collapse-item>
                  <el-collapse-item class="item" title="监控设备" name="2">
                    <el-radio-group
                      v-model="layertype"
                      @input="handleChangeLayertype"
                    >
                      <el-radio label="监控塔"></el-radio>
                      <el-radio label="卡口"></el-radio>
                    </el-radio-group>
                  </el-collapse-item>
                  <el-collapse-item class="item" title="防火设施" name="3">
                    <el-radio-group
                      v-model="layertype"
                      @input="handleChangeLayertype"
                    >
                      <el-radio label="消防队"></el-radio>
                      <el-radio label="物资库"></el-radio>
                      <el-radio label="取水点"></el-radio>
                      <el-radio label="防火道路"></el-radio>
                      <el-radio label="阻隔带"></el-radio>
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
      administration: [], // 行政区划
      layertype: "", // 图层类别
    };
  },
  methods: {
    /**
     * 用于处理修改基本图层
     */
    handleChangeBaseLayer(layers) {
      console.log("选择了:", layers);
      if (layers.includes("行政区划")) {
        console.log("行政区划勾选");
      } else {
        console.log("行政区划取消");
      }

      if (layers.includes("底图")) {
        console.log("行底图勾选");
        // TODO: 显示底图 - this.$refs.map.toggleBaseLayer(true);
      } else {
        console.log("底图取消");
        // TODO: 隐藏底图 - this.$refs.map.toggleBaseLayer(false);
        /**
         * map 组件里可以写个方法专门控制底图显隐
         *
         * boolean为true或false，layer为底图
         * toggleBaseLayer(boolean) {
         *   layer.setVisible(boolean)
         * }
         */
      }
    },
    /**
     * 用于处理图层类别修改
     * @param {*} val
     */
    handleChangeLayertype(val) {
      console.log("选择了:" + val);
    },
  },
};
</script>

<style lang="less" scoped>
.home {
  position: relative;

  // .left, .right {
  //   /deep/ .dv-border-box-10 .border-box-content {
  //     background-color: #0c1225;
  //     background-color: #042650;
  //     opacity: 0.7;
  //     margin: 7px;
  //     width: 100%;
  //     height: calc(100vh - 67px - 14px);
  //     border-radius: 10px;
  //     box-sizing: border-box;
  //   }
  // }
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
