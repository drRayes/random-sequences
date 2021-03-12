import Vue from 'vue'
import Router from 'vue-router'
import RandomSequences from '@/components/RandomSequences'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'RandomSequences',
      component: RandomSequences
    }
  ]
})
