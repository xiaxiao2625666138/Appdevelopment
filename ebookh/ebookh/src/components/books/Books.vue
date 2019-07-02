<template>
  <div class="books page">
    
    <books-header :now="page"></books-header>
    <books-body></books-body>
    <div class="footer">
        <p>Copyright@zxz5141509091</p>
    </div>
  </div>
</template>

<script>
import BooksHeader from './pages/Header'
import BooksBody from './pages/Body'
export default {
  data(){
    return {
      page:"books"
    }
  },
  components:{
    BooksHeader,
    BooksBody,
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
