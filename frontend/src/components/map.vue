<template>
    <div style="float:left" id="map">
        <GmapMap
         ref="mapRef"
         :center="center"
         :zoom="zoom"
         style="width:80vw;height:88vh"
        >
            <gmap-info-window
             :options="infoOptions"
             :position="infoWindowPos"
             :opened="infoWinOpen"
             @closeclick="infoWinOpen=false"
            >
            </gmap-info-window>
            <GmapMarker
            :key="i"
            v-for="(m,i) in markers"
            :position="m.position"
            :clickable="true"
            @click="toggleInfoWindow(m,i)">
            >
            </GmapMarker>
                <gmap-polyline v-if="path.length > 0" :path="path" ref="polyline">
            </gmap-polyline>
        </GmapMap>
        <div id="aptInfo" v-if="infoWinOpen">
            <div class="header-info">
                <h1>{{infoApt.aptName}}</h1>
                <h2>{{infoApt.dong}}</h2>
                <b-button @click="infoWinOpen=false" style="position:absolute;right:-44px;top:0px;color:white;text-decoration:none;background-color:#6c5ce7;border-color:#6c5ce7">
                    <b-icon icon="backspace" aria-label="닫기"></b-icon>
                </b-button>
            </div>
            <div>
                <b-table stacked :items="items"></b-table>
            </div>
            <p style="text-align:center">{{Si}} 평균 시세</p>
             <GChart
                type="AreaChart"
                :settings="{packages:['corechart']}"
                :data="chartData"
                :options="chartOptions"
              />
        </div>
    </div>
</template>
<script>
import {gmapApi as google} from "vue2-google-maps";

export default {
    
    name: 'Map',
    data (){
        return {
            dongCode : '',
            infoWindowPos: null,
            infoWinOpen:false,
            currentMidx:null,

            infoOptions:{
                content: '',
                pixelOffset:{
                    width:0,
                    height: -30
                }
            },
           
            infoApt: {
                aptName: '',
                area : '',
                buildYear: '',
                dealAmount: '',
                dealDay: '',
                dealMonth: '',
                dealYear: '',
                dong : '',
                floor: '',
                idx:'',
                lat: '',
                lng : '',
                no : '',
                totalCount: '',
                type: '',
            },
            items: [],
            chartOptions: {
                chart: {
                title: '시 정보',
                subtitle: '2020-2021년 추세',
                }
            }
        }
    },
    props:{
        apartList:Array,
        chartData:Array,
        Si:String,
        zoom: Number,
        path : Array,
    },
    methods:{
        toggleInfoWindow: function(marker, idx) {

            this.infoWindowPos = marker.position;
            this.infoOptions.content = marker.infoText.aptName;
            this.$refs.mapRef.panTo(marker.position);
            this.zoom = 15;
            this.infoApt = marker.infoText;
            this.items = [];
            this.items.push({
                "전용면적" : this.infoApt.area,
                "층 수" : this.infoApt.floor,
                "거래 형태" : this.infoApt.type,
                "거래등록일" : `${this.infoApt.dealYear}-${this.infoApt.dealMonth}-${this.infoApt.dealDay}`,
                "건축일" : this.infoApt.buildYear,
                "거래가" : `${this.infoApt.dealAmount}만원`
            });

            this.infoWinOpen = true;
            this.currentMidx = idx;
        },
        
    },
    computed:{
        google,
        markers : function(){
            var markers = [];
            this.apartList.forEach(e => markers.push({position:{lat : e.lat, lng: e.lng}, infoText: e}));
            return markers;
        },
        center : function(){
            var maxlat = 30;
            var maxlng = 124;
            var minlat = 39;
            var minlng = 133;
            this.apartList.forEach(e=>{
                if(e.lat> 30 || e.lat <39 || e.lng > 124 || e.lng < 133) {;
                    maxlat = Math.max(maxlat, e.lat);
                    maxlng = Math.max(maxlng, e.lng);
                    minlat = Math.min(minlat, e.lat);
                    minlng = Math.min(minlng, e.lng);
                }
            });
            console.log((maxlat+minlat)/2);
            console.log((maxlng+minlng)/2);
            return {lat: (maxlat+minlat)/2,lng: (maxlng+minlng)/2}
        },
    },
    created:function(){
    }
}
</script>
<style>
#aptInfo{
    position:absolute;
    top:18vh;
    left:19.5vw;
    background-color:white;
    width:30vh;
    height:70vh;
    line-height:1.58;
    margin: 6px 0 0 1px;
    border: 1px solid #dfe1e5;
    border-radius: 8px;
    box-shadow : 0 3px 6px rgb(0 0 0 / 16%), 0 3px 6px rgb(0 0 0 / 23%)
}
.header-info{
    position: relative;
    border-bottom: 1px solid #565eb6;
    padding: 0 21px 0 20px;
    text-align: center;
    background:#6c5ce7;
}
.header-info > h1{
    color:white;
    word-wrap: normal;
    font-size: 18px;
    line-height: 1.3;
    font-weight: 300;
}
.address{
    margin-top : 10px;
    display: block;
    font-size: 12px;
    font-weight: 200;
    color : #dedede;
}
</style>