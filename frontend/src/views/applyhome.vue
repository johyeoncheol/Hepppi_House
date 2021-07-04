<template>
  <div>
    <navbar></navbar>
    <applyimage></applyimage>
    <apply-data></apply-data>
  </div>
</template>
<script>
import applyData from '../components/applyData.vue';
import Applyimage from '../components/applyimage.vue';
import Navbar from '../components/Navbar.vue';
export default {
  components: {
    Navbar,
    applyData,
    Applyimage,
  },
};
</script>
