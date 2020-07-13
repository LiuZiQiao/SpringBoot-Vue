<template>
	<div>
		<h1>表单</h1>
		<!-- <el-row>
			<el-col>
				
			</el-col>
			<span>
				<i class="fa fa-user fa-fw"></i>用户管理
			</span>
			<el-divider></el-divider>
		</el-row> -->
		<form>
			用户名：<input type="text" id="username" name="username" style="width: 200px;"/>
			密 码：<input type="password" id="password" name="password" style="width: 200px;" />
			<input type="button" value="提交"/>
			<input type="reset" value="重置"/>
		</form>
		
		<h1>el 表单</h1>
		
		<el-form>
			<el-form-item>
				<i class="el-icon-user"></i>
				<el-input type="text" style="width: 200px;" v-model="UserForm.username" placeholder="用户名"></el-input>
			</el-form-item>
			<el-form-item>
				<el-input type="password" style="width: 200px;" v-model="UserForm.password" placeholder="密码" show-password></el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="submitForm('UserForm')">登陆</el-button>
				<el-button @click="resetForm('UserForm')">重置</el-button>
				<!-- <el-button style="width: 95px" @click="resetForm("UserForm")" > 注册</el-button> -->
			</el-form-item>
		</el-form>
		
		<!-- el表格 -->
		<h1>el  表格</h1>
		<hr />
		<el-table :data="tableData" style="width: 100%;">
			<el-table-column prop="date" label="日期" width="180"></el-table-column>
			<el-table-column prop="name" label="姓名" width="180"></el-table-column>
			<el-table-column prop="address" label="地址" width="180"></el-table-column>
		</el-table>
	</div>
</template>

<script>
	
	export default{
		data(){
			var checkUsername = (rule, value, callback) => {
			    if (!value) {
					return callback(new Error('姓名不能为空'));
			    }
			};
			var validatePass = (rule, value, callback) => {
			    if (value === '') {
			        callback(new Error('请输入密码'));
			    } else {
			        if (this.UserForm.password !== '') {
			            this.$refs.ruleForm.validateField('checkPass');
			        }
			      callback();
			      }
			};
			return{
				tableData: [{
					date: '2020-7-15',
					name: '小虎',
					address: '西安市未央区'
				},{
					date: '2020-7-15',
					name: '小虎',
					address: '西安市未央区'
				}],
				UserForm: {
					username: '',
					password: ''
				},
				rules: {
				  username: [
					{ validator: checkUsername, trigger: 'blur' }
				  ],
				  password: [
					{ validator: validatePass, trigger: 'blur' }
				  ]
			
				}
			}
		},
		methods:{
			submitForm(formName){
				this.$refs[formName].validate((valid)=>{
					if(valid){
						alert("submit");
					}else{
						alert("error submit");
						return false;
					}
				});
			},
			resetForm(formName){
				this.$refs[formName].resetFields();
			}
		}
	}
</script>