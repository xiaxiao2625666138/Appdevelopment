<template>
  <div class="details page">
    <details-header></details-header>
    <details-body v-if="book" :book="book"></details-body>
    <div class="footer">
        <p>Copyright@zxz5141509091</p>
    </div>
  </div>
</template>

<script>
import DetailsHeader from '../books/pages/Header'
import DetailsBody from './pages/Body'
export default {
  data(){
    return {
      book:{},
      bid:this.$route.query.bid
    }
  },
  components:{
    DetailsHeader,
    DetailsBody,
  },
   mounted(){
        this.$http.get("/api/DetailServlet?book_id="+this.bid).then((res)=>{
          console.log(res);
          const data=res.data;
          this.book=data;
        })
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
