<template>
    <div class='like'>
        <div class="like-header">
            <img src="@/assets/img/like0.png"> 猜你喜欢
        </div>
        <ul>
            <li v-for="item in likeList" :key=item.id class="like-item border-bottom">
                <div>
                    <img :src=item.imgUrl>
                </div>
                <div class="like-text">
                    <p class="title">{{item.title}}</p>
                    <p>
                        <span class="iconfont" v-for="i in item.star">&#xe615; </span>
                        <span class="comment">{{item.comment}}条评论</span>
                    </p>
                    <p class="location-p">
                        <span class="price">￥<span>{{item.price}}</span>起</span>
                        <span class="location">{{item.location}}</span>
                    </p>
                </div>
            </li>
        </ul>
        <div class="like-tail">
            查看所有产品
        </div>
    </div>
</template>

<script>
export default{
   data(){
       return{
           "likeList":[
              {"id": "01", "imgUrl":require('@/assets/img/like1.jpg'),
              "title":"上海迪士尼乐园", "star": 5, "comment":211789, 
              "price": 40, "location":"浦东新区"},
              {"id": "02", "imgUrl":require('@/assets/img/like2.jpg'),
              "title":"上海海洋水族馆", "star": 5, "comment":19368, 
              "price": 105, "location":"浦东新区"},
              {"id": "03", "imgUrl":require('@/assets/img/like3.jpg'),
              "title":"东方明珠空中旋转餐厅", "star": 5, "comment":1441, 
              "price": 288, "location":"东方明珠"},
              {"id": "04", "imgUrl":require('@/assets/img/like4.jpg'),
              "title":"上海科技馆", "star": 5, "comment":12836, 
              "price": 51, "location":"浦东新区"},
              {"id": "05", "imgUrl":require('@/assets/img/like5.jpg'),
              "title":"上海影视乐园", "star": 5, "comment":7572, 
              "price": 58.5, "location":"松江区"},
              {"id": "06", "imgUrl":require('@/assets/img/like6.jpg'),
              "title":"上海野生动物园", "star": 5, "comment":46172, 
              "price": 65, "location":"浦东新区"},
              {"id": "07", "imgUrl":require('@/assets/img/like7.jpg'),
              "title":"环球金融中心观光厅", "star": 5, "comment":18781, 
              "price": 80, "location":"浦东新区"},
              {"id": "08", "imgUrl":require('@/assets/img/like8.jpg'),
              "title":"上海马戏城", "star": 5, "comment":1727, 
              "price": 153.2, "location":"闸北区"},
              {"id": "09", "imgUrl":require('@/assets/img/like9.jpg'),
              "title":"上海欢乐谷", "star": 5, "comment":34219, 
              "price": 39.6, "location":"松江区"},
              {"id": "10", "imgUrl":require('@/assets/img/like10.jpg'),
              "title":"上海星空错觉艺术馆", "star": 5, "comment":10030, 
              "price": 55, "location":"黄浦区"},
              {"id": "11", "imgUrl":require('@/assets/img/like11.jpg'),
              "title":"上海海昌海洋公园", "star": 5, "comment":1559, 
              "price": 49, "location":"浦东新区"},
              {"id": "12", "imgUrl":require('@/assets/img/like12.jpg'),
              "title":"上海中心大厦", "star": 5, "comment":7983, 
              "price": 90, "location":"浦东新区"},
              {"id": "13", "imgUrl":require('@/assets/img/like13.jpg'),
              "title":"上海自然博物馆", "star": 5, "comment":6590, 
              "price": 30, "location":"静安区"},
              {"id": "14", "imgUrl":require('@/assets/img/like14.jpg'),
              "title":"东方明珠", "star": 5, "comment":65785, 
              "price": 85, "location":"浦东新区"},
              {"id": "15", "imgUrl":require('@/assets/img/like15.jpg'),
              "title":"黄浦江游览", "star": 5, "comment":3352, 
              "price": 66, "location":"黄浦区"},
              {"id": "16", "imgUrl":require('@/assets/img/like16.jpg'),
              "title":"上海杜莎夫人蜡像馆", "star": 5, "comment":22065, 
              "price": 129, "location":"黄浦区"},
              {"id": "17", "imgUrl":require('@/assets/img/like17.jpg'),
              "title":"城隍庙旅游区", "star": 5, "comment":473, 
              "price": 154, "location":"黄浦区"},
              {"id": "18", "imgUrl":require('@/assets/img/like18.jpg'),
              "title":"陆家嘴", "star": 5, "comment":337, 
              "price": 28, "location":"浦东新区"},
              {"id": "19", "imgUrl":require('@/assets/img/like19.jpg'),
              "title":"黄浦江游船", "star": 5, "comment":7192, 
              "price": 80, "location":"东方明珠"},
              {"id": "20", "imgUrl":require('@/assets/img/like20.jpg'),
              "title":"金茂大厦88层观光厅", "star": 5, "comment":8823, 
              "price": 44, "location":"浦东新区"},
              {"id": "21", "imgUrl":require('@/assets/img/like21.jpg'),
              "title":"上海浦江源温泉农庄", "star": 5, "comment":231, 
              "price": 236, "location":"松江区"},
              {"id": "22", "imgUrl":require('@/assets/img/like22.jpg'),
              "title":"迪士尼小镇", "star": 5, "comment":127, 
              "price": 28, "location":"浦东新区"},
              {"id": "23", "imgUrl":require('@/assets/img/like23.jpg'),
              "title":"上海人民公园", "star": 5, "comment":209, 
              "price": 156, "location":"黄浦区"},
              {"id": "24", "imgUrl":require('@/assets/img/like24.jpg'),
              "title":"外滩", "star": 5, "comment":1456, 
              "price": 55, "location":"黄浦区"},
              {"id": "25", "imgUrl":require('@/assets/img/like25.jpg'),
              "title":"外滩观光隧道", "star": 5, "comment":7634, 
              "price": 35, "location":"黄浦区"},
           ]
       }
   }
}
</script>

<style scoped lang="stylus">
@import '~css/common.styl'
.like{
    textOverflow();
    margin-top:.2rem;
    background:#fff;
    padding: .2rem;
}
.like-header{
    font-size:.32rem;
    margin-bottom: .2rem;
}
.like-header img{
    width: .3rem
}
.like-item{
    position: relative;
    overflow:hidden;
    display:flex;
    padding-top:.2rem;
}
.like-item img{
    width:2rem;
    height:2rem;
    padding-bottom:.2rem;
}
.like-text{
    padding-top:.1rem;
    margin-left: .2rem;
    color:#616161;
    font-size:.24rem;
}
.like-text p{
    margin-top: .2rem;
}
.like-text .title{
    font-size:.32rem;
    color: #212121;
}
.like-text .iconfont{
    color:#ffb436;
    font-size:.24rem;
}
.like-text .comment{
    margin-left: .3rem;
}
.like-text .price{
    color:#ff8300;
}
.price span{
    font-size:.4rem;
}
.like-text .location{
    position:absolute;
    right:0;
    top:1.66rem;
}
.like-tail{
    font-size: .28rem;
    color:#00afc7;
    text-align:center;
    padding:.2rem 0;
}
</style>