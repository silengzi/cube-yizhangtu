<template>
  <div class="left">
    <dv-border-box-10 backgroundColor="rgb(4, 47, 84, 0.7)">
      <div class="wrapper">
        <div class="top">
          <div class="description">
            <dv-decoration-7
              class="titleDecoration"
              style="width:150px;height:30px;"
            >
              <div class="title">
                天气监测
              </div>
            </dv-decoration-7>
            <div class="weather">
              <img
                src="@/assets/天气.png"
                alt=""
              >
              <span>预报</span>
            </div>
          </div>
          <dv-decoration-10 style="width:100%;height:5px;" />
          <div class="topContent">
            <div class="header">
              <div
                class="updateTime"
                :bind="updateTime"
              >
                <label>更新时间：</label>{{updateTime}}
              </div>
              <div class="primary">
                <label>首要污染物：</label>PM2.5
              </div>
            </div>
            <!-- 污染指数 -->
            <div class="pollutionIndex">
              <div class="index">
                <label>135</label>
                <span>轻度污染</span>
              </div>
              <div class="lineaer">

              </div>
            </div>
            <div class="sort">
              <!-- 温度 -->
              <div class="temperature category">
                <div class="flexLeft">
                  <img
                    src="@/assets/大气温度.png"
                    alt=""
                  >
                  <label for="">温度</label>
                </div>
                <span>27℃</span>
              </div>
              <!-- 湿度 -->
              <div class="humidity category">
                <div class="flexLeft">
                  <img
                    src="@/assets/湿度.png"
                    alt=""
                  >
                  <label for="">湿度</label>
                </div>
                <span>50%</span>
              </div>
              <!-- 风向 -->
              <div class="windDirection category">
                <div class="flexLeft">
                  <img
                    src="@/assets/风向.png"
                    alt=""
                  >
                  <label for="">风向</label>
                </div>
                <span>西北风</span>
              </div>
              <!-- 风速 -->
              <div class="windSpeed category">
                <div class="flexLeft">
                  <img
                    src="@/assets/风速.png"
                    alt=""
                  >
                  <label for="">风速</label>
                </div>
                <span>9m/s</span>

              </div>
              <!-- 土壤湿度 -->
              <div class="soilMoisture category">
                <div class="flexLeft">
                  <img
                    src="@/assets/土壤湿度.png"
                    alt=""
                  >
                  <label for="">土壤湿度</label>
                </div>
                <span>70%</span>
              </div>
              <!-- 气压 -->
              <div class="pressure category">
                <div class="flexLeft">
                  <img
                    src="@/assets/大气压.png"
                    alt=""
                  >
                  <label for="">气压</label>
                </div>
                <span>101.325kPa</span>
              </div>
            </div>
          </div>
        </div>
        <div class="center">
          <dv-decoration-7
            class="titleDecoration"
            style="width:150px;height:30px;"
          >
            <div class="title">
              站点统计
            </div>
          </dv-decoration-7>
          <dv-decoration-10 style="width:100%;height:5px;" />
        </div>
        <div class="bottom">
          <dv-decoration-7
            class="titleDecoration"
            style="width:150px;height:30px;"
          >
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
      updateTime: '2024-03-19 11:03:55'
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

      .description {
        display: flex;
        justify-content: space-between;
        align-items: center;
        .weather {
          display: flex;
          align-items: center;
          margin-right: 10px;
          img {
            width: 25px;
            margin-right: 5px;
          }
          span {
            color: #fff;
            font-size: 18px;
          }
        }
      }

      .topContent {
        .header {
          color: #fff;
          margin: 5px;
          font-size: 12px;
          display: flex;
          justify-content: space-between;

          label {
            color: #bcb8b8;
          }
        }

        .pollutionIndex {
          display: flex;
          justify-content: space-between;
          align-items: center;
          margin-right: 5px;

          .index {
            color: #fff;

            label {
              font-size: 35px;
            }
          }

          .lineaer {
            border: 1px solid #9bfee1;
            width: 200px;
            height: 16px;
          }
        }

        .sort {
          display: flex;
          flex-wrap: wrap;
          justify-content: space-between;
          margin: 5px;

          .category {
            width: 46%;
            height: 40px;
            margin: 5px;
            background: rgba(4, 47, 84, 0.5);
            display: flex;
            justify-content: space-between;
            align-items: center;

            .flexLeft {
              display: flex;
              align-items: center;
              img {
                width: 20px;
                height: 20px;
              }
  
              label {
                color: #bcb8b8;
                margin-left: 2px;
              }
            }

            span {
              color: #fff;
            }
          }
        }
      }
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
