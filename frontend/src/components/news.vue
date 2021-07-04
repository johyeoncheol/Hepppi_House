<template>
  <div class="overflow-auto container mt-3">
    <b-row>
      <b-col md="6" :key="news.title" v-for="news in newslist">
        <b-card
          no-body
          class="overflow-hidden"
          style="max-width: 650px; max-height: 220px; margin-bottom: 30px; padding: 10px"
          @click="linknews(news.link)"
        >
          <template #header>
            <h4
              class="mb-0"
              style="
                overflow: hidden;
                white-space: nowrap;
                text-overflow: ellipsis;
                cursor: pointer;
              "
            >
              {{ news.title }}
            </h4>
          </template>
          <b-row no-gutters>
            <b-col md="5">
              <b-card-img
                :src="news.imageLink"
                style="cursor: pointer"
                alt="Image"
                class="newsImage"
              ></b-card-img>
            </b-col>
            <b-col md="7">
              <b-card-body>
                <b-card-text style="white-space: normal; text-overflow: ellipsis; cursor: pointer">
                  {{ news.body }}
                </b-card-text>
              </b-card-body>
            </b-col>
          </b-row>
        </b-card></b-col
      >
    </b-row>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
export default {
  created() {
    this.$store.dispatch('ALLNEWS');
  },
  computed: {
    ...mapGetters(['newslist']),
  },
  methods: {
    linknews(linknews) {
      window.open(
        linknews,
        '뉴스 링크',
        'width:800px,height:700px, toolbar=no, menubar=no, scrollbars=no, resizable=yes'
      );
    },
  },
};
</script>

<style>
.newsImage {
  padding: 10px;
}
</style>
