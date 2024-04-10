<!-- 高德地图接口测试demo -->
<template>
  <div>
    <div v-if="forecasts">
      <div>{{ forecasts.province + " " + forecasts.city + " 更新时间: " + forecasts.reporttime }}</div>
      <div v-for="item in forecasts.casts" :key="item.date">
        <div>{{ item.date + " 周" + item.week + " " + item.dayweather + " " + item.nightweather + " " + item.daytemp + " " + item.nighttemp + " " + item.daywind + " " + item.nightwind + " " + item.daypower + " " + item.nightpower }}</div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "AMap",
  data() {
    return {
      forecasts: null
    }
  },
  created() {
    this.getWeather()
  },
  methods: {
    // 获取天气
    getWeather() {
      const adcode = '110101'; // 行政区编码
      const userKey = 'd28bdfe45916aa2df8cce4b38ab2ab2c'

      // extensions=all 表示获取预报的天气
      const url1 = `https://restapi.amap.com/v3/weather/weatherInfo?city=${adcode}&key=${userKey}&extensions=all`
      // extensions=base 表示获取当前时刻的天气
      const url2 = `https://restapi.amap.com/v3/weather/weatherInfo?city=${adcode}&key=${userKey}&extensions=base`

      axios.get(url1)
        .then((response) => {
          console.log(response.data);
          this.forecasts = response.data.forecasts[0]
        })
        .catch(function (error) {
          console.log(error);
        });

      axios.get(url2)
        .then(function (response) {
          console.log(response.data);
        })
        .catch(function (error) {
          console.log(error);
        });
    }
  }
}
</script>
