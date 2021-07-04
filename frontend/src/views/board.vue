<template>
  <div>
    <navbar></navbar>
    <qna-image></qna-image>
    <board-list></board-list>
  </div>
</template>

<script>
import BoardList from '../components/boardList.vue';
import Navbar from '../components/Navbar.vue';
import QnaImage from '../components/qnaImage.vue';

export default {
  components: { Navbar, BoardList, QnaImage },
};
</script>

<style></style>
