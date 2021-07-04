<template>
  <div class="index">
    <Navbar></Navbar>
    <main-image></main-image>
    <b-row>
      <b-col class="col-lg-9"><search></search></b-col>
      <b-col class="col-lg-3"><mainlogin></mainlogin></b-col>
    </b-row>
    <b-row>
      <b-col class="col-lg-9"><news></news></b-col>
      <b-col class="col-lg-3"><bookmark></bookmark></b-col>
    </b-row>
  </div>
</template>

<script>
import Bookmark from '../components/bookmark.vue';
import MainImage from '../components/mainImage.vue';
import Mainlogin from '../components/mainlogin.vue';
import Navbar from '../components/Navbar.vue';
import News from '../components/news.vue';
import Search from '../components/search.vue';
export default {
  name: 'index',
  components: {
    Navbar,
    MainImage,
    Search,
    Mainlogin,
    Bookmark,
    News,
  },
};
</script>
