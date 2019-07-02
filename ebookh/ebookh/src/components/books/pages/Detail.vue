<template>
    <div class="this-book block">
        <img :src="'data:image/jpg;base64,'+book.bookimage" />
        <div class="book-message">
            <p class="highlight score"> {{book.score}} </p>
            <p class="isbn">ISBN: {{book.isbn}}</p>
            <p>
                <span class="book-name">{{book.name}}</span>
                <span v-if="book.subtitle"> · 
                    <span class="subtitle">{{book.subtitle}}</span>
                </span>
            </p>
            <p>作者: 
              <span v-for="(author, index) in book.authors">
                  <span v-if="index!=0"> | </span>{{author.name}}
              </span>
            </p>
            <p v-if="book.translators[0]">译者: 
              <span v-for="(translator, index) in book.translators">
                  <span v-if="index!=0"> | </span>{{translator.name}}
              </span>
            </p>
            <p>版本：第{{book.version}}版</p>
            <p>语言：{{book.language}}</p>
            <p>出版：{{book.publish.name}} </p>
            <p class="logo">
                <button v-for="logo in book.logo">{{book.logos}}</button>
            </p>
        </div>
        <p class="num">
            销量 <span>{{book.saled}}</span> 册 |
            库存 <span>{{book.inventory}}</span> 册
            <span class="highlight">￥{{book.price}}</span>
        </p>
    </div>
</template>

<script>
export default {
  props: ["book"],
  data() {
    return {
    };
  },
  methods: {},
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
img {
  margin: 0;
  box-shadow: 0 0 20px 0;
}

.isbn{
    color:#000;
}

.this-book {
  position: absolute;
  background:#fff;
  z-index: 1000;
  left:0;
  right:0;
  top:0;
  bottom:0;
  margin:auto;
  padding: 20px;
  width:440px;
  height:240px;
  border-radius: 10px;
  box-shadow:0 0 100px 0;
}

.this-book img {
  width: 140px;
  border-radius:5px;
  z-index:10000;
}

.this-book button {
  float: none;
}

.book-message {
  display: inline-block;
  font-size: 15px;
  vertical-align:top;
  margin-left:10px;
  width:270px;
  height:200px;
}

.book-message p {
  margin-bottom: 10px;
  height:20px;
  line-height:20px;
  overflow:hidden;
  text-overflow:ellipsis;
  white-space:nowrap;
}

.book-message .score{
  height:25px;
  line-height:25px;
}

.this-book .highlight {
  font-size: 25px;
  margin: 10px;
}

.score {
  position: absolute;
  right: 0;
  top:15px;
}

.book-name {
  font-size: 20px;
  cursor: pointer;
}

.logo button {
  font-size: 10px;
  margin: 0 2px;
  cursor: auto;
}

.book-fun {
  padding-bottom: 10px;
}

.book-fun span {
  display: inline-block;
  width: 60px;
  text-align: center;
  cursor: pointer;
  color: cadetblue;
}

.shoucang {
  font-size: 24px;
}
.gouwuche {
  font-size: 28px;
}

.book-fun span:hover {
  color: #000;
}

.book-fun span:active {
  color: cadetblue;
}

.num{
    margin-top:10px;
}

.num span{
    color:orange;
    font-size:19px;
}

.subtitle{
    color:#666;
}
</style>