<template>
  <div class="signPage">
    <div class="formdiv">
      <el-form :model="formInline" class="demo-form-inline">
        <el-form-item>
          <img src="../assets/signLogo.jpg" alt="">
        </el-form-item>
        <el-form-item>
          <el-input v-model="formInline.email" placeholder="Email" class="inputSty"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input v-model="formInline.password" placeholder="Password" class="inputSty"></el-input>
        </el-form-item>
        <el-form-item>
          <el-radio class="radioSty" v-model="radio" label="1">I have read and agree to the Terms of Service and Privacy policy</el-radio>
          <el-radio class="radioSty" v-model="radio2" label="2">Remember Password</el-radio>
        </el-form-item>
        <el-form-item>
          <el-button  class="buttonSty" @click="signFun">SIGN IN</el-button>
        </el-form-item>
        <el-form-item>
          <span>Don`t have anaccount? </span>
          <router-link to="/"  class="routerSty">Register</router-link> <br>
          <span>Forgot Password</span>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>


<script>
// import axios from "axios";
import { loginFun } from "@/api/login";

// import axios from "axios";
export default {
  name: 'signPage',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      radio: '1',
      radio2: '2',
      formInline: {
        email: '',
        password: ''
      }
    }
  },
  methods: {
    signFun() {
      loginFun(this.formInline).then(res => {
        if (res.data) {
          localStorage.setItem('brocentUserId', userId);
          this.$router.push({ path: '/accountPage' })
        } else {
          this.$message.error('email or password is error!');
        }

        
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.signPage {
  background-image: url('../assets/signBack.jpg');
  background-size: 100% 100%;
  background-position: center;
  background-attachment: fixed; /* 背景图片固定 */
  min-height: 100vh; 
}
.formdiv {
  background-color: #fff;
  width: 500px;
  position: absolute;
  left: 56%;
  top: 14%;
}
.inputSty {
  width: 85%;
}
.radioSty {
  display: block;
  padding:10px 40px;
  text-align: left;
}
.buttonSty {
  background-color: #0076ff;
  color: #fff;
  width: 80%;
}
.routerSty {
  color: blue !important;
  text-decoration: none;
}
</style>
