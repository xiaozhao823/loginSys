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
        <div class="rightText">HOW DO YOU WORK?</div>
        <!-- <router-link to="/signPage" class="toPageSty">>> Go ahead to complete your profile so that we can get<br> to knowyou better and give you the right assignment</router-link> -->
        <div v-for="(item, index) in checkConent" :key="index" class="radioSty" :style="work === item.id?'border: 3px solid #409EFF':''">
          <el-radio v-model="work" :label="item.id" class="titleSty">{{item.title}}</el-radio>
          <div class="rightDesText" v-html="item.desText"></div>
        </div>
      <el-button  class="buttonSty" @click="toAddress">NEXT STEP</el-button>
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
      work: '1',
      checkConent: [
        {
          id: '1',
          title:'ON MY OWN',
          desText: 'I am a contractor and work<br>independently for one or more clients.'
        },
        {
          id: '2',
          title:'AS PART OF A COMPANY',
          desText: 'I have a registered business myself or I <br> am employed by a client.'
        }
      ]
    }
  },
  methods: {
    toAddress() {
      localStorage.setItem('work', this.work);
      this.$router.push({ path: '/addressPage' })
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
  /* border-bottom: 1px solid #322c2b; */
  width: 80%;
  margin: 0 auto;
}
.toPageSty {
  font-size: 20px;
  color: #3460df;
  margin-top: 150px;
  display: block;
  width: 80%;
}
.radioSty {
  border: 1px solid #000;
  width: 50%;
  margin: 30px auto;
  text-align: left;
  padding: 30px;
}
.titleSty {
  padding-bottom: 20px;
}
.rightDesText {
  border-top: 1px solid #000;
  padding-top: 20px;
}
.buttonSty {
  background-color: #0076ff;
  color: #fff;
  width: 64%;
}
</style>
