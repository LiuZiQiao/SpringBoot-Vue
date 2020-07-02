import axios from 'axios'
import{
    Message
}from 'element-ui'
import global_ from '../components/Global'
import router from '../router'

// import Cookies from 'js-cookie'
// axios.defaults.baseURL = 'http:localhost:8088/sport'


// let token = sessionStorage.getItem("token");
let http = axios.create({
    // baseURL: global_.httpRequestUrl,
    baseURL: 'http://localhost:8089/sport',
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
http.interceptors.request.use(
    config => {
        console.log(config);
        console.log("url-->"+config.url);
        console.log("data-->"+config.data);
        console.log("headers-->"+config.headers);
        console.log("method-->"+config.method);
        console.log("params-->"+config.params);
        if(config.url.indexOf('/login/userLogin')>=0){
            return config;
        }else{
            let token = sessionStorage.getItem("token");
            if(token){
                config.headers.token = token;
            }
            console.log(config);
            return config;
        }
    },
    err =>{
        return Promise.reject(err);
    }
)


/** 
 * get方法，对应get请求 
 * @param {String} url [请求的url地址] 
 * @param {Object} params [请求时携带的参数] 
 */
// export function get(url, params){    
//   return new Promise((resolve, reject) =>{        
//       axios.get(url, {            
//           params: params        
//       })        
//       .then(res => {            
//           resolve(res.data);        
//       })        
//       .catch(err => {            
//           reject(err.data)        
//       })    
//   });
// }


// /** 
//  * post方法，对应post请求 
//  * @param {String} url [请求的url地址] 
//  * @param {Object} params [请求时携带的参数] 
//  */
// export function post(url, params) {    
//   return new Promise((resolve, reject) => {         
//       axios.post(url, QS.stringify(params))        
//       .then(res => {            
//           resolve(res.data);        
//       })        
//       .catch(err => {            
//           reject(err.data)        
//       })    
//   });
// }


/*
 * Promise(ES6语法糖)
 * 他是一个对象，是用来处理异步操作的，可以让我们写异步调用的时候写起来更加优雅，更加美观便于阅读。
 * 顾名思义为承诺、许诺的意思，意思是使用了Promise之后他肯定会给我们答复，无论成功或者失败都会给我们一个答复，所以我们就不用担心他跑了哈哈。
 * 所以，Promise有三种状态：pending（进行中），resolved（完成），rejected（失败）。
 * 只有异步返回的结构可以改变其状态。所以，promise的过程一般只有两种：
 * pending->resolved(完成)
 * pending->rejected(失败)
 *
 * */
http.interceptors.response.use(
  res  => {

    console.log(res.status);

    if(res.data.code == 2 || res.data.code == 3){

      Message({
        showClose: true,
        message: '登录信息失效，请重新登录!',
        type: 'error',
        duration: 2000
      })

      //携带当前页面路由，以在登录页面完成登录后返回当前页面
      router.replace({
        path: '/login',
        query: {
          redirect: router.currentRoute.fullPath
        }
      });
    }

    if (res.status === 200) {
      return Promise.resolve(res);
    } else {
      return Promise.reject(res);
    }
  },
  err => {
    return Promise.reject(err);
  });


  function apiAxios(method, url, params, response) {
    http({
      method: method,
      url: url,
      // data: ((method === 'POST') || (method === 'PUT')) ? params : null,
      // params: ((method === 'GET') || (method === 'DELETE')) ? params : null,
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