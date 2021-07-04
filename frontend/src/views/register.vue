<template>
  <div class="join">
    <navbar></navbar>
    <registerForm></registerForm>
  </div>
</template>

<script>
import registerForm from '../components/registerForm.vue';
import Navbar from '../components/Navbar.vue';

export default {
  name: 'join',
  components: {
    Navbar,
    registerForm,
  },
};
</script>
