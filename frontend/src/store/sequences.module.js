import axios from 'axios'
const API_URL = '/api'
export const sequences = {
  state: {
    sequences: [],
    randomSelected: []
  },
  getters: {
    getSequences (state) {
      return state.sequences
    },
    getRandomSelected (state) {
      return state.randomSelected
    }
  },
  actions: {
    generateSequences (ctx, length) {
      axios
        .get(API_URL + '/generate/' + length)
        .then(response => {
        (ctx.commit('updateSequences', response.data))
        const selectedSequences = []
        const sequences = response.data
        for (let i = 0; i < sequences.length; i++) {
          const array = []
          while (array.length < 6) {
            let number = Math.floor(Math.random() * Math.floor(sequences[i].length))
            let selectedNumber = sequences[i][number]
            let exist = false
            array.forEach(element => {
              if (element === selectedNumber) {
                exist = true
              }
            })
            if (!exist) {
              array.push(selectedNumber)
            }
          }
          selectedSequences[i] = array
        }
        ctx.commit('updateRandomSelected', selectedSequences)
        })
    },
    setSequences (ctx, sequences) {
      ctx.commit('updateSequences', sequences)
    }
  },
  mutations: {
    updateSequences (state, sequences) {
      state.sequences = sequences
    },
    updateRandomSelected (state, randomSelected) {
      state.randomSelected = randomSelected
    }
  }
}
