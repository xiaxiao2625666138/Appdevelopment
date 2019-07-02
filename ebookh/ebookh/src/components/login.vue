<template>
  <div class="bg">
    <img src="@/assets/img/b.jpg" style="width:100%"/>
    <div class="fg"></div>
    <span class="book-store">Book Store</span>
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
      server:this.GLOBAL.server,
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
        var getUrl=this.server+"/login?username="+this.lname+"&password="+this.lpass;
        this.$http.post(getUrl).then((res)=>{
          console.log(res);
              this.message=res.data;
              if(this.message==this.lname){
                this.$router.push({path:'/guide', 
                params: {user: this.lname}});
              }
        })
      }else{
        var getUrl=this.server+"/register?username="+this.rname+"&email="+this.remail+"&password="
        +this.rpass+"&confirmPassword="+this.rcpass;
        this.$http.post(getUrl).then((res)=>{
          console.log(res);
          this.message=res.data;
        })
      }
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.book-store{
    position:absolute;
    top:10px;
    left:10px;
    z-index:10000;
    cursor:pointer;
    display:block;
    font-size:36px;
    font-family:STHupo;
    line-height:40px;
    color:rgba(0, 0, 0, 0.89);
}
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
    opacity:.5;
    z-index:100;
}

.ebook{
    position:absolute;
    top:20px;
    left:20px;
    right:0;
    color:black;
    opacity:1;
    z-index:1000;
}

.login-register {
  background: #000;
  width: 360px;
  overflow: hidden;
  text-align:center;
  border-radius: 15px;
  position:absolute;
  left:0;
  right:0;
  top:0;
  bottom:0;
  margin: auto;
  z-index:1000;
  box-shadow: 0 0 50px 0;
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
  box-shadow: 0 0 0 0;
}


input {
  border-width: 0;
  height: 25px;
  border-bottom-width: 2px;
  border-bottom-color: #444;
  border-radius:0;
  background: #000;
  color: #aaa;
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
