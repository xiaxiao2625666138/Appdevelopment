<template>
    <div class='header'>
        <div class='header-left'>
            <span class='iconfont'>&#xe611;</span>
        </div>
        <div class='header-search'>
            <span class='iconfont'>&#xe692;</span>
            输入城市/景点/游玩主题
        </div>
        <div class='header-right'>
            上海<span class='iconfont'>&#xe644;</span>
        </div>
    </div>
</template>

<script>
export default{
}
</script>

<style scoped lang='stylus'>
@import '~css/var.styl'
.header{
    background:$bgColor;
    width:100%;
    display:flex;
    line-height:.8rem;
    font-size:.28rem;
    color:#fff;
    font-family:Arial,"Microsoft Yahei","Helvetica Neue",Helvetica,sans-serif;
}
.header-left{
    width:.4rem;
    padding:0 .1rem 0 .2rem;
    font-weight:bold;
    font-size:.36rem;
}
.header-search{
    flex:1;
    background:#fff; 
    color:#e4e7ea;
    height:.6rem;
    margin: .1rem;
    border-radius:2px;
    line-height:.6rem;
    padding-left:.2rem;
}
.header-right{
    padding-right:.1rem;
}
</style>