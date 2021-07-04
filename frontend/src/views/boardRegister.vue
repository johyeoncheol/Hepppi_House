<template>
  <div>
    <navbar></navbar>
    <board-register-form></board-register-form>
  </div>
</template>

<script>
import BoardRegisterForm from '../components/BoardRegisterForm.vue';
import Navbar from '../components/Navbar.vue';
export default {
  components: { Navbar, BoardRegisterForm },
};
</script>

<style></style>
