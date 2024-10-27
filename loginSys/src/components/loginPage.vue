<template>
  <div class="loginPage">
    <!-- left side -->
    <div class="mainSty leftSty">
      <div class="leftTextSty">Welcome to Brocent!</div>
      <img src="../assets/loginImg.jpg" alt="" class="imgSty">
      <div class="textSty oneText">xxxxxxxxxxxxxxxxxxxxxxxxxxxxx</div>
      <div class="textSty twoText">xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</div>
      <div class="textSty threeText">xxxxxxxxxxxxxxxxxxxxxxxx</div>
    </div>
    <!-- right sied -->
    <div class="mainSty rightSty">
      <div class="rightText">Create password</div>
      <el-input placeholder="Password" v-model="passInput" show-password class="inputSty"></el-input>
      <div class="containSty">New password must contain:</div>
      <!-- 1 -->
      <div class="checkOption">
        <i class="el-icon-remove" v-if="!lengthShow"></i>
        <i class="el-icon-success" v-else style="color:#42b983"></i>
        <div class="checkText">8 characters or more</div>
      </div>
      <!-- 2 -->
      <div class="checkOption">
        <i class="el-icon-remove" v-if="!uppShow"></i>
        <i class="el-icon-success" v-else style="color:#42b983"></i>
        <div class="checkText">Uppercase character</div>
      </div>
      <!-- 3 -->
      <div class="checkOption">
        <i class="el-icon-remove" v-if="!lowShow"></i>
        <i class="el-icon-success" v-else style="color:#42b983"></i>
        <div class="checkText">Lowercase character</div>
      </div>
      <!-- 4 -->
      <div class="checkOption">
        <i class="el-icon-remove" v-if="!speShow"></i>
        <i class="el-icon-success" v-else style="color:#42b983"></i>
        <div class="checkText">Special character</div>
      </div>
      <!-- 5 -->
      <div class="checkOption">
        <i class="el-icon-remove" v-if="!numShow"></i>
        <i class="el-icon-success" v-else style="color:#42b983"></i>
        <div class="checkText">Number</div>
      </div>


      <el-button class="buttonSty" type="primary" @click="createdAcc">CREATE ACCOUNT</el-button>
      <div class="smText">Already have an account? 
        <!-- <a to="/signPage">Sign in</a> -->
        <router-link to="/signPage" class="routerSty">Sign in</router-link>
      </div>
       
    </div>
  </div>
</template>

<script>
import {updateFun} from "@/api/login";
export default {
  name: 'loginPage',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      passInput:'',
      lengthShow: false,
      uppShow: false,
      lowShow: false,
      speShow: false,
      numShow: false
    }
  },
  watch: {
    passInput(newValue, oldValue) {
      // console.log(this.passInput.length);
      const pattern = /[A-Z]/g
      const pattern2 = /[a-z]/g
      const pattern3 = /[!@#$%^&*]/g;
      const pattern4 = /[1-9]/g;
      // !@#$%^&*]
      // /^([A-Z])]+$/
      // 判断长度
      if (newValue.length >= 8) {
        this.lengthShow = true
      }else {
        this.lengthShow = false
      }
      // console.log(newValue.match(pattern));
      
      // console.log(Object.keys(newValue.match(pattern)).length);
      
      // 判断大写
      if (newValue.match(pattern) !== null) {
        this.uppShow = true
      }else {
        this.uppShow = false
      }
      // 小写字母
      if (newValue.match(pattern2) !== null) {
        this.lowShow = true
      }else {
        this.lowShow = false
      }
      // 特殊字符
      if (newValue.match(pattern3) !== null) {
        this.speShow = true
      }else {
        this.speShow = false
      }
      // 数字
      if (newValue.match(pattern4) !== null) {
        this.numShow = true
      }else {
        this.numShow = false
      }

    }
  },
  created() {
    debugger
    let userId = this.$route.query.userId; // John
    localStorage.setItem('brocentUserId', userId);
  },
  methods: {
    createdAcc() {
      let params = {
        userId: localStorage.getItem('brocentUserId'),
        password: this.passInput
      }
      updateFun(params).then( res => {
        if (res.data === 'ok') {
          this.$router.push({ path: '/accountPage' })
        } else{
          this.$message.error('Is error!');
        }
      })
    },
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.loginPage {
  width: 100%;
  height: 100%;
}
.mainSty {
  width: 50%;
  display: inline-block;
  position: absolute;
}
.leftSty{
  background-color: #3460df;
  left: 0;
  height: 100%;
}
.leftTextSty {
  color: #fff;
  padding-top: 10%;
  font-size: 40px;
  font-weight: bold;
}
.imgSty {
  width: 100%;
  padding-top: 38px;
}
.textSty {
  color: #fff;
}
.oneText {
  font-size: 28px;
}
.twoText {
  font-size: 24px;
}
.threeText {
  font-size: 20px;
}
.rightSty {
  padding-left: 80px;
  text-align: left;
}
.rightText {
  color: #000;
  font-size: 40px;
  padding-top: 10%;
  font-weight: bold;
  /* text-align: left; */
}
.inputSty {
  width: 80%;
  text-align: left;
  display: block;
  margin-top: 50px;
}
.containSty {
  font-size: 20px;
  padding-top: 16px;
}
.checkText {
  display: inline-block;
  padding: 6px 0;
}
.buttonSty {
  background-color: #3460df;
  border-color: #3460df;
  width: 80%;
  padding: 16px;
  font-weight: bold;
  margin-top: 40px;
}
.smText {
  padding-top: 20px;
  font-weight: 400;
}
.routerSty {
  color: blue !important;
  text-decoration: none;
}














h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
