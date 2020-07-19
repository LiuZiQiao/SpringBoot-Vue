import axios from 'axios';

// const service = axios.create({
//     // process.env.NODE_ENV === 'development' 来判断是否开发环境
//     // easy-mock服务挂了，暂时不使用了
//     // baseURL: 'https://www.easy-mock.com/mock/592501a391470c0ac1fab128',
//     timeout: 5000
// });


const service = axios.create({
    // baseURL: global_.httpRequestUrl,
    baseURL: 'http://localhost:8088/vue-manager',
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
        return config;
    },
    error => {
        console.log(error);
        return Promise.reject();
    }
);

service.interceptors.response.use(
    response => {
        if (response.status === 200) {
            return response.data;
        } else {
            Promise.reject();
        }
    },
    error => {
        console.log(error);
        return Promise.reject();
    }
);

export default service;
