<template>   
  <div class="shopping-item">
      <p  class="item-button" @click="choose">
        <button :style="chosen"/>
      </p>
      <div class="item-message"></div>
  </div>
</template>

<script>
export default {
  data(){
    return {
      chosen:{
        "background":"black"
      }
    }
  },
  methods:{
    choose:function(){
      this.chosen.background=this.chosen.background=="black"?"cadetblue":"black";
    },
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
  height:180px;
  z-index: 200;
}

.item-button{
  height:180px;
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
}

.item-message{
  background:#333;
  display:inline-block;
  width:545px;
  height:180px;
}
</style>
