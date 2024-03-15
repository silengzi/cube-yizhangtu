<template>
  <div class="left">
    <dv-border-box-10 backgroundColor="rgb(4, 47, 84, 0.7)">
      <div class="wrapper">
        <div class="top"></div>
        <div class="center"></div>
        <div class="bottom"></div>
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
    
      .top {
        background-color: #f00;
        flex: 1;
      }
      .center {
        background-color: #0f0;
        flex: 1;
      }
      .bottom {
        background-color: #00f;
        flex: 1;
      }
    }
}
</style>
