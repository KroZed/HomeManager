<template>
    <div class="loginBody">


        <div class="loginDiv">
            <div class="login-content">
                <el-row>
                    <el-col style="text-align: center; padding: 25px 0 25px 0">
                      <img src="@/assets/logo.png" style="width: 40px;height: 40px;" />
                      <span style="font-size: 36px; color: #e75c09"> 登录仓库管理系统</span>
                    </el-col>
                </el-row>
                <el-form
                    :model="loginForm"
                    label-width="100px"
                    :rules="rules"
                    ref="loginForm"
                >
                    <el-form-item label="账号" prop="no">
                        <el-input
                            style="width: 200px"
                            type="text"
                            v-model="loginForm.no"
                            autocomplete="off"

                        ></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="password">
                        <el-input
                            style="width: 200px"
                            type="password"
                            v-model="loginForm.password"
                            show-password
                            autocomplete="off"

                            @keyup.enter.native="confirm"
                        ></el-input>
                    </el-form-item>
                    <el-form-item style="padding-left: 2px">
                        <el-button
                            type="success"
                            @click="confirm"
                            :disabled="confirm_disabled"
                            style="font-size: 22px"
                        >
                          <i class="iconfont icon-login-logo"
                             style="font-size: 20px">
                          </i>
                            登 陆</el-button
                        >
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </div>
</template>


<script>
export default {
    name: "Login",
    data() {
        return {
            confirm_disabled: false, //防止多次提交
            loginForm: {
                no: "",
                password: "",
            },
            rules: {
                no: [
                    { required: true, message: "请输入账号", trigger: "blur" },
                ],
                password: [
                    { required: true, message: "请输密码", trigger: "blur" },
                ],
            },
        };
    },
    methods: {
        confirm() {
            this.confirm_disabled = true;
            this.$refs.loginForm.validate((valid) => {
                if (valid) {
                    //valid成功为true，失败为false
                    //去后台验证用户名密码
                    this.$axios
                        .post(this.$httpUrl + "/user/login", this.loginForm)
                        .then((res) => res.data)
                        .then((res) => {
                            if (res.code == 200) {
                                //存储
                                sessionStorage.setItem(
                                    "CurUser",
                                    JSON.stringify(res.data.user)
                                );

                                console.log(res.data.menu);
                                this.$store.commit("setMenu", res.data.menu);
                                //跳转到主页
                                this.$router.replace("/Index");
                            } else {
                                this.confirm_disabled = false;
                                alert("校验失败，用户名或密码错误！");
                                return false;
                            }
                        })
                        .catch((e) => {
                            this.confirm_disabled = false;
                            console.log(e);
                            if (
                                e.response == undefined ||
                                e.response.data == undefined
                            ) {
                                this.$message({
                                    showClose: true,
                                    message: e,
                                    type: "error",
                                    duration: 5000,
                                });
                            } else {
                                this.$message({
                                    showClose: true,
                                    message: e.response.data,
                                    type: "error",
                                    duration: 5000,
                                });
                            }
                        });
                } else {
                    this.confirm_disabled = false;
                    return false;
                }
            });
        },
    },
};
</script>

<style scoped>
html,
body {
    overflow-x: hidden;
}

.loginBody {
    position: absolute;
    width: 100%;
    height: 100%;
    /* background-color: #B3C0D1; */
    background: url("../assets/home.jpg");
    background-size: 100% 100%;

    overflow-x: hidden;
}
.loginDiv {
    position: absolute;
    top: 45%;
    left: 80%;
    margin-top: -200px;
    margin-left: -250px;
    width: 450px;
    height: 330px;
    background: #fff;
    border-radius: 5%;
    opacity: 0.9;
}
.login-title {
    margin: 20px 0;
    text-align: center;
}
.login-content {
    width: 400px;
    height: 250px;
    position: absolute;
    top: 25px;
    left: 25px;
}
</style>
