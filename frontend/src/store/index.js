import Vue from 'vue'
import Vuex from 'vuex'
import {sequences} from './sequences.module.js'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    sequences
  }
})
