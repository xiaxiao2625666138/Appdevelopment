import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/home/Home'
import Books from '@/components/books/Books'
import Details from '@/components/details/Details'

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
    }
  ]
})
