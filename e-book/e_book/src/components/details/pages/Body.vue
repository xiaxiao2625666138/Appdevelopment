<template>
    <div class="body">
        <div class="content">
            <div class="relational-books">
                <div class="rbook">
                    <p class="title">推荐</p>
                    <ul class="books">
                        <div v-for="i in 10" class="item block">
                         <div class="front item-front"></div>
                           <img src="@/assets/img/ics.jpg" />
                           <div class="message">
                             <p>深入理解计算机系统</p>
                             <p>作者: Randal E. Bryant & David R. O'Hallaron</p>
                             <p>评分: 9.9</p>
                             <p>价格:
                                <span class="highlight">￥1</span>
                             </p>
                            </div>
                        </div>
                    </ul>
                </div>
                <div class="rbook">
                    <p class="title">排行榜</p>
                    <ul class="books">
                        <div v-for="i in 10" class="item block">
                          <div class="front item-front"></div>
                          <img src="@/assets/img/ics.jpg" />
                          <div class="message">
                           <p >深入理解计算机系统</p>
                           <p>作者: Randal E. Bryant & David R. O'Hallaron</p>
                           <p>评分: 9.9</p>
                           <p>销量:
                             <span class="highlight">0 </span>册</p>
                          </div>
                        </div>
                    </ul>
                </div>
            </div>
            <div class="book-details">
                <div class="this-book block">
                    <img src="@/assets/img/ics.jpg" />
                    <div class="book-message">
                        <p class="highlight score"> 9.9 </p>
                        <p class="book-name" @click="changeColor" :style="nameStyle">深入理解计算机系统</p>
                        <p>Randal E. Bryant & David R. O'Hallaron</p>
                        <p>第三版( 英文版 )</p>
                        <p>机械工业出版社 </p>
                        <p><span class="highlight">￥1</span><span>月售 0册</span></p>
                        <p class="logo">
                            <button>本科教学</button>
                            <button>计算机系统</button>
                            <button>入门</button>
                        </p>
                    </div>
                    <div class="book-fun">
                        <button>收藏</button>
                        <button>购物车</button>
                    </div>
                </div>
                <div class="preview block">
                    <div>
                        <span>简介</span>
                        <span>作者</span>
                    </div>
                    <div class="pre-content">
                        <ul>
                            <div v-for="i in 10">
                             <p>好</p>
                             <p>好难</p>
                             <p>好难啊</p>
                             <p>好难啊好</p>
                             <p>好难啊好难</p>
                             <p>好难啊好难啊</p>
                             <p>好难啊好难啊好</p>
                             <p>好难啊好难啊好难</p>
                             <p>好难啊好难啊好难啊</p>
                            </div>
                        </ul>
                    </div>
                </div>
                <div class="similar-book block">
                    <p>相关书籍</p>
                    <ul >
                        <li v-for="i in 10">
                            <img src="@/assets/img/ics.jpg" />
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</template>

<script>
export default {
    data(){
        return{
            nameStyle:{
                color:"#aaa"
            },
        }
    },
    methods:{
      changeColor:function(){
          this.nameStyle.color=(this.nameStyle.color=="#aaa" 
          || this.nameStyle.color=="black") ?"red": "black";
      }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

.content{
    width:1000px;
}

.details-content img{
    margin:0;
}

.details-content img:hover{
    opacity:1;
}

.relational-books{
    display:inline-block;
    vertical-align: top; 
    width:300px;
    overflow:hidden;
}

.rbook{
    width:300px;
    overflow:hidden;
    margin-bottom:30px;
}

.books{
    position:relative;
    width:320px;
    height:398px;
    overflow-y:auto;
    overflow-x:hidden;
}

.title{
    text-align:center;
    background:#222;
    height:40px;
    line-height:40px;
    margin-top:0;
    margin-bottom:2px;
}

.item{
    z-index:100;
    overflow: auto;
    white-space: nowrap;
    width:300px;
    padding:1px;
    margin-bottom:2px;
    cursor:pointer;
}

.item-front{
    position:absolute;
    width:298px;
    height:132px;
    display:none;
}

.item:hover .item-front{
    display:block;
}

.item img{
    width:100px;
}

.message{
    display:inline-block;
    padding:0 5px;
    width:180px;
    overflow:hidden;
}

.message p{
    width:100%;
    height:30px;
    line-height:30px;
    text-align:left;
    overflow:hidden;
    text-overflow:ellipsis;
    white-space:nowrap
}

.item p+p{
    font-size:13px;
}


.book-details{
    display:inline-block;
    vertical-align: top; 
    width:640px;
    margin-left:56px;
    overflow:hidden;
}

.this-book{
    position:relative;
    z-index:100;
    padding:1px;
}

.this-book img{
    width:130px;
}

.this-book button{
    float:none;
}

.book-message{
    display:inline-block;
    font-size:15px;
}

.book-message p{
    margin:10px;
}

.this-book .highlight{
    font-size:25px;
    margin:10px;
}

.score{
    position:absolute;
    right:0;
}

.book-name{
    font-size:20px;
    cursor:pointer;
}

.logo button{
    font-size:10px;
    margin: 0 2px;
    cursor:auto;
}

.book-fun button{
    border-radius:4px;
    margin:5px 3px;
}

.book-fun button:hover{
    background:#111;
}


.preview{
    margin-top:2px;
    width:640px;
    overflow:hidden;
    padding:10px 1px;
}

.preview span{
    padding:8px 12px 4px 12px;
    margin:8px;
    font-size:20px;
    border-bottom:solid 2px #111;
    cursor:pointer;
}

.preview span:hover{
    border-bottom-color:orange;
}

.pre-content{
    padding: 5px 0;
    width:660px;
    height:400px;
    margin-top:20px;
    overflow-y:auto;
    overflow-x:hidden;
    z-index:100;
}

.similar-book{
    margin-top:2px;
    padding:1px;
    overflow:hidden;
    width:660px;
    height:187px;
    z-index:100;
}

.similar-book p{
    padding:8px 12px;
}

.similar-book ul{
    overflow-x:auto;
    overflow-y:hidden;
    height:200px;
}

.similar-book img{
    float:none;
    width:120px;
    margin-right:3px;
}
</style>