<template>
  <div class="body">
   <div class="ebook">ebook</div>
   <div class="content">
     <div class="information">
       <div><span>username</span> <input></input></div>
       <div><span>phone</span>  <input></input></div>
       <div><span>address</span> <input></input></div>
       <div><span>password</span> <input></input></div>
       <div><span>name</span> <input></input></div>
     </div>
   </div>
  </div>
</template>

<script>
export default {
  
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.body{
  width:600px;
  margin:0 auto;
  position:relative;
}
.ebook{
  margin:0 auto;
  text-align:center;
  color:cadetblue;
}
.content{
  height:700px;
}
.information{
  padding: 20px 0;
  width:400px;
  margin:0 auto;
}
.information div{
  margin-top:10px;
}
.information span{
  display:inline-block;
  background:#111;
  padding:9px;
  width:70px;
  text-align:center;
  border-radius:4px;
}
input{
  background:#000;
  height:30px;
  width:300px;
  border-radius:4px;
}
</style>
