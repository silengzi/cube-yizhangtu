import Vue from 'vue';

// 创建一个新的Vue实例作为事件总线
const EventBus = new Vue();

// 导出该实例，以便在应用程序中的其他地方使用
export default EventBus;