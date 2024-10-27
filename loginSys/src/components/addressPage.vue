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
        <div class="rightText">FILL IN YOUR ADDRESS</div>
        <el-form  :model="formLabelAlign" style="width: 80%;">
          <el-form-item>
            <el-input v-model="formLabelAlign.street" class="elInput" placeholder="Street/Number"></el-input>
          </el-form-item>
          <el-form-item>
            <el-input v-model="formLabelAlign.zip" class="elInput" placeholder="ZIP"></el-input>
          </el-form-item>
          <el-form-item>
            <el-input v-model="formLabelAlign.city" class="elInput" placeholder="City"></el-input>
          </el-form-item>
          <el-form-item>
            <el-input v-model="formLabelAlign.state" class="elInput" placeholder="State"></el-input>
          </el-form-item>
          <el-form-item>
            <el-input v-model="formLabelAlign.country" class="elInput" placeholder="Eslect Country"></el-input>
          </el-form-item>
        </el-form>
        <el-button  class="buttonSty" @click="toSignUp">NEXT STEP</el-button>
        <!-- <router-link to="/signPage" class="toPageSty">>> Go ahead to complete your profile so that we can get<br> to knowyou better and give you the right assignment</router-link> -->
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'account',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      formLabelAlign: {
        street: '',
        zip: '',
        city: '',
        state: '',
        country: ''
      }
    }
  },
  methods: {
    toSignUp() {
      localStorage.setItem('street', this.formLabelAlign.street);
      localStorage.setItem('zip', this.formLabelAlign.zip);
      localStorage.setItem('city', this.formLabelAlign.city);
      localStorage.setItem('state', this.formLabelAlign.state);
      localStorage.setItem('country', this.formLabelAlign.country);
      this.$router.push({ path: '/signUpPage' })
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
  padding-bottom: 60px;
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
}
</style>
