<template>
  <div class="content">
        <div class="body">
            <div class="body-left block">
              <router-link to="./daijian">
                <p title="暂时没有收藏功能">收藏</p>
              </router-link>
              <router-link to="./shopping">
                <p>购物车</p>
              </router-link>
              <router-link to="./daijian">
                <p title="暂时没有推荐功能">求推荐</p>
              </router-link>
              <router-link to="./daijian">
                <p title="暂时不能查看我的订单">我的订单</p>
              </router-link>
              <router-link to="./setting">
                <p title="暂时没有设置功能">设置</p>
              </router-link>
            </div>
            <div class="body-right">
              <div class="br-block">
                <div class="br-block1">
                    <div class="left block">
                        <router-link to="./books">
                          <p @click="send">图书浏览</p>
                        </router-link>
                        <ul class="recommand">
                          <li v-for="item in books">
                            <router-link :to="{path: 'details', query:{bid:item.book_id}}">
                              <img :src="item.cover" />
                            </router-link>
                          </li>
                        </ul>
                    </div>
                </div>
                <div class="classify right">
                  <router-link to="/books">
                      <p>热门分类 >></p>
                  </router-link>
                  <ul>
                    <li v-for="i in 8">
                      <button>计算机</button>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="br-block br-extend"> 
                <div class="br-block2">
                    <div class="left block">
                        <router-link to="./books">
                            <p>新书上架</p>
                        </router-link>
                        <ul class="newbook">
                          <li v-for="item in books">
                            <router-link :to="{path: 'details', query:{bid:item.book_id}}">
                              <img :src="item.cover" />
                            </router-link>
                          </li>
                        </ul>
                    </div>
                </div>
                <div class="rank right">
                  <router-link to="./books">
                      <p>月榜单 >></p>
                  </router-link>
                  <ul>
                    <li v-for="i in 10">
                      <router-link to="./books">
                      <p>{{i}}.<a href="details.html">深入理解计算机系统</a></p>
                      </router-link>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
    </div>
</template>

<script>
export default {
    props:['books'],
    methods:{
        send:function(){
            this.$http.get("/ebookWeb_war_exploded/toLookBook").then(function(res){
                alert("只有一本书:\n"+res.data);
            })
        }
    }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

.content{
    width:1200px;
}

.body-left{
    display:inline-block;
    width:150px;
    padding:20px 2px;
    z-index:100;
    border-radius:6px;
}

.body-left p{
    font-size:18px;
    margin:0;
    height:50px;
    line-height:50px;
    padding-left:40px;
    cursor:pointer;
    border-radius:10px;
}

.body-left p:hover{
    background:#111;
}

.body-right{
    display:inline-block;
    vertical-align: top;  
    margin-left:20px;
    overflow:hidden;
}

.body-right p{
    margin:4px 2px;
}

.br-block{
    white-space: nowrap;
    overflow:hidden;
}

.br-block1{
    display:inline-block;
    width:620px;
    height:197px;
    overflow:hidden;
}

.br-block2{
    display:inline-block;
    width:620px;
    height:370px;
    overflow:hidden;
}

.recommand{
    overflow-x:auto;
    overflow-y:hidden;
    height:200px;
}

.newbook{
    white-space:normal;
    overflow-x:hidden;
    overflow-y:auto;
    width:640px;
    height:346px;
}

.left{
    display:inline-block;
    padding:1px;
    width:620px;
    z-index:100;
}

.right{
    display:inline-block;
    white-space:normal;
    vertical-align: top; 
    margin-left:20px;
    width:160px;
}

.br-extend{
    margin-top:40px;
}

img{
    width:120px;
    margin:0 2px;
}

button{
    margin:3px;
}
</style>
