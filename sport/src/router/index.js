import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)
const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

import Main from '@/pages/Main'
import Dashboard from '@/pages/Dashboard'
import User from '@/pages/User'
import Log from '@/pages/Log'
import Login from '@/pages/Login'
import Student from '@/pages/Student'
import Score from '@/pages/Score'
import Teacher from '@/pages/Teacher'
import BasicData from '@/pages/BasicData'

let routes = [
  {
    path: '/login',
    name: 'login',
    component: Login
  },
  {
    path: '/',
    component: Main,
    hidden: true,
    children: [{
      path: '/home',
      component: Dashboard,
      name: '系统管理',
    }]
  },{
    path: '/',
    component: Main,
    name: '系统管理',
    iconCls: 'fa fa-cog fa-fw',
    children: [
      {
        path: '/student',
        component: Student,
        name: '学生管理',
        iconCls: 'fa fa-user-o fa-fw'
      },
      {
        path: '/score',
        component: Score,
        name: '成绩管理',
        auth:'student',
        iconCls: 'fa fa-file-text-o fa-fw'
      },
      {
        path: '/teacher',
        component: Teacher,
        name: '教师管理',
        auth:'teacher',
        iconCls: 'fa fa-user-circle fa-fw'
      },
      {
        path: '/basic-data',
        component: BasicData,
        name: '基础数据',
        auth:'teacher',
        iconCls: 'fa fa-database fa-fw'
      },
      {
        path: '/user',
        component: User,
        name: '用户管理',
        iconCls: 'fa fa-user-o fa-fw'
      },
      {
        path: '/log',
        component: Log,
        name: '日志管理',
        iconCls: 'fa fa-file-text-o fa-fw'
      }
    ]
  }
]

const router = new Router({
  mode: 'history',
  base: '/sport',
  routes: routes
})

export default router
