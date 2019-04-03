<template>
  <div class="home page">
    <login-register :ToLogin="ToLogin" :ToRegister="ToRegister" :ToDisplay="ToDisplay"
    class="login-register"></login-register>
    <home-header @tologin="tologin"></home-header>
    <home-body v-if="books[0]" :books='books'></home-body>
    <div class="footer">
        <p>Copyright@zxz5141509091</p>
    </div>
  </div>
</template>

<script>
import HomeHeader from './pages/Header'
import HomeBody from './pages/Body'
import LoginRegister from './pages/LoginRegister'
export default {
  data(){
    return{
      ToLogin:"",
      ToRegister:"",
      ToDisplay:{
        display:"none",
      },
      books:[],
    }
  },
  components:{
    HomeHeader,
    HomeBody,
    LoginRegister,
  },
   mounted(){
        this.$http.get("http://localhost:4040/static/mock/dataHome.json").then((res)=>{
          const data=res.data.data;
          this.books=data;
        })
  },
  methods:{
    tologin:function(){
      this.ToLogin={
        display:"block"
      };
      this.ToRegister={
        display:"none"
      };
      this.ToDisplay.display="block";
    },
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
