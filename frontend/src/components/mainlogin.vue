<template>
  <div class="container overflow-auto p-3">
    <b-card v-if="!member" style="height: 270px">
      <template #header>
        <h4 class="mb-0">로그인이 필요합니다.</h4>
      </template>
      <b-card-body style="padding-top: 45px" align="center">
        <router-link to="/login">
          <b-button class="loginbutton">로그인 </b-button>
        </router-link>
      </b-card-body>
    </b-card>

    <b-card v-if="member" style="height: 270px; min-width: 270px">
      <template #header>
        <h5 class="mb-0">{{ member.name }}님 환영합니다</h5>
      </template>

      <b-card-body>
        <b-card-title>회원님의 등록 주소</b-card-title>
        <b-card-text>{{ member.address }}</b-card-text>
      </b-card-body>

      <b-card-body align="center">
        <b-button class="button" variant="success" @click="logout">로그아웃</b-button>
        <router-link to="/">
          <b-button class="button" variant="warning">회원수정</b-button>
        </router-link>
      </b-card-body>
    </b-card>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
export default {
  computed: {
    ...mapGetters(['member']),
  },
  methods: {
    logout() {
      this.$store.state.member = '';
    },
  },
};
</script>

<style scoped>
.button {
  width: 90px;
  height: 40px;
  margin-left: 10px;
  margin-bottom: 5px;
}
.loginbutton {
  width: 250px;
  height: 90px;
  margin-left: 10px;
  font-size: 20px;
  opacity: 0.4;
}
</style>
