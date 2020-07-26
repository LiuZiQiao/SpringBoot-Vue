import axios from 'axios'

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
        console.log(res.status+'----');
        
        if(res.data.code === 0){
          console.log("----------")
        }
        
        if (res.status === 200) {
            return Promise.resolve(res);
        } else {
            Promise.reject(res);
        }
    },
    err => {
        console.log(err);/////??????????
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
