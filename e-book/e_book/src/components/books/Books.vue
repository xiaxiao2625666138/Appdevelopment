<template>
  <div class="books page">
    <books-header></books-header>
    <books-body :books='books'></books-body>
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
      books:[],
    }
  },
  components:{
    BooksHeader,
    BooksBody,
  },
  mounted(){
        this.$http.get("/api/HomeServlet").then((res)=>{
          console.log(res);
          const data=res.data.bookArr;
          this.books=data;
        })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
