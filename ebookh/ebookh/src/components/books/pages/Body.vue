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
         <div class="book-list">
            <ul class="bl">
               <li v-for="item in books">
                   <div class="item">
                      <img @mouseover="detail(item.id)" 
                      @mouseout="closeDetail" :src="item.cover" />
                      <div class="browse">
                          <p class="isbn">
                              ISBN: {{item.isbn}}
                          </p>
                          <p>
                              <span class="bookname">{{item.name}}</span> 
                              <span v-if="item.subtitle"> · {{item.subtitle}}</span>
                          </p>
                          <p>
                              <span v-for="(author, index) in item.authors">
                                  <span v-if="index!=0"> | </span>{{author.name}}
                              </span>
                          </p>
                          <p>
                              库存 <span class="inventory">{{item.inventory}}</span> 本！
                          </p>
                          <button class="iconfont gouwuche" v-if="!adm"
                          @click="addOrder(item.id)">
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
                color:'#000',
            },
            bybookname:{
                color:'#000',
            },
            detailBook:{},
            lookDetail:false,
            user:"",
            adm:false
        }
    },
    methods:{
        bookBrowse:function(){
            var getURL="http://localhost:8080/ebook/";
            if(this.filter=="bookname"){
                getURL=getURL+"lookBookLike?bookname="+this.condition;
            }else{
                getURL=getURL+"lookBookBy?authorName="+this.condition;
            }
            this.$http.get(getURL).then((res)=>{
            console.log(res);
            this.books=res.data;
            })
        },
        addOrder:function(book_id){
          var getUrl="http://localhost:8080/ebook/user/addEorder?bookid="+book_id;
          this.$http.get(getUrl).then((res)=>{
          console.log(res)});
        },
        setFilter:function(fil){
            this.filter=fil;
            if(fil=="bookname"){
                this.bybookname.color='orange';
                this.byauthor.color='#000';
            }else{
                this.byauthor.color='orange';
                this.bybookname.color='#000';
            }
            this.bookBrowse();
        },
        detail:function(id){
            this.$http.get("http://localhost:8080/ebook/lookBookById?id="+id).then((res)=>{
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
      this.$http.get("http://localhost:8080/ebook/userType").then((res)=>{
          console.log(res);
          if(res.data==0){
              this.$router.push({path: '/'});
          }else{
              this.user=res.data.user;
              this.adm=res.data.islogin==2;
          }
       });
        this.$http.get("http://localhost:8080/ebook/lookAllBook").then((res)=>{
          console.log(res);
          this.books=res.data;
      });
    }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.content{
    width:747px;
    height:870px;
    position:relative;
    overflow:hidden;
    z-index: 100;
    border-radius: 10px;
    box-shadow:0 0 50px 0;
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
    color:#000;
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
    background:#fff;
    box-shadow:0 0 10px 0;
}

input:focus{
    color:rgb(12, 195, 250);
}

img{
    width:120px;
    padding:0;
    margin:0;
}

.book-list{
    clear:both;
    width:780px;
    height:708px;
    overflow:hidden;
}

.bl{
    overflow-x:hidden;
    overflow-y:auto;
    white-space:normal;
    width:780px;
    height:710px;
    z-index:10000;
}

.item{
    margin:2px;
    height:171px;
    overflow:hidden;
    border-radius:7px;
    z-index:1000;
    box-shadow:0 0 15px 0;
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
