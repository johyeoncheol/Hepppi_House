import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';

import { BootstrapVue, IconsPlugin } from 'bootstrap-vue';
import * as VueGoogleMaps from 'vue2-google-maps';
import VueGoogleCharts from 'vue-google-charts';
// Install BootstrapVue
Vue.use(BootstrapVue);
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin);
// Google Map
Vue.use(VueGoogleMaps, {
  load: {
    key: 'AIzaSyC2-NFQnUCuze0_F_ANz5EsC1JwB3OQg60',
    libraries: 'places',
  },
});
Vue.use(VueGoogleCharts);
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount('#app');
