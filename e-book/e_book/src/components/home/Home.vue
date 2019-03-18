<template>
  <div class="home page">
    <login-register :ToLogin="ToLogin" :ToRegister="ToRegister" :ToDisplay="ToDisplay"
    class="login-register"></login-register>
    <home-header @tologin="tologin"></home-header>
    <home-body></home-body>
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
    }
  },
  components:{
    HomeHeader,
    HomeBody,
    LoginRegister,
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
