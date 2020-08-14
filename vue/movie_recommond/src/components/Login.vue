<template>
  <div class="login-wrap">
    <div class="ms-login">
      <div class="ms-title">Login</div>
      <el-form ref="loginForm" :model="loginParam" :rules="rules"  label-width="100px" class="ms-content">
        <el-form-item label="用户名">
          <el-input v-model="loginParam.username" type="text"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="loginParam.password" type="password"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button type="success" @click.native.prevent="handleLogin">登录</el-button>
          <el-button type="primary" @click.native.prevent="handleRegister">注册</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  let handleLogin = function () {
    this.$refs.loginForm.validate((valid) => {
      let httpUrl = ''
      if (valid) {
        httpUrl = 'http://localhost:8088/user/login';

        var loginParams = {
          username: this.loginParam.username,
          password: this.loginParam.password
        };
        console.log(loginParams)
        this.$api.post(httpUrl, loginParams, response => {
          if (response.data.code == 0) {
            sessionStorage.setItem('username', this.loginParam.username);
            this.$router.push({
              path: '/home'
            })
            this.$message({
              type: 'success',
              message: '欢迎登录：' + this.loginParam.username
            })
          }
        })

      }
    })
  }

  let handleRegister = function () {
    this.$router.push({
      path: '/register'
    })
  }

  export default {
    name: 'Login',
    data() {
      return {
        loginParam: {
          username: '',
          password: ''
        },
        rules: {
          username: [{required: true, message: '请输入用户名', trigger: 'blur'}],
          password: [{required: true, message: '请输入密码', trigger: 'blur'}],
        }
      }
    },
    methods: {
      handleLogin,
      handleRegister
    },
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .login-wrap {
    position: relative;
    width: 100%;
    height: 100%;
    /* background-image: url(/../assets/img/login-bg.jpg); */
    background-size: 100%;
  }
  .ms-title {
    width: 100%;
    line-height: 50px;
    text-align: center;
    font-size: 20px;
    color: #2c3e50;
    border-bottom: 1px solid #ddd;
  }
  .ms-login {
    position: absolute;
    left: 50%;
    top: 50%;
    width: 350px;
    margin: 50px 0 0 -175px;
    border-radius: 5px;
    background: rgba(255, 255, 255, 0.3);
    overflow: hidden;
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
