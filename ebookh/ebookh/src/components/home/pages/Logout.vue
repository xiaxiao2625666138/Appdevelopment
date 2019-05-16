<template>
  <div id='logout' class="logout">
    <p class="iconfont return" @click="tologout">&#xe658;</p>
    <p class="title iconfont">&#xe621;</p>
    <div class="choose">
      <span style="color:orange">{{user}}</span><br />
    </div>
    <div>
      <div class="submit-button">
        <button @click="logout">注销</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props:['user'],
  data:function(){
    return{
    }
  },
  methods:{
    tologout:function(event){
       this.$emit('tologout');
       event.preventDefault();
    },
    logout:function(){
        var getUrl="/api/page/LogoutServlet?";
         this.$http.get(getUrl).then((res)=>{
             console.log(res);
        })
        this.$router.push({path:"/"});
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.logout {
  background: #000;
  width: 350px;
  height: 250px;
  color: #aaa;
  overflow: hidden;
  text-align:center;
  opacity: 0.96;
  border-radius: 5px;
  position:absolute;
  left:0;
  right:0;
  top:0;
  bottom:0;
  margin: auto;
  z-index:1000;
}
.title {
  margin:50px 0 0 0;
  font-size: 30px;
  color: rgb(163, 196, 204);
  text-align: center;
}



.return{
  position:absolute;
  right:0;
  margin-right:10px;
  margin-top:10px;
  cursor:pointer;
}

.choose {
  margin-top:20px;
  margin-bottom:40px;
}

button {
  float:none;
  border-width: 0;
  height: 25px;
  border-bottom-width: 2px;
  border-bottom-color: #444;
  border-radius:0;
  background: #000;
  color: #aaa;
  cursor: pointer;
  width: 120px;
}


input {
  border-width: 0;
  height: 25px;
  border-bottom-width: 2px;
  border-bottom-color: #444;
  border-radius:0;
  background: #000;
}

.submit-button button {
  background: #888;
  border-width: 0;
  border-radius: 3px;
  width: 150px;
  height: 30px;
}
.submit-button button:hover {
  background: hsl(182, 89%, 64%);
}
</style>
