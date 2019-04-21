<template>
  <div class="home page">
    <login-register :ToLogin="ToLogin" :ToRegister="ToRegister" 
    :ToDisplay="ToDisplay" :islogin="islogin" class="login-register"
    @loginSuc="loginSuc"></login-register>
    <logout :ToLogout="ToLogout" @logoutSuc="logoutSuc" :name="user"></logout>
    <home-header @tologin="tologin" :islogin="islogin" :user="user"></home-header>
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
import Logout from './pages/Logout'
export default {
  data(){
    return{
      ToLogin:"",
      ToRegister:"",
      ToDisplay:{
        display:"none",
      },
      ToLogout:{
        display:"none",
      },
      books:[],
      user:"",
      islogin:0,
    }
  },
  components:{
    HomeHeader,
    HomeBody,
    LoginRegister,
    Logout,
  },
   mounted(){
        this.$http.get("/api/HomeServlet").then((res)=>{
          console.log(res);
          this.books=res.data.bookArr;
          this.user=res.data.username;
          this.islogin=res.data.islogin;
        })
  },
  methods:{
    tologin:function(){
      if(this.islogin==0){
        this.ToLogin={
          display:"block"
        };
        this.ToRegister={
          display:"none"
        };
        this.ToDisplay.display="block";
      }else{
        this.ToLogout.display="block";
      }
          
    },
    loginSuc:function(name){
      this.islogin=1;
      this.user=name;
    },
    logoutSuc:function(){
      this.islogin=0;
      this.user="";
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
