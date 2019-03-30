<template>
    
  <div class="shopping page">
    
    <div class="shopping-logo">
        <span class="iconfont">&#xe600;</span>
    </div>
    <div class="nothing">
      <div class="tobooks">
        <p>空空如也</p>
        <button> 去购物 </button>
      </div>
    </div>
    <div class="shopping-item">
      <p  class="item-button">
          <button/>
      </p>
      <div class="item-message">
      </div>
    </div>
  </div>
</template>

<script>

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

.nothing{
  margin:0 auto;
  width:100%;
  padding:20px 0;
  display:none;
}
.tobooks{
  width:60px;
  margin:0 auto;
  padding: 20px;
}
.tobooks p{
  height:30px;
  line-height:30px;
}
.tobooks button{
  padding:10px;
  border-radius:20px;
}
.page{
  height:1400px;
}
.shopping{
  padding: 40px;
}
.shopping-logo{
  margin:0 auto;
  display:block;
  width:60px;
  height:60px;
  background:#444;
  z-index:10000;
  opacity:0.9;
  border-radius:60px;
  padding:15px;
  opacity:0.9;
}
.iconfont{
  font-size:60px;
  color:#000;
}

.shopping-item{
  clear:both;
  margin:0 auto;
  margin-top:10px;
  width:560px;
  height:150px;
  z-index: 200;
}

.item-button{
  height:150px;
  width:50px;
  display:inline-block;
  position:relative;
}

.item-button button{
  margin: auto;  
  position: absolute;  
  top: 0; left: 0; bottom: 0; right: 0;  
  background:#333;
  width:20px;
  height:20px;
}

.item-message{
  background:#333;
  display:inline-block;
  width:500px;
  height:150px;
}
</style>
