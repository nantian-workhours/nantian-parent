(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-619e94be"],{"21f4":function(e,t,a){"use strict";a.d(t,"a",function(){return l});a("a1bf"),a("e5df"),a("aa7b"),a("b328");var r=a("caf6"),o=a.n(r),i=a("d4aa");function l(e){return o.a.get(i["a"].params.subTypeQuery+"?dicType="+e)}},"72d4":function(e,t,a){"use strict";var r=a("fe53"),o=a.n(r);o.a},d400:function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-lx-friend"}),e._v(" 员工管理")]),a("el-breadcrumb-item",[e._v(" 查看详情")])],1)],1),a("div",{staticClass:"container"},[a("h5",{staticClass:"mgb10"},[e._v("基本信息")]),a("el-form",{ref:"form",attrs:{inline:!0,rules:e.rules,model:e.form,disabled:e.disableStatus,"label-width":"80px"}},[a("el-form-item",{attrs:{label:"姓名",prop:"name",required:""}},[a("el-input",{attrs:{placeholder:"请录入"},model:{value:e.form.name,callback:function(t){e.$set(e.form,"name",t)},expression:"form.name"}})],1),a("el-form-item",{attrs:{label:"身份证号",prop:"idNo",required:""}},[a("el-input",{attrs:{placeholder:"请录入"},model:{value:e.form.idNo,callback:function(t){e.$set(e.form,"idNo",t)},expression:"form.idNo"}})],1),a("el-form-item",{attrs:{label:"性别"}},[a("el-select",{staticStyle:{width:"200px"},model:{value:e.form.sex,callback:function(t){e.$set(e.form,"sex",t)},expression:"form.sex"}},e._l(e.sexList,function(e,t){return a("el-option",{key:t,attrs:{label:e.dicValue,value:e.dicCode}})}),1)],1),a("el-form-item",{attrs:{label:"生日"}},[a("el-date-picker",{staticClass:"width-control",attrs:{type:"date",placeholder:"请录入"},model:{value:e.form.birthday,callback:function(t){e.$set(e.form,"birthday",t)},expression:"form.birthday"}})],1),a("el-form-item",{attrs:{label:"民族"}},[a("el-input",{attrs:{placeholder:"请录入"},model:{value:e.form.ethnic,callback:function(t){e.$set(e.form,"ethnic",t)},expression:"form.ethnic"}})],1),a("el-form-item",{attrs:{label:"籍贯"}},[a("el-input",{attrs:{placeholder:"请录入"},model:{value:e.form.nativePlace,callback:function(t){e.$set(e.form,"nativePlace",t)},expression:"form.nativePlace"}})],1),a("el-form-item",{attrs:{label:"婚姻状况"}},[a("el-select",{staticStyle:{width:"200px"},model:{value:e.form.marriageStatus,callback:function(t){e.$set(e.form,"marriageStatus",t)},expression:"form.marriageStatus"}},e._l(e.marrigeList,function(e,t){return a("el-option",{key:t,attrs:{label:e.dicValue,value:e.dicCode}})}),1)],1),a("el-form-item",{attrs:{label:"公司邮箱",prop:"companyEmail",required:""}},[a("el-input",{attrs:{placeholder:"请录入"},model:{value:e.form.companyEmail,callback:function(t){e.$set(e.form,"companyEmail",t)},expression:"form.companyEmail"}})],1),a("el-form-item",{attrs:{label:"个人邮箱"}},[a("el-input",{attrs:{placeholder:"请录入"},model:{value:e.form.personEmail,callback:function(t){e.$set(e.form,"personEmail",t)},expression:"form.personEmail"}})],1),a("el-form-item",{attrs:{label:"手机号码",prop:"mobileNo",required:""}},[a("el-input",{attrs:{placeholder:"请录入"},model:{value:e.form.mobileNo,callback:function(t){e.$set(e.form,"mobileNo",t)},expression:"form.mobileNo"}})],1),a("el-form-item",{attrs:{label:"学历"}},[a("el-select",{staticStyle:{width:"200px"},model:{value:e.form.education,callback:function(t){e.$set(e.form,"education",t)},expression:"form.education"}},e._l(e.educationList,function(e,t){return a("el-option",{key:t,attrs:{label:e.dicValue,value:e.dicCode}})}),1)],1),a("el-form-item",{attrs:{label:"毕业院校"}},[a("el-input",{attrs:{placeholder:"请录入"},model:{value:e.form.university,callback:function(t){e.$set(e.form,"university",t)},expression:"form.university"}})],1),a("el-form-item",{attrs:{label:"专业"}},[a("el-input",{attrs:{placeholder:"请录入"},model:{value:e.form.major,callback:function(t){e.$set(e.form,"major",t)},expression:"form.major"}})],1),a("el-form-item",{attrs:{label:"毕业日期"}},[a("el-date-picker",{staticClass:"width-control",attrs:{type:"date",placeholder:"请录入"},model:{value:e.form.graduationDate,callback:function(t){e.$set(e.form,"graduationDate",t)},expression:"form.graduationDate"}})],1),a("el-form-item",{attrs:{label:"职位"}},[a("el-select",{staticStyle:{width:"200px"},model:{value:e.form.position,callback:function(t){e.$set(e.form,"position",t)},expression:"form.position"}},e._l(e.positionList,function(e,t){return a("el-option",{key:t,attrs:{label:e.dicValue,value:e.dicCode}})}),1)],1),a("el-form-item",{attrs:{label:"岗位"}},[a("el-select",{staticStyle:{width:"200px"},model:{value:e.form.post,callback:function(t){e.$set(e.form,"post",t)},expression:"form.post"}},e._l(e.postList,function(e,t){return a("el-option",{key:t,attrs:{label:e.dicValue,value:e.dicCode}})}),1)],1),a("el-form-item",{attrs:{label:"在职状态"}},[a("el-select",{staticStyle:{width:"200px"},model:{value:e.form.status,callback:function(t){e.$set(e.form,"status",t)},expression:"form.status"}},e._l(e.statusList,function(e,t){return a("el-option",{key:t,attrs:{label:e.dicValue,value:e.dicCode}})}),1)],1),a("el-form-item",{attrs:{label:"入司日期"}},[a("el-date-picker",{staticClass:"width-control",attrs:{type:"date",placeholder:"请录入"},model:{value:e.form.entryDate,callback:function(t){e.$set(e.form,"entryDate",t)},expression:"form.entryDate"}})],1),a("el-form-item",{attrs:{label:"离司日期"}},[a("el-date-picker",{staticClass:"width-control",attrs:{type:"date",placeholder:"请录入"},model:{value:e.form.leaveDate,callback:function(t){e.$set(e.form,"leaveDate",t)},expression:"form.leaveDate"}})],1),a("el-form-item",{attrs:{label:"所属部门"}},[a("el-select",{staticStyle:{width:"200px"},model:{value:e.form.deptId,callback:function(t){e.$set(e.form,"deptId",t)},expression:"form.deptId"}},e._l(e.deptList,function(e,t){return a("el-option",{key:t,attrs:{label:e.label,value:e.value}})}),1)],1),a("el-form-item",{attrs:{label:"系统权限",prop:"jurisdiction",required:""}},[a("el-select",{staticStyle:{width:"200px"},model:{value:e.form.jurisdiction,callback:function(t){e.$set(e.form,"jurisdiction",t)},expression:"form.jurisdiction"}},e._l(e.sysPowerList,function(e,t){return a("el-option",{key:t,attrs:{label:e.dicValue,value:e.dicCode}})}),1)],1)],1),"new"==e.status?a("el-button",{attrs:{type:"primary",disabled:e.disableStatus},on:{click:function(t){return e.newOrUptate("new")}}},[e._v("添加")]):a("el-button",{attrs:{type:"primary",disabled:e.disableStatus},on:{click:function(t){return e.newOrUptate("update")}}},[e._v("更新")]),a("el-button",{attrs:{type:"success",disabled:!e.disableStatus},on:{click:e.editHandle}},[e._v("编辑")]),a("el-button",{attrs:{type:"danger"},on:{click:e.cancel}},[e._v("取消")])],1)])},o=[],i=(a("38f0"),a("a1bf"),a("e5df"),a("aa7b"),a("b328"),a("21f4")),l={data:function(){return{form:{},rules:{name:[{required:!0,message:"请输入必填项",trigger:"blur"}],idNo:[{required:!0,message:"请输入必填项",trigger:"blur"}],companyEmail:[{required:!0,message:"请输入必填项",trigger:"blur"}],mobileNo:[{required:!0,message:"请输入必填项",trigger:"blur"}],jurisdiction:[{required:!0,message:"请输入必填项",trigger:"blur"}]},deptList:[],sexList:[],marrigeList:[],educationList:[],positionList:[],statusList:[],postList:[],sysPowerList:[],projectInfo:{},perId:null,status:null}},methods:{editHandle:function(){this.status="edit"},transReqData:function(e){var t="";for(var a in e)t+=encodeURIComponent(a)+"="+encodeURIComponent(e[a])+"&";return t},nullFilter:function(e){var t={};for(var a in e)null!=e[a]&&"password"!==a&&(t[a]=e[a]);return t},newOrUptate:function(e){var t=this;this.$refs["form"].validate(function(a){if(a){var r="new"===e?t.$api.employee.adduser:t.$api.employee.updatebyidno,o=t.nullFilter(t.form);console.log(o),t.$axios.postForm(r,o).then(function(e){200===e.code?(t.$message.success("员工信息添加成功"),t.$router.back(-1)):t.$message.error(e.data.errorMessage)}).catch(function(e){console.log(e),t.$message.error(e.errorMessage)})}})},deptListQuery:function(){var e=this;this.$axios.get(this.$api.department.findAll).then(function(t){if(200==t.code){var a=[],r=t.data.data;r.forEach(function(e){a.push({label:e.deptName,value:e.deptId})}),e.deptList=a}else e.$message.error("部门列表数据查询失败: "+t.message)}).catch(function(e){})},initDictList:function(){var e=this;Object(i["a"])("sex").then(function(t){var a=t.data;200===a.code?e.sexList=a.data.res:e.sexList=[]}),Object(i["a"])("MARRIAGE_STATUS").then(function(t){var a=t.data;200===a.code?e.marrigeList=a.data.res:e.marrigeList=[]}),Object(i["a"])("EDUCATION").then(function(t){var a=t.data;200===a.code?e.educationList=a.data.res:e.educationList=[]}),Object(i["a"])("POSITION").then(function(t){var a=t.data;200===a.code?e.positionList=a.data.res:e.positionList=[]}),Object(i["a"])("STATUS").then(function(t){var a=t.data;200===a.code?e.statusList=a.data.res:e.statusList=[]}),Object(i["a"])("POST").then(function(t){var a=t.data;200===a.code?e.postList=a.data.res:e.postList=[]}),Object(i["a"])("SYS_POWER").then(function(t){var a=t.data;200===a.code?e.sysPowerList=a.data.res:e.sysPowerList=[]})},cancel:function(){this.$router.back(-1)},employeeInfoQuery:function(e){var t=this;this.$axios.get(this.$api.employee.selectpersonnel+"?perId="+e).then(function(e){200===e.code&&(t.form=e.data.data)})}},computed:{disableStatus:function(){return"showdetail"===this.status}},mounted:function(){this.perId=this.$route.params.perId,this.status=this.$route.params.status,this.deptListQuery(),this.initDictList(),null!=this.perId&&this.employeeInfoQuery(this.perId)}},s=l,n=(a("72d4"),a("620d")),c=Object(n["a"])(s,r,o,!1,null,"5f059302",null);t["default"]=c.exports},fe53:function(e,t,a){}}]);