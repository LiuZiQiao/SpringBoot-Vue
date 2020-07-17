<template>
  <div class="login-warp">
    <div class="ms-login">
      <div class="ms-title">Login</div>
      <el-form :model="loginParam" :rules="rules" label-width="100px">
        <el-form-item :prop="username" label="用户名">
          <el-input v-model="loginParam.username" type="text"></el-input>
        </el-form-item>
        <el-form-item :prop="password" label="密码">
          <el-input v-model="loginParam.password" type="password"></el-input>
        </el-form-item>

        <el-form-item>
          <div class="login-btn">
            <el-button type="primary" @click="submitForm">登录</el-button>
            <el-button type="primary" @click="register">注册</el-button>
          </div>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      loginParam: {
        username: '',
        password: ''
      },
      rules: {
        username:[{required: true,message: '请输入用户名', trigger: 'blur'}],
        password:[{required: true,message: '请输入密码', trigger: 'blur'}],
      }
    }
  },
  methods: {
    submitForm() {
        this.$refs.loginParam
    }
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.login-wrap {
    position: relative;
    width: 100%;
    height: 100%;
    background-image: url(../assets/img/login-bg.jpg);
    background-size: 100%;
}
.ms-login {
    position: absolute;
    left: 50%;
    top: 50%;
    width: 350px;
    margin: -190px 0 0 -175px;
    border-radius: 5px;
    background: rgba(255, 255, 255, 0.3);
    overflow: hidden;
}

.ms-title {
    width: 100%;
    line-height: 50px;
    text-align: center;
    font-size: 20px;
    color: #fff;
    border-bottom: 1px solid #ddd;
}
.ms-content {
    padding: 30px 30px;
}
.login-btn {
    text-align: center;
}
.login-btn button {
    width: 100%;
    height: 36px;
    margin-bottom: 10px;
}
.login-tips {
    font-size: 12px;
    line-height: 30px;
    color: #fff;
}
</style>
