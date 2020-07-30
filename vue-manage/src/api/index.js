// import request from '../utils/request';
import axios from 'axios';

// const service = axios.create({
//     // process.env.NODE_ENV === 'development' 来判断是否开发环境
//     // easy-mock服务挂了，暂时不使用了
//     // baseURL: 'https://www.easy-mock.com/mock/592501a391470c0ac1fab128',
//     timeout: 5000
// });


const service = axios.create({
    // baseURL: global_.httpRequestUrl,
    baseURL: 'http://localhost:8088/Vmanage',
    withCredentials:true,
    headers: {
        'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
    },
    transformRequest: [function(data){
        let newData = '';
        for (let k in data){
            if (data.hasOwnProperty(k) == true){
                newData += encodeURIComponent(k) + '=' + encodeURIComponent(data[k]) +'&';
            }
        }
        return newData;
    }]
});


// http requeset 拦截器
service.interceptors.request.use(
    config => {
        console.log(config);
        return config;
    },
    error => {
        console.log(error);
        return Promise.reject(error);
    }
);

service.interceptors.response.use(

    res => {
        if (res.status === 200) {
            return Promise.resolve(res);
        } else {
            Promise.reject(res);
        }
    },
    err => {
        console.log(err);
        return Promise.reject(err);
    }
);

function apiAxios(method, url, params, response) {
    service({
      method: method,
      url: url,
      data: method === 'POST' || method === 'PUT' ? params : null,
      params: method === 'GET' || method === 'DELETE' ? params : null,
    }).then(function(res) {
      console.log(res);
      response(res);
    }).catch(function(err) {
      console.log(err);
      response(err);
    })
  }

export default {
    get: function(url, params, response) {
        return apiAxios('GET', url, params, response)
    },
    post: function(url, params, response) {
        return apiAxios('POST', url, params, response)
    },
    put: function(url, params, response) {
        return apiAxios('PUT', url, params, response)
    },
    delete: function(url, params, response) {
        return apiAxios('DELETE', url, params, response)
    }
}



/**
 * get方法，对应get请求
 * @param {String} url [请求的url地址]
 * @param {Object} params [请求时携带的参数]
 */
export function get(url, params){
  return new Promise((resolve, reject) =>{
      axios.get(url, {
          params: params
      })
      .then(res => {
          resolve(res.data);
      })
      .catch(err => {
          reject(err.data)
      })
  });
}


/**
 * post方法，对应post请求
 * @param {String} url [请求的url地址]
 * @param {Object} params [请求时携带的参数]
 */
export function post(url, params) {
  return new Promise((resolve, reject) => {
      axios.post(url, QS.stringify(params))
      .then(res => {
          resolve(res.data);
      })
      .catch(err => {
          reject(err.data)
      })
  });
}
