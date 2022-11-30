<template>
  <div id="userRegist">
    <b-container>
      <b-row>
        <b-col>
          <h1 id="title_header">SignUp</h1>
        </b-col>
      </b-row>
      <b-row>
        <b-col></b-col>
        <b-col cols="5">
          <b-card class="text-center mt-3" style="max-width: 40rem" align="left">
            <b-form class="text-left">
              <b-form-group label-for="userid">
                <b-form-input
                  id="userid"
                  v-model="user.username"
                  required
                  placeholder="아이디"
                  @keyup.enter="confirm"
                  @blur="idCheck"
                ></b-form-input>
              </b-form-group>
              <b-form-group label-for="name">
                <b-form-input
                  id="name"
                  v-model="user.name"
                  required
                  placeholder="본명"
                  @keyup.enter="confirm"
                ></b-form-input>
              </b-form-group>
              <b-form-group label-for="userpwd">
                <b-form-input
                  type="password"
                  id="userpwd"
                  v-model="user.password"
                  required
                  placeholder="비밀번호"
                  @keyup.enter="confirm"
                  @blur="pwCheck"
                ></b-form-input>
              </b-form-group>

              <b-form-group label-for="userpwd">
                <b-form-input
                  type="password"
                  id="userpwd"
                  v-model="user.passwordCheck"
                  required
                  placeholder="비밀번호 확인"
                  @keyup.enter="confirm"
                  @blur="pwCheck"
                ></b-form-input>
              </b-form-group>
              <b-form-group label-for="nickname">
                <b-form-input
                  id="nickname"
                  v-model="user.nickname"
                  required
                  placeholder="닉네임"
                  @keyup.enter="confirm"
                ></b-form-input>
              </b-form-group>

              <b-form-group label-for="email">
                <b-form-input
                  id="email"
                  v-model="user.email"
                  required
                  placeholder="이메일"
                  @keyup.enter="confirm"
                ></b-form-input>
              </b-form-group>

              <button type="button" id="user_button" @click="confirm">회원 등록</button>
            </b-form>
          </b-card>
        </b-col>
        <b-col></b-col>
      </b-row>
    </b-container>
  </div>
</template>
<script>
import { mapActions, mapState } from 'vuex';
const userStore = "userStore";
export default {
  name: "UserRegist",
  data() {
    return {
      // isLoginError: false,
      user: {
        username: null,
        name : null,
        password: "",
        passwordCheck: "",
        nickname: null,
        email: null
      }
    };
  },
  methods:{
    ...mapActions(userStore, ["userRegist", "idcheck"]),
    confirm(){
        console.log(this.user);
        this.userRegist(this.user);
        this.$router.push({ name: "home" });
    },
    idCheck(){
      console.log(this.idcheck(this.user))
    },
    pwCheck(){
      console.log(this.pwCheckOK);
      if(this.password != null && this.passwordCheck != null){
        if(this.password === this.passwordCheck){
          this.pwCheckOK = true;
        } else {
          this.pwCheckOK = false;
        }
      } else {
        this.pwCheckOK = false;
      }
    }
  },
  computed:{
    ...mapState(userStore, ["idCheckOk", "pwCheckOk"]),
  }
}
</script>
<style>
@import "@/assets/css/user.css";
</style>