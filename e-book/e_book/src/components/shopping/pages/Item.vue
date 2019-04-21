<template>   
  <div class="shopping-item" :style="deleteOrder">
      <p  class="item-button" @click="choose">
        <button :class="{chosen:chosen, notchosen:!chosen}"/>
      </p>
      <div class="item-message">
          <img :src="order.cover"/>
          <div class="order-message" >
            <p class="order-time">订单时间：{{order.time}}</p>
            <p class="book-name">{{order.book_name}}<span v-if="order.subtitle" class="subtitle"> · {{order.subtitle}}</span></p>
            <p>第 <span class="version">{{order.version}}</span> 版 · <span class="version">{{order.language_name}}</span> 版</p>
            <p>价格：<span class="price">￥{{order.price}}</span></p>
          </div>
      </div>
      <div class="number">
        <input type="button" value="-" @click="addBook(-1)" class="jian" /><input type="button" :value="num" class="shu" /><input type="button" value="+" @click="addBook(1)" class="jia" />
      </div>
  </div>
</template>

<script>
export default {
  props:['order'],
  data(){
    return {
      chosen:this.order.chosen=='Y',
      num:this.order.book_num,
      deleteOrder:{
        display:"block"
      }
    }
  },
  methods:{
    choose:function(){
      var ch;
      if(this.chosen){
        ch="N";
      }else{
        ch="Y";
      }
      var getUrl="/api/ChooseOrderServlet?order_id="+this.order.order_id
      +"&chosen="+ch;
          this.$http.get(getUrl).then((res)=>{
          console.log(res)});
      this.chosen=!this.chosen;
    },
    addBook:function(m){
      var getUrl="/api/AddBookServlet?order_id="+this.order.order_id
      +"&addition="+m;
          this.$http.get(getUrl).then((res)=>{
          console.log(res);
          this.num=res.data;});
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.shopping-item{
  clear:both;
  margin-top:2px;
  width:600px;
  background:black;
  height:160px;
  z-index: 200;
  position:relative;
}

.notchosen{
    background:black;
}

.chosen{
  background:cadetblue;
}

.item-button{
  height:160px;
  width:50px;
  display:inline-block;
  position:relative;
  background:#333;
  cursor:pointer;
}

.item-button:hover{
  background:cadetblue;
}

.item-button button{
  margin: auto;  
  position: absolute;  
  top: 0; left: 0; bottom: 0; right: 0;
  width:20px;
  height:20px;
  border-radius:200px;
}

.item-message{
  background:#333;
  display:inline-block;
  width:545px;
  height:160px;
  overflow:hidden;
}

.number{
  position:absolute;
  border-radius:100px;
  overflow:hidden;
  bottom:10px;
  right:10px;
}

.number input{
  border-radius:0;
  display:inline-block;
  text-align:center;
  height:26px;
}

.jian, .jia{
  width: 35px;
  cursor:pointer;
  background:#222;
}

.jian:hover, .jia:hover{
  background:#000;
  opacity:0.85;
}

.shu{
  width:50px;
  text-align:center;
  background:#000;
  opacity:0.85;
}


img{
  width:112px;
}

.order-message{
  display:inline-block;
  height:130px;
  padding:15px;
  overflow:hidden;
}

.order-time{
  height:30px;
  line-height:30px;
  color:#666;
}

.book-name{
  font-size:17px;
  height:35px;
  line-height:35px;
}

.subtitle{
  font-size:15px;
  color:#888;
}

.version{
  line-height:25px;
  color:orange;
}

.price{
  font-size:20px;
  color:orange;
  height:25px;
}

</style>
