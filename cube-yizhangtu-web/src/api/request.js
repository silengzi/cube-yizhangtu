import axios from 'axios'
const request = axios.create({
    baseURL: '/api',
    timeOut: 5000,
})
export default request