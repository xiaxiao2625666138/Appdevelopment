<template>
  <div class="guide">
      <router-link to="./guide" class="title">
        <p>Book Store</p>
      </router-link>
      <div class="guide-item">
        <router-link v-if="adm" to="./userManage">
        <p :class="{now: now=='userManage'}">用户管理</p>
        </router-link>
        <router-link to="./books">
        <p :class="{now: now=='books'}">图书浏览</p>
        </router-link>
        <router-link v-if="!adm" to="./shopping">
        <p :class="{now: now=='shopping'}">购物车</p>
        </router-link>
        <router-link v-if="!adm" to="./order">
        <p :class="{now: now=='order'}">我的订单</p>
        </router-link>
        <router-link v-if="adm" to="./order">
        <p :class="{now: now=='order'}">订单管理</p>
        </router-link>
        <router-link to="./setting" v-if=0>
        <p :class="{now: now=='setting'}">设置</p>
        </router-link>
    </div>
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
.title{
    cursor:pointer;
    font-size:36px;
    font-family:STHupo;
    line-height:40px;
    color:rgba(0, 0, 0, 0.89);
    padding-left:10px;
}
.title:hover{
  opacity: .3;
}
.guide{
  background:#fff;
  background:rgb(239, 240, 234);
  box-shadow:0 0 30px 0;
  font-size:23px;
  padding-top:20px;
  width:100%;
  height:40px;
  font-family: STLiti;
  white-space:nowrap;
  overflow:hidden;
}

.guide div, .guide p, .guide-item p{
  display:inline-block;
}

.guide-item{
  width:100%;
}

.guide-item p{
  width:120px;
  margin: 0 0 0 12%;
  text-align:center;
}


.guide a{
  color:#000;
}
.guide p+p{
  display:inline-block;
}

.guide-item p:hover{
  opacity: .3;
}

</style>
