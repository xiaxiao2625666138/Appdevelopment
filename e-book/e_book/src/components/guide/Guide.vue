<template>
  <div class="bg">
    <img src="@/assets/img/guide1.jpg" style="width:100%"/>
    <div class="fg"></div>
    <span class="ebook">ebook</span>
    <div class="fun">
        <div class="buttons">
        <router-link to="./books">
            <input type="button" value="图书浏览" />
        </router-link>
        <router-link  v-if="!adm" to="./shopping">
            <input type="button" value="购物车" />
        </router-link>
        <router-link v-if="adm" to="./userManage">
            <input type="button" value="用户管理" />
        </router-link>
        <router-link  v-if="!adm" to="./order">
            <input type="button" value="我的订单" />
        </router-link>
        <router-link   v-if="adm" to="./order">
            <input type="button" value="订单管理" />
        </router-link>
        <input type="button" value="退出" @click="logout" />
        </div>
    </div>
  </div>
</template>

<script>
export default {
  data:function(){
    return{
        user:"",
        adm: false
    }
  },
  methods:{ 
    logout:function(){
      var getUrl="/api/page/LogoutServlet?";
      this.$http.get(getUrl).then((res)=>{
         console.log(res);
      })
      this.$router.push({path:"/"});
    },
  },
  mounted(){
    this.$http.get("/api/page/UserTypeServlet").then((res)=>{
          console.log(res);
          if(res.data==302){
              this.$router.push({path: '/'});
          }else{
              this.user=res.data.user;
              this.adm=res.data.islogin==2;
          }
    })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.bg{
    width:100vw;
    height:100vh;
    background:#444;
    overflow:hidden;
}
.bg img:hover{
   opacity:1;
}

.fg{
    position:absolute;
    top:0px;
    width:100vw;
    height:100vh;
    background:#fff;
    opacity:.5;
    z-index:100;
}

.ebook{
    position:absolute;
    top:0;
    left:0;
    right:0;
    color:black;
    opacity:1;
    z-index:1000;
}

.fun{
    position:absolute;
    z-index:1000;
    top:25%;
    width:100%;
}

.buttons{
    width:400px;
    margin:0 auto;
}

.buttons input{
    margin: 0 auto;
    display:block;
    margin:30px;
    width:300px;
    height:40px;
    background:#000;
    opacity: .8;
    border-radius: 10px;
    color:#aaa;
    font-size:16px;
    cursor:pointer;
}

input:hover{
    opacity:1;
}

input:active{
    opacity:.4;
}


</style>
