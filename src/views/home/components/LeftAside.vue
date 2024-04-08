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
            <div
              class="weather"
              @mouseenter="showWeatherDetail = true"
              @mouseleave="showWeatherDetail = false"
            >
              <img
                src="@/assets/天气.png"
                alt=""
              >
              <span>预报</span>
            </div>
            <div
              class="weather-detail"
              v-show="showWeatherDetail"
            >
              <div class="weather-detail-description">
                <div class="weather-today weather-detail-day">
                  <div class="weather-day">今天</div>
                  <div class="weather-date">3-15</div>
                  <img
                    src="@/assets/太阳.png"
                    alt=""
                  >
                  <div class="weather-info">晴</div>
                  <div class="weather-pollution">轻度污染</div>
                </div>
                <div class="weather-tommorrow weather-detail-day">
                  <div class="weather-day">明天</div>
                  <div class="weather-date">3-15</div>
                  <img
                    src="@/assets/太阳.png"
                    alt=""
                  >
                  <div class="weather-info">晴</div>
                  <div class="weather-pollution">中度污染</div>
                </div>
                <div class="weather-sunday weather-detail-day">
                  <div class="weather-day">星期日</div>
                  <div class="weather-date">3-15</div>
                  <img
                    src="@/assets/太阳.png"
                    alt=""
                  >
                  <div class="weather-info">晴</div>
                  <div class="weather-pollution">轻度污染</div>
                </div>
                <div class="weather-monday weather-detail-day">
                  <div class="weather-day">星期一</div>
                  <div class="weather-date">3-15</div>
                  <img
                    src="@/assets/太阳.png"
                    alt=""
                  >
                  <div class="weather-info">晴</div>
                  <div class="weather-pollution">轻度污染</div>
                </div>
                <div class="weather-tuesday weather-detail-day">
                  <div class="weather-day">星期二</div>
                  <div class="weather-date">3-15</div>
                  <img
                    src="@/assets/太阳.png"
                    alt=""
                  >
                  <div class="weather-info">晴</div>
                  <div class="weather-pollution">轻度污染</div>
                </div>
              </div>
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
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
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
            style="width:160px;height:30px;"
          >
            <div class="title">
              监测站点统计
            </div>
          </dv-decoration-7>
          <dv-decoration-10 style="width:100%;height:5px;" />
          <div class="monitor">
            <div class="monitor-top">
              <div class="monitor-sum monitor-top-item">
                <img
                  src="@/assets/合计.png"
                  alt=""
                >
                <div class="monitor-sum-index monitor-top-desc">
                  <label class="sum text">合计</label>
                  <label class="sum-index index">21</label>
                </div>
              </div>
              <div class="monitor-camera monitor-top-item">
                <img
                  src="@/assets/摄像头.png"
                  alt=""
                >
                <div class="monitor-camera-index monitor-top-desc">
                  <label class="camera text">摄像头</label>
                  <label class="camera-index index">2</label>
                </div>
              </div>
            </div>
            <div class="monitor-sort">
              <!-- 国控站 -->
              <div class="country monitor-class">
                <div class="img"></div>
                <div class="country-desc monitor-sort-desc">
                  <label class="country-label text">国控站</label>
                  <label class="country-index monitor-sort-index">8</label>
                </div>
              </div>
              <!-- 省控站 -->
              <div class="province monitor-class">
                <div class="img"></div>
                <div class="province-desc monitor-sort-desc">
                  <label class="province-label text">省控站</label>
                  <label class="province-index monitor-sort-index">8</label>
                </div>
              </div>
              <!-- 市控站 -->
              <div class="city monitor-class">
                <div class="img"></div>
                <div class="city-desc monitor-sort-desc">
                  <label class="city-label text">市控站</label>
                  <label class="city-index monitor-sort-index">0</label>
                </div>
              </div>
              <!-- 微站 -->
              <div class="mini monitor-class">
                <div class="img"></div>
                <div class="mini-desc monitor-sort-desc">
                  <label class="mini-label text">微站</label>
                  <label class="mini-index monitor-sort-index">1</label>
                </div>
              </div>
              <!-- 扬尘站 -->
              <div class="dust monitor-class">
                <div class="img"></div>
                <div class="dust-desc monitor-sort-desc">
                  <label class="dust-label text">扬尘站</label>
                  <label class="dust-index monitor-sort-index">0</label>
                </div>
              </div>
              <!-- 其他 -->
              <div class="other monitor-class">
                <div class="img"></div>
                <div class="other-desc monitor-sort-desc">
                  <label class="other-label text">其他</label>
                  <label class="other-index monitor-sort-index">2</label>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="bottom">
          <dv-decoration-7
            class="titleDecoration"
            style="width:160px;height:30px;"
          >
            <div
              class="title"
              v-show="show==1"
            >
              野生动物保护
            </div>
            <div
              class="title"
              v-show="show==2"
            >
              野生植物保护
            </div>
          </dv-decoration-7>
          <dv-decoration-10 style="width:100%;height:5px;" />
          <!-- 转换按钮 -->
          <div class="convert">
            <el-button
              type="primary"
              size="mini"
              @click="toggleChart"
            >切换</el-button>
          </div>
          <div class="wildlife">
            <dv-conical-column-chart
              v-show="show==1"
              :config="configWildLife"
              class="wildlife-chart"
            />
            <dv-conical-column-chart
              v-show="show==2"
              :config="configPlant"
              class="wild-plant-chart"
            />
          </div>
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
      updateTime: '2024-03-19 11:03:55',

      configWildLife: {
        data: [
          { name: '国家一级保护动物', value: 20 },
          { name: '国家二级保护动物', value: 50 },
          { name: '三有保护动物', value: 100 },
          { name: '濒危物种', value: 60 },
        ],
        fontSize: 7.8,
      },
      show: 1,
      configPlant: {
        data: [
          { name: '国家重点保护植物', value: 20 },
          { name: '省级重点保护植物', value: 50 },
          { name: '市级重点保护植物', value: 100 },
        ],
        fontSize: 7.8,
      },
      showWeatherDetail: false,
    };
  },
  methods: {
    toggleChart() {
      this.show = this.show === 1 ? 2 : 1;
    }
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
      position: relative;

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

        .weather-detail {
          width: 300px;
          height: 200px;
          background-color: rgba(4, 47, 84, 0.7);
          border-radius: 8px;
          position: absolute;
          top: 40px;
          left: 325px;

          .weather-detail-description {
            display: flex;
            justify-content: space-between;

            .weather-detail-day {
              display: flex;
              flex-direction: column;
              justify-content: space-around;
              color: #fff;
  
              /* .weather-day, .weather-date, img, .weather-info, .weather-pollution {
                flex: 1;
              } */
              .weather-day {
                flex: 1;
              }
              .weather-date {
                flex: 1;
              }
              .weather-info {
                flex: 1;
              }
              .weather-pollution {
                flex: 1;
              }
  
              img {
                flex: 1;
                width: 20px;
                height: 20px;
              }
            }
          }

        }
        .weather:hover {
          cursor: pointer;

          .weather-detail {
            display: block;
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
            display: flex;
            justify-content: space-around;
            align-items: center;

            div {
              width: 17%;
              height: 75%;
              background-color: #e8b961;
            }
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

      .monitor {
        height: 85%;
        display: flex;
        flex-direction: column;
        justify-content: space-around;
        .monitor-top {
          display: flex;
          justify-content: space-around;

          .monitor-top-item {
            display: flex;
            align-items: center;

            .monitor-top-desc {
              height: 38px;
              display: flex;
              flex-direction: column;
              justify-content: space-between;
              align-items: center;

              .text {
                color: #9da9b3;
                font-size: 16px;
              }

              .index {
                font-size: 23px;
                color: #3bfefc;
              }
            }
          }
        }

        .monitor-sort {
          height: 50%;
          margin: 20px 10px 0;
          // padding: 10px;
          display: flex;
          flex-wrap: wrap;
          justify-content: space-around;
          align-items: center;
          background-color: rgba(4, 47, 84, 0.5);

          .monitor-class {
            width: 30%;
            display: flex;
            align-items: center;

            .img {
              width: 20px;
              height: 20px;
              background-color: #395676;
              border-radius: 50%;
            }

            .monitor-sort-desc {
              margin-left: 5px;
              display: flex;
              flex-direction: column;
              .text {
                color: #9daab8;
              }

              .monitor-sort-index {
                color: #2ca0de;
                font-size: 20px;
              }
            }
          }
        }
      }
    }
    .bottom {
      flex: 1;
      overflow: hidden;

      .convert {
        float: right;
      }

      .wildlife {
        width: 100%;
        height: 60%;
        display: flex;
        justify-content: center;
        align-items: center;

        .wildlife-chart {
          width: 360px;
          height: 200px;
        }
        .wild-plant-chart {
          width: 360px;
          height: 200px;
        }
      }
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
