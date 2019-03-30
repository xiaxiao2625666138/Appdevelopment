import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/home/Home'
import Books from '@/components/books/Books'
import Details from '@/components/details/Details'
import Shopping from '@/components/shopping/Shopping'

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
    }
  ]
})
