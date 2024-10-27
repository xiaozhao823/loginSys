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
        <div class="rightText">Congratulation!<br> Your account has been created!</div>
        <router-link to="/workPage" class="toPageSty">>> Go ahead to complete your profile so that we can get<br> to knowyou better and give you the right assignment</router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'account',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  methods: {
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
  margin-top: 140px;
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
}
.rightText {
  font-size: 30px;
  border-bottom: 1px solid #322c2b;
  width: 80%;
}
.toPageSty {
  font-size: 20px;
  color: #3460df;
  margin-top: 150px;
  display: block;
  width: 80%;
}
</style>
