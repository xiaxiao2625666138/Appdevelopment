<template>
  <div class="header">
      <router-link to="./guide" class="ebook">
        <span >ebook</span>
      </router-link>
      <router-link to="./books">
        <span :class="{now: now=='books'}" title="暂时还没有收藏功能">图书浏览</span>
      </router-link>
      <router-link v-if="!adm" to="./shopping">
        <span :class="{now: now=='shopping'}">购物车</span>
      </router-link>
      <router-link v-if="adm" to="./userManage">
        <span :class="{now: now=='userManage'}">用户管理</span>
      </router-link>
      <router-link to="./daijian">
        <span title="暂时还没有推荐功能">求推荐</span>
      </router-link>
      <router-link v-if="!adm" to="./order">
        <span :class="{now: now=='order'}">我的订单</span>
      </router-link>
      <router-link v-if="adm" to="./order">
        <span :class="{now: now=='order'}">订单管理</span>
      </router-link>
      <router-link to="./setting">
        <span :class="{now: now=='setting'}">设置</span>
      </router-link>
    </div>
</template>

<script>
export default {
  props:["now"],
  data:function(){
    return{
        user:"",
        adm: false
    }
  },

  mounted(){
    this.$http.get("/api/page/UserTypeServlet").then((res)=>{
        this.user=res.data.user;
        this.adm=res.data.islogin==2;
    })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.header span{
    margin-right:5%;
    cursor:pointer;
}

.header span:hover{
    color:#555;
}

.ebook{
    margin-right:20%;
}
</style>
