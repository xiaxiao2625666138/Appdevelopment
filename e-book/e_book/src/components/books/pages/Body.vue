<template>
  <div class="body">
    <div class="content">
         <div class="select">
             <span>分类</span>
             <input placeholder="搜索 | 深入理解计算机系统"/>
             <ul class="classify">
                 <li v-for="i in 20"><button>计算机</button> </li>
             </ul>
         </div>
         <div class="book-list block">
            <ul class="bl">
                          <li v-for="item in books">
                            <router-link :to="{path: 'details', query:{bid:item.book_id}}">
                              <img :src="item.cover" />
                            </router-link>
                          </li>
                        </ul>
        </div>
      </div>
 </div>
</template>

<script>
export default {
    props:['books']
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.content{
    width:744px;
}

.header span+span{
    margin-right:5%;
    cursor:pointer;
}

.header span+span:hover{
    color:#333;
}

.ebook{
    margin-right:20%;
}

.classify{
    clear:both;
    height:100%;
    white-space:normal;
    margin:10px 0 20px 0;

}

input{
    margin-left:440px;
    border-radius:16px;
}

img{
    float:left;
    width:120px;
    margin:2px;
}

.book-list{
    clear:both;
    width:744px;
    height:708px;
    overflow:hidden;
}

.bl{
    overflow-x:hidden;
    overflow-y:auto;
    white-space:normal;
    width:765px;
    height:710px;
    z-index:10000;
}

button{
    margin:3px;
}
</style>
