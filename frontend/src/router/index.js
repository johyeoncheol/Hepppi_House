import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

import index from '../views/index.vue';
import login from '../views/login.vue';
import register from '../views/register.vue';
import board from '../views/board.vue';
import boardRegister from '../views/boardRegister.vue';
import boardDetail from '../views/boardDetail';
import map from '../views/map.vue';
import notice from '../views/notice.vue';
import applyhome from '../views/applyhome.vue';
import favoriteApt from '../views/favoriteApt.vue';
import loan from '../views/loan.vue';

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    //로그인 관련 부분
    { path: '/', component: index },
    { path: '/login', component: login },
    { path: '/register', component: register },
    //공지사항 관련 부분
    { path: '/notice', component: notice },
    //게시판 관련 부분
    { path: '/board', component: board },
    { path: '/boardRegister', component: boardRegister },
    { path: '/detail/:no', component: boardDetail },
    //지도 관련 부분
    { path: '/map', component: map },
    { path: '/map?dongCode=:no', component: map },
    //청약 관련 부분
    { path: '/applyhome', component: applyhome },
    //즐겨찾기 관련 부분
    { path: '/favoriteApt/:id', component: favoriteApt },
    //대출 정보 관련 부분
    { path: '/loan', component:loan},
  ],
});

export default router;
