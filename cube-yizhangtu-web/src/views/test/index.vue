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
            :props="{
              expandTrigger: 'hover',
              label: 'name',
              value: 'area_code',
            }"
            clearable
            @change="handleChangeXzqh"
          ></el-cascader>
        </div>
        <div class="date">
          <el-date-picker v-model="dateValue" type="year" placeholder="选择年">
          </el-date-picker>
        </div>
        <LayerList></LayerList>
        <Legend></Legend>
      </div>
      <RightAside></RightAside>
    </div>
    <div class="mainMap">
      <Map ref="map"></Map>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import Header from "@/components/header.vue";
import Map from "@/views/test/components/Map.vue";
import LeftAside from "@/views/test/components/LeftAside.vue";
import RightAside from "@/views/test/components/RightAside.vue";
import LayerList from "@/views/test/components/LayerList.vue";
import Legend from "@/views/test/components/Legend.vue";

import { reqRegionTree } from "@/api";

export default {
  name: "Home",
  components: {
    Header,
    Map,
    LeftAside,
    RightAside,
    LayerList,
    Legend,
  },
  data() {
    return {
      value: [],
      options: [
        // {
        //   value: 'shandongsheng',
        //   label: '山东省',
        //   children: [
        //     {
        //       value: 'jinanshi',
        //       label: '济南市',
        //       children: [
        //         {
        //           value: 'lixiaqu',
        //           label: '历下区',
        //         },
        //         {
        //           value: 'gaoxinqu',
        //           label: '高新区',
        //         },
        //       ]
        //     },
        //     {
        //       value: 'weifangshi',
        //       label: '潍坊市',
        //       children: [
        //         {
        //           value: 'shouguangshi',
        //           label: '寿光市'
        //         },
        //         {
        //           value: 'weichengqu',
        //           label: '潍城区'
        //         },
        //       ]
        //     },
        //   ]
        // },
        // {
        //   value: 'shanxisheng',
        //   label: '山西省',
        //   children: [
        //     {
        //       value: 'taiyuanshi',
        //       label: '太原市',
        //       children: [
        //         {
        //           value: 'jiancaopingqu',
        //           label: '尖草坪区',
        //         },
        //         {
        //           value: 'xiaodianqu',
        //           label: '小店区',
        //         },
        //       ]
        //     },
        //     {
        //       value: 'yangquanshi',
        //       label: '阳泉市',
        //       children: [
        //         {
        //           value: 'yuxian',
        //           label: '盂县'
        //         },
        //         {
        //           value: 'chengqu',
        //           label: '城区'
        //         },
        //       ]
        //     },
        //   ]
        // },
      ],
      dateValue: "",
      layerName: ["1"],
      administration: [], // 行政区划
      monitor: "", // 监控
      facilities: "", // 防火设施
    };
  },
  mounted() {
    this.getRegionTree();
  },
  methods: {
    async getRegionTree() {
      let result = await reqRegionTree();
      let res = result.data;
      this.options = res;

      // 获取到所有行政区划后，给个默认值
      const _default = [];
      const province = res[0];
      _default.push(province.area_code);

      if (province.children && province.children.length) {
        const city = province.children[0];
        _default.push(city.area_code);

        if (city.children && city.children.length) {
          const country = city.children[0];
          _default.push(country.area_code);
        }
      }

      this.$nextTick(() => {
        this.value = _default;
        this.handleChangeXzqh(this.value); // 赋值不会触发组件的事件，需要手动触发一下
      });
    },
    /**
     * 行政区划改变的事件
     * 使对应的省级行政区划高亮显示
     */
    handleChangeXzqh(val) {
      const provinceCode = val[0]; // 获取省级编码
      this.$refs.map.createHeightLightFeature(provinceCode); // 调用Map组件的方法来生成高亮要素
    },
  },
};
</script>

<style lang="less" scoped>
.home {
  position: relative;

  .main {
    height: calc(100vh - 67px);
    .center {
      height: 100%;
    }
  }
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
}
</style>
