<template>
  <div class="content">
        <div class="body">
            <div class="body-left block">
              <p>收藏</p>
              <p>购物车</p>
              <p>求推荐</p>
              <p>我的订单</p>
              <p>设置</p>
            </div>
            <div class="body-right">
              <div class="br-block">
                <div class="br-block1">
                    <div class="left block">
                        <router-link to="./books">
                            <p>推荐 | 书库</p>
                        </router-link>
                        <ul class="recommand">
                          <li v-for=" i in 8">
                            <router-link to="/details">
                              <img :src="books[0].imgUrl" />
                            </router-link>
                          </li>
                        </ul>
                    </div>
                </div>
                <div class="classify right">
                  <router-link to="./books">
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
                          <li v-for="i in 40">
                            <router-link to="/details">
                              <img :src="books[0].imgUrl" />
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
                      <router-link to="./details">
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
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

.content{
    width:1200px;
}

.body-left{
    display:inline-block;
    width:160px;
    padding:20px 2px;
    z-index:100;
}

.body-left p{
    font-size:20px;
    margin:0;
    height:50px;
    line-height:50px;
    padding-left:50px;
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
    height:180px;
    overflow:hidden;
}

.br-block2{
    display:inline-block;
    width:620px;
    height:348px;
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
    height:315px;
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
