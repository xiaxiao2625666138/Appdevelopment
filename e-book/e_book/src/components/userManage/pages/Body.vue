<template>
    <div class="page">
        <div class="content">
            <img src="@/assets/img/guide.jpg"/>
            <div class="foreground"></div>
            <div class="users">
                <div class="user" v-for="user in users">
                    <div class="user-message">
                    <span class="iconfont icon">&#xe621;</span>
                    <span class="username">{{user.username}}</span>
                    <span class="phone">{{user.phone}}</span>
                    <span class="address">{{user.address}}</span>
                    <span class="email">{{user.email}}</span>
                    </div>
                    <button type="button" class="disabled" 
                            :class="{on: user.disabled=='N', off: user.disabled=='Y'}"
                            @click="disableUser(user.username)">
                        <span  v-if="user.disabled=='N'">on</span>
                        <span  v-if="user.disabled=='Y'">off</span>
                    </button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  data: function() {
    return {
      users: []
    };
  },
  components: {},
  methods: {
      getAllUser:function(){
           this.$http.get("/api/page/adm/AllUserServlet").then(res => {
           console.log(res);
           if (res.data == 302) {
              this.$router.push({ path: "/" });
           } else {
           this.users = res.data;
         }
       });
      },
      disableUser:function(uname){
          var getUrl="/api/page/adm/DisableUserServlet?username="+uname;
          this.$http.get(getUrl).then(res => {
          console.log(res);
          if (res.data == 302) {
          this.$router.push({ path: "/" });
          } else if(res.data==0){
              alert("Cannot Disable Administrator!");
          }else if(res.data==-1){
              alert("Have No This User! ");
          }else if(res.data==1){
              this.getAllUser();
          }else{
              alert(res.data);
          }
      });
    }
  },
  mounted() {
    this.getAllUser();
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

.content{
    width:1000px;
    overflow:hidden;
    margin:0 auto;
    overflow:hidden;
    position: relative;
    border-radius:30px;
}

img{
    position: absolute;
    width:100%;
}

img:hover{
    opacity: 1;
}

.foreground{
    width:100%;
    height:90%;
    top:60px;
    background:#fff;
    position:absolute;
    opacity: .5;
}

.users{
    height:1000px;
    width:1000px;
    margin:80px 0;
    padding:0 35px;
    overflow:auto;
}

.user{
    position: relative;
    z-index:10px;
}

.user-message{
    display:inline-block;
    width:830px;
    height:40px;
    margin-bottom:5px;
    padding:10px;
    line-height: 40px;
    background:#000;
    font-size:15px;
    opacity: .85;
    border-top-left-radius:10px;
    border-bottom-left-radius:10px;
}
.user-message:hover{
    opacity:.3;
}

.user span{
    margin-left:5px;
    display: inline-block;
    overflow:hidden;
    text-overflow:ellipsis;
    white-space:nowrap;
    cursor:pointer;
}

.icon{
    display:inline-block;
    background:#222;
    width:40px;
    font-size:25px;
    text-align:center;
    border-radius: 30px;
}

.username{
    width:120px;
}

.phone{
    width:120px;
}

.address{
    width:250px;
}

.email{
    width:200px;
}

.disabled{
    width:80px;
    height:60px;
    font-size:20px;
    vertical-align: top;
    margin:0;
    border-radius:0;
    border-top-right-radius:10px;
    border-bottom-right-radius:10px;
    margin-left:-5px;
    opacity:.85;
}

.disabled:hover{
    opacity: 1;
}

.disabled:active{
    opacity: .5;
}

.on{
    background:rgb(241, 84, 11);
    color:#222;
}

.off{
    background:#000;
    color:#aaa;
}

</style>