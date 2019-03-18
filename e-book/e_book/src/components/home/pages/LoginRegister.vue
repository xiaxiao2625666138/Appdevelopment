<template>
  <div id='login-register' class="login-register" :style="ToDisplay">
    <p class="iconfont return" @click="close">&#xe658;</p>
    <p class="title iconfont">&#xe621;</p>
    <div class="choose">
      <button @click="tologin">登陆</button>
      <button @click="toregister">注册</button>
    </div>
    <div class="login" :style="ToLogin" id="login">
      <div class="enter">
        <p>用户名:
          <input type="input" />
        </p>
        <p>密&emsp;码:
          <input type="input" />
        </p>
      </div>
      <div class="submit-button">
        <button>登陆</button>
      </div>
    </div>
    <div class="register" :style="ToRegister" id="register">
      <div class="enter">
        <p>用户名&emsp;:<input type="input" />
        </p>
        <p>密&emsp;&emsp;码:<input type="input" />
        </p>
        <p>确认密码:<input type="input" />
        </p>
      </div>
      <div class="submit-button ">
        <button>注册</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props:['ToDisplay','ToLogin', 'ToRegister'],
  data:function(){
    return{
    }
  },
  methods:{
    tologin:function(){
      this.ToLogin.display="block";
      this.ToRegister.display="none";
    },
    toregister:function(){
      this.ToLogin.display="none";
      this.ToRegister.display="block";
    },
    close:function(){
      this.ToDisplay.display="none";
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.login-register {
  background: #000;
  width: 350px;
  height: 480px;
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
  margin:50px 0;
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
  margin-top:40px;
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

.choose button:hover {
  border-bottom-color: cadetblue;
}

input {
  border-width: 0;
  height: 25px;
  border-bottom-width: 2px;
  border-bottom-color: #444;
  border-radius:0;
  background: #000;
}
.enter input {
  width: 180px;
  margin-bottom: 20px;
}
.enter input:hover {
  border-bottom-color: cadetblue;
}
.enter {
  margin-bottom:20px;
}

.submit-button button {
  background: #888;
  border-width: 0;
  border-radius: 3px;
  width: 150px;
  height: 30px;
}
.submit-button button:hover {
  background: cadetblue;
}
</style>
