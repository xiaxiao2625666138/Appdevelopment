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
                <li v-for="i in 50">
                    <router-link to="/details">
                       <img src="@/assets/img/ics.jpg" />
                    </router-link>
                </li>
            </ul>
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
.content{
    width:869px;
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
    margin-left:560px;
    border-radius:16px;
}

img{
    float:left;
    width:120px;
    margin:2px;
}

.book-list{
    clear:both;
    width:869px;
    height:796px;
    overflow:hidden;
}

.bl{
    overflow-x:hidden;
    overflow-y:auto;
    white-space:normal;
    width:889px;
    height:794px;
    z-index:10000;
}

button{
    margin:3px;
}
</style>
