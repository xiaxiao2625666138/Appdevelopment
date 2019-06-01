import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Books from '@/components/books/Books'
import Shopping from '@/components/shopping/Shopping'
import Daijian from '@/components/daijian/Daijian'
import Setting from '@/components/setting/setting'
import Order from '@/components/order/Order'
import Guide from '@/components/guide/Guide'
import UserManage from '@/components/userManage/UserManage'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login 
    },
    {
      path: '/books',
      name:'Books',
      component:Books
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
    },
    {
      path:'/order',
      name:'Order',
      component:Order
    },
    {
      path:'/guide',
      name:'guide',
      component:Guide
    },
    {
      path:'/userManage',
      name:'userManage',
      component:UserManage
    }
  ]
})
