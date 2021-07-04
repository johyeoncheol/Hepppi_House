<template>
  <div class="container col-md-7">
    <b-form @submit="onSubmit" class="p-5" align="center">
      <b-form-group class="m-3" label="아이디">
        <b-form-input
          v-model.lazy="form.id"
          type="text"
          placeholder="아이디를 입력해 주세요"
          required
          class="p-2"
          @change="duplicateCheck"
        ></b-form-input>
        <p style="float: left; color: red" v-if="duplicateyes">중복된 ID입니다.</p>
        <p style="float: left; color: green" v-if="duplicateno">사용가능한 ID입니다.</p>
      </b-form-group>

      <b-form-group class="m-3" label="비밀번호">
        <b-form-input
          type="password"
          v-model="form.pass"
          placeholder="비밀번호를 입력해 주세요"
          class="p-2"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group class="m-3" label="비밀번호 확인">
        <b-form-input
          type="password"
          v-model.lazy="pass2"
          placeholder="비밀번호를 입력해 주세요"
          class="p-2"
          required
        ></b-form-input>

        <p style="float: left; color: red" v-if="passwordEqual">비밀번호가 일치하지 않습니다.</p>
      </b-form-group>
      <b-form-group class="m-3" label="이름">
        <b-form-input
          type="text"
          v-model="form.name"
          placeholder="이름을 입력해 주세요"
          class="p-2"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group class="m-3" label="주소" inline>
        <span
          ><b-form-input
            type="text"
            v-model="form.zipNo"
            placeholder="우편번호"
            style="
              width: 40%;
              margin-bottom: 5px;
              margin-right: 5px;
              float: left;
              background-color: white;
            "
            required
            readonly
          ></b-form-input>
          <b-button v-b-modal.my-modal style="float: left">주소 검색</b-button>
          <b-modal id="my-modal">
            도로명 주소 검색
            <div class="search-wrap">
              <fieldset>
                <span class="wrap">
                  <input
                    type="text"
                    class="popSearchInput"
                    placeholder="검색어 -예시 : 도로명(반포대로 58), 건물명(독립기념관), 지번(삼성동 25)"
                    name="keyword"
                    id="keyword"
                    v-model="addressText"
                    tabindex="1"
                    @keyup.enter="searchAddress"
                  />
                  <input
                    type="button"
                    title="검색"
                    tabindex="2"
                    style="cursor: pointer"
                    @click="searchAddress"
                  />
                </span>
                <div class="juso_info" style="text-align: center">
                  <p class="search-sampletxt">
                    예시 : 도로명(반포대로 58), 건물명(독립기념관), 지번(삼성동 25)
                  </p>
                </div>
              </fieldset>
              <hr />
              <div v-if="errorMessage != ''" style="text-align: center">{{ errorMessage }}</div>
              <b-list-group>
                <b-list-group-item
                  href="#"
                  class="flex-column align-items-start"
                  v-for="(address, index) in addressList"
                  :key="index"
                  @click="findAddress(address)"
                >
                  <div class="d-flex w-100 justify-content-between">
                    <h5 class="small">{{ address.roadAddr }}</h5>
                    <small>{{ address.zipNo }}</small>
                  </div>
                </b-list-group-item>
              </b-list-group>
            </div>
          </b-modal>
        </span>
        <div id="map" style="width: 300px; height: 300px; margin-top: 10px; display: none"></div>
        <b-form-input
          type="text"
          v-model="form.address"
          placeholder="주소"
          class="mb-2 mr-sm-2 mb-sm-0"
          style="background-color: white"
          required
          readonly
        ></b-form-input>
      </b-form-group>
      <span>
        <b-button class="button" type="submit" variant="warning">회원가입</b-button>
      </span>
    </b-form>
  </div>
</template>
<script>
import axios from 'axios';

export default {
  data() {
    return {
      form: {
        id: '',
        pass: '',
        name: '',
        checked: 'false',
        zipNo: '',
        address: '',
        admCd: '',
        rnMgtSn: '',
        udrtYn: '',
        buldMnnm: '',
        buldSlno: '',
      },
      isModalViewed: false,
      addressText: '',
      errorMessage: '',
      addressList: [],
      pass2: '',
      duplicateyes: false,
      duplicateno: false,
    };
  },
  computed:{
    passwordEqual : function() {
      if(this.form.pass == '' || this.pass2 == '') return false;
      if(this.form.pass == this.pass2) return false;

      else return true;
    },
  },
  methods: {
    duplicateCheck() {
      axios.get('http://localhost/member/duplicate/' + this.form.id).then((response) => {
        if (response.data == '') {
          this.duplicateyes = false;
          this.duplicateno = true;
        } else {
          this.duplicateyes = true;
          this.duplicateno = false;
        }
      });
    },
    onSubmit(event) {
      event.preventDefault();
      if (this.duplicate) {
        alert('아이디를 확인해 주세요.');
        return;
      }
      if (this.form.pass != this.pass2) {
        alert('비밀번호가 일치하지 않습니다.');
        return;
      }
      if (this.form.name == '') {
        alert('이름을 입력해 주세요.');
        return;
      }
      if (this.form.address == '') {
        alert('주소를 입력해 주세요.');
        return;
      }
      axios.post('http://localhost/member/signup', this.form).then((response) => {
        alert(response.data);
        this.$router.push('/');
      });
    },
    findAddress(address) {
      this.$bvModal.hide('my-modal');
      //입력 값 초기화
      this.addressList = [];
      this.addressText = '';
      this.form.zipNo = address.zipNo;
      this.form.address = address.roadAddr;
      this.form.admCd = address.admCd;
      this.form.rnMgtSn = address.rnMgtSn;
      this.form.udrtYn = address.udrtYn;
      this.form.buldMnnm = address.buldMnnm;
      this.form.buldSlno = address.buldSlno;
    },
    searchAddress() {
      axios
        .get(
          'https://www.juso.go.kr/addrlink/addrLinkApi.do?confmKey=devU01TX0FVVEgyMDIxMDUyMTE1MzAzNjExMTE4ODg=&resultType=json&keyword=' +
            this.addressText
        )
        .then((response) => {
          if (response.data.results.juso == null) {
            this.addressList = [];
            this.errorMessage = response.data.results.common.errorMessage;
          } else {
            this.errorMessage = '';
            this.addressList = response.data.results.juso;
          }
        });
    },
  },
};
</script>
<style scoped>
div {
  margin: auto;
}

.modal,
.overlay {
  width: 100%;
  height: 100%;
  position: fixed;
  left: 0;
  top: 0;
}

.overlay {
  opacity: 0.5;
  background-color: black;
}

.modal-card {
  position: relative;
  max-width: 80%;
  margin: auto;
  margin-top: 30px;
  padding: 20px;
  background-color: white;
  min-height: 500px;
  z-index: 10;
  opacity: 1;
}

.search-wrap {
  display: block;
  position: relative;
  border-bottom: 1px solid #e9e9e9;
  margin: 0 auto;
  padding: 15px 0;
}
.wrap {
  display: block;
  width: 420px;
  position: relative;
  box-sizing: border-box;
  border: 2px solid #186bb9;
  margin: 0 auto;
  padding: 0 39px 0 0;
  background-color: #fff;
}
.wrap input[type='text'] {
  width: 100%;
  border: o none;
  line-height: 35px;
  font-size: 12px;
  font-weight: normal;
  ime-mode: active;
  border: 0 none;
}
.wrap input[type='button'] {
  position: absolute;
  right: 0;
  top: 0;
  height: 40px;
  width: 39px;
  border: 0 none;
  background: url(https://www.juso.go.kr/juso_support_center/img_addrlink/btn-search.png) 50% 50%
    no-repeat;
}
.search-sampletxt {
  margin: 5px auto 0 auto;
  color: #186bb9;
  display: inline;
  opacity: 0.7;
  font-size: 11px;
  text-align: center;
}

.button {
  width: 120px;
  height: 40px;
  margin-top: 10px;
}
</style>
