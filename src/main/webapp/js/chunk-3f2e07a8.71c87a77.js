(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-3f2e07a8"],{"21f4":function(e,t,a){"use strict";a.d(t,"a",function(){return o});a("a1bf"),a("e5df"),a("aa7b"),a("b328");var n=a("caf6"),l=a.n(n),i=a("d4aa");function o(e){return l.a.get(i["a"].params.subTypeQuery+"?dicType="+e)}},"4e18":function(e,t,a){"use strict";var n=a("5ebb"),l=a.n(n);l.a},"5ebb":function(e,t,a){},c2f2:function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-lx-friend"}),e._v(" 员工管理")]),a("el-breadcrumb-item",[e._v(" 信息管理")])],1)],1),a("div",{staticClass:"container"},[a("el-form",{attrs:{inline:!0,model:e.form,"label-width":"80px"}},[a("el-form-item",{attrs:{label:"部门"}},[a("el-select",{attrs:{clearable:""},model:{value:e.form.deptId,callback:function(t){e.$set(e.form,"deptId",t)},expression:"form.deptId"}},e._l(e.deptList,function(e,t){return a("el-option",{key:t,attrs:{label:e.label,value:e.value}})}),1)],1),a("el-form-item",{attrs:{label:"员工姓名"}},[a("el-input",{attrs:{type:"input"}})],1),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:e.queryByIdAndName}},[e._v("查询")]),a("el-button",{attrs:{type:"danger"},on:{click:e.employeeNew}},[e._v("新增员工")])],1)],1),a("el-table",{staticClass:"table",attrs:{data:e.data,border:"",height:"260"}},[a("el-table-column",{attrs:{prop:"name",label:"员工姓名"}}),a("el-table-column",{attrs:{prop:"alias",label:"别名",formatter:e.nameFmt}}),a("el-table-column",{attrs:{prop:"idNo",label:"身份证号"}}),a("el-table-column",{attrs:{prop:"deptId",label:"部门"}}),a("el-table-column",{attrs:{prop:"nativePlace",label:"关联客户"}}),a("el-table-column",{attrs:{prop:"status",label:"状态"}}),a("el-table-column",{attrs:{label:"操作",width:"180",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"text",icon:"el-icon-search"},on:{click:function(a){return e.employeeDetail(t.row)}}},[e._v("详情")]),a("el-button",{attrs:{type:"text",icon:"el-icon-edit"},on:{click:function(a){return e.employeeEdit(t.row)}}},[e._v("编辑")]),a("el-button",{staticClass:"red",attrs:{type:"text",icon:"el-icon-delete"},on:{click:function(a){return e.employeeDel(t.row)}}},[e._v("删除")])]}}])})],1)],1)])},l=[],i=(a("58b5"),a("38f0"),a("d4aa"),a("21f4"),{data:function(){return{data:[],form:{},deptList:[],dialogFormVisible:!1}},created:function(){this.deptListQuery(),this.queryAll()},methods:{deptListQuery:function(){var e=this;this.$axios.get(this.$api.department.findAll).then(function(t){if(200==t.code){var a=[],n=t.data.data;n.forEach(function(e){a.push({label:e.deptName,value:e.deptId})}),e.deptList=a}else e.$message.error("部门列表数据查询失败: "+t.message)}).catch(function(e){})},queryAll:function(){var e=this;this.$axios.post(this.$api.employee.findbyidandname).then(function(t){200===t.code&&(e.data=t.data["select list "])})},queryByIdAndName:function(){var e=this,t="?deptId="+this.form.deptId,a=null==this.form.deptId?this.$api.employee.findbyidandname:this.$api.employee.findbyidandname+t;this.$axios.post(a).then(function(t){e.data=t.data["select list "]})},nameFmt:function(e){return e.name+"001"},employeeNew:function(){this.$router.push("/employee/detail/new")},employeeDetail:function(e){this.$router.push("/employee/detail/showdetail/"+e.perId)},employeeEdit:function(e){this.$router.push("/employee/detail/edit/"+e.perId)},employeeDel:function(e){var t=this,a=e.idNo;e.inProjectName;this.$confirm("确定要删除证件号为："+a+"的员工吗？").then(function(){t.$axios.post(t.$api.employee.deletebyidno,{idNo:a,inProjectName:""}).then(function(e){200===e.code?(t.$message("删除成功"),t.queryAll()):t.$message.error("删除失败")})}).catch(function(e){})}}}),o=i,r=(a("4e18"),a("620d")),s=Object(r["a"])(o,n,l,!1,null,"d3213e42",null);t["default"]=s.exports}}]);