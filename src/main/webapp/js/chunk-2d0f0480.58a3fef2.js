(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0f0480"],{"9c66":function(e,t,a){"use strict";a.r(t);var d=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"table"},[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-lx-settings"}),e._v(" 系统管理")]),a("el-breadcrumb-item",[e._v(" 参数管理")])],1)],1),a("div",{staticClass:"container"},[a("el-form",{staticClass:"demo-form-inline",attrs:{inline:!0,model:e.queryForm}},[a("el-form-item",{attrs:{label:"参数类别"}},[a("el-select",{attrs:{clearable:"",filterable:!0},model:{value:e.queryForm.typeCode,callback:function(t){e.$set(e.queryForm,"typeCode",t)},expression:"queryForm.typeCode"}},e._l(e.typeData,function(e){return a("el-option",{key:e.typeCode,attrs:{label:e.typeName,value:e.typeCode}})}),1)],1),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:e.queryByType}},[e._v("查询")]),a("el-button",{attrs:{type:"success"},on:{click:function(t){e.dialogTypeAdd=!0}}},[e._v("添加类别")]),a("el-button",{attrs:{type:"danger"},on:{click:function(t){e.dialogSubTypeAdd=!0}}},[e._v("添加类别子项")])],1)],1),a("el-table",{staticClass:"table mgb10",attrs:{data:e.tableData,border:""}},[a("el-table-column",{attrs:{prop:"dicType",label:"类别编码"}}),a("el-table-column",{attrs:{prop:"dicTypeChn",label:"类别名称",formatter:e.typeChnFmt}}),a("el-table-column",{attrs:{prop:"dicCode",label:"子项编码",formatter:e.defaultFmt}}),a("el-table-column",{attrs:{prop:"dicValue",label:"子项值",formatter:e.defaultFmt}}),a("el-table-column",{attrs:{label:"操作",width:"320",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{staticClass:"red",attrs:{type:"text",icon:"el-icon-remove"},on:{click:function(a){return e.typeDel(t.$index,t.row)}}},[e._v("删除类别")]),t.row.dicCode?a("el-button",{staticClass:"green",attrs:{type:"text",icon:"el-icon-delete"},on:{click:function(a){return e.subTypeDel(t.$index,t.row)}}},[e._v("删除子类")]):e._e()]}}])})],1),a("el-dialog",{attrs:{title:"添加类别",visible:e.dialogTypeAdd},on:{"update:visible":function(t){e.dialogTypeAdd=t}}},[a("el-form",{ref:"typeAddForm",staticStyle:{width:"600px"},attrs:{model:e.typeAddForm,rules:e.typeAddFormRules,"label-width":e.formLabelWidth}},[a("el-form-item",{attrs:{label:"类别编号",prop:"typeCode"}},[a("el-input",{attrs:{placeholder:"格式: WORK_TYPE"},model:{value:e.typeAddForm.typeCode,callback:function(t){e.$set(e.typeAddForm,"typeCode",t)},expression:"typeAddForm.typeCode"}})],1),a("el-form-item",{attrs:{label:"类别名称",prop:"typeName"}},[a("el-input",{attrs:{placeholder:"格式: 类别名称"},model:{value:e.typeAddForm.typeName,callback:function(t){e.$set(e.typeAddForm,"typeName",t)},expression:"typeAddForm.typeName"}})],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.dialogTypeAdd=!1}}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:e.typeAdd}},[e._v("确 定")])],1)],1),a("el-dialog",{attrs:{title:"添加类别子项",visible:e.dialogSubTypeAdd},on:{"update:visible":function(t){e.dialogSubTypeAdd=t}}},[a("el-form",{ref:"subTypeAddForm",staticStyle:{width:"600px"},attrs:{model:e.subTypeAddForm,rules:e.subTypeAddFormRules,"label-width":e.formLabelWidth}},[a("el-form-item",{attrs:{label:"参数类别",prop:"dicType"}},[a("el-select",{attrs:{filterable:!0},model:{value:e.subTypeAddForm.dicType,callback:function(t){e.$set(e.subTypeAddForm,"dicType",t)},expression:"subTypeAddForm.dicType"}},e._l(e.typeData,function(e){return a("el-option",{key:e.typeCode,attrs:{label:e.typeName,value:e.typeCode}})}),1)],1),a("el-form-item",{attrs:{label:"类别子项编码",prop:"dicCode"}},[a("el-input",{attrs:{placeholder:"格式: M/F"},model:{value:e.subTypeAddForm.dicCode,callback:function(t){e.$set(e.subTypeAddForm,"dicCode",t)},expression:"subTypeAddForm.dicCode"}})],1),a("el-form-item",{attrs:{label:"类别子项名称",prop:"dicValue"}},[a("el-input",{attrs:{placeholder:"格式: 男/女"},model:{value:e.subTypeAddForm.dicValue,callback:function(t){e.$set(e.subTypeAddForm,"dicValue",t)},expression:"subTypeAddForm.dicValue"}})],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.dialogSubTypeAdd=!1}}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:e.subTypeAdd}},[e._v("确 定")])],1)],1)],1)])},o=[],r=(a("81a9"),a("d4aa")),s=a("3ec5"),i=a.n(s),l=a("0b1b"),p={name:"basetable",mixins:[l["a"]],data:function(){return{queryForm:{},typeData:[{typeCode:"",typeName:""}],tableData:[],typeAddForm:{typeCode:"",typeName:""},subTypeAddForm:{dicType:"",dicCode:"",dicValue:""},typeAddFormRules:{typeCode:[{required:!0,message:"请填写类别编码",trigger:"change"}],typeName:[{required:!0,message:"请填写类别名称",trigger:"change"}]},subTypeAddFormRules:{dicType:[{required:!0,message:"请选择参数类别",trigger:"blur"}],dicCode:[{required:!0,message:"请填写子类编码",trigger:"blur"}],dicValue:[{required:!0,message:"请填写子类名称",trigger:"blur"}]},editFlag:!1,dialogTypeAdd:!1,dialogSubTypeAdd:!1,formLabelWidth:"120px"}},created:function(){this.initData()},methods:{queryByType:function(){var e=this,t=this.queryForm.typeCode;t?this.$axios.get(r["a"].params.subTypeQuery+"?dicType="+t).then(function(a){200===a.code?a.data.res.length?e.tableData=a.data.res:e.tableData=[{dicType:t}]:e.$message(a.message)}):this.initData()},initData:function(){var e=this;i.a.all([this.typeQuery(),this.subTypeQuery()]).then(i.a.spread(function(t,a){200===t.code&&200===a.code?(e.typeData=t.data.res,e.formatTableData(a.data.res,t.data.res)):(200!==t.code&&e.$message(t.message),200!==a.code&&e.$message(a.message))}))},formatTableData:function(e,t){if(!t.length)return e||[];var a=[],d=e.map(function(e){return e.dicType});t.forEach(function(e){-1===d.indexOf(e.typeCode)&&a.push({dicType:e.typeCode})}),a=a.concat(e),this.tableData=a},typeQuery:function(){return this.$axios.get(r["a"].params.typeQuery)},subTypeQuery:function(){return this.$axios.get(r["a"].params.subTypeQuery)},typeAdd:function(){var e=this;function t(){var e=this,t=this.typeAddForm,a={typeCode:t.typeCode,typeName:t.typeName};this.$axios.post(r["a"].params.typeAdd,a).then(function(t){200===t.code?(e.$message({message:"类别添加成功",type:"success"}),e.updateTable()):e.$message.error("类别添加失败"),e.dialogTypeAdd=!1})}this.$refs.typeAddForm.validate(function(a){a&&t.call(e)})},subTypeAdd:function(){var e=this;function t(){var e=this,t=this.subTypeAddForm;this.$axios.post(r["a"].params.subTypeAdd,t).then(function(t){200===t.code?(e.$message({message:"子类别添加成功",type:"success"}),e.updateTable(),e.updateDictData()):e.$message.error("子类别添加失败"),e.dialogSubTypeAdd=!1})}this.$refs.subTypeAddForm.validate(function(a){a&&t.call(e)})},typeDel:function(e,t){var a=this,d=t.dicType,o=t.dicCode;this.$confirm('本操作会删除类别 "'+t.dicType+'"及其所有子类, 确定要继续删除吗?',"提示").then(function(){a.deleteTypeRequest(r["a"].params.typeDelete+"?typeCode="+d),o&&a.deleteTypeRequest(r["a"].params.subTypeDeleteByDicType+"?dicType="+d)})},subTypeDel:function(e,t){var a=this,d=t.dicCode;this.$confirm('确定要进行删除子类 "'+d+'"吗?',"提示").then(function(){a.deleteTypeRequest(r["a"].params.subTypeDelete+"?dicCode="+d)})},deleteTypeRequest:function(e){var t=this;this.$axios.post(e).then(function(e){200===e.code?(t.$message({message:"删除成功",type:"success"}),t.updateTable(),t.updateDictData()):t.$message.error("删除失败")})},updateTable:function(){this.initData()},typeChnFmt:function(e,t){var a=e.dicType,d=this.typeData.filter(function(e){return e.typeCode===a});return d.length?d[0].typeName:"-"}},watch:{dialogTypeAdd:function(e){e&&this.$refs.typeAddForm&&this.$refs.typeAddForm.resetFields()},dialogSubTypeAdd:function(e){this.editFlag||e&&this.$refs.subTypeAddForm&&this.$refs.subTypeAddForm.resetFields()}}},n=p,u=a("305e"),c=Object(u["a"])(n,d,o,!1,null,"797c611b",null);t["default"]=c.exports}}]);