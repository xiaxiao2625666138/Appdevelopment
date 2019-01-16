<template>
    <div class='hot'>
        <div class="hot-header">
            <img src="@/assets/img/hot0.png"><span class="left"> 本周热门榜单</span>
            <span class="right">全部榜单<span class="iconfont">&#xe632;</span></span>
        </div>
        <ul class="hot-list">
            <li class="hot-item" v-for="item in hotList" :key=item.id>
                <img :src=item.imgUrl> 
                <p>{{item.title}}</p>   
                <p><span class="price">￥{{item.price}}</span>起</p>              
            </li>
        </ul>
    </div>
</template>

<script>
export default{
    data(){
        return {
            "hotList":[
                {"id": "01", "imgUrl": require('@/assets/img/hot1.jpg'), "title": "上海迪士尼乐园", "price":"40"},
                {"id": "02", "imgUrl": require('@/assets/img/hot2.jpg'), "title": "上海野生动物园", "price":"65"},
                {"id": "03", "imgUrl": require('@/assets/img/hot3.jpg'), "title": "东方明珠", "price":"85"},
                {"id": "04", "imgUrl": require('@/assets/img/hot4.jpg'), "title": "上海动物园", "price":"38"},
                {"id": "05", "imgUrl": require('@/assets/img/hot5.jpg'), "title": "上海海昌海洋公园", "price":"49"},
                {"id": "06", "imgUrl": require('@/assets/img/hot6.jpg'), "title": "环球金融中心观光厅", "price":"80"},
                {"id": "07", "imgUrl": require('@/assets/img/hot7.jpg'), "title": "上海杜莎夫人蜡像馆", "price":"129"},
                {"id": "08", "imgUrl": require('@/assets/img/hot8.jpg'), "title": "上海自然博物馆", "price":"30"},
                {"id": "09", "imgUrl": require('@/assets/img/hot9.jpg'), "title": "辰山植物园", "price":"60"},
                {"id": "10", "imgUrl": require('@/assets/img/hot10.jpg'), "title": "上海海洋水族馆", "price":"105"},
            ],
        }
    }
}
</script>

<style scoped lang="stylus">
@import '~css/common.styl'
.hot{
    margin-top:.2rem;
    background:#fff;
    padding: .2rem 0 .1rem .2rem;
    font-size: .24rem;
}
.hot-header img{
    width: .32rem;
}
.left{
    font-size:.32rem;
}
.right{
    float:right;
    padding-right:.2rem;
    color:#616161;
}
.hot-list{
    overflow-x:scroll;
    white-space:nowrap;
    overflow-y:hidden;
    height: 3.2rem;
}
.hot-item{
    display:inline-block;
    padding: .2rem .2rem .2rem 0;
    width: 2rem;
    height:2rem;
}
.hot-item img{
    width: 100%;
    height:100%;
}
.hot-list p{
    text-align:center;
    margin-top: .1rem;
    textOverflow();
}
.price{
    font-size:.26rem;
    color:rgb(255, 131, 0);
}
</style>