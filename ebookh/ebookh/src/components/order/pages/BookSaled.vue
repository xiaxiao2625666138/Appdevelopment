<template>
<div class="body">
    <span @click="close" class="iconfont close">&#xe658;</span>
    <p class="title">在 <span class="highlight">{{begin}}</span> 至 <span class="highlight">{{end}}</span> 时间内</p>
    <p class="userConsume" v-for="item in bookSaled">
        <span class="span">书名: <span>{{item[2]}} </span></span>
        <span class="span">购买人次: <span class="highlight">{{item[3]}}</span> </span>
        <span class="span"> 总销量: <span class="highlight">{{item[4]}}</span> 册</span>
    </p>
</div>
</template>

<script>
export default {
  props:["begin", "end", "bookSaled"],
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
    width:910px;
    position:absolute;
    background:rgb(239, 240, 234);
    height:1120px;
    z-index:100000;
}

.body p{
    width:890px;
    clear:both;
    background:rgb(56, 52, 47);
    color:rgb(177, 169, 169);
    height:60px;
    line-height:60px;
    margin:5px 0;
    border-radius:5px;
    font-size:20px;
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
