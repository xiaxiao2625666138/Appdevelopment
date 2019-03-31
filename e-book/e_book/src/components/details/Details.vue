<template>
  <div class="details page">
    <details-header></details-header>
    <details-body :book='books[0]'></details-body>
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
      books:[],
    }
  },
  components:{
    DetailsHeader,
    DetailsBody,
  },
   mounted(){
        this.$http.get("http://localhost:8080/static/mock/dataHome.json").then((res)=>{
          const data=res.data.data;
          this.books=data;
        })
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
