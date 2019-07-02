<template>
<div class="body">
    <span @click="close" class="iconfont close">&#xe658;</span>
    <p class="title">在 <span class="highlight">{{begin}}</span> 至 <span class="highlight">{{end}}</span> 时间内</p>
    <p class="userConsume" v-for="item in userConsume">
        <span class="span"> 用户: <span>{{item[0]}} </span></span>
        <span class="span">共计购书: <span class="highlight">{{item[1]}}</span> 册</span>
        <span class="span"> 累计消费: <span class="highlight">￥ {{item[2]}}</span> </span>
    </p>
</div>
</template>

<script>
export default {
  props:["begin", "end", "userConsume"],
  data(){
    return {
    }
  },
  methods:{

      close:function(){
          this.$emit("close");
      }
     
  },
  mounted(){
    
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.body{
    width:100%;
    position:absolute;
    background:rgb(239, 240, 234);
    height:100%;
    z-index:100000;
}

.body p{
    clear:both;
    background:rgb(56, 52, 47);
    color:rgb(177, 169, 169);
    height:60px;
    line-height:60px;
    margin:5px 0;
    border-radius:5px;
    font-size:20px;
    width:100%;
}

.title{
    text-align:center;
}

.userConsume .span{
    display:inline-block;
    width:33%;
    padding-left:10px;
}

.close{
    color:#000;
    cursor:pointer;
    font-size:20px;
    position:absolute;
    top:20px;
    right:20px;
}

.close:hover{
    opacity: .5;
}
</style>
