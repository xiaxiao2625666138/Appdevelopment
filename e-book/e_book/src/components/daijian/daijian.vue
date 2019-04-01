<template>
  <div class="daijian page">
   <daijian-header></daijian-header>
   <daijian-body></daijian-body>
   <div class="footer">
        <p>Copyright@zxz5141509091</p>
   </div>
  </div>
</template>

<script>
import DaijianHeader from '../books/pages/Header'
import DaijianBody from "./pages/Body"
export default{
  components:{
    DaijianBody,
    DaijianHeader,
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.daijian{
}
</style>
