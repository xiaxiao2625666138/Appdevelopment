<template>   
  <div class="shopping-item">
      <p  class="item-button" @click="choose">
        <button :style="chosen"/>
      </p>
      <div class="item-message"></div>
      <div class="number">
        <input type="button" value="-" @click="add(0)" class="jian" /><input type="button" :value="num" class="shu" /><input type="button" value="+" @click="add(1)" class="jia" />
      </div>
  </div>
</template>

<script>
export default {
  data(){
    return {
      chosen:{
        "background":"black"
      },
      num:1
    }
  },
  methods:{
    choose:function(){
      this.chosen.background=this.chosen.background=="black"?"cadetblue":"black";
    },
    add:function(m){
      if (m==0) this.num=(this.num-1)>0 ?this.num-1:0;
      else this.num=this.num+1;
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

.item-button{
  height:160px;
  width:50px;
  display:inline-block;
  position:relative;
  background:#333;
  cursor:pointer;
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

</style>
