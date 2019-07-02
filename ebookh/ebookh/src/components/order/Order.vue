<template>
  <div class="page">
   <order-header :now="page"></order-header>
   <order-body></order-body>
   <div class="footer">
        <p>Copyright@zxz5141509091</p>
   </div>
  </div>
</template>

<script>
import OrderHeader from '../books/pages/Header'
import OrderBody from "./pages/Body"
export default{
  components:{
    OrderBody,
    OrderHeader,
  },
  data(){
    return{
      page:"order"
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.page{
}
</style>
