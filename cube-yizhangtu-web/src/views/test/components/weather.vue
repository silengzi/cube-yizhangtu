<template>
  <div
    class="weather-detail"
    v-if="forecasts"
  >
    <div class="address">{{forecasts.province + " " + forecasts.city + " 更新时间: " + forecasts.reporttime}}</div>
    <div class="weather-detail-desc">
      <div class="weather-detail-description">
        <div
          class="weather-detail-day"
          v-for="item in forecasts.casts"
          :key="item.date"
        >
          <div class="weather-day">{{"周" + item.week}}</div>
          <div class="weather-date">{{item.date}}</div>
          <div class="day-weather">
            <img
              src="@/assets/太阳.png"
              alt=""
            >
            <div class="weather-info">{{item.dayweather}}</div>
          </div>
          <div class="weather-pollution">轻度污染</div>
        </div>
      </div>
      <div class="line">
        <!-- <div
                class="line-chart"
                ref="lineChart"
                >{{item.daytemp}}℃</div>
                <div
                class="line-chart"
                ref="lineChart"
                >{{item.nighttemp}}℃</div> -->
        <div
          class="line-chart"
          ref="lineChart"
          style="width: 300px; height: 100%;"
        ></div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import * as echarts from 'echarts';

export default {
  name: '',
  data() {
    return {
      forecasts: null,
    };
  },
  created() {
    this.getWeather();
    // this.renderLineChart();
  },
  methods: {
    getWeather() {
      const adcode = '110101'; // 行政区编码
      const userKey = 'd28bdfe45916aa2df8cce4b38ab2ab2c'

      // extensions=all 表示获取预报的天气
      const url1 = `https://restapi.amap.com/v3/weather/weatherInfo?city=${adcode}&key=${userKey}&extensions=all`
      // extensions=base 表示获取当前时刻的天气
      const url2 = `https://restapi.amap.com/v3/weather/weatherInfo?city=${adcode}&key=${userKey}&extensions=base`

      axios.get(url1)
        .then((response) => {
          // console.log(response.data);
          this.forecasts = response.data.forecasts[0]
          this.$nextTick(() => {
            this.renderLineChart()
          })
        })
        .catch(function (error) {
          console.log(error);
        });

      // axios.get(url2)
      //   .then(function (response) {
      //     // console.log(response.data);
      //   })
      //   .catch(function (error) {
      //     console.log(error);
      //   });
    },
    renderLineChart() {
      const lineChart = echarts.init(this.$refs.lineChart);
      const option = {
        grid: {
          top: '20%',
          bottom: '0%',
          left: '0%',
          right: '0%',
        },
        xAxis: {
          type: 'category',
          data: ['Mon', 'Tue', 'Wed', 'Thu'],
          show: false,
        },
        yAxis: {
          type: 'value',
          show: false,
        },
        series: [
          {
            data: [820, 932, 901, 934],
            type: 'line',
            label: {
              show: true,
              textStyle: {
                color: 'white'
              }
            },
            smooth: true,
          },
          {
            data: [234, 345, 475, 568],
            type: 'line',
            label: {
              show: true,
              textStyle: {
                color: 'white'
              }
            },
            smooth: true,
          },
        ]
      }
      lineChart.setOption(option);
    },
  }
};
</script>

<style scoped lang="less">
.weather-detail {
  //   width: 300px;
  //   height: 200px;
  background-color: rgba(4, 47, 84, 0.7);
  border-radius: 8px;
  position: absolute;
  top: 40px;
  left: 325px;
  color: #f9f3f3;

  .address {
    font-size: 14px;
    padding: 5px 0;
    text-align: center;
    border-bottom: 1px solid;
  }

  .weather-detail-desc {
    display: flex;
    flex-direction: column;
    width: 300px;
    height: 200px;

    .weather-detail-description {
      display: flex;
      justify-content: space-around;

      .weather-detail-day {
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        align-items: center;

        img {
          width: 20px;
          height: 20px;
        }

        .weather-date {
          font-size: 12px;
        }

        line {
          height: calc(100% - 103px);
        }
      }
    }
  }
}
</style>
