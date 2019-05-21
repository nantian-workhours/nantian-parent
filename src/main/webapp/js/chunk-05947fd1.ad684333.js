(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-05947fd1"],{"1e45":function(t,e,r){"use strict";var a=r("476f"),o=r.n(a);o.a},"476f":function(t,e,r){},e37c:function(t,e,r){"use strict";r.r(e);var a=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"table"},[r("div",{staticClass:"crumbs"},[r("el-breadcrumb",{attrs:{separator:"/"}},[r("el-breadcrumb-item",[r("i",{staticClass:"el-icon-lx-remind"}),t._v(" 工时管理")]),r("el-breadcrumb-item",[t._v(" 异议处理")])],1)],1),r("div",{staticClass:"container"},[r("el-form",{attrs:{inline:!0,model:t.queryForm,"label-width":"80px"}},[r("el-form-item",{attrs:{label:"申请人"}},[r("el-input",{attrs:{clearable:"",placeholder:"请输入"},model:{value:t.queryForm.userName,callback:function(e){t.$set(t.queryForm,"userName",e)},expression:"queryForm.userName"}})],1),r("el-form-item",{attrs:{label:"申请日期"}},[r("el-date-picker",{attrs:{type:"date",clearable:"",placeholder:"请选择日期"},model:{value:t.queryForm.applyDateStr,callback:function(e){t.$set(t.queryForm,"applyDateStr",e)},expression:"queryForm.applyDateStr"}})],1),r("el-form-item",[r("el-button",{attrs:{type:"primary"},on:{click:t.queryFn}},[t._v("查询")]),r("el-button",{attrs:{type:"danger"},on:{click:function(e){t.showObjectionDialog=!0}}},[t._v("异议申请")])],1)],1),r("el-table",{staticClass:"table",attrs:{data:t.tableData,border:""}},[r("el-table-column",{attrs:{prop:"userName",label:"申请人"}}),r("el-table-column",{attrs:{prop:"userName",label:"申请工时",formatter:t.applyTypeFmt,width:"300"}}),r("el-table-column",{attrs:{prop:"workDate",label:"异议日期",formatter:t.dateFmt}}),r("el-table-column",{attrs:{prop:"applyDate",label:"申请日期",formatter:t.dateFmt}}),r("el-table-column",{attrs:{prop:"errDescribe",label:"申请理由"}}),r("el-table-column",{attrs:{prop:"applyStatus",label:"处理状态",formatter:t.statusFmt}}),r("el-table-column",{attrs:{label:"操作",width:"180",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return["R"===e.row.applyStatus?r("el-button",{attrs:{type:"text",icon:"el-icon-edit"},on:{click:function(r){return t.beginAudit(e.row)}}},[t._v("审核")]):r("span",[t._v("-")])]}}])})],1),r("el-dialog",{attrs:{title:"异议申请",visible:t.showObjectionDialog},on:{"update:visible":function(e){t.showObjectionDialog=e}}},[r("el-form",{attrs:{model:t.objectionForm}},[r("el-form-item",{attrs:{label:"申请人","label-width":t.formLabelWidth}},[r("el-input",{staticStyle:{width:"220px"},attrs:{readonly:""},model:{value:t.objectionForm.userName,callback:function(e){t.$set(t.objectionForm,"userName",e)},expression:"objectionForm.userName"}}),t._v(" 后续自动带入当前登录的用户名\r\n                ")],1),r("el-form-item",{attrs:{label:"异议日期","label-width":t.formLabelWidth}},[r("el-date-picker",{attrs:{type:"date",placeholder:"选择日期"},model:{value:t.objectionForm.workDateStr,callback:function(e){t.$set(t.objectionForm,"workDateStr",e)},expression:"objectionForm.workDateStr"}}),t._v(" \r\n                    "),r("el-button",{attrs:{type:"primary"},on:{click:t.queryHours}},[t._v("查询")])],1),r("el-form-item",{attrs:{label:"当天工时","label-width":t.formLabelWidth}},[r("el-row",{attrs:{gutter:24}},[r("el-col",{attrs:{span:5,align:"left"}},[r("el-tag",{attrs:{type:"primary"}},[t._v("正常工时："+t._s(t.objectionForm.normalHours)+"H")])],1),r("el-col",{attrs:{span:5}},[r("el-tag",{attrs:{type:"success"}},[t._v("加班工时："+t._s(t.objectionForm.workHours)+"H")])],1),r("el-col",{attrs:{span:5}},[r("el-tag",{attrs:{type:"danger"}},[t._v("请假工时："+t._s(t.objectionForm.leaveHours)+"H")])],1)],1)],1),r("el-form-item",{attrs:{label:"申请工时","label-width":t.formLabelWidth}},[r("p",[t._v("正常工时 "),r("el-input-number",{attrs:{min:1,max:10,size:"mini","controls-position":"right"},model:{value:t.objectionForm.normalHoursStr,callback:function(e){t.$set(t.objectionForm,"normalHoursStr",e)},expression:"objectionForm.normalHoursStr"}}),t._v(" H")],1),r("p",[t._v("加班工时 "),r("el-input-number",{attrs:{min:1,max:10,size:"mini","controls-position":"right"},model:{value:t.objectionForm.workHoursStr,callback:function(e){t.$set(t.objectionForm,"workHoursStr",e)},expression:"objectionForm.workHoursStr"}}),t._v(" H")],1),r("p",[t._v("请假工时 "),r("el-input-number",{attrs:{min:1,max:10,size:"mini","controls-position":"right"},model:{value:t.objectionForm.leaveHoursStr,callback:function(e){t.$set(t.objectionForm,"leaveHoursStr",e)},expression:"objectionForm.leaveHoursStr"}}),t._v(" H")],1)]),r("el-form-item",{attrs:{label:"申请理由","label-width":t.formLabelWidth}},[r("el-input",{attrs:{type:"textarea"},model:{value:t.objectionForm.errDescribe,callback:function(e){t.$set(t.objectionForm,"errDescribe",e)},expression:"objectionForm.errDescribe"}})],1),r("el-form-item",{attrs:{label:"附件","label-width":t.formLabelWidth}},[r("el-upload",{staticClass:"upload-demo",attrs:{action:"","list-type":"picture"}},[r("el-button",{attrs:{size:"small",type:"primary"}},[t._v("点击上传")]),r("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("只能上传jpg/png文件，且不超过500kb")])],1)],1)],1),r("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[r("el-button",{on:{click:function(e){t.showObjectionDialog=!1}}},[t._v("取 消")]),r("el-button",{attrs:{type:"primary"},on:{click:function(e){t.showObjectionDialog=!1}}},[t._v("确 定")])],1)],1),r("el-dialog",{attrs:{title:"异议审核",visible:t.showAuditDialog},on:{"update:visible":function(e){t.showAuditDialog=e}}},[r("el-form",{ref:"auditForm",attrs:{model:t.auditForm,rules:t.rules}},[r("el-form-item",{attrs:{label:"异议日期","label-width":t.formLabelWidth}},[r("el-input",{attrs:{type:"input",value:"2019-01-23",readonly:""}})],1),r("el-form-item",{attrs:{label:"当天工时","label-width":t.formLabelWidth}},[r("el-row",{attrs:{gutter:24}},[r("el-col",{attrs:{span:5,align:"left"}},[r("el-tag",{attrs:{type:"primary"}},[t._v("正常工时："+t._s(t.auditForm.normalHours)+"H")])],1),r("el-col",{attrs:{span:5}},[r("el-tag",{attrs:{type:"success"}},[t._v("加班工时："+t._s(t.auditForm.workHours)+"H")])],1),r("el-col",{attrs:{span:5}},[r("el-tag",{attrs:{type:"danger"}},[t._v("请假工时："+t._s(t.auditForm.leaveHours)+"H")])],1)],1)],1),r("el-form-item",{attrs:{label:"申请工时","label-width":t.formLabelWidth}},[r("el-row",{attrs:{gutter:24}},[r("el-col",{attrs:{span:5,align:"left"}},[r("el-tag",{attrs:{type:"primary"}},[t._v("正常工时："+t._s(t.auditForm.leaveHoursStr)+"H")])],1),r("el-col",{attrs:{span:5}},[r("el-tag",{attrs:{type:"success"}},[t._v("加班工时："+t._s(t.auditForm.leaveHoursStr)+"H")])],1),r("el-col",{attrs:{span:5}},[r("el-tag",{attrs:{type:"danger"}},[t._v("请假工时："+t._s(t.auditForm.leaveHoursStr)+"H")])],1)],1)],1),r("el-form-item",{attrs:{label:"申请理由","label-width":t.formLabelWidth}},[r("el-input",{attrs:{type:"textarea",readonly:""},model:{value:t.auditForm.errDescribe,callback:function(e){t.$set(t.auditForm,"errDescribe",e)},expression:"auditForm.errDescribe"}})],1),r("el-form-item",{attrs:{label:"附件","label-width":t.formLabelWidth}},[r("img",{attrs:{src:t.auditForm.filePath,alt:""}})]),r("el-form-item",{attrs:{label:"审核处理","label-width":t.formLabelWidth,prop:"applyStatus",required:""}},[r("el-select",{attrs:{placeholder:"请选择"},model:{value:t.auditForm.applyStatus,callback:function(e){t.$set(t.auditForm,"applyStatus",e)},expression:"auditForm.applyStatus"}},[r("el-option",{attrs:{label:"通过",value:"Y"}}),r("el-option",{attrs:{label:"退回",value:"N"}})],1)],1),r("el-form-item",{attrs:{label:"退回原因","label-width":t.formLabelWidth}},[r("el-input",{attrs:{type:"textarea"},model:{value:t.auditForm.approveOpn,callback:function(e){t.$set(t.auditForm,"approveOpn",e)},expression:"auditForm.approveOpn"}})],1)],1),r("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[r("el-button",{on:{click:function(e){t.showAuditDialog=!1}}},[t._v("取消")]),r("el-button",{attrs:{type:"primary"},on:{click:t.auditSubmit}},[t._v("提交")])],1)],1)],1)])},o=[],l=(r("0dc2"),r("d4aa"),{data:function(){return{tableData:[],queryForm:{},objectionForm:{userName:"陆佰"},auditForm:{},showObjectionDialog:!1,showAuditDialog:!1,formLabelWidth:"120px",rules:{applyStatus:[{required:!0,message:"请输入必填项",trigger:"blur"}]}}},mounted:function(){this.findAll()},methods:{auditSubmit:function(){var t=this;this.$refs["auditForm"].validate(function(e){if(e){var r={applySeq:t.auditForm.applySeq,applyStatus:t.auditForm.applyStatus,approveOpn:t.auditForm.approveOpn};t.$axios.postForm(t.$api.objection.applySubmit,r).then(function(e){200===e.code?(t.$message.success("审核成功"),t.showAuditDialog=!1,t.findAll()):t.$message.error("审核失败: "+e.data.error)})}})},beginAudit:function(t){this.auditForm=t,delete this.auditForm.applyStatus,this.showAuditDialog=!0},queryHours:function(){var t=this,e={userName:this.objectionForm.userName,applyDateStr:this.objectionForm.applyDateStr};this.$axios.postForm(this.$api.objection.findAll,e).then(function(e){if(200===e.code){var r=e.data.data;t.objectionForm={normalHoursStr:r.normalHoursStr,workHoursStr:r.workHoursStr,leaveHoursStr:r.leaveHoursStr,normalHours:r.normalHours,workHours:r.workHours,leaveHours:r.leaveHours}}else t.$message.error("查询工时信息失败")})},statusFmt:function(t,e,r){var a={N:"退回",R:"审核中",Y:"通过"};return a[r]},dateFmt:function(t,e,r){return null!=r?r.split(" ")[0]:"-"},applyTypeFmt:function(t){var e=t.normalHours,r=t.workHours,a=t.leaveHours;return"正常工时：".concat(e,"；加班工时：").concat(r,"；请假工时：").concat(a)},queryFn:function(){this.queryForm.applyDateStr=this.formatDate(this.queryForm.applyDateStr,"yyyy-MM-dd"),this.findAll(this.queryForm)},findAll:function(t){var e=this,r=t||{};this.$axios.postForm(this.$api.objection.findAll,r).then(function(t){200===t.code?e.tableData=t.data.data:e.$message.error("查询工时信息失败")})}}}),i=l,s=(r("1e45"),r("620d")),n=Object(s["a"])(i,a,o,!1,null,"6c4c9d3a",null);e["default"]=n.exports}}]);