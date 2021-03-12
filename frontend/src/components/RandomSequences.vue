<template>
  <div>

    <div>
      <p>Length of array</p>
      <p>{{message}}</p>
      <input v-model="length" type="number"/>
    </div>
    <button @click='generate'>GENERATE</button>
    <div class="tbl-content">
      <table class="responsive-table">
        <tr v-for="selected in getRandomSelected" class="table-row">
          <td v-for="number in selected">{{number}}</td>
        </tr>
      </table>
    </div>

    <div/>
    <button @click='autoGenerate'>AUTO GENERATE</button>
  </div>

</template>
<script>
import {mapGetters} from 'vuex'
export default {
  name: 'RandomSequences',
  data () {
    return {
      length: 10,
      message: 'Please input number between 10 and 100.',
      interval: ''
    }
  },
  computed: {
    ...mapGetters(['getRandomSelected'])
  },
  methods: {
    generate () {
      this.message = 'Please input number between 10 and 100.'
      if (this.length <= 100 && this.length >= 10) {
        window.clearInterval(this.interval)
        this.$store.dispatch('generateSequences', this.length)
      } else {
        this.message = 'INCORRECT NUMBER. Please input number between 10 and 100.'
      }
    },
    autoGenerate () {
      window.clearInterval(this.interval)
      this.$store.dispatch('generateSequences', this.length)
      this.interval = window.setInterval(() => {
        this.$store.dispatch('generateSequences', this.length)
        }, 10000)

    }
  }
}
</script>
<style>
h1{
  font-size: 30px;
  color: #fff;
  text-transform: uppercase;
  font-weight: 300;
  text-align: center;
  margin-bottom: 15px;
}
table{
  width:100%;
  table-layout: fixed;
}
.tbl-content{
  height:300px;
  overflow-x:auto;
  margin-top: 0px;
  border: 1px solid rgba(255,255,255,0.3);
}
th{
  padding: 20px 15px;
  text-align: left;
  font-weight: 500;
  font-size: 12px;
  color: #fff;
  text-transform: uppercase;
}
td{
  padding: 15px;
  text-align: left;
  vertical-align:middle;
  font-weight: 300;
  font-size: 12px;
  color: #fff;
  border-bottom: solid 1px rgba(255,255,255,0.1);
}

/* demo styles */

@import url(https://fonts.googleapis.com/css?family=Roboto:400,500,300,700);
body{
  background: -webkit-linear-gradient(left, #25c481, #25b7c4);
  background: linear-gradient(to right, #25c481, #25b7c4);
  font-family: 'Roboto', sans-serif;
}
/* for custom scrollbar for webkit browser*/

::-webkit-scrollbar {
    width: 6px;
}
::-webkit-scrollbar-track {
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
}
::-webkit-scrollbar-thumb {
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
}
</style>
