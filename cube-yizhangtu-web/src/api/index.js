import request from "./request";
export const reqWeather = () => request({
    url: '/weather/getWeather',
    method: 'get',
})