import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Index from '../views/Index.vue'
import Form from '../views/Form.vue'
import Button from '../views/Button.vue'
import Menu from '../views/Menu.vue'
Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
	  path: '/index',
	  name: 'Index',
	  component: Index
  },
  {
  	  path: '/form',
  	  name: 'From',
  	  component: Form
  },
  {
	  path: '/button',
	  name: 'Button',
	  component: Button
  },
  {
  	  path: '/menu',
  	  name: 'Menu',
  	  component: Menu
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
