// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

Vue.config.productionTip = false

//css
import './assets/css/reset.css'
import './assets/css/iconfont.css'

//js
import FastClick from 'fastclick'
FastClick.attach(document.body);

//axios
import axios from 'axios'
axios.defaults.withCredentials = true;
Vue.prototype.$http=axios

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
