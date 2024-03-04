<template>
  <div class="header">
    <h1 class="headerTitle">智慧林草展示平台</h1>
    <div class="icon">
      <i class="el-icon-setting"></i>
      <i class="exit">
        <img
          src="../assets/登出.png"
          alt=""
        >
      </i>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Header',
  props: {
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less">
.header {
  background-color: #103932;
  position: relative;
  height: 67px;
}
.headerTitle {
  color: #fff;
  text-align: center;
  padding: 12px 0 12px 0;
  letter-spacing: 0.1em;
  display: inline-block;
  width: 100%;
}
.icon {
  display: inline-block;
  position: absolute;
  top: 16px;
  right: 10px;

  .el-icon-setting::before {
    font-size: 30px;
    position: absolute;
    top: 3px;
    right: 50px;
    font-weight: bold;
  }

  .exit {
    img {
      width: 38px;
      height: 35px;
    }
  }
}
</style>
