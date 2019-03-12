<template>
    <div class='weekend'>
       <div class="title">
           周末去哪儿
       </div>
       <ul>
           <li v-for="item in weekendList" 
           :key=item.id class="item">
               <div class="weekend-img">
                   <img :src="item.imgUrl">
               </div>
               <div class="message">
                   <p>{{item.title}}</p>
                   <p>{{item.comment}}</p>
               </div>
           </li>
       </ul>
    </div>
</template>

<script>
export default{
    data(){
        return {
            "weekendList":[
                {"id":"01", "imgUrl":require('@/assets/img/weekend1.jpg'),"title":"上海泡汤圣地", 
                "comment":"上海的朋友总会问，哪里可以泡温泉，那里的温泉好呢？这里有最好最全的上海温泉！"},
                {"id":"02", "imgUrl":require('@/assets/img/weekend2.jpg'),"title":"上海必打卡", 
                "comment":"中西合璧，现代和传统各有各的精彩"},
                {"id":"03", "imgUrl":require('@/assets/img/weekend3.jpg'),"title":"周末亲自爱玩", 
                "comment":"走进自然或玩转乐园，感知大千世界，游乐项目惊险刺激，特色表演精彩纷呈，等你们~"},
                {"id":"04", "imgUrl":require('@/assets/img/weekend4.jpg'),"title":"上海城市观光", 
                "comment":"来这里寻找你所不认识的魔都，感受云端漫步，品味老上海风情，享受休闲时光"},
                {"id":"05", "imgUrl":require('@/assets/img/weekend5.jpg'),"title":"情迷博物馆", 
                "comment":"走进艺术殿堂，电影博物馆生动演绎着电影人和电影背后的故事，你不想知道吗~"}
            ],
        }
    }
}
</script>

<style scoped lang="stylus">
@import '~css/common.styl'
.weekend{
    textOverflow();
}

.title{
    font-size:.32rem;
    padding: .24rem;
}

.item{
    background:#fff;
    margin-top:.1rem;
}

.weekend-img{
    width:100%;
    height:0;
    padding-bottom:37.4375%;
}

.weekend-img img{
    width:100%;
}

.message{
    padding: .2rem;
}

.message p{
    padding-bottom:.2rem;
    font-size:.28rem;
    color:#212121;
}

.message p+p{
    width:70%;
    textOverflow();
    font-size:.24rem;
    color:#616161;
}
</style>