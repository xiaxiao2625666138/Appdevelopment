<template>
    <div class="home">
        <home-header></home-header>
        <home-swiper></home-swiper>
        <home-icons></home-icons>
        <home-location></home-location>
        <home-hot></home-hot>
        <home-like></home-like>
        <home-weekend></home-weekend>
    </div>
</template>

<script>
import HomeHeader from './pages/Header'
import HomeSwiper from './pages/Swiper'
import HomeIcons from './pages/Icons'
import HomeLocation from './pages/Location'
import HomeHot from './pages/Hot'
import HomeLike from './pages/Like'
import HomeWeekend from './pages/Weekend'
export default{
    components:{
        HomeHeader,
        HomeSwiper,
        HomeIcons,
        HomeLocation,
        HomeHot,
        HomeLike,
        HomeWeekend,
    }
}
</script>

<style scoped>
.home{
    background:#f5f5f5;
}
</style>