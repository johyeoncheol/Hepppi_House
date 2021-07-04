<template>
  <div class="login">
    <navbar></navbar>
    <login-form></login-form>
  </div>
</template>

<script>
import LoginForm from '../components/loginForm.vue';
import Navbar from '../components/Navbar.vue';

export default {
  name: 'login',
  components: {
    Navbar,
    LoginForm,
  },
};
</script>
