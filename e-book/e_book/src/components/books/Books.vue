<template>
  <div class="books page">
    <books-header></books-header>
    <books-body v-if="books[0]" :books='books'></books-body>
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
        this.$http.get("http://localhost:4040/static/mock/dataHome.json").then((res)=>{
          const data=res.data.data;
          this.books=data;
        })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
