<template>
  <div class="bg">
    <img src="@/assets/img/b.jpg" style="width:100%"/>
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
      var getUrl="http://localhost:8080/ebook/logout";
      this.$http.get(getUrl).then((res)=>{
         console.log(res);
      })
      this.$router.push({path:"/"});
    },
  },
  mounted(){
    this.$http.get("http://localhost:8080/ebook/userType").then((res)=>{
          console.log(res);
          if(res.data==0){
              this.$router.push({path: '/'});
          }else{
              this.user=res.data.user;
              this.adm=(res.data==2);
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
    top:20px;
    left:20px;
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
    border-radius: 10px;
    color:#aaa;
    font-size:16px;
    cursor:pointer;
    box-shadow: 0 0 50px 0;
}

input:hover{
    opacity:.5;
}

input:active{
    opacity:1;
}


</style>
