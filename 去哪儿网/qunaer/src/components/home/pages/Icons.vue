<template>
    <div class="icons">
        <swiper :options="swiperOption" class="swiper">
            <swiper-slide v-for="(page,index) in page" :key=index>
                <div class='icons-item' v-for="item in page" :key=item.id>
                    <img :src=item.imgUrl :key=item.id>
                    <p>{{item.title}}</p>
                </div>
            </swiper-slide>
            <div class="swiper-pagination"  slot="pagination"></div>
        </swiper>
    </div>
</template>

<script>
export default{
    data(){
        return{
            "iconsList":[
                {"id":"01", "imgUrl":require('@/assets/img/icons1.png'),"title":"景点门票"},
                {"id":"02", "imgUrl":require('@/assets/img/icons2.png'),"title":"一日游"},
                {"id":"03", "imgUrl":require('@/assets/img/icons3.png'),"title":"上海必游"},
                {"id":"04", "imgUrl":require('@/assets/img/icons4.png'),"title":"动植物园"},
                {"id":"05", "imgUrl":require('@/assets/img/icons5.png'),"title":"城市观光"},
                {"id":"06", "imgUrl":require('@/assets/img/icons6.png'),"title":"泡温泉"},
                {"id":"07", "imgUrl":require('@/assets/img/icons7.png'),"title":"上海欢乐谷"},
                {"id":"08", "imgUrl":require('@/assets/img/icons8.png'),"title":"野生动物园"},
                {"id":"09", "imgUrl":require('@/assets/img/icons9.png'),"title":"上海迪士尼"},
                {"id":"10", "imgUrl":require('@/assets/img/icons10.png'),"title":"游乐场"}
            ],
            swiperOption:{
                pagination:{
                    el: '.swiper-pagination'
                }
            }
        }
    },
    computed:{
        page(){
            let pages=[];
            this.iconsList.forEach((item, index)=>{
                let idx=Math.floor(index/8);
                if(!pages[idx])pages[idx]=[];
                pages[idx].push(item);
            })
            return pages;
        }
    }
}
</script>

<style scoped lang="stylus">
@import '~css/common.styl'
.icons{
    text-overflow();
    background:#fff;
    width:100%;
}
.icons-item{
    width:25%;
    padding-bottom:25%;
    height:0;
    float:left;
}
.icons-item img{
    width:1.1rem;
    height:1.1rem;
    display:block;
    margin:0 auto;
    padding-top: .2rem;
}
.icons-item p{
    textOverflow();
    color:#212121;
    font-size:.24rem;
    text-align:center;
    margin-top:.1rem;
}
.swiper-pagination{
    top: 2.85rem;
}
.swiper >>> .swiper-pagination-bullet{
    width:.13rem;
    height:.13rem;
}
.swiper >>> .swiper-pagination-bullet-active{
    background: #00bcd4;
}
</style>