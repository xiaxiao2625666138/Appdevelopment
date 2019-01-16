<template>
    <div class="swiper">
    <swiper :options="swiperOption">
    <swiper-slide v-for="item in swiperList" :key=item.id>
        <img :src=item.imgUrl>
    </swiper-slide>
    <div class="swiper-pagination"  slot="pagination"></div>
    </swiper>
    </div>
</template>

<script>
export default{
    data(){
        return{
            "swiperList":[
                {
                    "id":"01", "imgUrl":require('@/assets/img/swiper1.jpg')
                },
                {
                    "id":"02", "imgUrl":require('@/assets/img/swiper2.jpg')
                },
                {
                    "id":"03", "imgUrl":require('@/assets/img/swiper3.jpg')
                },
                {
                    "id":"04", "imgUrl":require('@/assets/img/swiper4.jpg')
                },
                {
                    "id":"05", "imgUrl":require('@/assets/img/swiper5.jpg')
                },
                {
                    "id":"06", "imgUrl":require('@/assets/img/swiper6.jpg')
                },
                {
                    "id":"07", "imgUrl":require('@/assets/img/swiper7.jpg')
                },
            ],
            swiperOption:{
                pagination:{
                    el: '.swiper-pagination'
                },
                loop:true
            }
        }
    }
}
</script>

<style scoped>
.swiper{
    background:#ccc;
    height:0;
    padding-bottom:26.67%;
}
.swiper img{
    width:100%;
    height:100%;
}
.swiper >>> .swiper-pagination-bullet-active{
    background:#fff;
}
</style>