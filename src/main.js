import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
// 引入elementui
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
// 引入openlayers样式
import "ol/ol.css"

// datav组件库
// 将自动注册所有组件为全局组件
import dataV from '@jiaminghi/data-view'
Vue.use(dataV)

import EventBus from './utils/bus';
Vue.prototype.$EventBus = EventBus

Vue.config.productionTip = false
Vue.use(ElementUI);

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
