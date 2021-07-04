<template>
  <div>
    <navbar></navbar>
    <board-view></board-view>
  </div>
</template>

<script>
import BoardView from '../components/BoardView.vue';
import Navbar from '../components/Navbar.vue';
export default {
  components: { Navbar, BoardView },
};
</script>

<style></style>
