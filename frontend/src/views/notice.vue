<template>
  <div>
    <navbar></navbar>
    <notice-image></notice-image>
    <noticelist></noticelist>
  </div>
</template>

<script>
import Navbar from '../components/Navbar.vue';
import NoticeImage from '../components/noticeImage.vue';
import Noticelist from '../components/noticelist.vue';

export default {
  components: { Navbar, Noticelist, NoticeImage },
};
</script>

<style></style>
