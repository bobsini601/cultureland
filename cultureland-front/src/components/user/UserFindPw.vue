<template>
  <b-container>
    <b-row>
      <b-col>
        <h1 id="title_header">FindPw</h1>
      </b-col>
    </b-row>
    <b-row>
      <b-col></b-col>
      <b-col >
        <b-card class="text-center mt-3" style="max-width: 40rem" align="left">
          <b-form class="text-left">
            <b-alert show variant="danger" > 비밀번호를 찾을 수 없습니다. </b-alert>
            <!-- <b-form-group label-for="username">
              <b-form-input
                id="username"
                v-model="user.username"
                required
                placeholder="ID"
                @keyup.enter="confirm"
              ></b-form-input>
            </b-form-group>
            <b-form-group label-for="password">
              <b-form-input
                type="password"
                id="password"
                v-model="user.password"
                required
                placeholder="PW"
                @keyup.enter="confirm"
              ></b-form-input> 
            </b-form-group>-->
            <p><button type="button" id="user_button" @click="confirm">비밀번호 찾기</button></p>
          </b-form>
        </b-card>
      </b-col>
      <b-col></b-col>
    </b-row>
  </b-container>
</template>
<script>
export default {
  name: "UserFindPw",
}
</script>
<style scoped>

</style>