<template>
  <div class="left">
    <dv-border-box-10 backgroundColor="rgb(4, 47, 84, 0.7)">
      <div class="wrapper">
        <div class="top">
          <dv-decoration-7 class="titleDecoration" style="width:150px;height:30px;">
            <div class="title">
              天气监测
            </div>
          </dv-decoration-7>
          <dv-decoration-10 style="width:100%;height:5px;" />
        </div>
        <div class="center">
          <dv-decoration-7 class="titleDecoration" style="width:150px;height:30px;">
            <div class="title">
              站点统计
            </div>
          </dv-decoration-7>
          <dv-decoration-10 style="width:100%;height:5px;" />
        </div>
        <div class="bottom">
          <dv-decoration-7 class="titleDecoration" style="width:150px;height:30px;">
            <div class="title">
              报警情况
            </div>
          </dv-decoration-7>
          <dv-decoration-10 style="width:100%;height:5px;" />
        </div>
      </div>
    </dv-border-box-10>
  </div>
</template>

<script>
export default {
  name: '',
  data() {
    return {

    };
  },
  methods: {

  }
};
</script>

<style scoped lang="less">
.left {
  z-index: 2;
  position: absolute;
  top: 67px;
  left: 0;
  width: 20%;
  height: calc(100vh - 67px);

  .wrapper {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    padding-top: 10px;
    box-sizing: border-box;

    .top {
      flex: 1;
    }
    .center {
      flex: 1;
    }
    .bottom {
      flex: 1;
    }
    .title {
      color: #fff;
      font-size: 18px;
      font-weight: bold;
      padding: 0 5px;
    }
    .titleDecoration {
      margin-bottom: 5px;
    }
  }
}
</style>
