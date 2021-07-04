<template>
  <div>
    <b-navbar
      toggleable="lg"
      type="dark"
      variant="secondary"
      style="background-color: #ff6b6b !important"
    >
      <router-link to="/">
        <img alt="House Logo" src="../assets/navhouse.png" />
      </router-link>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav class="nav_title">
          <b-nav-item style="min-width: 266px" to="/">햅삐하우스</b-nav-item>
        </b-navbar-nav>
        <b-navbar-nav class="nav_menu">
          <b-nav-item style="min-width: 116px" href="/notice">공지사항</b-nav-item>
          <b-nav-item style="min-width: 125px" href="/applyhome">청약 정보</b-nav-item>
          <b-nav-item style="min-width: 125px" href="/loan">대출 정보</b-nav-item>
          <b-nav-item style="min-width: 150px" to="/board">질문 게시판</b-nav-item>
        </b-navbar-nav>

        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">
          <b-nav-item-dropdown class="nav_drop">
            <!-- Using 'button-content' slot -->
            <template #button-content>
              <em>User</em>
            </template>
            <b-dropdown-item v-if="!member" to="/login">로그인</b-dropdown-item>
            <b-dropdown-item v-if="!member" to="/register">회원가입</b-dropdown-item>
            <b-dropdown-item v-if="member" @click="logout">로그아웃</b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
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
      this.$store.state.member = null;
      console.log(this.$store.state.member);
    },
  },
};
</script>

<style scoped>
.header {
  background-color: #ddeef8;
}

.nav_title {
  font-size: 50px;
  margin-left: 10px;
}
.nav_menu {
  margin-left: 30px;
  font-size: 25px;
}
.nav_drop {
  font-size: 18px;
  margin-left: 20px;
}

.navlist {
  color: black;
  text-decoration: none;
  font-size: 25px;
  float: right;
  margin: 1.2em 2em 1em 0em;
}
img {
  width: 150px;
  height: 100%;
  margin: 0.2em 1em 0.2em 2em;
}
a {
  text-decoration-line: none;
  text-decoration-color: none;
  text-decoration-style: none;
}
</style>
