<template>
  <div class="container col-md-8 mt-5">
    <b-card no-body style="max-width: 80rem; height: 700px" img-top>
      <template #header>
        <h4 class="m-2">질문 게시판</h4>
      </template>

      <b-card-body style="height: 400px">
        <b-card-title class="m-1">글 제목 : {{ board.title }}</b-card-title>
        <b-card-text class="m-3"> 작성 내용: {{ board.content }} </b-card-text>
      </b-card-body>

      <b-list-group flush>
        <b-list-group-item class="m-1">작성자 : {{ board.writer }}</b-list-group-item>
        <b-list-group-item class="m-1">작성시간 : {{ board.wdate }}</b-list-group-item>
      </b-list-group>

      <b-card-body align="center">
        <router-link to="/boardRegister">
          <b-button class="col-md-2 m-2" variant="success">새 글쓰기</b-button>
        </router-link>
        <router-link to="/board">
          <b-button class="col-md-2 m-2" variant="warning">글 목록</b-button>
        </router-link>
      </b-card-body>
    </b-card>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
export default {
  created() {
    //action call
    var boardno = this.$route.params.no; //이전화면에서 파라메터 받아옴
    this.$store.dispatch('SHOWBOARD', { num: boardno });
  },
  computed: {
    ...mapGetters(['board']),
  },
};
</script>

<style scoped>
input:focus {
  outline: none;
}
.inputBox {
  background: white;
  height: 50px;
  line-height: 50px;
  border-radius: 5px;
}
.inputBox input {
  border-style: none;
  font-size: 0.9rem;
}
.addContainer {
  background: linear-gradient(to right, #6478fb, #8763fb);
  display: inline-block;
  width: 3rem;
  border-radius: 0 5px 5px 0;
}

.modifyBtn {
  color: white;
  vertical-align: middle;
}

table {
  margin: 10px auto;
  border-collapse: collapse;
  border: 2px solid #996;
  font: normal 90%/140% verdana, arial, helvetica, sans-serif;
  color: #333;
  background: #fffff0;
}

.caption {
  background-color: #222;
  vertical-align: middle;
  text-align: center;
  padding: 15px;
  font-size: 20px;
  color: #fff;
}

td,
th {
  border: 1px solid #cc9;
  padding: 0.3em;
}
thead th,
tfoot th {
  background-color: '#f5deb3';
  border: 1px solid #cc9;
  text-align: center;
  font-size: 1em;
  font-weight: bold;
  color: #444;
  background: #dbd9c0;
}
tbody td a {
  background: transparent;
  color: #72724c;
  text-decoration: none;
  border-bottom: 1px dotted #cc9;
}
tbody td a:hover {
  background: transparent;
  color: #666;
  border-bottom: 1px dotted #72724c;
}
tbody th a {
  background: transparent;
  color: #72724c;
  text-decoration: none;
  font-weight: bold;
  border-bottom: 1px dotted #cc9;
}
tbody th a:hover {
  background: transparent;
  color: #666;
  border-bottom: 1px dotted #72724c;
}
tbody th,
tbody td {
  vertical-align: top;
  text-align: center;
}
tfoot td {
  border: 1px solid #996;
}
.odd {
  color: #333;
  background: #f7f5dc;
}
tbody tr:hover {
  color: #333;
  background: #fff;
}
tbody tr:hover th,
tbody tr.odd:hover th {
  color: #333;
  background: #ddd59b;
}

tbody tr {
  height: 50px;
  line-height: 50px;
}
ul {
  padding: 22px 50px 50px 490px;
  width: 940px;
  list-style: none;
}
#gnb li {
  display: inline;
}
#gnb li a {
  display: inline-block;
  background: #222;
  color: #fff;
  width: 150px;
  height: 23px;
  padding-top: 3px;
  text-align: center;
}
#gnb li a:hover {
  background: #900;
}
</style>
