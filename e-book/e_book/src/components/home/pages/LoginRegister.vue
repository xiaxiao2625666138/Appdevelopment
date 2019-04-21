<template>
  <div id='login-register' class="login-register" :style="ToDisplay">
    <p class="iconfont return" @click="close">&#xe658;</p>
    <p class="title iconfont">&#xe621;</p>
    <div class="choose" >
      <span style="color:orange">{{message}}</span><br />
      <button @click="tologin" :style="loginStyle">登陆</button>
      <button @click="toregister" :style="registerStyle">注册</button>
    </div>
    <div class="login" :style="ToLogin" id="login">
      <div class="enter">
        <p>
          <input type="text" placeholder="username" v-model="lname" />
        </p>
        <p>
          <input type="text" placeholder="password" v-model="lpass" />
        </p>
      </div>
      <div class="submit-button">
        <button @click="loginRegister">登陆</button>
      </div>
    </div>
    <div class="register" :style="ToRegister" id="register" >
      <div class="enter">
        <p>
          <input type="text" placeholder="username" v-model="rname" required/>
        </p>
        <p>
          <input type="text" placeholder="password" v-model="rpass" required/>
        </p>
        <p>
          <input type="input" placeholder="confirm password" v-model="rcpass" required/>
        </p>
      </div>
      <div class="submit-button ">
        <button @click="loginRegister">注册</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props:['ToDisplay','ToLogin', 'ToRegister','status'],
  data:function(){
    return{
      message:"",
      loginStyle:{
         "border-bottom-color": "hsl(182, 89%, 64%)"
      },
      registerStyle:{
        "border-bottom-color": "#444"
      },
      fun:0,
      lname:"",
      lpass:"",
      rname:"",
      rpass:"",
      rcpass:"",
    }
  },
  methods:{
    tologin:function(){
      this.ToLogin.display="block";
      this.ToRegister.display="none";
      this.loginStyle={
         "border-bottom-color": "hsl(182, 89%, 64%)"
      };
      this.registerStyle={
         "border-bottom-color": "#444"
      };
      this.fun=0;
      this.message="";
    },
    toregister:function(){
      this.ToLogin.display="none";
      this.ToRegister.display="block";
      this.loginStyle={
         "border-bottom-color": "#444"
      };
      this.registerStyle={
         "border-bottom-color": "hsl(182, 89%, 64%)"
      };
      this.fun=1;
      this.message="";
    },
    close:function(){
      this.ToDisplay.display="none";
      this.message="";
      this.lname="";
      this.lpass="";
      this.rname="";
      this.rpass="";
      this.rcpass="";
    },
    loginRegister:function(){
      if(this.fun==0){
        var getUrl="/api/LoginServlet?username="+this.lname+"&password="+this.lpass;
        this.$http.get(getUrl).then((res)=>{
          console.log(res);
          var status=res.data;
          if(status==-3){
            this.message="password cannot be null!"
          }else if(status==-2){
            this.message="username cannot be null!"
          }else if(status==-1){
            this.message="Please Check User Name! ";
          }else if(status==0){
            this.message="Please Check Password! "
          }else if(status==1){
            this.$emit("loginSuc", this.lname);
            this.close();
          }else{
            this.message="User Has logined! "
          }
        })
      }else{
        var getUrl="/api/RegisterServlet?username="+this.rname+"&password="
        +this.rpass+"&cpassword="+this.rcpass;
        this.$http.get(getUrl).then((res)=>{
          console.log(res);
          var status=res.data;
          if(status==-3){
            this.message="password cannot be null!"
          }else if(status==-2){
            this.message="username cannot be null!"
          }else if(status==-1){
            this.message="Different Password! ";
          }else if(status==0){
            this.message="Username Has Been Registered! "
          }else if(status==1){
            this.message="Register Successfully! "
          }
        })
      }
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.login-register {
  background: #000;
  width: 320px;
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
  margin:50px 0 20px 0;
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
  width: 100px;
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
  border-bottom-color: hsl(182, 89%, 64%);
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
  background: hsl(182, 89%, 64%);
}
</style>
