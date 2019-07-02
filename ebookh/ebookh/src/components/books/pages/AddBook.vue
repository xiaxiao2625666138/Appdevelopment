<template>
    <div class="content">
        <p class="warning">! 注意：错误的输入将被设置为默认值</p>
        <p><input v-model="isbn" placeholder="ISBN" /></p>
        <p><input v-model="bookname" placeholder="book name" /></p>
        <p><input v-model="subtitle" placeholder="subtitle" /></p>
        <p><input v-model="author" placeholder="author" /></p>
        <p><input v-model="translator" placeholder="translator" /></p>
        <p><input v-model="version" placeholder="version: 1" /></p>
        <p><input v-model="language" placeholder="language: Chinese" /></p>
        <p><input v-model="publish" placeholder="publish" /></p>
        <p><input v-model="inventory" placeholder="inventory: 50" /></p>
        <p><input v-model="price" placeholder="price: 0.0" /></p>
        <div>
            <p class="file">
                &emsp;book cover
                <input placeholder="book cover" type="file"/>
            </p>
        </div>
        <p class="fun">
            <button @click="cancel">Cancel</button>
            <button @click="addbook">Submit</button>
        </p>
    </div>
</template>

<script>
export default {
  props: [],
  data() {
    return {
        isbn:"test",
        bookname:"昨日晴空",
        subtitle:"洋场",
        author:"xiaxiao",
        translator:"",
        version:"1",
        language:"Chinese",
        publish:"xiaxiao出版社",
        inventory:50,
        price:0.0,
        server:this.GLOBAL.server,
    };
  },
  methods: {
      cancel:function(event){
          this.$emit("cancel");
      },
      addbook:function(){
          var url1=this.server+"/adm/addBook"+
          "?isbn="+this.isbn+"&bookname="+this.bookname+"&subtitle="+this.subtitle+
              "&author="+this.author+"&translator="+this.translator+"&version="+this.version+
              "&language="+this.language+"&publish="+this.publish+"&inventory="+this.inventory+
              "&price="+this.price;
          this.$http.get(url1).then((res)=>{
              console.log(res);
              if(res.data.status=="fail"){
                  alert(res.data.msg);
                  return;
              }
              var formaData=new FormData();
              var formData=new window.FormData();
              formData.append("file", document.querySelector('input[type=file]').files[0]);
              var options={
                  url:this.server+"/adm/upload",
                  data:formData,
                  method:"post",
                  headers:{
                      'Content-Type': 'multipart/form-data'
                  }
              }
              this.$http(options).then((res)=>{
                  console.log(res);
                  if(res.data.status=="ok"){
                      alert("add book: "+this.bookname);
                  }else{
                      alert("add book error!");
                  }
                  this.$emit("update");
                  this.$emit("cancel");
              })
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