(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-22f6b358"],{"0290":function(e,t,o){"use strict";o.r(t);var s=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{staticClass:"login-wrap"},[o("div",{staticClass:"ms-login"},[o("div",{staticClass:"ms-title"},[e._v("软件资源二中心工时管理系统")]),o("el-form",{ref:"loginForm",staticClass:"ms-content",attrs:{model:e.loginForm,rules:e.rules,"label-width":"0px"}},[o("el-form-item",{attrs:{prop:"name"}},[o("el-input",{attrs:{placeholder:"手机号 / 身份证号 / 公司邮箱"},model:{value:e.loginForm.name,callback:function(t){e.$set(e.loginForm,"name",t)},expression:"loginForm.name"}},[o("el-button",{attrs:{slot:"prepend",icon:"el-icon-lx-people"},slot:"prepend"})],1)],1),o("el-form-item",{attrs:{prop:"password"}},[o("el-input",{attrs:{type:"password",placeholder:"password"},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.submitForm("loginForm")}},model:{value:e.loginForm.password,callback:function(t){e.$set(e.loginForm,"password",t)},expression:"loginForm.password"}},[o("el-button",{attrs:{slot:"prepend",icon:"el-icon-lx-lock"},slot:"prepend"})],1)],1),o("div",{staticClass:"login-btn"},[o("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.submitForm("loginForm")}}},[e._v("登录")])],1),o("p",{staticClass:"login-tips"},[e._v("Tips : 11010119900307563X")])],1)],1)])},r=[],n=(o("a1bf"),o("e5df"),o("aa7b"),o("b328"),{data:function(){return{loginForm:{name:"",password:""},rules:{name:[{required:!0,message:"请输入手机号 / 身份证号 / 公司邮箱",trigger:"blur"}],password:[{required:!0,message:"请输入密码",trigger:"blur"}]}}},methods:{submitForm:function(e){var t=this;this.$refs[e].validate(function(e){if(!e)return!1;t.$axios.postForm(t.$api.user.login,t.loginForm).then(function(e){if(200===e.code)t.$store.commit("login/updateLogin",!0),t.$store.commit("login/updateUserInfo",{userName:"admin"}),t.$message.success("登录成功"),t.$router.push("/dashboard");else{var o="undefined"!==typeof e.data.message?e.data.message:"密码输入错误";t.$message.error(o)}})})}}}),a=n,i=(o("a0f0"),o("620d")),l=Object(i["a"])(a,s,r,!1,null,"05545cfe",null);t["default"]=l.exports},"19e2":function(e,t,o){},a0f0:function(e,t,o){"use strict";var s=o("19e2"),r=o.n(s);r.a}}]);