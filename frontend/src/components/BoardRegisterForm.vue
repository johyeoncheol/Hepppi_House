<template>
  <div class="overflow-auto container col-md-8 mt-5">
    <b-container class="m-2" fluid>
      <b-row>
        <b-col sm="2">
          <label class="contnetTitle" for="textarea-small">제목:</label>
        </b-col>
        <b-col sm="10">
          <b-form-textarea
            v-model="title"
            size="lg"
            rows="1"
            placeholder="제목을 입력해 주세요"
            no-resize
          ></b-form-textarea>
        </b-col>
      </b-row>

      <b-row class="mt-2">
        <b-col sm="2">
          <label class="contnetTitle" for="textarea-large">내용:</label>
        </b-col>
        <b-col sm="10">
          <b-form-textarea
            v-model="content"
            rows="15"
            size="md"
            placeholder="내용을 입력해 주세요"
            no-resize
          ></b-form-textarea>
        </b-col>
      </b-row>
    </b-container>

    <div class="mt-4" align="center">
      <b-button @click="addTodo" class="col-md-2 m-2" variant="success">글 등록</b-button>
      <router-link to="/board">
        <b-button class="col-md-2 m-2" variant="warning">글 목록</b-button>
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      title: null,
      content: null,
    };
  },
  methods: {
    addTodo() {
      if (this.title != null && this.content != null) {
        const newBoard = {
          title: this.title,
          content: this.content,
          writer: this.$store.state.member.id,
        };
        this.$store.dispatch('ADDBOARD', newBoard);
        this.$router.push('/board');
      } else {
        alert('내용을 입력해 주세요');
      }
    },
  },
};
</script>

<style>
.contnetTitle {
  font-size: 25px;
}
</style>
