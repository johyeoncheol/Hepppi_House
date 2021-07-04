<template>
  <div class="map" style="float: left; width: 100%; height: 100%">
    <navbar></navbar>
    <mapList
      :apartList="apartList"
      :totalCount="totalCount"
      @infoApt="infoApt"
      @searchApt="searchApt"
    ></mapList>
    <mapView :apartList="apartList" :chartData="chartData" :Si="Si" :zoom="zoom" :path="path" ref="initMap"></mapView>
  </div>
</template>

<script>
import Navbar from '../components/Navbar.vue';
import mapList from '../components/mapList.vue';
import mapView from '../components/map.vue';

import axios from 'axios';

export default {
  name: 'join',
  data() {
    return {
      dongCode: '',
      apartList: [],
      totalCount: '',
      chartData: [['Year', 'amount']],
      Si: '',
      zoom: 7,
      path: [],
    };
  },
  components: {
    Navbar,
    mapView,
    mapList,
  },
  created() {
    var favoriteAptid = this.$route.params.id;
    axios.get('http://localhost/favorite/' +favoriteAptid).then((response) => {
      this.apartList = response.data;
      this.apartList.forEach(e=>this.path.push({lat: e.lat, lng: e.lng}));
      this.totalCount = this.apartList.length;
    });
    //도 평균정보
    axios.get('http://localhost/api/average/' + this.dongCode).then((response) => {
      this.Si = response.data['Si'];
      delete response.data['Si'];
      for (var temp in response.data) {
        this.chartData.push([temp, parseFloat(response.data[temp])]);
      }
    });
  },
  methods: {
    infoApt(apart) {
      this.$refs.initMap.toggleInfoWindow(
        { position: { lat: apart.lat, lng: apart.lng }, infoText: apart },
        apart.idx
      );
    },
    searchApt(text) {
      axios.get('http://localhost/aptList/' + this.dongCode + '/' + text).then((response) => {
        this.apartList = response.data;
        this.totalCount = this.apartList[0]['totalCount'];
      });
    },
  },
};
</script>

<style scoped></style>
