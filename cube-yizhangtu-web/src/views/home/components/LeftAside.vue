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
            <Weather v-show="showWeatherDetail"></Weather>
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
                <label>首要污染物：</label>{{getPrimary_factor}}
              </div>
            </div>
            <!-- 污染指数 -->
            <div class="pollutionIndex">
              <div class="index">
                <label>{{level}}</label>
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
                <span>{{weaData.f1}}℃</span>
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
                <span>{{weaData.f2}}%</span>
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
                <span>{{weaData.f3}}</span>
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
                <span>{{weaData.f4}}m/s</span>

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
                <span>{{weaData.f5}}%</span>
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
                <span>{{weaData.f6}}kPa</span>
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
                  <label class="sum-index index">{{getSum}}</label>
                </div>
              </div>
              <div class="monitor-camera monitor-top-item">
                <img
                  src="@/assets/摄像头.png"
                  alt=""
                >
                <div class="monitor-camera-index monitor-top-desc">
                  <label class="camera text">摄像头</label>
                  <label class="camera-index index">{{monitorData.摄像头}}</label>
                </div>
              </div>
            </div>
            <div class="monitor-sort">
              <!-- 气体检测器 -->
              <div class="country monitor-class">
                <div class="img"></div>
                <div class="country-desc monitor-sort-desc">
                  <label class="country-label text">气体检测器</label>
                  <label class="country-index monitor-sort-index">{{monitorData.气体检测器}}</label>
                </div>
              </div>
              <!-- 云台 -->
              <div class="province monitor-class">
                <div class="img"></div>
                <div class="province-desc monitor-sort-desc">
                  <label class="province-label text">云台</label>
                  <label class="province-index monitor-sort-index">{{monitorData.云台}}</label>
                </div>
              </div>
              <!-- 无人机 -->
              <div class="city monitor-class">
                <div class="img"></div>
                <div class="city-desc monitor-sort-desc">
                  <label class="city-label text">无人机</label>
                  <label class="city-index monitor-sort-index">{{monitorData.无人机}}</label>
                </div>
              </div>
              <!-- 卡口 -->
              <div class="mini monitor-class">
                <div class="img"></div>
                <div class="mini-desc monitor-sort-desc">
                  <label class="mini-label text">卡口</label>
                  <label class="mini-index monitor-sort-index">{{monitorData.卡口}}</label>
                </div>
              </div>
              <!-- 红外相机 -->
              <div class="dust monitor-class">
                <div class="img"></div>
                <div class="dust-desc monitor-sort-desc">
                  <label class="dust-label text">红外相机</label>
                  <label class="dust-index monitor-sort-index">{{monitorData.红外相机}}</label>
                </div>
              </div>
              <!-- 声光报警器 -->
              <div class="other monitor-class">
                <div class="img"></div>
                <div class="other-desc monitor-sort-desc">
                  <label class="other-label text">声光报警器</label>
                  <label class="other-index monitor-sort-index">{{monitorData.声光报警器}}</label>
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
            <!-- 野生动物 -->
            <dv-conical-column-chart
              v-show="show==1"
              :config="configWildLife"
              class="wildlife-chart"
            />
            <!-- 野生植物 -->
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
import Weather from '@/views/home/components/weather'
import { reqWeather, reqMonitorNums, reqWildlifeNums, reqWildplantNums } from '@/api/index'

export default {
  name: '',
  components: {
    Weather,
  },
  data() {
    return {
      updateTime: '',
      type: '',
      obj: {
        'f1': '温度',
        'f2': '湿度',
        'f3': '风向',
        'f4': '风速',
        'f5': '土壤湿度',
        'f6': '气压',
      },
      level: '',
      // 天气数据
      weaData: {
        'f1': '',
        'f2': '',
        'f3': '',
        'f4': '',
        'f5': '',
        'f6': '',
      },
      // 监控设备数据
      monitorData: {
        '摄像头': 0,
        '气体检测器': 0,
        '云台': 0,
        '无人机': 0,
        '卡口': 0,
        '红外相机': 0,
        '声光报警器': 0,
      },
      configWildLife: {
        data: [],
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
    },
    async getWildlifeNums() {
      // console.log(this.configWildLife.data)
      // let result = await reqWildlifeNums()
      // let res = result.data
      // let transformedData = Object.entries(res.data).map(([key, value]) => {
      //   return {name: key, value: value}
      // })
      // this.configWildLife.data = transformedData
      // console.log(this.configWildLife.data)
      try {
        let result = await reqWildlifeNums();
        let res = result.data;
        console.log(res.data); // 添加这行来确认返回的数据结构
        let transformedData = Object.entries(res.data).map(([key, value]) => {
          return { name: key, value: value };
        });
        // 确保数据更新是响应式的
        this.$set(this.configWildLife, 'data', transformedData);
        console.log(this.configWildLife.data);
      } catch (error) {
        console.error('Error fetching wildlife numbers:', error);
      }
    }
  },
  mounted() {
    // 天气监测
    reqWeather().then(res => {
      let result = res.data
      this.updateTime = result.data[0].updateTime;
      this.level = result.data[0].level;
      this.weaData = result.data[0];
    })
    // 监控设备
    reqMonitorNums().then(res => {
      let result = res.data
      // this.monitorData.气体检测器 = result.data.气体检测器
      this.monitorData = result.data
    })
  },
  async created() {
    await this.getWildlifeNums()
  },
  computed: {
    // 首要污染物
    getPrimary_factor() {
      this.type = 'f1'
      return this.obj[this.type]
    },
    // 监控设备合计
    getSum() {
      return Object.values(this.monitorData).reduce((total, value) => total + value, 0);
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

        .weather:hover {
          cursor: pointer;

          /* .weather-detail {
            display: block;
          } */
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
          justify-content: space-around;
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
          height: 57%;
          margin: 20px 10px 0;
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
