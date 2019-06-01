<template>
  <div class="guide">
      <router-link to="./books">
        <p :class="{now: now=='books'}" title="暂时还没有收藏功能">图书浏览</p>
      </router-link>
      <router-link v-if="!adm" to="./shopping">
        <p :class="{now: now=='shopping'}">购物车</p>
      </router-link>
      <router-link v-if="adm" to="./userManage">
        <p :class="{now: now=='userManage'}">用户管理</p>
      </router-link>
      <router-link v-if="!adm && 0" to="./daijian" >
        <p title="暂时还没有推荐功能">求推荐</p>
      </router-link>
      <router-link v-if="!adm" to="./order">
        <p :class="{now: now=='order'}">我的订单</p>
      </router-link>
      <router-link v-if="adm" to="./order">
        <p :class="{now: now=='order'}">订单管理</p>
      </router-link>
      <router-link to="./setting">
        <p :class="{now: now=='setting'}">设置</p>
      </router-link>
    </div>
</template>

<script>
export default {
  props:["now"],
  data:function(){
    return{
        user:"",
        adm: false,
        server:this.GLOBAL.server,
    }
  },

  mounted(){
    this.$http.get(this.server+"/userType").then((res)=>{
        this.adm=res.data==2;
    })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.guide{
  padding:20px 0;
  top:150px;
  left:80px;
  position:absolute;
  background:#fff;
  z-index: 10000;
  border-radius: 10px;
  box-shadow:0 0 30px 0;
  width:160px;
  font-size:20px;
  text-align:center;
}
.guide a{
  color:#000;
}
.guide p{
  height:40px;
  line-height: 40px;
}

.guide p:hover{
  box-shadow:0 0 15px 0;
  border-radius: 5px;
}

</style>
