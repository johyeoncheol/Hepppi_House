<template>
  <div class="container col-md-7">
    <b-form class="p-5" align="center">
      <b-form-group class="m-3" label="아이디">
        <b-form-input
          v-model="id"
          type="text"
          placeholder="아이디를 입력해 주세요"
          required
          class="p-2"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" class="m-3" label="비밀번호">
        <b-form-input
          type="password"
          v-model="pass"
          placeholder="비밀번호를 입력해 주세요"
          class="p-2"
          @keyup.enter="login"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group class="mb-3">
        <b-form-checkbox v-model="checked" value="true">아이디 저장</b-form-checkbox>
      </b-form-group>

      <b-row style="display: inline">
        <span>
          <b-button class="button" @click="login" variant="success">로그인</b-button>
        </span>
        <span>
          <router-link to="/register">
            <b-button class="button" variant="warning">회원가입</b-button>
          </router-link>
        </span>
      </b-row>
    </b-form>
  </div>
</template>

<script>
export default {
  computed: {
    logincheck() {
      return this.$store.state.member;
    },
  },
  data() {
    return {
      id: null,
      pass: null,
      checked: 'false',
    };
  },

  methods: {
    login() {
      if (this.id != null && this.pass != null) {
        const newMember = {
          id: this.id,
          pass: this.pass,
        };
        this.$store.dispatch('LOGINMEMBER', newMember).then(() => {
          if (this.$store.state.member) {
            this.$router.push('/');
          }
        });
      } else {
        alert('아이디와 비밀번호를 입력해 주세요');
      }
    },
  },
};
</script>
<style scoped>
div {
  margin: auto;
}
.button {
  width: 120px;
  height: 40px;
  margin-top: 10px;
}
</style>
