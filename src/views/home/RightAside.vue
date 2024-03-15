<template>
  <div class="right">
    <dv-border-box-10 backgroundColor="rgb(4, 47, 84, 0.7)">
      <div class="wrapper">
        <div class="top">
          <dv-decoration-7 class="titleDecoration" style="width:150px;height:30px;">
            <div class="title">
              优良天数
            </div>
          </dv-decoration-7>
          <dv-decoration-10 style="width:100%;height:5px;" />
          </div>
        <div class="center">
          <dv-decoration-7 class="titleDecoration" style="width:150px;height:30px;">
            <div class="title">
              质量排名
            </div>
          </dv-decoration-7>
          <dv-decoration-10 style="width:100%;height:5px;" />
          </div>
        <div class="bottom">
          <dv-decoration-7 class="titleDecoration" style="width:150px;height:30px;">
            <div class="title">
              污染日历
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
.right {
  z-index: 2;
  position: absolute;
  top: 67px;
  left: calc(100vw - 20%);
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
