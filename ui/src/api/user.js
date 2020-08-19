import request from '@/utils/request'

export function login(data) {
  const headers = {
    'Authorization': 'Basic ' + btoa(data.username + ':' + data.password)
  }
  return request({
    url: '/api/token',
    method: 'get',
    headers,
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/logout',
    method: 'post'
  })
}
