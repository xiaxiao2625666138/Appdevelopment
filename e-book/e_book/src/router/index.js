import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/home/Home'
import Books from '@/components/books/Books'
import Details from '@/components/details/Details'
import Shopping from '@/components/shopping/Shopping'
import Daijian from '@/components/daijian/Daijian'
import Setting from '@/components/setting/setting'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home 
    },
    {
      path: '/books',
      name:'Books',
      component:Books
    },
    {
      path:'/details',
      name:'Details',
      component:Details
    },
    {
      path:'/shopping',
      name:'Shopping',
      component:Shopping
    },
    {
      path:'/daijian',
      name:'Daijian',
      component:Daijian
    },
    {
      path:'/setting',
      name:'Setting',
      component:Setting
    }
  ]
})
