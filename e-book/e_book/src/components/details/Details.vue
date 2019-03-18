<template>
  <div class="details page">
    <details-header></details-header>
    <details-body></details-body>
    <div class="footer">
        <p>Copyright@zxz5141509091</p>
    </div>
  </div>
</template>

<script>
import DetailsHeader from '../books/pages/Header'
import DetailsBody from './pages/Body'
export default {
  components:{
    DetailsHeader,
    DetailsBody,
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
