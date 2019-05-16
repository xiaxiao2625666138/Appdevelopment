<template >   
  <div class="shopping-body">
    <img class="background" src="@/assets/img/bg.jpg" />
    <div class="foreground"></div>
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
      v-for="order in orders" :order="order" :key="order.order_id"></shopping-item>
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
    ShoppingItem
  },
  data(){
    return {
      orders:[],
    }
  },
  methods:{
      getOrderList:function(){
        this.$http.get("/api/page/AllOrderToPaidServlet").then((res)=>{
          console.log(res);
          if(res.data==302){
            this.$router.push({path:"/"});
          }else{
            this.orders=res.data;
          }
        })
      },
      chooseAll:function(){
          this.$refs.item.forEach((it, index)=>{
            it.chosen=true;
          });
          var getUrl="/api/page/ChooseAllOrderServlet?chosen=Y";
          this.$http.get(getUrl).then((res)=>{
          console.log(res)});
      },
      chooseZero:function(){
          this.$refs.item.forEach((it, index)=>{
            it.chosen=false;
          });
          var getUrl="/api/page/ChooseAllOrderServlet?chosen=N";
          this.$http.get(getUrl).then((res)=>{
          console.log(res)});
      },
      deleteOrder:function(){
        var getUrl="/api/page/DeleteOrderServlet";
          this.$http.get(getUrl).then((res)=>{
          console.log(res);
          this.getOrderList();
          });
      },
      payOrder:function(){
        var getUrl="/api/page/PayOrderServlet";
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
  width:601px;
  height:780px;
  padding: 60px 0;
  overflow:hidden;
  position:relative;
  border-radius:30px;
}

.background{
  position:absolute;
  width:100%;
  border-radius:30px;
}
.foreground{
  width:100%;
  height:100%;
  border-radius:30px;
  position:absolute;
  background:#fff;
  opacity: .5;
  z-index:5;
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
  width:40px;
  height:40px;
  background:#000;
  z-index:10000;
  opacity:0.9;
  border-radius:100px;
  padding:15px;
  margin-top:20px;
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
   margin:1px;
}
.fun{
  position:absolute;
  bottom:40px;
  margin-top:2px;
  z-index:1000;
  overflow:hidden;
}
.fun input{
  border-radius: 10px;
  height:35px;
  font-size:15px;
  cursor:pointer;
  background:#000;
  opacity: .8;
}

.fun input:hover{
  background:#333;
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
