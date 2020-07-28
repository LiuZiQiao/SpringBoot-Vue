<template>
  <div class="regist-wrap">
    <div class="ms-regist">
      <div class="title">欢迎注册</div>
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="用户名" prop="username">
          <el-input type="text" v-model="ruleForm.username" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="真实姓名" prop="realname">
          <el-input type="text" v-model="ruleForm.realname" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="pass">
          <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="checkPass">
          <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-input v-model="ruleForm.sex"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="ruleForm.email"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click.native.prevent="handleRegister">提交</el-button>
<!--          <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>-->
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>
<script>
  let handleRegister = function () {
    console.log("---------");
    this.$refs.ruleForm.validate((valid) => {
      let httpUrl = ''
      if (valid) {
        httpUrl = 'http://localhost:8088/user/register';

        var registerParams = {
          username: this.ruleForm.username,
          realname: this.ruleForm.realname,
          password: this.ruleForm.pass,
          sex: this.ruleForm.sex,
          email: this.ruleForm.email
        };
        console.log(registerParams);
        this.$api.post(httpUrl, registerParams, response => {
          if (response.data.code == 0) {

            this.$message({
              type: 'success',
              message: '注册成功，即将跳转登录界面'
            })

            this.$router.push({
              path: '/'
            })
          }
        })
      }
    })
  }
  export default {
    data() {
      var checkRealName = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('真实姓名不能为空'));
        }
        // setTimeout(() => {
        //   if (!Number.isInteger(value)) {
        //     callback(new Error('请输入数字值'));
        //   } else {
        //     if (value < 18) {
        //       callback(new Error('必须年满18岁'));
        //     } else {
        //       callback();
        //     }
        //   }
        // }, 1000);
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.ruleForm.checkPass !== '') {
            this.$refs.ruleForm.validateField('checkPass');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm.pass) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
      var validateSex = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入性别'));
        }
      };
      var validateEmail = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入邮箱'));
        }
      };
      return {
        ruleForm: {
          username: '',
          realname: '',
          email: '',
          pass: '',
          checkPass: '',
          sex: ''
        },
        rules: {
          username: [{required: true, message: '请输入用户名', trigger: 'blur'}],

          //   username: [
          //     { validator: validatePass, trigger: 'blur' }
          //   ],
          // realname: [
          //   {validator: checkRealName, trigger: 'blur'}
          // ],
          // pass: [
          //   {validator: validatePass, trigger: 'blur'}
          // ],
          // checkPass: [
          //   {validator: validatePass2, trigger: 'blur'}
          // ],
          // email: [
          //   {validator: validateEmail, trigger: 'blur'}
          // ],

        }
      };
    },
    methods: {
      handleRegister,
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          console.log(formName);

          let httpUrl = '';
          if (valid) {
            alert('submit!');
            httpUrl = 'http://localhost:8088/user/register';

            var registerParams = {
              username: this.ruleForm.username,
              realname: this.ruleForm.realname,
              password: this.ruleForm.password,
              sex: this.ruleForm.sex,
              email: this.ruleForm.email
            };
            console.log(registerParams);
            this.$api.post(httpUrl, registerParams, response => {
              if (response.data.code == 0) {
                this.$router.push({
                  path: '/login'
                })
                this.$message({
                  type: 'success',
                  message: '注册成功，即将跳转登录界面'
                })
              }
            })
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style scoped>
  .regist-wrap {
    position: relative;
    width: 100%;
    height: 100%;
    background-image: url(../assets/img/login-bg.jpg);
    background-size: 100%;
  }
  .ms-regist {
    position: absolute;
    left: 50%;
    top: 50%;
    width: 350px;
    margin: 50px 0 0 50px;
    border-radius: 5px;
    background: rgba(255, 255, 255, 0.3);
    overflow: hidden;
  }
  .title {
    width: 100%;
    height: 50px;
    text-align: center;
    font-size: 20px;
    color: #2c3e50;
    border-bottom: 1px solid #ddd;
  }

</style>
