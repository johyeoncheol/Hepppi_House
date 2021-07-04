<template>
  <div class="overflow-auto container col-md-7 mt-5">
    <b-table
      id="my-table"
      :items="boardlist"
      :fields="fields"
      :per-page="perPage"
      :current-page="currentPage"
      striped
      hover
    >
      <template #cell(title)="data">
        <!-- `data.value` is the value after formatted by the Formatter -->
        <span class="titleName" @click="showDetailBoard(data.item.no)">
          {{ data.value }}
        </span>
      </template>
    </b-table>
    <b-row>
      <b-col>
        <b-pagination
          v-model="currentPage"
          :total-rows="rows"
          :per-page="perPage"
          aria-controls="my-table"
        ></b-pagination
      ></b-col>
      <b-col class="col-lg-3">
        <b-button class="col-md-6" @click="Boardwrite" variant="warning">글 쓰기</b-button>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
export default {
  data() {
    return {
      fields: [
        {
          key: 'title',
          label: '글 제목',
          formatter: (value) => {
            return value;
          },
        },

        {
          key: 'writer',
          label: '작성자',
          formatter: (value) => {
            return value;
          },
        },
        {
          key: 'wdate',
          label: '작성 날짜',
          formatter: (value) => {
            return value.split(' ')[0];
          },
        },
      ],
      perPage: 15,
      currentPage: 1,
      boardNum: 0,
    };
  },
  computed: {
    ...mapGetters(['boardlist']),
    ...mapGetters(['member']),
    rows() {
      return this.$store.state.boardlist.length;
    },
  },
  created() {
    this.$store.dispatch('ALLBOARD');
  },

  methods: {
    showDetailBoard(no) {
      this.$router.push('/detail/' + no);
    },
    Boardwrite() {
      if (!this.$store.state.member) {
        alert('로그인 후에 글쓰기를 이용하실 수 있습니다.');
        this.$router.push('/login');
        return;
      }
      this.$router.push('/boardRegister');
    },
  },
};
</script>
<style scoped>
a {
  text-decoration-line: none;
}
</style>
