<template>
  <div class="header">
      <span class="ebook" title="change style">ebook</span>
      <input type="text" placeholder="搜索 | 深入理解计算机系统" />
    <p class="logout">
        <span @click="tologout" class="iconfont">&#xe621; 
            <span style="font-size:15px;color:orange">{{user}}</span>
        </span> 
        <router-link to="./shopping">
            <span class="iconfont">&#xe631;</span>
        </router-link>
    </p>
  </div>
</template>

<script>
export default {
  props:['user'],
  methods:{
      tologout:function(event){
          this.$emit('tologout')
          event.preventDefault()
      },
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

.logout{
    margin-left:10%;
    float:right;
    margin-top:45px;
    cursor:pointer;
}


.logout span{
    margin-right:40px;
}

input {
    margin-left:30%;
}

.iconfont{
    font-size:22px;
}
</style>
