import Vue from 'vue'
import Router from 'vue-router'
import accountPage from '@/components/accountPage'
import loginPage from '@/components/loginPage'
import signPage from '@/components/signPage'
import workPage from '@/components/workPage'
import addressPage from '@/components/addressPage'
import signUpPage from '@/components/signUpPage'
import finishPage from '@/components/finishPage'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'loginPage',
      component: loginPage
    },
    {
      path: '/signPage',
      name: 'signPage',
      component: signPage
    },
    {
      path: '/accountPage',
      name: 'accountPage',
      component: accountPage
    },
    {
      path: '/workPage',
      name: 'workPage',
      component: workPage
    },
    {
      path: '/addressPage',
      name: 'addressPage',
      component: addressPage
    },
    {
      path: '/signUpPage',
      name: 'signUpPage',
      component: signUpPage
    },
    {
      path: '/finishPage',
      name: 'finishPage',
      component: finishPage
    }
  ]
})
