<!-- 高德地图接口测试demo -->
<template>
  <div>
    <div id="btn" @mouseenter="isShow = true" @mouseleave="isShow = false">预报</div>
    <div v-show="isShow" v-if="forecasts">
      <div>
        {{
          forecasts.province +
          " " +
          forecasts.city +
          " 更新时间: " +
          forecasts.reporttime
        }}
      </div>
      <div v-for="item in forecasts.casts" :key="item.date">
        <div>
          {{
            item.date +
            " 周" +
            item.week +
            " " +
            item.dayweather +
            " " +
            item.nightweather +
            " " +
            item.daytemp +
            " " +
            item.nighttemp +
            " " +
            item.daywind +
            " " +
            item.nightwind +
            " " +
            item.daypower +
            " " +
            item.nightpower
          }}
        </div>
      </div>
      <div class="echarts-wrap">
        <div
          id="echartsdom"
          style="width: 200px; height: 200px; background-color: #00ff00"
        ></div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import * as echarts from 'echarts'

export default {
  name: "AMap",
  data() {
    return {
      isShow: false,
      forecasts: null,
    };
  },
  created() {
    this.getWeather();
  },
  mounted() {
  },
  methods: {
    // 获取天气
    getWeather() {
      const adcode = "110101"; // 行政区编码
      const userKey = "d28bdfe45916aa2df8cce4b38ab2ab2c";

      // extensions=all 表示获取预报的天气
      const url1 = `https://restapi.amap.com/v3/weather/weatherInfo?city=${adcode}&key=${userKey}&extensions=all`;
      // extensions=base 表示获取当前时刻的天气
      // const url2 = `https://restapi.amap.com/v3/weather/weatherInfo?city=${adcode}&key=${userKey}&extensions=base`;

      axios
        .get(url1)
        .then((response) => {
          console.log(response.data);
          this.forecasts = response.data.forecasts[0];

          /**
           * 1. echarts的dom节点只有在forecasts有数据的时候才会通过v-if渲染出来，所以要等到天气接口数据返回之后再初始化echarts
           * 2. 天气数据返回之后，不能立刻执行echarts初始化，因为forecasts数据有了之后，v-if通过了就会渲染dom，这个dom渲染是需要时间的，dom还没渲染好就去初始化echart也会报错，所以通过nextTick方法，让初始化在dom渲染完毕后再执行
           * nextTick是vue的语法，官方文档：https://v2.cn.vuejs.org/v2/api/#Vue-nextTick
           */
          this.$nextTick(() => {
            this.initEcharts()
          })
        })
        .catch(function (error) {
          console.log(error);
        });

      // axios
      //   .get(url2)
      //   .then(function (response) {
      //     console.log(response.data);
      //   })
      //   .catch(function (error) {
      //     console.log(error);
      //   });
    },
    initEcharts() {
      // 基于准备好的dom，初始化echarts实例
      var myChart = echarts.init(document.getElementById("echartsdom"));

      // 指定图表的配置项和数据
      var option = {
        title: {
          text: "ECharts 入门示例",
        },
        tooltip: {},
        legend: {
          data: ["销量"],
        },
        xAxis: {
          data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"],
        },
        yAxis: {},
        series: [
          {
            name: "销量",
            type: "bar",
            data: [5, 20, 36, 10, 10, 20],
          },
        ],
      };

      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
    },
  },
};
</script>
