<template>
  <div class="home page">
    <logout :user="user" :class="{close: !Tologout, open: Tologout}" @tologout="tologout"></logout>
    <home-header :islogin="islogin" :user="user" @tologout="tologout"></home-header>
    <home-body :books='books'></home-body>
    <div class="footer">
        <p>Copyright@zxz5141509091</p>
    </div>
  </div>
</template>

<script>
import HomeHeader from './pages/Header'
import HomeBody from './pages/Body'
import Logout from './pages/Logout'
export default {
  data(){
    return{
      books:[],
      user:"",
      islogin:0,
      Tologout: false,
    }
  },
  components:{
    HomeHeader,
    HomeBody,
    Logout,
  },
   mounted(){
        this.$http.get("/api/page/HomeServlet?filter=all").then((res)=>{
          console.log(res);
            if(res.data==302){
              this.$router.push({path:"/"});
            }else{
              this.books=res.data.bookArr;
              this.user=res.data.username;
              this.islogin=res.data.islogin;
            }
        })
  },
  methods:{
    tologout:function(){
      this.Tologout=!this.Tologout;
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.close{
  display:none;
}

.open{
  display:block;
}
</style>
