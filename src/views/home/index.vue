<template>
  <div class="home">
    <Header />
    <div class="main">
      <LeftAside></LeftAside>
      <div class="center">
        <div class="select">
          <el-cascader
            v-model="value"
            :options="options"
            :props="{ expandTrigger: 'hover' }"
            clearable
          ></el-cascader>
        </div>
        <div class="date">
          <el-date-picker
            v-model="dateValue"
            type="year"
            placeholder="选择年"
          >
          </el-date-picker>
        </div>
        <!-- <div class="layerList">
          <dv-border-box-12 class="mask" backgroundColor="rgb(4, 47, 84, 0.7)">
            <div>
              <div class="title">
                <img
                  src="@/assets/layers.png"
                  alt=""
                >
                <span>图层列表</span>
              </div>
              <div class="layerContent">
                <el-collapse v-model="layerName">
                  <el-collapse-item class="item" title="行政区划" name="1">
                    <el-checkbox-group v-model="administration">
                      <el-checkbox label="行政区划" checked></el-checkbox>
                    </el-checkbox-group>
                  </el-collapse-item>
                  <el-collapse-item class="item" title="监控设备" name="2">
                    <el-radio-group v-model="monitor">
                      <el-radio label="监控塔"></el-radio>
                      <el-radio label="卡口"></el-radio>
                    </el-radio-group>
                  </el-collapse-item>
                  <el-collapse-item class="item" title="防火设施" name="3">
                    <el-radio-group v-model="facilities">
                      <el-radio label="消防队"></el-radio>
                      <el-radio label="物资库"></el-radio>
                      <el-radio label="取水点"></el-radio>
                      <el-radio label="防火道路"></el-radio>
                      <el-radio label="阻隔带"></el-radio>
                    </el-radio-group>
                  </el-collapse-item>
                </el-collapse>
              </div>
            </div>
          </dv-border-box-12>
        </div> -->
        <LayerList></LayerList>
        <div class="legend">
          <dv-border-box-12 backgroundColor="rgb(4, 47, 84, 0.7)">
            <span>图例</span>
          </dv-border-box-12>
        </div>
      </div>
      <RightAside></RightAside>
    </div>
    <div class="mainMap">
      <Map></Map>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import Header from '@/components/header.vue'
import Map from '@/views/home/components/Map.vue'
import LeftAside from '@/views/home/components/LeftAside.vue'
import RightAside from '@/views/home/components/RightAside.vue'
import LayerList from '@/views/home/components/LayerList.vue'

export default {
  name: 'Home',
  components: {
    Header,
    Map,
    LeftAside,
    RightAside,
    LayerList,
  },
  data() {
    return {
      value: [],
      options: [
        {
          value: 'shandongsheng',
          label: '山东省',
          children: [
            {
              value: 'jinanshi',
              label: '济南市',
              children: [
                {
                  value: 'lixiaqu',
                  label: '历下区',
                },
                {
                  value: 'gaoxinqu',
                  label: '高新区',
                },
              ]
            },
            {
              value: 'weifangshi',
              label: '潍坊市',
              children: [
                {
                  value: 'shouguangshi',
                  label: '寿光市'
                },
                {
                  value: 'weichengqu',
                  label: '潍城区'
                },
              ]
            },
          ]
        },
        {
          value: 'shanxisheng',
          label: '山西省',
          children: [
            {
              value: 'taiyuanshi',
              label: '太原市',
              children: [
                {
                  value: 'jiancaopingqu',
                  label: '尖草坪区',
                },
                {
                  value: 'xiaodianqu',
                  label: '小店区',
                },
              ]
            },
            {
              value: 'yangquanshi',
              label: '阳泉市',
              children: [
                {
                  value: 'yuxian',
                  label: '盂县'
                },
                {
                  value: 'chengqu',
                  label: '城区'
                },
              ]
            },
          ]
        },
      ],
      dateValue: '',
      layerName: ['1'],
      administration: [], // 行政区划
      monitor: '', // 监控
      facilities: '', // 防火设施
    }
  }
}
</script>

<style lang="less" scoped>
.home {
  position: relative;
  
 
  .mainMap {
    width: 100%;
    height: calc(100vh - 67px);
    position: absolute;
    top: 67px;
    left: 0;
    z-index: 1;
  }
  .select {
    position: relative;
    .el-cascader {
      z-index: 2;
      position: absolute;
      top: 5px;
      left: 21%;
    }
  }
  .date {
    position: absolute;
    z-index: 2;
    position: absolute;
    top: 72px;
    left: calc(222px + 21%);
  }
  
  .legend {
    position: relative;
    .dv-border-box-12 {
      width: 200px;
      height: 150px;
      z-index: 2;
      position: absolute;
      top: calc(100vh - 220px);
      left: 20%;

      span {
        color: #fff;
        position: absolute;
        top: 15px;
        left: 18px;
      }
    }
  }
}
</style>