<template>
    <div class="body">
        <div class="content">
            <div class="relational-books">
                <div class="rbook">
                    <p class="title">推荐</p>
                    <ul class="books">
                        <div v-for="i in 10" class="item block">
                         <div class="front item-front"></div>
                           <img :src="book.imgUrl" />
                           <div class="message">
                             <p>{{book.name}}</p>
                             <p>{{book.author}}</p>
                             <p>评分: {{book.score}}</p>
                             <p>价格:
                                <span class="highlight">￥{{book.price}}</span>
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
                          <img :src="book.imgUrl" />
                          <div class="message">
                           <p >{{book.name}}</p>
                           <p>{{book.author}}</p>
                           <p>评分: {{book.score}}</p>
                           <p>销量:
                             <span class="highlight">{{book.saled}} </span>册</p>
                          </div>
                        </div>
                    </ul>
                </div>
            </div>
            <div class="book-details">
                <div  class="this-book block">
                    <img :src="book.cover" />
                    <div class="book-message">
                        <p class="highlight score"> {{book.score}} </p>
                        <p >
                            <span class="book-name" @click="changeColor" :style="nameStyle">{{book.book_name}}</span>
                            <span v-if="book.subtitle"> · {{book.subtitle}}</span></p>
                        <p>作者：{{book.author_name}} 
                            <span v-if="book.author1_name"> | {{book.author1_name}}</span>
                            <span v-if="book.author2_name"> | {{book.author2_name}}</span>
                            <span v-if="book.author3_name"> | {{book.author3_name}}</span> </p>
                        <p>译者：{{book.translator_name}} 
                            <span v-if="book.translator1_name"> | {{book.translator1_name}}</span>
                            <span v-if="book.translator2_name"> | {{book.translator2_name}}</span>
                            <span v-if="book.translator3_name"> | {{book.translator3_name}}</span> </p>
                        <p>版本：第{{book.version}}版</p>
                        <p>语言：{{book.language_name}}</p>
                        <p>出版：{{book.press_name}} </p>
                        <p><span class="highlight">￥{{book.price}}</span><span>销量 {{book.saled}} 册</span></p>
                        <p class="logo">
                            <button v-for="logo in book.logo">{{book.logos}}</button>
                        </p>
                    </div>
                    <div class="book-fun">
                        <span class="iconfont shoucang">&#xe601;</span>
                        <span class="iconfont gouwuche">&#xe60c;</span>
                    </div>
                </div>
                <div class="preview block">
                    <div>
                        <span @click="lookBook" :style="book_intro_style">简介</span>
                        <span @click="lookAuthor" :style="author_intro_style">作者</span>
                    </div>
                    <div class="pre-content">
                        <p v-if="book_intro">
                            {{book.detail}}
                        </p>
                        <p v-if="author_intro">
                            {{book.author_detail}}
                        </p>
                    </div>
                </div>
                <div class="similar-book block">
                    <p>相关书籍</p>
                    <ul >
                        <li v-for="i in 10">
                            <img :src="book.imgUrl" />
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</template>

<script>
export default {
    props:['book'],
    data(){
        return{
            nameStyle:{
                color:"#aaa"
            },
            book_intro:true,
            author_intro:false,
            book_intro_style:{
                "border-bottom":"solid 2px orange"
            },
            author_intro_style:{
                "border-bottom":"solid 2px #111"
            }
        }
    },
    methods:{
      changeColor:function(){
          this.nameStyle.color=(this.nameStyle.color=="#aaa" 
          || this.nameStyle.color=="black") ?"red": "black";
      },
      lookBook:function(){
          this.book_intro=true;
          this.book_intro_style={
                "border-bottom":"solid 2px orange"
            };
          this.author_intro=false;
          this.author_intro_style={
                "border-bottom":"solid 2px #111"
            };
      },
      lookAuthor:function(){
          this.book_intro=false;
          this.book_intro_style={
                "border-bottom":"solid 2px #111"
            };
          this.author_intro=true;
          this.author_intro_style={
                "border-bottom":"solid 2px orange"
            };
      }
    },
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
    width:135px;
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

.book-fun{
    padding-bottom:10px;
}

.book-fun span{
    display:inline-block;
    width:60px;
    text-align:center;
    cursor:pointer;
    color:cadetblue;
}

.shoucang{
    font-size:24px;
}
.gouwuche{
    font-size:28px;
}

.book-fun span:hover{
    color:#000;
}

.preview{
    margin-top:2px;
    width:640px;
    overflow:hidden;
    padding:10px 2px;
}

.preview span{
    padding:8px 12px 4px 12px;
    font-size:16px;
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
.pre-content p{
    width: 620px;
    margin: 0 auto;
    white-space:normal;
    line-height:30px;
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