<template>
  <div class="body">
    <div class="content">
         <div class="select">
             <button v-if="adm" class="add">+</button>
             <button @click="setFilter('author')"
             :style="byauthor">Author</button>
             <button @click="setFilter('bookname')"
             :style="bybookname">Book Name</button>
             <input @keyup="bookBrowse()" v-model="condition"
             type="text" placeholder="搜索 | 深入理解计算机系统"/>
         </div>
         <detail-book v-if="lookDetail" :book="detailBook"></detail-book>
         <div class="book-list block">
            <ul class="bl">
               <li v-for="item in books">
                   <div class="item">
                      <img @mouseover="detail(item.book_id)" 
                      @mouseout="closeDetail" :src="item.cover" />
                      <div class="browse">
                          <p class="isbn">
                              ISBN: {{item.ISBN}}
                          </p>
                          <p>
                              <span class="bookname">{{item.book_name}}</span> 
                              <span v-if="item.subtitle"> · {{item.subtitle}}</span>
                          </p>
                          <p>
                              <span >{{item.author_name}}</span>
                              <span v-if="item.author1_name"> | {{item.author1_name}}</span>
                              <span v-if="item.author2_name"> | {{item.author2_name}}</span>
                              <span v-if="item.author3_name"> | {{item.author3_name}}</span>
                          </p>
                          <p>
                              库存 <span class="inventory">{{item.inventory}}</span> 本！
                          </p>
                          <button class="iconfont gouwuche" v-if="!adm"
                          @click="addOrder(item.book_id)">
                              &#xe60c;
                          </button>
                          <div v-if="adm" class="manage">
                              <button v-if="item.onsale=='N'" @click="offOnSale(item.book_id, 'Y', item)">add</button>
                              <button v-if="item.onsale=='Y'" @click="offOnSale(item.book_id, 'N', item)">Delete</button>
                              <button >Alter</button>
                          </div>
                      </div>
                   </div>
               </li>
            </ul>
        </div>
      </div>
 </div>
</template>

<script>

import DetailBook from "./Detail";

export default {
    props:[],
    components:{
        DetailBook,
    },
    data:function(){
        return{
            filter:"bookname",
            condition:"",
            ready:false,
            books:[],
            byauthor:{
                color:'#aaa',
            },
            bybookname:{
                color:'#aaa',
            },
            detailBook:{},
            lookDetail:false,
            user:"",
            adm:false
        }
    },
    methods:{
        bookBrowse:function(){
            var getURL="/api/page/HomeServlet?filter="+this.filter+"&"+this.filter+"="+this.condition;
            console.log(getURL);
            this.$http.get(getURL).then((res)=>{
            console.log(res);
            this.books=res.data.bookArr;
            })
        },
        addOrder:function(book_id){
          var getUrl="/api/page/AddOrderServlet?book_id="+book_id;
          this.$http.get(getUrl).then((res)=>{
          console.log(res)});
        },
        setFilter:function(fil){
            this.filter=fil;
            if(fil=="bookname"){
                this.bybookname.color='orange';
                this.byauthor.color='#aaa';
            }else{
                this.byauthor.color='orange';
                this.bybookname.color='#aaa';
            }
            this.bookBrowse();
        },
        detail:function(book_id){
            this.$http.get("/api/page/DetailServlet?book_id="+book_id).then((res)=>{
            this.detailBook=res.data;
            this.lookDetail=true;
            })
        },
        closeDetail:function(){
            this.lookDetail=false;
            this.Detailbook={};
        },
        offOnSale:function(book_id, offon, item){
            var getUrl="/api/page/adm/OffOnServlet?book_id="+book_id+"&offon="+offon;
            this.$http.get(getUrl).then((res)=>{
                item.onsale=offon;
            });
        }
    },
    mounted(){
      this.$http.get("/api/page/UserTypeServlet").then((res)=>{
          console.log(res);
          if(res.data==302){
              this.$router.push({path: '/'});
          }else{
              this.user=res.data.user;
              this.adm=res.data.islogin==2;
          }
       });
        this.$http.get("/api/page/HomeServlet?filter=all").then((res)=>{
          console.log(res);
          this.books=res.data.bookArr;
      });
    }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.content{
    width:1122px;
    height:870px;
    position:relative;
    background:black;
    border-radius:30px;
    overflow:hidden;
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

.select{
    height:60px;
    margin-top:40px;
    position:relative;
}

.select button{
    width:110px;
    height:30px;
    margin-left:20px;
}

.select .add{
  width:42px;
  height:40px;
  border-radius: 30px;
  font-size:25px;
}

input{
    position:absolute;
    right:20px;
    border-radius:16px;
    height:28px;
    width:300px;
}

.block{
    background:none;
}

img{
    width:120px;
    padding:0;
    margin:0;
}

.book-list{
    clear:both;
    width:1120px;
    height:708px;
    overflow:hidden;
}

.bl{
    overflow-x:hidden;
    overflow-y:auto;
    white-space:normal;
    width:1150px;
    height:710px;
    z-index:10000;
}

.item{
    background:#333;
    margin:2px;
    height:171px;
    overflow:hidden;
    border-radius:7px;
}

button{
    margin:3px;
}

.browse{
    display:inline-block;
    overflow:hidden;
    width:236px;
    padding:0 5px;
    position:relative;
    vertical-align:top;
    height:160px;
}

.browse p{
    overflow:hidden;
    text-overflow:ellipsis;
    white-space:nowrap;
    height:30px;
    line-height:30px;
}

.isbn{
    color:#888;
}

.bookname{
    font-size:17px;
}

.inventory{
    color:rgb(255, 81, 0);
    font-size:19px;
}

.gouwuche{
    display:block;
    font-size:30px;
    position:absolute;
    bottom:0;
    right:10px;
    color:#888;
    cursor:pointer;
    border-radius:40px;
}

.gouwuche:focus{
    color:orange;
}

.gouwuche:hover{
    color:orange;
}

.gouwuche:active{
    color:#fff;
}

button:hover{
   background:rgb(255, 102, 0);
   color:#333;
}
button:active{
    background:#222;
}

.manage{
    margin-top:10px;
    text-align:right;
}
.manage button{
    width:60px;
}

</style>
