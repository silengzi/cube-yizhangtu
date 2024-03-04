<template>
  <div class="home">
    <Header />
    <div class="main">
      <div class="left">
        <dv-border-box-12>dv-border-box-12</dv-border-box-12>
      </div>
      <div class="right">
        <dv-border-box-12>dv-border-box-12</dv-border-box-12>
      </div>
    </div>
    <div class="center">
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
  }
}
</script>

<style lang="less" scoped>
.home {
  position: relative;
  .main {
    display: flex;
    justify-content: space-between;
    // .left,
    // .right {
    //   .el-aside {
    //     // width: 500px !important;
    //     height: calc(100vh - 67px) !important;
    //     // border: 1px solid #272424;
    //     background-color: #dcdcd2;
    //     opacity: 0.5;
    //     z-index: 2;
    //     position: absolute;
    //     top: 67px;
    //     left: 0;
    //   }
    // }
    .left, .right {
      .dv-border-box-12 {
        width: 300px;
        height: calc(100vh - 67px);
        // border: 1px solid #272424;
        // background-color: #4a4a58;
        // opacity: 0.5;
        z-index: 2;
        position: absolute;
        top: 67px;
        left: 0;
      }
    }
    .right {
      .dv-border-box-12 {
        left: calc(100vw - 300px);
      }
    }
  }
  .center {
    width: 100%;
    height: calc(100vh - 67px);
    position: absolute;
    top: 67px;
    left: 0;
    z-index: 1;
  }
}
</style>