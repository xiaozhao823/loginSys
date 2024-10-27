import request from '../utils/request'

export function loginFun(data) {
  return request({
    url: '/api/login',
    method: 'post',
    data: data
  })
}

export function updateFun(data) {
  return request({
    url: '/api/update',
    method: 'post',
    data: data
  })
}