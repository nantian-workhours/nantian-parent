(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-3ab9e030"],{"32b7":function(t,e,l){"use strict";var a=l("415b"),r=l.n(a);r.a},"415b":function(t,e,l){},7159:function(t,e,l){t.exports=l.p+"img/img.146655c9.jpg"},e37c:function(t,e,l){"use strict";l.r(e);var a=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"table"},[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-lx-remind"}),t._v(" 工时管理")]),a("el-breadcrumb-item",[t._v(" 异议处理")])],1)],1),a("div",{staticClass:"container"},[a("el-form",{attrs:{inline:!0,model:t.form,"label-width":"80px"}},[a("el-form-item",{attrs:{label:"申请人"}},[a("el-input",{attrs:{placeholder:"请输入申请人姓名"}})],1),a("el-form-item",{attrs:{label:"申请日期"}},[a("el-date-picker",{staticStyle:{width:"140px"},attrs:{type:"date",placeholder:"申请日期"},model:{value:t.form.startDate,callback:function(e){t.$set(t.form,"startDate",e)},expression:"form.startDate"}})],1),a("el-form-item",[a("el-button",{attrs:{type:"primary"}},[t._v("查询")]),a("el-button",{attrs:{type:"danger"},on:{click:function(e){t.dialogFormVisible=!0}}},[t._v("异议申请")])],1)],1),a("el-table",{staticClass:"table",attrs:{data:t.data,border:""}},[a("el-table-column",{attrs:{prop:"name",label:"申请人",width:"120"}}),a("el-table-column",{attrs:{prop:"type",label:"申请类型",width:"100"}}),a("el-table-column",{attrs:{prop:"date",label:"异议日期",width:"120"}}),a("el-table-column",{attrs:{prop:"content",label:"申请理由"}}),a("el-table-column",{attrs:{prop:"date",label:"申请日期",width:"120"}}),a("el-table-column",{attrs:{prop:"progress",label:"处理状态",width:"100"}}),a("el-table-column",{attrs:{label:"操作",width:"180",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"text",icon:"el-icon-edit"},on:{click:function(e){t.auditFormVisible=!0}}},[t._v("审核")])]}}])})],1),a("el-dialog",{attrs:{title:"异议申请",visible:t.dialogFormVisible},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[a("el-form",{attrs:{model:t.form}},[a("el-form-item",{attrs:{label:"异议日期","label-width":t.formLabelWidth}},[a("el-date-picker",{attrs:{type:"date",placeholder:"选择日期"},model:{value:t.form.date,callback:function(e){t.$set(t.form,"date",e)},expression:"form.date"}})],1),a("el-form-item",{attrs:{label:"当天工时","label-width":t.formLabelWidth}},[a("el-row",{attrs:{gutter:24}},[a("el-col",{attrs:{span:5,align:"left"}},[a("el-tag",{attrs:{type:"primary"}},[t._v("正常工时：8H")])],1),a("el-col",{attrs:{span:5}},[a("el-tag",{attrs:{type:"success"}},[t._v("加班工时：2H")])],1),a("el-col",{attrs:{span:5}},[a("el-tag",{attrs:{type:"danger"}},[t._v("请假工时：0H")])],1)],1)],1),a("el-form-item",{attrs:{label:"申请工时","label-width":t.formLabelWidth}},[a("p",[t._v("正常工时 "),a("el-input-number",{attrs:{min:1,max:10,size:"mini","controls-position":"right"},model:{value:t.form.num1,callback:function(e){t.$set(t.form,"num1",e)},expression:"form.num1"}}),t._v(" H")],1),a("p",[t._v("加班工时 "),a("el-input-number",{attrs:{min:1,max:10,size:"mini","controls-position":"right"},model:{value:t.form.num2,callback:function(e){t.$set(t.form,"num2",e)},expression:"form.num2"}}),t._v(" H")],1),a("p",[t._v("请假工时 "),a("el-input-number",{attrs:{min:1,max:10,size:"mini","controls-position":"right"},model:{value:t.form.num3,callback:function(e){t.$set(t.form,"num3",e)},expression:"form.num3"}}),t._v(" H")],1)]),a("el-form-item",{attrs:{label:"申请理由","label-width":t.formLabelWidth}},[a("el-input",{attrs:{type:"textarea"},model:{value:t.form.desc,callback:function(e){t.$set(t.form,"desc",e)},expression:"form.desc"}})],1),a("el-form-item",{attrs:{label:"附件","label-width":t.formLabelWidth}},[a("el-upload",{staticClass:"upload-demo",attrs:{action:"","list-type":"picture"}},[a("el-button",{attrs:{size:"small",type:"primary"}},[t._v("点击上传")]),a("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("只能上传jpg/png文件，且不超过500kb")])],1)],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("确 定")])],1)],1),a("el-dialog",{attrs:{title:"异议审核",visible:t.auditFormVisible},on:{"update:visible":function(e){t.auditFormVisible=e}}},[a("el-form",{attrs:{model:t.formInline}},[a("el-form-item",{attrs:{label:"异议日期","label-width":t.formLabelWidth}},[a("el-input",{attrs:{type:"input",value:"2019-01-23",readonly:""}})],1),a("el-form-item",{attrs:{label:"当天工时","label-width":t.formLabelWidth}},[a("el-row",{attrs:{gutter:24}},[a("el-col",{attrs:{span:5,align:"left"}},[a("el-tag",{attrs:{type:"primary"}},[t._v("正常工时：8H")])],1),a("el-col",{attrs:{span:5}},[a("el-tag",{attrs:{type:"success"}},[t._v("加班工时：0H")])],1),a("el-col",{attrs:{span:5}},[a("el-tag",{attrs:{type:"danger"}},[t._v("请假工时：0H")])],1)],1)],1),a("el-form-item",{attrs:{label:"申请工时","label-width":t.formLabelWidth}},[a("el-row",{attrs:{gutter:24}},[a("el-col",{attrs:{span:5,align:"left"}},[a("el-tag",{attrs:{type:"primary"}},[t._v("正常工时：8H")])],1),a("el-col",{attrs:{span:5}},[a("el-tag",{attrs:{type:"success"}},[t._v("加班工时：3H")])],1),a("el-col",{attrs:{span:5}},[a("el-tag",{attrs:{type:"danger"}},[t._v("请假工时：0H")])],1)],1)],1),a("el-form-item",{attrs:{label:"申请理由","label-width":t.formLabelWidth}},[a("el-input",{attrs:{type:"textarea",value:"当天加班工时应为3小时，忘批准",readonly:""}})],1),a("el-form-item",{attrs:{label:"附件","label-width":t.formLabelWidth}},[a("img",{attrs:{src:l("7159"),alt:""}})]),a("el-form-item",{attrs:{label:"审核处理","label-width":t.formLabelWidth}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:t.formInline.auditType,callback:function(e){t.$set(t.formInline,"auditType",e)},expression:"formInline.auditType"}},[a("el-option",{attrs:{label:"通过",value:"zhonghang"}}),a("el-option",{attrs:{label:"不通过",value:"renshou"}})],1)],1),a("el-form-item",{attrs:{label:"不通过原因","label-width":t.formLabelWidth}},[a("el-input",{attrs:{type:"textarea"}})],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.auditFormVisible=!1}}},[t._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:function(e){t.auditFormVisible=!1}}},[t._v("确 定")])],1)],1)],1)])},r=[],i=l("d4aa"),o={data:function(){return{data:[],dialogFormVisible:!1,form:{region:"",date:"",desc:""},formInline:{auditType:""},formLabelWidth:"120px",auditFormVisible:!1}},mounted:function(){this.getData()},methods:{getData:function(){var t=this;this.$axios.post(i["a"].manhour.objection).then(function(e){t.data=e.data.list})}}},s=o,n=(l("32b7"),l("620d")),m=Object(n["a"])(s,a,r,!1,null,"ff615190",null);e["default"]=m.exports}}]);