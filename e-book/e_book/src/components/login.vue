<template>
  <div class="bg">
    <img src="@/assets/img/background1.jpg" style="width:100%"/>
    <div class="fg"></div>
    <span class="ebook">ebook</span>
  <div id='login-register' class="login-register" :style="LRH">
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
          <input type="password" placeholder="password" v-model="lpass" />
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
          <input type="text" placeholder="@email" v-model="remail" required/>
        </p>
        <p>
          <input type="password" placeholder="password" v-model="rpass" required/>
        </p>
        <p>
          <input type="password" placeholder="confirm password" v-model="rcpass" required/>
        </p>
      </div>
      <div class="submit-button ">
        <button @click="loginRegister">注册</button>
      </div>
    </div>
  </div>
  </div>
</template>

<script>
export default {
  data:function(){
    return{
      message:"",
      loginStyle:{
         "border-bottom-color": "hsl(182, 96%, 50%)"
      },
      registerStyle:{
        "border-bottom-color": "#444"
      },
      ToLogin: {
          display:"block"
      },
      ToRegister: {
          display:"none"
      },
      LRH:{
          height:'460px'
      },
      fun:0,
      lname:"",
      lpass:"",
      rname:"",
      remail:"",
      rpass:"",
      rcpass:"",
    }
  },
  methods:{
    tologin:function(){
      this.ToLogin.display="block";
      this.ToRegister.display="none";
      this.loginStyle={
         "border-bottom-color": "rgb(0, 247, 255)"
      };
      this.registerStyle={
         "border-bottom-color": "#444"
      };
      this.fun=0;
      this.message="";
      this.LRH.height="460px"
    },
    toregister:function(){
      this.ToLogin.display="none";
      this.ToRegister.display="block";
      this.loginStyle={
         "border-bottom-color": "#444"
      };
      this.registerStyle={
         "border-bottom-color": "rgb(0, 247, 255)"
      };
      this.fun=1;
      this.message="";
      this.LRH.height="600px";
    },
    loginRegister:function(){
      if(this.fun==0){
        var getUrl="/api/LoginServlet?username="+this.lname+"&password="+this.lpass;
        this.$http.get(getUrl).then((res)=>{
          console.log(res);
          var status=res.data;
          if(status==-4){
            this.message="username cannot be null!"
          }else if(status==-3){
            this.message="password cannot be null!"
          }else if(status==-2){
            this.message="Please Check User Name! ";
          }else if(status==-1){
            this.message="User Has ben disabled! "
          }else if(status==0){
            this.message="Please Check Password! "
          }else if(status=1){
              this.message="Login Successfully!";
              this.$router.push({path:'/guide', 
              params: {user: this.lname, adm: status==2}});
          }
        })
      }else{
        var getUrl="/api/RegisterServlet?username="+this.rname+"&email="+this.remail+"&password="
        +this.rpass+"&cpassword="+this.rcpass;
        this.$http.get(getUrl).then((res)=>{
          console.log(res);
          var status=res.data;
          if(status==-4){
              this.message="Username Cannot Be Null!"
          }else if(status==-3){
            this.message="Check Email Formate!"
          }else if(status==-2){
            this.message="Password Cannot Be Null!"
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
.bg{
    width:100vw;
    height:100vh;
    background:#444;
    overflow:hidden;
}
.bg img:hover{
   opacity:1;
}

.fg{
    position:absolute;
    top:0px;
    width:100vw;
    height:100vh;
    background:#fff;
    opacity:.7;
    z-index:100;
}

.ebook{
    position:absolute;
    top:0;
    left:0;
    right:0;
    color:black;
    opacity:1;
    z-index:1000;
}

.login-register {
  background: #000;
  width: 360px;
  color: #aaa;
  overflow: hidden;
  text-align:center;
  opacity: 0.8;
  border-radius: 15px;
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
  width: 119px;
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
  width: 230px;
  margin-bottom: 40px;
  font-size:16px;
}
.enter input:hover {
  border-bottom-color: rgb(0, 247, 255);
}
.enter {
  margin-bottom:20px;
}

.submit-button button {
  background: #222;
  border-width: 0;
  border-radius: 3px;
  width: 200px;
  height: 35px;
  font-size:16px;
}
.submit-button button:hover {
  background: hsl(182, 96%, 50%);
}

.submit-button button:active{
  background: #222;
}

</style>
