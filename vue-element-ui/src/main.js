import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

import { Button, Select } from 'element-ui';
// import './element-variables.scss'


import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import router from './router'

Vue.use(ElementUI);
Vue.use(Button);
Vue.use(Select)


Vue.use(router)
new Vue({
  el:'#app',
  router,
  render: h => h(App)
});
