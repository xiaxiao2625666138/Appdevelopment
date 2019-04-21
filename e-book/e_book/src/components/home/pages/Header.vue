<template>
  <div class="header">
      <span class="ebook" title="change style">ebook</span>
      <input type="text" placeholder="搜索 | 深入理解计算机系统" />
    <p class="login-register">
        <span @click="tologin" class="iconfont">&#xe621; 
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
  props:['status', 'user'],
  methods:{
      tologin:function(event){
          this.$emit('tologin')
          event.preventDefault()
      },
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

.login-register{
    margin-left:10%;
    float:right;
    margin-top:45px;
    cursor:pointer;
}


.login-register span{
    margin-right:40px;
}

input {
    margin-left:30%;
}

.iconfont{
    font-size:22px;
}
</style>
