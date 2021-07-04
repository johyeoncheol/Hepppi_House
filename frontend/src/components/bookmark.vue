<template>
  <div class="container overflow-auto p-3">
    <b-card v-if="!member" style="min-height: 900px; min-width: 270px">
      <template #header>
        <h4 class="mb-0">매물 즐겨찾기</h4>
      </template>
      <b-card-body align="center">
        <b-card-text><h5>로그인 후에 이용하실 수 있습니다.</h5></b-card-text>
      </b-card-body>
    </b-card>

    <b-card v-if="member" style="min-height: 900px; min-width: 270px">
      <template #header>
        <h5 class="mb-0">매물 즐겨찾기</h5>
          <b-card-footer align="center">
            <b-button variant="warning" @click="searchCity()" class="searchButton">
              아파트 조회
            </b-button>
          </b-card-footer>
      </template>
      <b-card-body :key="bookmark.no" v-for="bookmark in bookmarklist">
        <b-card-title
          ><h5>아파트 이름: {{ bookmark.aptName }}</h5></b-card-title
        >
        <b-list-group flush>
          <b-list-group-item>동이름: {{ bookmark.dong }}</b-list-group-item>
          <b-list-group-item>건축년도: {{ bookmark.buildYear }} 년도</b-list-group-item>
          <b-list-group-item>시세: {{ bookmark.dealAmount }} 만원</b-list-group-item>
        </b-list-group>
      </b-card-body>
    </b-card>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
export default {
  created() {
    if (this.$store.state.member) {
      this.$store.dispatch('ALLBOOKMARK', this.$store.state.member.id);
    }
  },
  computed: {
    ...mapGetters(['member']),
    ...mapGetters(['bookmarklist']),
  },
  methods: {
    logout() {
      this.$store.state.member = null;
    },
    searchCity() {
      this.$router.push('/favoriteApt/'+this.$store.state.member.id);
    },
  },
};
</script>

<style>
.searchButton {
  min-width: 180px;
  height: 50px;
  border-radius: 8px;
  margin-top: 10px;
  margin-bottom: 10px;
  font-size: 18px;
}
</style>
