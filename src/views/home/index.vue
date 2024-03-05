<template>
  <div class="home">
    <Header />
    <div class="main">
      <div class="left">
        <dv-border-box-10>dv-border-box-10</dv-border-box-10>
      </div>
      <div class="center">
        <div class="select">
          <dv-border-box-12>
            <el-select
              v-model="value"
              placeholder="请选择"
            >
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              >
              </el-option>
            </el-select>
          </dv-border-box-12>
        </div>
        <div class="layerList">
          <dv-border-box-12>
            <i>
              <img
                src="@/assets/layers.png"
                alt=""
              >
            </i>
            <span>图层列表</span>
          </dv-border-box-12>
        </div>
        <div class="legend">
          <dv-border-box-12>
            <span>图例</span>
          </dv-border-box-12>
        </div>
      </div>
      <div class="right">
        <dv-border-box-10>dv-border-box-10</dv-border-box-10>
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
      options: [{
        value: '选项1',
        label: '黄金糕'
      }, {
        value: '选项2',
        label: '双皮奶'
      }, {
        value: '选项3',
        label: '蚵仔煎'
      }, {
        value: '选项4',
        label: '龙须面'
      }, {
        value: '选项5',
        label: '北京烤鸭'
      }],
      value: ''
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
      background-color: #042650;
      opacity: 0.7;
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
    .dv-border-box-12 {
      width: 200px;
      height: 150px;
      z-index: 2;
      position: absolute;
      top: 0;
      left: 300px;
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
  .layerList {
    position: relative;
    .dv-border-box-12 {
      width: 200px;
      height: 300px;
      z-index: 2;
      position: absolute;
      top: 0;
      left: calc(100vw - 300px - 200px);

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
    /deep/ .dv-border-box-12 .border-box-content {
      background-color: #042650;
      opacity: 0.7;
      margin: 6px;
      border-radius: 10px;
      box-sizing: border-box;
      width: 188px;
      height: 288px;
    }
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
    /deep/ .dv-border-box-12 .border-box-content {
      background-color: #042650;
      opacity: 0.7;
      margin: 6px;
      border-radius: 10px;
      box-sizing: border-box;
      width: 188px;
      height: 138px;
    }
  }
}
</style>