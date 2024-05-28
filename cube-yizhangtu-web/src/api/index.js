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