(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-ce453958"],{"08fe":function(t,e,l){},"4edb":function(t,e,l){"use strict";l.r(e);var a=function(){var t=this,e=t.$createElement,l=t._self._c||e;return l("div",{staticClass:"table"},[l("div",{staticClass:"crumbs"},[l("el-breadcrumb",{attrs:{separator:"/"}},[l("el-breadcrumb-item",[l("i",{staticClass:"el-icon-lx-remind"}),t._v(" 请假管理")]),l("el-breadcrumb-item",[t._v(" 请假查询")])],1)],1),l("div",{staticClass:"container"},[l("el-form",{staticClass:"demo-form-inline",attrs:{inline:!0,model:t.formInline}},[l("el-form-item",{attrs:{label:"姓名"}},[l("el-input",{attrs:{placeholder:"姓名"},model:{value:t.formInline.user,callback:function(e){t.$set(t.formInline,"user",e)},expression:"formInline.user"}})],1),l("el-form-item",{attrs:{label:"所属部门"}},[l("el-select",{attrs:{placeholder:"请选择"},model:{value:t.formInline.department,callback:function(e){t.$set(t.formInline,"department",e)},expression:"formInline.department"}},[l("el-option",{attrs:{label:"资源二中心一部",value:"01"}}),l("el-option",{attrs:{label:"资源二中心二部",value:"02"}})],1)],1),l("el-form-item",{attrs:{label:"年度"}},[l("el-date-picker",{attrs:{type:"month",placeholder:"请选择年份"},model:{value:t.date,callback:function(e){t.date=e},expression:"date"}})],1),l("el-form-item",[l("el-button",{attrs:{type:"primary"}},[t._v("查询")])],1),l("el-form-item",[l("el-button",{attrs:{type:"danger"},on:{click:function(e){t.dialogFormVisible=!0}}},[t._v("请假申请")])],1)],1),l("el-table",{staticClass:"table",attrs:{data:t.tableData,border:""}},[l("el-table-column",{attrs:{prop:"name",label:"姓名",width:"120"}}),l("el-table-column",{attrs:{prop:"year",label:"年份",width:"120"}}),l("el-table-column",{attrs:{prop:"date",label:"请假日期",sortable:"",width:"120"}}),l("el-table-column",{attrs:{prop:"type",label:"请假类型",width:"80"}}),l("el-table-column",{attrs:{prop:"explain",label:"说明"}}),l("el-table-column",{attrs:{prop:"vacation",label:"年假天数",width:"120"}}),l("el-table-column",{attrs:{prop:"vacation",label:"调休天数",width:"120"}}),l("el-table-column",{attrs:{fixed:"right",label:"审核",width:"120"},scopedSlots:t._u([{key:"default",fn:function(e){return[l("el-button",{staticClass:"el-icon-lx-roundcheck",attrs:{type:"text",size:"small"}},[t._v(" 通过")]),l("el-button",{staticClass:"red el-icon-lx-exit",attrs:{type:"text",size:"small"}},[t._v("退回")])]}}])})],1),l("el-dialog",{attrs:{title:"请假申请",visible:t.dialogFormVisible},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[l("el-form",{attrs:{model:t.form}},[l("el-form-item",{attrs:{label:"所属部门","label-width":t.formLabelWidth}},[l("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.department,callback:function(e){t.$set(t.form,"department",e)},expression:"form.department"}},[l("el-option",{attrs:{label:"资源二中心一部",value:"01"}}),l("el-option",{attrs:{label:"资源二中心二部",value:"02"}})],1)],1),l("el-form-item",{attrs:{label:"请假时间","label-width":t.formLabelWidth}},[l("el-col",{attrs:{span:6}},[l("el-date-picker",{staticStyle:{width:"100%"},attrs:{type:"date",placeholder:"开始日期"},model:{value:t.form.startDate,callback:function(e){t.$set(t.form,"startDate",e)},expression:"form.startDate"}})],1),l("el-col",{staticClass:"inline",staticStyle:{"text-align":"center"},attrs:{span:1}},[t._v(" -")]),l("el-col",{attrs:{span:6}},[l("el-date-picker",{staticStyle:{width:"100%"},attrs:{type:"date",placeholder:"结束日期"},model:{value:t.form.endDate,callback:function(e){t.$set(t.form,"endDate",e)},expression:"form.endDate"}})],1)],1),l("el-form-item",{attrs:{label:"请假类型","label-width":t.formLabelWidth}},[l("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.type,callback:function(e){t.$set(t.form,"type",e)},expression:"form.type"}},[l("el-option",{attrs:{label:"调休",value:"01"}}),l("el-option",{attrs:{label:"病假",value:"02"}}),l("el-option",{attrs:{label:"事假",value:"03"}})],1)],1),l("el-form-item",{attrs:{label:"请假内容","label-width":t.formLabelWidth}},[l("el-input",{attrs:{type:"textarea"},model:{value:t.form.desc,callback:function(e){t.$set(t.form,"desc",e)},expression:"form.desc"}})],1)],1),l("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[l("el-button",{on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("取 消")]),l("el-button",{attrs:{type:"primary"},on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("确 定")])],1)],1)],1)])},r=[],o=l("d4aa"),i={name:"basetable",data:function(){return{date:"",tableData:[],formInline:{user:"",time:"",department:"",type:""},dialogFormVisible:!1,form:{startDate:"",endDate:"",region:"",desc:""},formLabelWidth:"120px"}},created:function(){this.getData()},methods:{getData:function(){var t=this;this.$axios.post(o["a"].holiday.query).then(function(e){console.log(e.data),t.tableData=e.data.list})},formatter:function(t,e){return"-"}}},s=i,n=(l("5c43"),l("5be0")),c=Object(n["a"])(s,a,r,!1,null,"6413fbfa",null);e["default"]=c.exports},"5c43":function(t,e,l){"use strict";var a=l("08fe"),r=l.n(a);r.a}}]);