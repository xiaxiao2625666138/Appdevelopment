<template>   
  <div class="shopping-body">
    <div class="shopping-logo">
        <span class="iconfont">&#xe600;</span>
    </div>
    <div class="nothing">
        <p>~ 空空如也 ~
           <router-link to="./books">
             <span class="tobooks">去购物 >></span>
           </router-link>
        </p>
    </div>
    <div class="shopping-items">
      <shopping-item ref="item" v-for="i in 10" :key="i"></shopping-item>
    </div>
    <div class="fun">
      <input type="button" class="choose-all" @click="chooseAll" value="全选"/>
      <input type="button" class="choose-all" @click="chooseZero" value="全不选"/>
      <input type="button" class="delete"  value="删除"/>
      <input type="button" class="submit" value="提交订单"/>
    </div>
  </div>
</template>

<script >
import ShoppingItem from "./Item"
export default {
  components:{
    ShoppingItem
  },
  data(){
    return {
    }
  },
  methods:{
      chooseAll:function(){
          this.$refs.item.forEach((it, index)=>{
            it.chosen.background="cadetblue";
          })
      },
      chooseZero:function(){
          this.$refs.item.forEach((it, index)=>{
            it.chosen.background="black";
          })
      }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.shopping-body{
  margin:0 auto;
  width:600px;
  height:830px;
  padding: 40px 0;
  overflow:hidden;
}
.nothing{
  margin:0 auto;
  width:200px;
  padding:20px 0;
  display:none;
}
.tobooks{
  padding: 20px;
}
.tobooks p{
  height:30px;
  line-height:30px;
}

.shopping-logo{
  margin:0 auto;
  display:block;
  width:40px;
  height:40px;
  background:#111;
  z-index:10000;
  opacity:0.9;
  border-radius:100px;
  padding:15px;
}
.iconfont{
  font-size:40px;
  color:cadetblue;;
  line-height:40px;
}

.shopping-items{
   width:620px;
   height:730px;
   overflow:auto;
   margin-top:20px;
}
.fun{
  margin-top:2px;
}
.fun input{
  border-radius: 2px;
  height:35px;
  font-size:15px;
  cursor:pointer;
}
.fun input:hover{
  background:cadetblue;
}

.choose-all{
  width: 120px;
}
.delete{
  width:120px;
}
.submit{
  width:227px;
}

</style>
