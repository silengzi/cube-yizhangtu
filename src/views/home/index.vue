<template>
  <div class="home">
    <Header />
    <div class="main">
      <div class="left">
        <dv-border-box-10 backgroundColor="rgb(4, 47, 84, 0.7)">dv-border-box-10</dv-border-box-10>
      </div>
      <div class="center">
        <div class="select">
          <el-cascader
            v-model="value"
            :options="options"
            :props="{ expandTrigger: 'hover' }"
            @change="handleChange"
            clearable
          ></el-cascader>
        </div>
        <div class="date">
          <el-date-picker
            v-model="dateValue"
            type="year"
            placeholder="选择年"
          >
          </el-date-picker>
        </div>
        <div class="layerList">
          <dv-border-box-12 class="mask" backgroundColor="rgb(4, 47, 84, 0.7)">
            <div class="title">
              <i>
                <img
                  src="@/assets/layers.png"
                  alt=""
                >
              </i>
              <span>图层列表</span>
            </div>
            <div class="layerContent">
              <el-collapse v-model="layerName">
                <el-collapse-item title="行政区划" name="1">
                  <el-checkbox-group v-model="administration">
                    <el-checkbox label="行政区划" checked></el-checkbox>
                  </el-checkbox-group>
                </el-collapse-item>
                <el-collapse-item title="监控设备" name="2">
                  <el-radio-group v-model="monitor">
                    <el-radio label="监控塔"></el-radio>
                    <el-radio label="卡口"></el-radio>
                  </el-radio-group>
                </el-collapse-item>
                <el-collapse-item title="防火设施" name="3">
                  <el-radio-group v-model="facilities">
                    <el-radio label="消防队"></el-radio>
                    <el-radio label="物资库"></el-radio>
                    <el-radio label="取水点"></el-radio>
                    <el-radio label="防火道路"></el-radio>
                    <el-radio label="阻隔带"></el-radio>
                  </el-radio-group>
                </el-collapse-item>
              </el-collapse>
            </div>
          </dv-border-box-12>
        </div>
        <div class="legend">
          <dv-border-box-12 backgroundColor="rgb(4, 47, 84, 0.7)">
            <span>图例</span>
          </dv-border-box-12>
        </div>
      </div>
      <div class="right">
        <dv-border-box-10 backgroundColor="rgb(4, 47, 84, 0.7)">dv-border-box-10</dv-border-box-10>
      </div>
    </div>
    <div class="mainMap">
      <Map></Map>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import Header from '@/components/header.vue'
import Map from '@/views/home/Map.vue'

export default {
  name: 'Home',
  components: {
    Header,
    Map
  },
  data() {
    return {
      value: [],
      options: [
        {
          value: 'shandongsheng',
          label: '山东省',
          children: [
            {
              value: 'jinanshi',
              label: '济南市',
              children: [
                {
                  value: 'lixiaqu',
                  label: '历下区',
                },
                {
                  value: 'gaoxinqu',
                  label: '高新区',
                },
              ]
            },
            {
              value: 'weifangshi',
              label: '潍坊市',
              children: [
                {
                  value: 'shouguangshi',
                  label: '寿光市'
                },
                {
                  value: 'weichengqu',
                  label: '潍城区'
                },
              ]
            },
          ]
        },
        {
          value: 'shanxisheng',
          label: '山西省',
          children: [
            {
              value: 'taiyuanshi',
              label: '太原市',
              children: [
                {
                  value: 'jiancaopingqu',
                  label: '尖草坪区',
                },
                {
                  value: 'xiaodianqu',
                  label: '小店区',
                },
              ]
            },
            {
              value: 'yangquanshi',
              label: '阳泉市',
              children: [
                {
                  value: 'yuxian',
                  label: '盂县'
                },
                {
                  value: 'chengqu',
                  label: '城区'
                },
              ]
            },
          ]
        },
      ],
      dateValue: '',
      layerName: ['1'],
      administration: [], // 行政区划
      monitor: '', // 监控
      facilities: '', // 防火设施
    }
  }
}
</script>

<style lang="less" scoped>
.home {
  position: relative;
  .main {
    // display: flex;
    // justify-content: space-between;
    .left,
    .right {
      .dv-border-box-10 {
        width: 300px;
        height: calc(100vh - 67px);
        z-index: 2;
        position: absolute;
        top: 67px;
        left: 0;
      }
    }
    .right {
      .dv-border-box-10 {
        left: calc(100vw - 300px);
      }
    }
  }
  .left,
  .right {
    /deep/ .dv-border-box-10 .border-box-content {
      // background-color: #0c1225;
      // background-color: #042650;
      // opacity: 0.7;
      margin: 7px;
      width: 287px;
      height: calc(100vh - 67px - 14px);
      border-radius: 10px;
      box-sizing: border-box;
    }
  }
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
      left: 305px;
    }
  }
  .date {
    position: absolute;
    // width: 200px;
    // height: 150px;
    z-index: 2;
    position: absolute;
    top: 72px;
    left: 530px;
  }
  .layerList {
    position: relative;
    .dv-border-box-12 {
      width: 200px;
      min-height: 300px;
      z-index: 2;
      position: absolute;
      top: 0;
      left: calc(100vw - 300px - 200px);

      .title {
        position: relative;
        i {
          img {
            width: 25px;
            height: 25px;
            // display: inline-block;
            position: absolute;
            top: 15px;
            left: 12px;
          }
        }
        span {
          color: #fff;
          // display: inline-block;
          position: absolute;
          top: 15px;
          left: 42px;
        }
      }
      .title::after {
        content: "";
        position: absolute;
        left: 0;
        top: 50px;
        right: 0;
        width: 90%;
        margin: auto;
        height: 1px;
        background-color: #1dabf2;
      }
    }
    .layerContent {
      position: absolute;
      z-index: 2;
      top: 55px;
      left: 17px;
      color: #fff;

      .el-collapse {
        border-top: none;
        border-bottom: none;
      
        /deep/ .el-collapse-item__content {
          padding-bottom: 0;
          // line-height: 0;
        }
        /deep/ .el-collapse-item__header {
          color: #fff;
          background-color: transparent;  // 背景色变为透明，即不显示任何颜色
          border-bottom: none;
          font-size: 16px;
          height: 30px;
        }
        /deep/ .el-collapse-item__wrap {
          background-color: transparent;  // 背景色变为透明，即不显示任何颜色
          border-bottom: none;
        }
        /deep/ .el-checkbox__label {
          color: #fff;
          font-size: 15px;
        }
        /deep/ .el-checkbox__input.is-checked+.el-checkbox__label {
          color: #409EFF;
        }
        /deep/ .el-checkbox, .el-checkbox__input {
          display: block;
        }
        .el-radio {
          display: block;
          margin-bottom: 5px;
        }
        /deep/ .el-radio__label {
          color: #fff;
        }
      }
    }
    /* /deep/ .dv-border-box-12 .border-box-content {
      background-color: #042650;
      opacity: 0.7;
      margin: 6px;
      border-radius: 10px;
      box-sizing: border-box;
      width: 188px;
      height: 288px;
    } */
  }
  .legend {
    position: relative;
    .dv-border-box-12 {
      width: 200px;
      height: 150px;
      z-index: 2;
      position: absolute;
      top: calc(100vh - 220px);
      left: 300px;

      span {
        color: #fff;
        // display: inline-block;
        position: absolute;
        top: 15px;
        left: 18px;
      }
    }
    // /deep/ .dv-border-box-12 .border-box-content {
    //   background-color: #042650;
    //   opacity: 0.7;
    //   margin: 6px;
    //   border-radius: 10px;
    //   box-sizing: border-box;
    //   width: 188px;
    //   height: 138px;
    // }
  }
}
</style>