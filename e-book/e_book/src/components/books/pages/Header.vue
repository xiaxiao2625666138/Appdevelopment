<template>
  <div class="header">
      <router-link to="/" class="ebook">
        <span>ebook</span>
      </router-link>
      <router-link to="./daijian">
        <span title="暂时还没有收藏功能">收藏</span>
      </router-link>
      <router-link to="./shopping">
        <span>购物车</span>
      </router-link>
      <router-link to="./daijian">
        <span title="暂时还没有推荐功能">求推荐</span>
      </router-link>
      <router-link to="./daijian">
        <span title="暂时还没有我的订单功能">我的订单</span>
      </router-link>
      <router-link to="./setting">
        <span title="暂时还没有设置功能">设置</span>
      </router-link>
    </div>
</template>

<script>
export default {
  
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.header span{
    margin-right:5%;
    cursor:pointer;
}

.header span:hover{
    color:#333;
}

.ebook{
    margin-right:20%;
}
</style>
