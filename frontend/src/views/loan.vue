<template lang="">
    <div>
        <navbar></navbar>
        <loan style="width:980px;height:100%;margin:auto"></loan>
    </div>
</template>
<script>
import Navbar from '../components/Navbar.vue';
import Loan from '../components/Loan.vue';
export default {
    components: {
      Navbar,
      Loan,
    },
    data(){
        return{
            schdulList:[],
        }
    },
   created(){
    
  }
}
</script>
<style lang="">
    
</style>