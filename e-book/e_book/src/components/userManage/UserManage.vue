<template>
  <div class="root">
      <userManage-header :now="page"></userManage-header>
      <userManage-body class="body"></userManage-body>
      <div class="footer">
        <p>Copyright@zxz5141509091</p>
      </div>
  </div>
</template>

<script>
import UserManageHeader from '@/components/books/pages/Header'
import UserManageBody from './pages/Body'
export default {
  data:function(){
    return{
      page:"userManage",
    }
  },
  components:{
      UserManageHeader,
      UserManageBody,
  },
  methods:{ 
    
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.root{
}
</style>