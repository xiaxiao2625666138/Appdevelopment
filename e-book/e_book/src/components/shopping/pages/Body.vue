<template >   
  <div class="shopping-body">
    <div class="shopping-logo">
        <span class="iconfont">&#xe600;</span>
    </div>
    <div class="nothing" v-if="orders[0]==null">
        <p>~ 空空如也 ~
           <router-link to="./books">
             <span class="tobooks">去购物 >></span>
           </router-link>
        </p>
    </div>
    <div class="shopping-items">
      <shopping-item ref="item"
      v-for="order in orders" :order="order" :key="order.order_id"></shopping-item>
    </div>
    <div class="fun">
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
    ShoppingItem
  },
  data(){
    return {
      orders:[],
    }
  },
  methods:{
      getOrderList:function(){
        this.$http.get("/api/AllOrderToPaidServlet").then((res)=>{
          console.log(res);
          this.orders=res.data;
        })
      },
      chooseAll:function(){
          this.$refs.item.forEach((it, index)=>{
            it.chosen=true;
          });
          var getUrl="/api/ChooseAllOrderServlet?chosen=Y";
          this.$http.get(getUrl).then((res)=>{
          console.log(res)});
      },
      chooseZero:function(){
          this.$refs.item.forEach((it, index)=>{
            it.chosen=false;
          });
          var getUrl="/api/ChooseAllOrderServlet?chosen=N";
          this.$http.get(getUrl).then((res)=>{
          console.log(res)});
      },
      deleteOrder:function(){
        var getUrl="/api/DeleteOrderServlet";
          this.$http.get(getUrl).then((res)=>{
          console.log(res);
          });
        this.$refs.item.forEach((it, index)=>{
            if(it.chosen){
              it.deleteOrder.display="none";
            }
          });
      },
      payOrder:function(){
        var getUrl="/api/PayOrderServlet";
          this.$http.get(getUrl).then((res)=>{
          console.log(res);
          alert("支付 ￥"+res.data+"!");
          });
        this.$refs.item.forEach((it, index)=>{
            if(it.chosen){
              it.chosen=false;
              it.deleteOrder.display="none";
            }
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
  width:600px;
  height:760px;
  padding: 60px 0;
  overflow:hidden;
}
.nothing{
  margin:0 auto;
  width:200px;
  padding:20px 0;
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
   height:650px;
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
  background:#111;
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
