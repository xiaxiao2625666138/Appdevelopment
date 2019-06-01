<template>   
  <div class="shopping-item">
      <p class="item-button">
        <button :class="{chosen:order.chosen=='Y', notchosen:order.chosen=='N'}"
           @click="choose"/>
      </p>
      <div class="item-message">
          <img :src="order.book.cover"/>
          <div class="order-message" >
            <p>{{order.book.ISBN}}</p>
            <p class="order-time">订单时间：{{order.time}}</p>
            <p class="book-name">{{order.book.name}}<span v-if="order.subtitle" class="subtitle"> · {{order.subtitle}}</span></p>
            <p>第 <span class="version">{{order.book.version}}</span> 版 · <span class="version">{{order.book.language}}</span> 版</p>
            <p>价格：<span class="price">￥{{order.book.price}}</span></p>
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
      num:this.order.book_num,
      server:this.GLOBAL.server,
    }
  },
  methods:{
    choose:function(){
      var ch;
      if(this.order.chosen=='Y'){
        this.order.chosen='N';
        ch="N";
      }else{
        this.order.chosen='Y';
        ch="Y";
      }
      var getUrl=this.server+"/user/choseEorder?orderid="+this.order.id
      +"&chosen="+ch;
          this.$http.get(getUrl).then((res)=>{
          console.log(res);
          this.chosen=!this.chosen;});
    },
    addBook:function(m){
      var getUrl=this.server+"/user/addBookNumber?orderid="+this.order.id
      +"&add="+m;
          this.$http.get(getUrl).then((res)=>{
          console.log(res);
          this.num=res.data;
          this.order.book_num=res.data;});
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.shopping-item{
  clear:both;
  margin-top:10px;
  margin-bottom:10px;
  width:600px;
  height:160px;
  z-index: 200;
  position:relative;
  overflow:hidden;
  border-radius: 8px;
  box-shadow:0 0 10px 0;
  z-index:100000;
}

.item-button .chosen{
  background:rgb(4, 164, 228);
  color:rgb(4, 164, 228);
}

.item-button .notchosen{
  background:#fff;
}

.item-button{
  height:160px;
  width:50px;
  display:inline-block;
  position:relative;
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
  display:inline-block;
  width:545px;
  height:160px;
  overflow:hidden;
  opacity: .9;
}

.number{
  position:absolute;
  border-radius:100px;
  overflow:hidden;
  bottom:10px;
  right:10px;
  box-shadow:0 0 15px 0;
  color:rgb(4, 164, 228);
}

.number input{
  border-radius:0;
  display:inline-block;
  text-align:center;
  height:26px;
  background:rgb(4, 164, 228);
  color:#fff;
}

.jian, .jia{
  width: 35px;
  cursor:pointer;
}

.jian:hover, .jia:hover{
  opacity:0.6;
}

.number input:active{
  background:cadetblue;
}

.shu{
  width:50px;
  text-align:center;
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
