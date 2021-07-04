<template lang="">
  <div style="float: left; width: 19%; height: 88vh">
    <section class="bg-light row justify-content-center" id="portfolio">
      <div class="card">
        <div class="card-body">
          <h3 class="card-title">
            거래 정보 : {{ totalCount }}건
            <b-icon
              style="cursor: pointer; float: right; margin-right: 20px"
              @click="searchForm"
              icon="search"
              aria-label="검색"
            ></b-icon>
            <b-form-input
              id="search"
              v-model="searchText"
              type="text"
              placeholder="검색어 입력"
              v-show="searchOn"
              style="margin-top: 10px"
              @keyup.enter="changeList"
            ></b-form-input>
          </h3>
          <div class="scrollable">
            <aside v-for="(apart, index) in apartList" :key="index" @click="infoApt(apart, index)">
              <hr />
              <h4>{{ apart.aptName }}</h4>
              <h5>거래금액 : {{ apart.dealAmount }}만원</h5>
              <h5>면적: {{ apart.area }}m<sup>2</sup></h5>
              <p class="small">
                <i class="fa fa-calendar pr-10"></i>거래등록일 : {{ apart.dealYear }}-{{
                  apart.dealMonth
                }}-{{ apart.dealDay }}
                <b-button
                  v-if="apart.favorite == 0"
                  @click="favoriteInsert(apart)"
                  style="
                    position: relative;
                    right: -10px;
                    top: 0px;
                    color: white;
                    text-decoration: none;
                    background-color: #6c5ce7;
                    border-color: #6c5ce7;
                  "
                >
                  <b-icon icon="bag-check" aria-label="즐겨찾기 추가"></b-icon>
                </b-button>
                <b-button
                  v-if="apart.favorite == 1"
                  @click="favoriteDelete(apart)"
                  style="
                    position: relative;
                    right: -10px;
                    top: 0px;
                    color: white;
                    text-decoration: none;
                    background-color: #6c5ce7;
                    border-color: #6c5ce7;
                  "
                >
                  <b-icon icon="bag-check-fill" aria-label="즐겨찾기 삭제"></b-icon>
                </b-button>
              </p>
            </aside>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>
<script>
import axios from 'axios';

export default {
  data() {
    return {
      click: 'false',
      searchOn: false,
      searchText: '',
    };
  },
  props: {
    apartList: Array,
    totalCount: String,
  },
  methods: {
    searchForm: function () {
      if (this.searchOn) this.searchOn = false;
      else this.searchOn = true;
    },
    infoApt: function (apart, index) {
      apart.idx = index;
      this.$emit('infoApt', apart);
    },
    favoriteInsert(apart) {
			if(this.$store.state.member == null){
				alert("로그인 후 이용해 주세요.");
				return;
			}
      apart.favorite = 1;
      apart.id = this.$store.state.member.id;
      console.log(apart);
      axios.post('http://localhost/favorite/', apart).then(() => {
        alert('즐겨찾기 등록이 완료되었습니다.');
      });
    },
    favoriteDelete(apart) {
      apart.favorite = 0;
      apart.id = 'test';
      console.log(apart);
      axios
        .delete(`http://localhost/favorite/${apart.id}/${apart.aptName}/${apart.area}`)
        .then(() => {
          alert('즐겨찾기 삭제가 완료되었습니다.');
        });
    },
    changeList() {
      this.$emit('searchApt', this.searchText);
    },
  },
};
</script>
<style>
.card {
  height: 88vh;
}
.scrollable {
  overflow-y: auto;
  height: 75vh;
}
aside:hover {
  background-color: #dfe6e9;
}
</style>
