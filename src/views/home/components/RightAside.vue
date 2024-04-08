<template>
  <div class="right">
    <dv-border-box-10 backgroundColor="rgb(4, 47, 84, 0.7)">
      <div class="wrapper">
        <div class="top">
          <dv-decoration-7
            class="titleDecoration"
            style="width:150px;height:30px;"
          >
            <div class="title">
              告警统计
            </div>
          </dv-decoration-7>
          <dv-decoration-10 style="width:100%;height:5px;" />
          <!-- 饼图 -->
          <div class="pie">
            <div
              class="pie-chart"
              ref="pieChart"
            ></div>
          </div>
        </div>
        <div class="center">
          <dv-decoration-7
            class="titleDecoration"
            style="width:150px;height:30px;"
          >
            <div class="title">
              古树名木
            </div>
          </dv-decoration-7>
          <dv-decoration-10 style="width:100%;height:5px;" />
          <div class="bar">
            <div
              class="bar-chart"
              ref="barChart"
            ></div>
          </div>
        </div>
        <div class="bottom">
          <dv-decoration-7
            class="titleDecoration"
            style="width:150px;height:30px;"
          >
            <div class="title">
              综合排名
            </div>
          </dv-decoration-7>
          <dv-decoration-10 style="width:100%;height:5px;" />
          <div class="rank">
            <dv-scroll-ranking-board
              class="scroll-ranking-board"
              :config="config"
            />
          </div>
        </div>
      </div>
    </dv-border-box-10>
  </div>
</template>

<script>
// 引入echarts
import * as echarts from 'echarts'
export default {
  name: '',
  data() {
    return {
      // 饼图数据
      pieData: [
        { value: 335, name: '火灾告警' },
        { value: 310, name: '非法活动' },
        { value: 234, name: '野生动物异常' },
        { value: 350, name: '自然灾害' },
        { value: 555, name: '环境污染' }
      ],
      // 柱状图数据
      barXData: ['乔木', '灌木', '草本'],
      // 综合排名数据
      config: {
        data: [
          {
            name: '阳泉',
            value: 55
          },
          {
            name: '太原',
            value: 120
          },
          {
            name: '晋中',
            value: 78
          },
          {
            name: '临汾',
            value: 66
          },
          {
            name: '大同',
            value: 80
          },
          {
            name: '运城',
            value: 45
          },
          {
            name: '朔州',
            value: 29
          }
        ],
      }

    };
  },
  mounted() {
    this.renderPieChart()
    this.renderBarChart()
  },
  methods: {
    // 饼图渲染
    renderPieChart() {
      const pieChart = echarts.init(this.$refs.pieChart)
      const option = {
        tooltip: {
          trigger: 'item'
        },
        legend: {
          type: 'scroll',
          data: ['火灾告警', '非法活动', '野生动物异常', '自然灾害', '环境污染'],
          top: 'bottom',
          left: '20',
          textStyle: {
            color: '#fff'
          }
        },
        toolbox: {
          show: false,
          feature: {
            // mark: { show: true },
            // dataView: { show: true, readOnly: false },
            // restore: { show: true },
            // saveAsImage: { show: true }
          }
        },
        series: [
          {
            name: '告警统计',
            type: 'pie',
            radius: [30, 70],
            center: ['50%', '50%'],
            // roseType: 'area',
            // itemStyle: {
            //   borderRadius: 8
            // },
            data: this.pieData,
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      };
      pieChart.setOption(option);
    },
    // 柱状图渲染
    renderBarChart() {
      const barChart = echarts.init(this.$refs.barChart)
      const option = {
        xAxis: {
          type: 'category',
          data: this.barXData,
          // 坐标轴样式
          axisLine: {
            lineStyle: {
              color: '#9daab8'
            }
          },
          // 坐标轴标签样式
          axisLabel: {
            color: '#fff'
          }
        },
        yAxis: {
          type: 'value',

          // 坐标轴样式
          axisLine: {
            show: true,
            lineStyle: {
              color: '#9daab8'
            }
          },
          // 坐标轴标签样式
          axisLabel: {
            color: '#fff'
          },
          // 显示分割线
          splitLine: {
            show: false,
          }
        },
        series: [
          {
            data: [
              {
                value: 100,
                itemStyle: {
                  color: 'rgb(0, 255, 255)',
                }
              },
              {
                value: 156,
                itemStyle: {
                  color: 'rgb(255, 192, 203)',
                }
              },
              {
                value: 145,
                itemStyle: {
                  color: 'rgb(255, 255, 192)',
                }
              },
            ],
            // 柱宽
            barWidth: '40%',
            type: 'bar',
            itemStyle: {
              color: 'rgb(0, 255, 255)'
            }
          }
        ]
      }
      barChart.setOption(option);
    }

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

      .pie {
        width: 100%;
        height: 80%;
        display: flex;
        justify-content: center;
        align-items: center;

        .pie-chart {
          width: 100%;
          height: 100%;
        }
      }
    }
    .center {
      flex: 1;

      .bar {
        width: 100%;
        height: 80%;
        display: flex;
        justify-content: center;
        align-items: center;

        .bar-chart {
          width: 100%;
          height: 100%;
        }
      }
    }
    .bottom {
      flex: 1;
      .rank {
        width: 100%;
        height: 80%;
        display: flex;
        justify-content: center;
        align-items: center;

        .scroll-ranking-board {
          width:300px;
          height:200px;
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
