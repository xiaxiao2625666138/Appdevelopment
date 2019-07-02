<template>
    <div class="content">
        <p class="warning">! 注意：不输入将保持原来的内容</p>
        <p><input v-model="isbn" :placeholder="'ISBN: '+book.isbn" /></p>
        <p><input v-model="bookname" :placeholder="'book name: '+book.name" /></p>
        <p><input v-model="subtitle" :placeholder="'subtitle: '+book.subtitle" /></p>
        <p><input v-model="author" :placeholder="'author: '+book.authors[0].name" /></p>
        <p><input v-model="translator" v-if="book.translators[0]" :placeholder="'translator: '+book.translators[0].name" /></p>
        <p><input v-model="translator" v-if="!book.translators[0]" placeholder="translator" /></p>
        <p><input v-model="version" :placeholder="'version: '+book.version" /></p>
        <p><input v-model="language" :placeholder="'language: '+book.language" /></p>
        <p><input v-model="publish" :placeholder="'publish: '+book.publish.name" /></p>
        <p><input v-model="inventory" :placeholder="'inventory: '+book.inventory" /></p>
        <p><input v-model="price" :placeholder="'price: '+book.price" /></p>
        <div>
            <p class="file">
                &emsp;book cover
                <input placeholder="book cover" type="file"/>
            </p>
        </div>
        <p class="fun">
            <button @click="cancel">Cancel</button>
            <button @click="alterbook">Submit</button>
        </p>
    </div>
</template>

<script>
export default {
  props: ["book"],
  data() {
    return {
        isbn:"",
        bookname:"",
        subtitle:"",
        author:"",
        translator:"",
        version:"",
        language:"",
        publish:"",
        inventory:"",
        price:"",
        server:this.GLOBAL.server,
    };
  },
  methods: {
      cancel:function(event){
          this.$emit("cancel");
      },
      alterbook:function(){
          var url1=this.server+"/adm/alterBook"+
          "?isbn="+this.isbn+"&bookname="+this.bookname+"&subtitle="+this.subtitle+
              "&author="+this.author+"&translator="+this.translator+"&version="+this.version+
              "&language="+this.language+"&publish="+this.publish+"&inventory="+this.inventory+
              "&price="+this.price+"&bookid="+this.book.id;
          this.$http.get(url1).then((res)=>{
              console.log(res);
              if(res.data.status=="fail"){
                  alert(res.data.msg);
                  return;
              }
              var formaData=new FormData();
              var formData=new window.FormData();
              if(document.querySelector('input[type=file]').files[0]){
                  formData.append("file", document.querySelector('input[type=file]').files[0]);
                  var options={
                  url:this.server+"/adm/alterCover",
                  data:formData,
                  method:"post",
                   headers:{
                      'Content-Type': 'multipart/form-data'
                    }
                  }
                  this.$http(options).then((res)=>{
                  console.log(res);
                  if(res.data.status=="ok"){
                      alert("alter book: "+this.book.name);
                  }else{
                      alert("alter book error!");
                  }
              })
            }
              this.$emit("update");
              this.$emit("cancel");
          })
      }
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->

<style scoped>

.warning{
    text-align:center;
    margin-bottom:20px;
}

.content{
    background:rgb(239, 240, 234);
    z-index:10000;
    width:100%;
    padding-top:80px;
}

input{
    width:300px;
    height:35px;
    padding:0 20px;
    border-radius:5px;
    display:block;
    margin: 0 auto;
    margin-bottom:20px;
    font-size:16px;
    box-shadow:0 0 5px 0;
}

.file{
    width:340px;
    height:35px;
    line-height:35px;
    margin:0 auto;
    border-radius: 5px;
    position: relative;
    background:#333;
    color:rgb(131, 130, 130);
    font-size:16px;
    box-shadow:0 0 5px 0;
    overflow:hidden;
}

.file input{
    margin-top:0;
    padding:0;
    width:100%;
    opacity:0;
    position:absolute;
    top:0;
}

.fun{
    width:300px;
    margin:0 auto;
    margin-top:30px;
}
.fun button{
    float:none;
    width:100px;
    height:30px;
    margin:0 25px;
}
</style>