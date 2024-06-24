import request from "./request";
// 查询气象监测各项因子测量值
export const reqWeather = () => request({
    url: '/weather/getWeather',
    method: 'get',
})
// 统计监控设备各种类型的数量
export const reqMonitorNums = () => request({
    url: '/monitor/getMonitorNums',
    method: 'get',
})
// 统计动物各类型数量
export const reqWildlifeNums = () => request({
    url: '/wildlife/getWildlifeNums',
    method: 'get',
})
// 统计植物各类型数量
export const reqWildplantNums = () => request({
    url: '/wildplant/getWildplantNums',
    method: 'get',
})
// 统计告警各类型数量
export const reqAlarmNums = () => request({
    url: '/alarm/getAlarmNums',
    method: 'get',
})
// 统计古树名木各类型数量
export const reqTreesNums = () => request({
    url: '/trees/getTreesNums',
    method: 'get',
})
// 查询综合排名
export const reqRanking = () => request({
    url: '/Ranking/getRanking',
    method: 'get',
})

// 查询图层列表
export const reqLayerList = (data) => request({
    url: '/layers/getLayers',
    method: 'get',
    params: data
})

// 查询全量行政区划
export const reqRegionTree = () => request({
    url: '/region/tree',
    method: 'get'
})