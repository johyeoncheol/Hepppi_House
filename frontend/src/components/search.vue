<template>
  <div
    class="overflow-auto container mt-3"
    style="
      background-color: #cad2d5;
      min-height: 270px;
      padding-top: 90px;
      padding-bottom: 80px;
      opacity: 0.9;
      border-radius: 8px;
    "
  >
    <b-row>
      <b-col>
        <b-form-select
          class="cityform"
          v-model="city"
          :options="cityoptions"
          @change="GugunFocus"
        ></b-form-select>
      </b-col>
      <b-col
        ><b-form-select
          class="guform"
          v-model="gugun"
          :options="gugunoptions"
          @change="DongFocus"
        ></b-form-select>
      </b-col>
      <b-col
        ><b-form-select class="dongform" v-model="dong" :options="dongoptions"></b-form-select
      ></b-col>
      <b-col
        ><b-button type="submit" variant="warning" @click="searchCity" class="searchButton">
          아파트 검색
        </b-button>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
export default {
  created() {
    this.$store.dispatch('GETCITY');
  },
  data() {
    return {
      city: null,
      gugun: null,
      dong: null,
    };
  },
  computed: {
    ...mapGetters(['cityoptions']),
    gugunoptions() {
      return this.$store.state.gugunoptions;
    },
    dongoptions() {
      return this.$store.state.dongoptions;
    },
  },
  methods: {
    GugunFocus() {
      this.$store.dispatch('GETGUNGU', { city: this.city });
    },
    DongFocus() {
      this.$store.dispatch('GETDONG', { city: this.city, gugun: this.gugun });
    },
    searchCity() {
      for (var i = 1; i < this.$store.state.dongoptions.length; i++) {
        if (this.$store.state.dongoptions[i].text == this.dong) {
          console.log(this.$store.state.dongoptions[i].dongcode);
          this.$router.push('/map?dongCode=' + this.$store.state.dongoptions[i].dongcode);
        }
      }
    },
  },
};
</script>

<style scoped>
.cityform {
  min-width: 300px;
  height: 50px;
  padding: 10px;
  border-radius: 8px;
  margin: 10px;
}
.guform {
  min-width: 300px;
  height: 50px;
  padding: 10px;
  border-radius: 8px;
  margin: 10px;
}
.dongform {
  min-width: 300px;
  height: 50px;
  padding: 10px;
  border-radius: 8px;
  margin: 10px;
}
.searchButton {
  min-width: 180px;
  height: 50px;
  border-radius: 8px;
  margin: 10px;
  font-size: 18px;
}
</style>
