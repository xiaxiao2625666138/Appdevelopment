import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Books from '@/components/books/Books'
import Shopping from '@/components/shopping/Shopping'
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
