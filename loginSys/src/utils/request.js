import axios from 'axios'

const service = axios.create({
  timeout: 1000 * 1000000,
  withCredentials: true,
  BASE_URL: '/api',
  headers: {
     'Content-Type': 'application/json; charset=utf-8'
   }
})
export default service
