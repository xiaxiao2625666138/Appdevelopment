<template>
    <div class='location border-top'>
       <div class="location-item  border-right">
           <span class="iconfont ">&#xe720;</span>
           上海浦东新区
       </div>
       <div class="location-item">
           <span class="iconfont">&#xe642;</span>
           必游榜单
       </div>
    </div>
</template>

<script>
export default{
}
</script>

<style scoped lang="stylus">
@import '~css/common.styl'
.location{
    textOverflow();
    background:#fff;
    position:relative;
    padding-top:.4rem;
    color: #444;
    font-size:.32rem;
    display:flex;
}
.location-item span{
    font-size: .36rem;
}
.location-item{
    position:relative;
    text-align:center;
    line-height:1rem;
    width:50%;
}
</style>