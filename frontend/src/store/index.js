import Vue from 'vue';
import Vuex from 'vuex';
//import createPersistedState from 'vuex-persistedstate';

import axios from '../axios/axios-common';

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {},
  state: {
    //회원 관련
    member: null,
    //게시판 관련
    boardlist: [],
    board: null,
    //주소관련
    cityoptions: [{ value: null, text: '도시를 선택해주세요', disabled: true }],
    gugunoptions: [{ value: null, text: '구 또는 군을 선택해주세요', disabled: true }],
    dongoptions: [{ value: null, text: '동을 선택해주세요', disabled: true }],
    //즐겨찾기 관련
    bookmarklist: [],
    newslist: [],
    //청약 관련
    applyhomelist: [],
  },
  getters: {
    //회원 관련
    member(state) {
      return state.member;
    },

    //게시판 관련
    boardlist(state) {
      //todolist return
      return state.boardlist;
    },
    board(state) {
      return state.board;
    },

    //주소 관련
    cityoptions(state) {
      return state.cityoptions;
    },
    gugunoptions(state) {
      return state.gugunoptions;
    },
    dongoptions(state) {
      return state.dongoptions;
    },

    //즐겨찾기 관련
    bookmarklist(state) {
      return state.bookmarklist;
    },

    //뉴스 관련
    newslist(state) {
      return state.newslist;
    },

    //청약 관련
    applyhomelist(state) {
      return state.applyhomelist;
    },
  },
  actions: {
    //회원 관련
    LOGINMEMBER: (store, payload) => {
      return axios
        .post('/member/login', payload)
        .then((response) => {
          if (response.data == '') {
            alert('아이디 비밀번호가 틀렸습니다.');
            return;
          }
          store.commit('MEMBER', { member: response.data });
        })
        .catch(() => alert('서버에 문제가 있습니다.'));
    },
    ADDMEMBER: (store, payload) => {
      axios
        .post('/member/signup', payload)
        .then(() => {
          console.log('회원가입이 되었습니다.');
          store.dispatch('MEMBER');
        })
        .catch((exp) => alert('회원가입에 실패했습니다.' + exp));
    },
    UPDATEMEMBER: (store, payload) => {
      console.log(payload);
      axios
        .update('/api/qna', payload)
        .then(() => {
          console.log('회원 수정이 되었습니다.');
          store.dispatch('MEMBER');
        })
        .catch((exp) => alert('추가 처리에 실패하였습니다.' + exp));
    },
    PASSSEARCH: (store, payload) => {
      console.log(payload);
      axios
        .get('/api/qna', payload)
        .then(() => {
          console.log('비밀번호를 찾았습니다.');
          store.dispatch('MEMBER');
        })
        .catch((exp) => alert('정보가 일치하지 않습니다.' + exp));
    },

    //게시판 관련
    ALLBOARD: (store) => {
      axios
        .get('/api/qna')
        .then((response) => {
          store.commit('ALLBOARD', { boardlist: response.data });
        })
        .catch((response) => {
          console.log(response);
        });
    },
    SHOWBOARD: (store, payload) => {
      console.log(payload);
      axios
        .get('/api/qna/' + payload.num)
        .then((response) => {
          store.commit('SHOWBOARD', { board: response.data }); //call mutation
          console.log('조회 처리하였습니다.');
        })
        .catch((exp) => alert('조회 처리에 실패하였습니다.' + exp));
    },
    ADDBOARD: (store, payload) => {
      console.log(payload);
      axios
        .post('/api/qna', payload)
        .then(() => {
          console.log('추가 처리했습니다');
          store.dispatch('ALLBOARD');
        })
        .catch((exp) => alert('추가 처리에 실패하였습니다.' + exp));
    },

    //adress 관련
    GETCITY: (store, payload) => {
      axios
        .get('/location/cityList', payload)
        .then((response) => {
          store.commit('CITYINFO', { location: response.data }); //call mutation
        })
        .catch((exp) => alert('조회 처리에 실패하였습니다.' + exp));
    },
    GETGUNGU: (store, payload) => {
      axios
        .get('/location/cityList/' + payload.city)
        .then((response) => {
          store.commit('GUGUNINFO', { location: response.data });
        })
        .catch((exp) => alert('추가 처리에 실패하였습니다.' + exp));
    },
    GETDONG: (store, payload) => {
      axios
        .get('/location/cityList/' + payload.city + '/' + payload.gugun)
        .then((response) => {
          store.commit('DONGINFO', { location: response.data });
        })
        .catch((exp) => alert('추가 처리에 실패하였습니다.' + exp));
    },

    //즐겨찾기 관련
    ALLBOOKMARK: (store, payload) => {
      axios
        .get('/favorite/' + payload)
        .then((response) => {
          console.log(response);
          store.commit('ALLBOOKMARK', { bookmarklist: response.data });
        })
        .catch((response) => {
          console.log(response);
        });
    },

    //뉴스 관련
    ALLNEWS: (store) => {
      axios
        .get('/api/news')
        .then((response) => {
          store.commit('ALLNEWS', { newslist: response.data });
        })
        .catch((response) => {
          console.log(response);
        });
    },

    //청약 관련
    ALLAPPLYHOME: (store) => {
      axios
        .get('/api/applyhome')
        .then((response) => {
          console.log(response);
          store.commit('ALLAPPLYHOME', { applyhomelist: response.data });
        })
        .catch((response) => {
          console.log(response);
        });
    },
  },
  mutations: {
    //회원 관련
    MEMBER: (state, payload) => {
      state.member = payload.member;
    },

    //게시판 관련
    ALLBOARD: (state, payload) => {
      state.boardlist = payload.boardlist;
    },
    SHOWBOARD: (state, payload) => {
      state.board = payload.board;
    },

    //주소 관련
    CITYINFO: (state, payload) => {
      for (var i = 0; i < payload.location.length; i++) {
        state.cityoptions.push({ value: payload.location[i].city, text: payload.location[i].city });
      }
    },
    GUGUNINFO: (state, payload) => {
      state.gugunoptions.splice(1, state.gugunoptions.length - 1);
      for (var i = 0; i < payload.location.length; i++) {
        state.gugunoptions.push({
          value: payload.location[i].gugun,
          text: payload.location[i].gugun,
        });
      }
    },
    DONGINFO: (state, payload) => {
      state.dongoptions.splice(1, state.dongoptions.length - 1);
      for (var i = 0; i < payload.location.length; i++) {
        state.dongoptions.push({
          value: payload.location[i].dong,
          text: payload.location[i].dong,
          dongcode: payload.location[i].dongcode,
        });
      }
    },

    //즐겨찾기 관련
    ALLBOOKMARK: (state, payload) => {
      state.bookmarklist = payload.bookmarklist;
      console.log(payload);
    },
    //뉴스 관련
    ALLNEWS: (state, payload) => {
      state.newslist = payload.newslist;
      console.log(state);
    },
    ALLAPPLYHOME: (state, payload) => {
      state.applyhomelist = payload.applyhomelist.reverse();
    },
  },

  // plugins: [createPersistedState()],
});
