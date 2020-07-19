import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
          {
              path: '/',
              redirect: '/login'
          },
          {
              path: '/',
              component: () => import(/* webpackChunkName: "home" */ '../components/common/Home.vue'),
              meta: { title: '自述文件' },
              children: [
                  {
                      path: '/dashboard',
                      component: () => import(/* webpackChunkName: "dashboard" */ '../components/pages/Dashboard.vue'),
                      meta: { title: '系统首页' }
                  }
              ]
          },
          {
              path: '/login',
              component: () => import(/* webpackChunkName: "login" */ '../components/pages/Login.vue'),
              meta: { title: '登录' }
          },
          {
              path: '*',
              redirect: '/404'
          }
      ]
  });
