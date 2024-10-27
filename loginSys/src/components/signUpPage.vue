<template>
  <div class="account">
    <div class="header">
      <div class="headerLeft">
        <img src="../assets/signLogo.jpg" alt="">
      </div>
      <div class="headerRight" @click="goHomePage">Go to HomePage</div>
    </div>
    <div class="content">
      <div class="leftContent">
        <img src="../assets/signBack.jpg" alt="">
      </div>
      <div class="rightContent">
        <div class="rightText">WHAT MADE YOU SIGN <br> UP WITH BROCENT</div>
        <div class="radionGroSty">
          <el-radio v-model="radio" label="1">Another service or product</el-radio><br>
          <el-radio v-model="radio" label="2">Art, Photography & Creative Services</el-radio><br>
          <el-radio v-model="radio" label="3">Construction & Professional Services</el-radio><br>
          <el-radio v-model="radio" label="4">Consulting & Professional Services</el-radio><br>
          <el-radio v-model="radio" label="5">Financial Services & Insurance</el-radio><br>
          <el-radio v-model="radio" label="6">Hair,Spa & Aesthetics</el-radio><br>
          <el-radio v-model="radio" label="7">Medical, Dental & Health</el-radio><br>
          <el-radio v-model="radio" label="8">Non-profits, Associations & Groups</el-radio><br>
          <el-radio v-model="radio" label="9">Real Estate</el-radio><br>
          <el-radio v-model="radio" label="10">Retailers, Resellers & Sale</el-radio><br>
          <el-radio v-model="radio" label="11">Web, Tech & Media</el-radio><br>
        </div>
        <el-button  class="buttonSty" @click="toFinish">FINISH</el-button>
        <!-- <router-link to="/signPage" class="toPageSty">>> Go ahead to complete your profile so that we can get<br> to knowyou better and give you the right assignment</router-link> -->
      </div>
    </div>
  </div>
</template>

<script>
  import {updateFun} from "@/api/login";
export default {
  name: 'account',
  data () {
    return {
      radio: '1',
      msg: 'Welcome to Your Vue.js App',
      formLabelAlign: {
          name: '',
          region: '',
          type: '',
          state: '',
          country: ''
        }
    }
  },
  methods: {
    toFinish() {
      localStorage.setItem('radio', this.radio);
      let params = {
        userId: localStorage.getItem('brocentUserId'),
        work: localStorage.getItem('work'),
        street: localStorage.getItem('street'),
        zip: localStorage.getItem('zip'),
        city: localStorage.getItem('city'),
        state: localStorage.getItem('state'),
        country: localStorage.getItem('country'),
        radio: localStorage.getItem('radio')
      }
      updateFun(params).then( res => {
        if (res.data === 'ok') {
          this.$router.push({ path: '/finishPage' })
        } else {
          this.$message.error('Is error!');
        }
        
      })
    },
    goHomePage() {
      this.$router.push({ path: '/accountPage' })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.header {
  height: 50px;
}
.headerLeft {
  position: absolute;
  top: 10px;
  left: 5px;
  img {
    width: 50%;
  }
}
.headerRight {
  position: absolute;
  right: 75px;
  top: 49px;
  font-size: 20px;
  cursor: pointer;
}
.content {
  width: 100%;
  margin-top: 110px;
}
.leftContent {
  position: absolute;
  /* border: 1px solid red; */
  width: 50%;
  left: 0px;
  img {
    width: 200px;
    margin-top: 100px;
  }
}
.rightContent {
  position: absolute;
  right: 0;
  /* border: 1px solid blue; */
  width: 50%;
  /* padding-top: 200px; */
}
.rightText {
  font-size: 30px;
  /* border-bottom: 1px solid #322c2b; */
  width: 80%;
  padding-bottom: 20px;
}
.elInput {
  width: 60%;
}
.toPageSty {
  font-size: 20px;
  color: #3460df;
  margin-top: 150px;
  display: block;
  width: 80%;
}
.buttonSty {
  background-color: #0076ff;
  color: #fff;
  width: 52%;
  margin-left: -135px;
  margin-top: 20px;
}
.radionGroSty {
  text-align: left;
  line-height: 31px;
  padding-left: 120px;
}
</style>
