<template>
  <div class="header">
      <router-link to="/" class="ebook">
        <span>ebook</span>
      </router-link>
        <span>收藏</span>
        <span>购物车</span>
        <span>求推荐</span>
        <span>我的订单</span>
        <span>设置</span>
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
