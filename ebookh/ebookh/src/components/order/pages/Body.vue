<template>
  <div class="body">
   <img class="background" src="@/assets/img/bg.jpg" />
   <div class="foreground"></div>
   <div class="ebook">order</div>
   <div class="filter" >
     <input type="text" placeholder="2000-01-01 12:00:00" v-model="time1"/>
     <input type="text" placeholder="2020-01-01 12:00:00" v-model="time2"/>
     <button @click="orderStatistics">统计</button>
   </div>
   <div class="content" v-if="!statistics">
     <div v-for="order in orders"
         v-if="(order.time>=time1 && order.time<=time2) 
         || (order.time<=time2 && time1=='') 
         || (order.time>=time1 &&time2=='')" 
         class="order" >
          <p class="order-id">{{order.user_name}} | {{order.time}}</p>
          <div v-for="book in order.books"
               class="book">
            <img :src="book.cover"/>
            <div class="message">
              <p class="ISBN">ISBN: {{book.ISBN}}</p>
              <p>
                <span class="book-name">{{book.book_name}}asdfasdfasdfasdfasdf</span>
                <span v-if="book.subtitle" class="subtitle"> · {{book.subtitle}}</span>
              </p>
              <p>第 {{book.version}} 版 · {{book.language_name}} 版</p>
              <p>
                <span class="price highlight">￥ {{book.price}}</span>
                &emsp;购买 <span class="highlight">{{book.book_num}}</span> 册
              </p>
            </div>
          </div>
          <p class="money highlight">￥ {{order.money}}</p>
     </div>
   </div>
   <div class="content" v-if="statistics">
     <div class="total">
       <span @click="close" class="iconfont close">&#xe658;</span>
       <div>
         <p >用户 <span class="number">{{orderSta.username}}</span></p>
         <p>在
           <span  class="number" v-if="orderSta.time1!=''">{{orderSta.time1}}</span>
           <span class="number" v-if="orderSta.time1==''">注册</span>
           —
           <span class="number" v-if="orderSta.time2!=''">{{orderSta.time2}}</span>
           <span class="number" v-if="orderSta.time2==''">至今</span>
           时间段里
         </p>
         <p>购书 <span class="number">{{orderSta.times}} </span>次</p>
         <p>累计购书 <span class="number">{{orderSta.book_num}}</span> 册</p>
         <p>共计消费 <span class="highlight">￥{{orderSta.TotalMoney}}</span></p>
       </div>
       <div>
         <span>于 <span class="number">{{orderSta.maxTime}}</span></span>
         <span>达单笔最大交易金额 <span class="highlight"> ￥{{orderSta.maxMoney}}</span></span>
       </div>
     </div>
     <div class="detail" v-for="order in orderSta.orders"
          :class="{max: order.time==orderSta.maxTime}">
       <p style="width:380px">订单日期：<span>{{order.time}}</span></p>
       <p style="width:250px">购书 <span>{{order.book_num}}</span> 册</p>
       <p>消费 <span class="highlight">￥{{order.money}}</span></p>
     </div>
     <div class="tail"></div>
   </div>
  </div>
</template>

<script>
export default {
  data(){
    return {
      orders:[],
      time1:"",
      time2:"",
      orderSta:{},
      statistics:false
    }
  },
  methods:{
      getOrderList:function(){
        this.$http.get("/api/page/OrderServlet").then((res)=>{
          console.log(res);
          if(res.data==302){
            this.$router.push({path:"/"});
          }else{
            this.orders=res.data;
          }
        })
      },
      orderStatistics:function(){
        var getUrl="api/page/OrderStatisticsServlet?time1="
        +this.time1+"&time2="+this.time2;
        this.$http.get(getUrl).then((res)=>{
          console.log(res);
          this.orderSta=res.data;
          this.statistics=true;
        })
      },
      close:function(){
        this.statistics=false;
      }
  },
  mounted(){
        this.getOrderList();
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.body{
  margin:0 auto;
  position:relative;
  width:890px;
  overflow:hidden;
  margin-bottom:80px;
}
.ebook{
  left:30px;
  width:30px;
  color:cadetblue;
  z-index:400;
  top:80px;
  position:absolute;
}

.filter{
  position:absolute;
  top:110px;
  right:50px;
  z-index:400;
}

.filter input{
  right:60px;
  width:150px;
  height:30px;
  border-radius:8px;
  background:#000;
  opacity: .7;
}

.filter button{
  width:70px;
  height:30px;
  vertical-align: top;
  border-radius:8px;
  background:#000;
  opacity: .7;
  color:#666;
}
.filter button:hover{
  background:orange;
}
.filter button:active{
  opacity: .3;
}

.content{
  margin:0 auto;
  padding:0 40px;
  width:900px;
  height:1180px;
  z-index:1000;
  overflow:auto;
  position: relative;
  margin-top:80px;
}

.background{
  top:80px;
  width:890px;
  opacity:1;
  position:absolute;
  z-index:2;
  border-radius:30px;
}

.foreground{
  width:890px;
  height:1185px;
  background:#fff;
  z-index:10;
  position:absolute;
  opacity: .4;
  top:160px;
}

.book img{
  width:80px;
}

.order{
  float:left;
  position:absolute;
  width:400px;
  margin:3px;
  color:#aaa;
  position:relative;
  overflow:hidden;
  border-radius:10px;
  background:black;
  opacity:.9;
  z-index:1000;
}

.order-id{
  height:30px;
  line-height:30px;
  color:#666;
  padding:10px 10px 0 10px;
}

.money{
   background:black;
   padding: 10px;
   text-align:right;
}

.book{
  background:#222;
  margin:1px;
  width:397px;
}

.message{
  display:inline-block;
  vertical-align:top;
  padding:10px;
}

.message p{
  margin-bottom:6px;
  width:280px;
  overflow:hidden;
  text-overflow:ellipsis;
  white-space:nowrap
}

.book-name{
  font-size:17px;
}

.subtitle{
  color:#666;
}

.ISBN{
  color:#666;
}

.total{
  background:#000;
  width:800px;
  height:60px;
  opacity: .95;
  padding:5px 0;
  border-top-left-radius: 15px;
  border-top-right-radius: 15px;
  color:#aaa;
  overflow:hidden;
  text-align:center;
  position: relative;
}

.total p{
  height:30px;
  line-height:30px;
  text-align:center;
  display:inline-block;
  padding:0 10px ;
}

.number{
  color:orange;
  font-size:17px;
}

.detail{
  background:#000;
  opacity: .85;
  width:800px;
  overflow:hidden;
  padding:30px 0;
  margin-bottom:1px;
}

.detail:hover{
  opacity: 1;
}

.detail p{
  display:inline-block;
  padding-left:10px;
}
.detail .highlight{
  font-size:16px;
}

.tail{
  height:60px;
  width:800px;
  background:#000;
  opacity:.95;
  border-bottom-left-radius: 15px;
  border-bottom-right-radius: 15px;
}

.max{
  background:rgb(78, 40, 4);
}

.close{
  position:absolute;
  right:15px;
  top:15px;
  font-size:20px;
  cursor:pointer;
}

</style>
