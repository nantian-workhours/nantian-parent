(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0cbae1"],{"4b63":function(e,t,l){"use strict";l.r(t);var o=function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("div",{staticClass:"table"},[l("div",{staticClass:"crumbs"},[l("el-breadcrumb",{attrs:{separator:"/"}},[l("el-breadcrumb-item",[l("i",{staticClass:"el-icon-lx-remind"}),e._v(" 员工管理")]),l("el-breadcrumb-item",[e._v(" 所在项目")])],1)],1),l("div",{staticClass:"container"},[l("el-form",{attrs:{inline:!0}},[l("el-form-item",{attrs:{label:"客户类别"}},[l("el-select",{attrs:{placeholder:"请选择"},model:{value:e.queryForm.custType,callback:function(t){e.$set(e.queryForm,"custType",t)},expression:"queryForm.custType"}},e._l(e.dictObj["cust"],function(e,t){return l("el-option",{key:t,attrs:{label:e.dicValue,value:e.dicCode}})}),1)],1),l("el-form-item",{attrs:{label:"项目名称"}},[l("el-select",{attrs:{placeholder:"请选择"},model:{value:e.queryForm.projectNumber,callback:function(t){e.$set(e.queryForm,"projectNumber",t)},expression:"queryForm.projectNumber"}},e._l(e.projectList,function(e,t){return l("el-option",{key:t,attrs:{label:e.projectName,value:e.projectNumber}})}),1)],1),l("el-form-item",{attrs:{label:"员工姓名"}},[l("el-input",{attrs:{placeholder:"员工姓名"},model:{value:e.queryForm.name,callback:function(t){e.$set(e.queryForm,"name",t)},expression:"queryForm.name"}})],1),l("el-form-item",[l("el-button",{attrs:{type:"primary"}},[e._v("查询")]),l("el-button",{attrs:{type:"danger"},on:{click:function(t){e.dialogFormVisible=!0}}},[e._v("关联员工")])],1)],1),l("el-table",{staticClass:"table",attrs:{data:e.proData,border:"",height:"260"}},[l("el-table-column",{attrs:{prop:"name",label:"员工姓名"}}),l("el-table-column",{attrs:{prop:"idno",label:"身份证号"}}),l("el-table-column",{attrs:{prop:"dept",label:"部门"}}),l("el-table-column",{attrs:{prop:"relatepro",label:"客户类别"}}),l("el-table-column",{attrs:{prop:"proname",label:"项目名称"}}),l("el-table-column",{attrs:{prop:"worktype",label:"工作类别"}}),l("el-table-column",{attrs:{prop:"level",label:"技术等级"}}),l("el-table-column",{attrs:{prop:"starttime",label:"开始日期"}}),l("el-table-column",{attrs:{prop:"endtime",label:"结束日期"}}),l("el-table-column",{attrs:{prop:"status",label:"在场状态"}}),l("el-table-column",{attrs:{label:"操作",width:"180",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-button",{attrs:{type:"text",icon:"el-icon-edit"}},[e._v("编辑")])]}}])})],1)],1),l("el-dialog",{attrs:{title:"添加员工",visible:e.dialogFormVisible},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[l("el-form",{staticStyle:{width:"600px"},attrs:{model:e.projectForm,"label-width":e.formLabelWidth}},[l("el-form-item",{attrs:{label:"员工姓名"}},[l("el-input",{model:{value:e.projectForm.name,callback:function(t){e.$set(e.projectForm,"name",t)},expression:"projectForm.name"}})],1),l("el-form-item",{attrs:{label:"身份证号"}},[l("el-input",{model:{value:e.projectForm.idno,callback:function(t){e.$set(e.projectForm,"idno",t)},expression:"projectForm.idno"}})],1),l("el-form-item",{attrs:{label:"客户类别"}},[l("el-select",{attrs:{placeholder:"请选择"},model:{value:e.projectForm.custType,callback:function(t){e.$set(e.projectForm,"custType",t)},expression:"projectForm.custType"}},e._l(e.dictObj["cust"],function(e,t){return l("el-option",{key:t,attrs:{label:e.dicValue,value:e.dicCode}})}),1)],1),l("el-form-item",{attrs:{label:"项目名称"}},[l("el-select",{attrs:{placeholder:"请选择"},model:{value:e.projectForm.proname,callback:function(t){e.$set(e.projectForm,"proname",t)},expression:"projectForm.proname"}},e._l(e.projectList,function(e,t){return l("el-option",{key:t,attrs:{label:e.projectName,value:e.projectNumber}})}),1)],1),l("el-form-item",{attrs:{label:"工作类别"}},[l("el-select",{attrs:{placeholder:"请选择"},model:{value:e.projectForm.workType,callback:function(t){e.$set(e.projectForm,"workType",t)},expression:"projectForm.workType"}},e._l(e.dictObj["wt"],function(e,t){return l("el-option",{key:t,attrs:{label:e.dicValue,value:e.dicCode}})}),1)],1),l("el-form-item",{attrs:{label:"技术等级"}},[l("el-select",{attrs:{placeholder:"请选择"},model:{value:e.projectForm.level,callback:function(t){e.$set(e.projectForm,"level",t)},expression:"projectForm.level"}},e._l(e.dictObj["dc"],function(e,t){return l("el-option",{key:t,attrs:{label:e.dicValue,value:e.dicCode}})}),1)],1),l("el-form-item",{attrs:{label:"起始日期"}},[l("el-date-picker",{attrs:{type:"date",placeholder:"开始日期"},model:{value:e.projectForm.startDate,callback:function(t){e.$set(e.projectForm,"startDate",t)},expression:"projectForm.startDate"}}),e._v(" -\r\n                "),l("el-date-picker",{attrs:{type:"date",placeholder:"结束日期"},model:{value:e.projectForm.endDate,callback:function(t){e.$set(e.projectForm,"endDate",t)},expression:"projectForm.endDate"}})],1)],1),l("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[l("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("取 消")]),l("el-button",{attrs:{type:"primary"},on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("确 定")])],1)],1)],1)},r=[],a=(l("58b5"),l("a1bf"),l("e5df"),l("aa7b"),l("b328"),{data:function(){return{queryForm:{},form:{},projectForm:{},formLabelWidth:"120px",dialogFormVisible:!1,proData:[],inputDisable:!1,projectList:[],dictObj:{}}},created:function(){this.initDictData()},methods:{initDictData:function(){var e=this;this.dictObj=this.$store.state.dict.dictObj,this.$axios.postForm(this.$api.customer.findAll).then(function(t){200===t.code&&(e.projectList=t.data.data)})},addAlias:function(){this.dialogFormVisible=!0,this.inputDisable=!1,this.projectForm={}},editAlias:function(e){this.inputDisable=!0;var t=e.name,l=e.idno,o=e.alias,r=e.group;this.projectForm.name=t,this.projectForm.idno=l,this.projectForm.alias=o,this.projectForm.group=r,this.dialogFormVisible=!0},delAlias:function(e){this.$confirm("确定要删除吗?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){}).catch(function(){})}}}),i=a,c=l("620d"),s=Object(c["a"])(i,o,r,!1,null,"5b5255fb",null);t["default"]=s.exports}}]);