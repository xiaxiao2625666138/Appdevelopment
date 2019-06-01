<template>
    
  <div class="shopping page">
    <router-link to="./guide" class="ebook">
        <p>Book Store</p>
    </router-link>
    <shopping-header :now="page"></shopping-header>
    <shopping-body></shopping-body>
    <div class="footer">
      <p>Copyright@zxz5141509091</p>
    </div>
  </div>
</template>

<script>
import ShoppingHeader from '../books/pages/Header'
import ShoppingBody from './pages/Body'
export default {
  data(){
    return{
      page:"shopping",
    }
  },
  components:{
    ShoppingHeader,
    ShoppingBody,
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.body{
  width:600px;
  height:800px;
  background:red;
  margin:0 auto;
}
.footer{
  margin-top:60px;
}
</style>
