<template >   
  <div class="shopping-body">
    <div class="shopping-logo">
        <span class="iconfont">&#xe600;</span>
    </div>
    <div class="nothing" v-if="!orders[0]">
        <p>~ 空空如也 ~
           <router-link to="./books">
             <span class="tobooks">去购物 >></span>
           </router-link>
        </p>
        <hr />
    </div>
    <div class="shopping-items">
      <shopping-item ref="item"
      v-for="order in orders" :order="order"
      :key="order.order_id" v-if="order.book_num>0"></shopping-item>
    </div>
    <div v-if="orders[0]" class="fun">
      <input type="button" class="choose-all" @click="chooseAll" value="全选"/>
      <input type="button" class="choose-all" @click="chooseZero" value="全不选"/>
      <input type="button" class="delete" @click="deleteOrder" value="删除"/>
      <input type="button" class="submit" @click="payOrder" value="提交订单"/>
    </div>
  </div>
</template>

<script >
import ShoppingItem from "./Item"
export default {
  components:{
    ShoppingItem,
  },
  data(){
    return {
      orders:[],
      server:this.GLOBAL.server,
    }
  },
  methods:{
      getOrderList:function(){
        this.$http.get(this.server+"/user/getPersonalCart").then((res)=>{
          console.log(res);
            this.orders=res.data;
        })
      },
      chooseAll:function(){
          this.orders.forEach((it, index)=>{
            it.chosen="Y";
          });
          var getUrl=this.server+"/user/choseAllEorder?chosen=Y";
          this.$http.get(getUrl).then((res)=>{
          console.log(res)});
      },
      chooseZero:function(){
          this.orders.forEach((it, index)=>{
            it.chosen="N";
          });
          var getUrl=this.server+"/user/choseAllEorder?chosen=N";
          this.$http.get(getUrl).then((res)=>{
          console.log(res)});
      },
      deleteOrder:function(){
        var getUrl=this.server+"/user/deleteEorder";
          this.$http.get(getUrl).then((res)=>{
          console.log(res);
          this.getOrderList();
          });
      },
      payOrder:function(){
        var getUrl=this.server+"/user/payOrder";
          this.$http.get(getUrl).then((res)=>{
          console.log(res);
          alert("支付 ￥"+res.data+"!");
          this.getOrderList();
          });
      }
  },
  mounted(){
        this.getOrderList();
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.shopping-body{
  margin:0 auto;
  width:603px;
  height:830px;
  overflow:hidden;
  position:relative;
  border-radius:10px;
  box-shadow:0 0 50px 0;
  margin-top:100px;
  margin-left:27%;
}

.nothing{
  width:210px;
  padding:20px 0;
  color:#000;
  position:absolute;
  margin:0 auto;
  z-index:10;
  left:0;
  right:0;
}

.nothing a{
  color:rgb(100, 55, 4);
}

.nothing a:active{
  color:orange;
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
  width:30px;
  height:30px;
  z-index:10000;
  opacity:0.9;
  border-radius:100px;
  padding:15px;
  margin-top:20px;
  margin-bottom:20px;
  box-shadow:0 0 30px 0;
  background:rgb(20, 188, 255);
}
.iconfont{
  font-size:30px;
  line-height:30px;
}

.shopping-items{
   width:620px;
   height:650px;
   overflow:auto;
   margin:1px;
}

.fun{
  position: absolute;
  bottom:30px;
}

.fun input{
  border-radius: 10px;
  height:35px;
  font-size:15px;
  cursor:pointer;
  background:rgb(20, 188, 255);
  box-shadow:0 0 15px 0;
}

.fun input:hover{
  opacity:0.5;
  color:#fff;
}

.fun input:active{
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
