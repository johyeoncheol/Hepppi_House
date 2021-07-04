<template>
  <div class="overflow-auto container col-md-7 mt-5">
    <b-table
      id="my-table"
      :items="applyhomelist"
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
          key: 'date',
          label: '청약 날짜',
          formatter: (value) => {
            return (
              value[0] +
              value[1] +
              value[2] +
              value[3] +
              '년 ' +
              value[4] +
              value[5] +
              '월 ' +
              value[6] +
              value[7] +
              '일 '
            );
          },
        },

        {
          key: 'title',
          label: '아파트 이름',
          formatter: (value) => {
            return value;
          },
        },
        {
          key: 'type',
          label: '타입',
          formatter: (value) => {
            return value;
          },
        },
      ],
      perPage: 15,
      currentPage: 1,
    };
  },
  created() {
    this.$store.dispatch('ALLAPPLYHOME');
  },
  computed: {
    ...mapGetters(['applyhomelist']),
    rows() {
      return this.$store.state.applyhomelist.length;
    },
  },
};
</script>

<style></style>
