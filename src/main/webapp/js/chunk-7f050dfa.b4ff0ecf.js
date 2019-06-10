(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-7f050dfa"],{4326:function(t,e,a){},"93c1":function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"table"},[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-lx-remind"}),t._v(" 工时管理")]),a("el-breadcrumb-item",[t._v(" 工时查询")])],1)],1),a("div",{staticClass:"container"},[a("el-form",{ref:"queryForm",attrs:{inline:!0,model:t.queryForm,rules:t.queryFormRules,"label-width":"80px"}},[a("el-form-item",{attrs:{label:"员工姓名"}},[a("el-input",{attrs:{placeholder:"员工姓名"},model:{value:t.queryForm.userName,callback:function(e){t.$set(t.queryForm,"userName",e)},expression:"queryForm.userName"}})],1),"0"!==t.jur?a("el-form-item",{attrs:{label:"客户类型"}},[a("el-select",{attrs:{clearable:""},model:{value:t.queryForm.custType,callback:function(e){t.$set(t.queryForm,"custType",e)},expression:"queryForm.custType"}},t._l(t.dictObj["cust"],function(t,e){return a("el-option",{key:e,attrs:{label:t.dicValue,value:t.dicCode}})}),1)],1):t._e(),a("el-form-item",{attrs:{label:"选择日期",prop:"dateRange",required:""}},[a("el-date-picker",{attrs:{type:"monthrange","range-separator":"至","start-placeholder":"开始月份","end-placeholder":"结束月份"},model:{value:t.queryForm.dateRange,callback:function(e){t.$set(t.queryForm,"dateRange",e)},expression:"queryForm.dateRange"}})],1),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.findAll(t.queryForm)}}},[t._v("查询")])],1)],1),t._l(t.resData,function(e,l){return[a("el-card",{key:l,staticClass:"box-card",staticStyle:{margin:"20px 0"},attrs:{shadow:"hover"}},[a("el-row",{staticClass:"mgb5",attrs:{gutter:24}},[a("el-col",{staticClass:"font-bold",attrs:{span:4}},[a("el-tag",{attrs:{type:"success"}},[t._v("月份："+t._s(e.month))])],1),a("el-col",{staticClass:"font-bold",attrs:{span:4}},[t._v("当月正常工作日："+t._s(e.workingDays)+"天")]),a("el-col",{staticClass:"font-bold",attrs:{span:4}},[t._v("当月正常工时："+t._s(e.workingHours)+"小时")]),a("el-col",{staticClass:"font-bold",attrs:{span:4}},[t._v("当月出勤工时："+t._s(e.allHours)+"小时")]),a("el-col",{staticClass:"font-bold",attrs:{span:4}},[t._v("当月加班工时："+t._s(e.addedHours)+"小时")]),a("el-col",{attrs:{span:4,algin:"right"}},[e.allHours?a("el-button",{staticStyle:{"margin-top":"-3px"},attrs:{type:"danger",size:"mini"},on:{click:function(e){t.showDialog=!0}}},[t._v("异议申请")]):t._e()],1)],1),e.allHours?a("el-row",{key:l+"1"},[a("el-table",{staticClass:"table",attrs:{data:e.data,border:""}},[a("el-table-column",{attrs:{prop:"name",label:"姓名",width:"80"}}),a("el-table-column",{attrs:{prop:"proDpmt",label:"部门","min-width":"120"}}),a("el-table-column",{attrs:{prop:"proName",label:"项目","min-width":"120"}}),a("el-table-column",{attrs:{prop:"day_01",label:"1日"}}),a("el-table-column",{attrs:{prop:"day_02",label:"2日"}}),a("el-table-column",{attrs:{prop:"day_03",label:"3日"}}),a("el-table-column",{attrs:{prop:"day_04",label:"4日"}}),a("el-table-column",{attrs:{prop:"day_05",label:"5日"}}),a("el-table-column",{attrs:{prop:"day_06",label:"6日"}}),a("el-table-column",{attrs:{prop:"day_07",label:"7日"}}),a("el-table-column",{attrs:{prop:"day_08",label:"8日"}}),a("el-table-column",{attrs:{prop:"day_09",label:"9日"}}),a("el-table-column",{attrs:{prop:"day_10",label:"10日"}}),a("el-table-column",{attrs:{prop:"day_11",label:"11日"}}),a("el-table-column",{attrs:{prop:"day_12",label:"12日"}}),a("el-table-column",{attrs:{prop:"day_13",label:"13日"}}),a("el-table-column",{attrs:{prop:"day_14",label:"14日"}}),a("el-table-column",{attrs:{prop:"day_15",label:"15日"}}),a("el-table-column",{attrs:{prop:"day_16",label:"16日"}}),a("el-table-column",{attrs:{prop:"day_17",label:"17日"}}),a("el-table-column",{attrs:{prop:"day_18",label:"18日"}}),a("el-table-column",{attrs:{prop:"day_19",label:"19日"}}),a("el-table-column",{attrs:{prop:"day_20",label:"20日"}}),a("el-table-column",{attrs:{prop:"day_21",label:"21日"}}),a("el-table-column",{attrs:{prop:"day_22",label:"22日"}}),a("el-table-column",{attrs:{prop:"day_23",label:"23日"}}),a("el-table-column",{attrs:{prop:"day_24",label:"24日"}}),a("el-table-column",{attrs:{prop:"day_25",label:"25日"}}),a("el-table-column",{attrs:{prop:"day_26",label:"26日"}}),a("el-table-column",{attrs:{prop:"day_27",label:"27日"}}),a("el-table-column",{attrs:{prop:"day_28",label:"28日"}}),a("el-table-column",{attrs:{prop:"day_29",label:"29日"}}),a("el-table-column",{attrs:{prop:"day_30",label:"30日"}}),a("el-table-column",{attrs:{prop:"day_31",label:"31日"}}),a("el-table-column",{attrs:{prop:"normalHours",width:"100",label:"正常工时"}}),a("el-table-column",{attrs:{prop:"addedHours",width:"100",label:"加班工时"}}),a("el-table-column",{attrs:{fixed:"right",label:"操作",width:"100"},scopedSlots:t._u([{key:"default",fn:function(t){}}],null,!0)})],1)],1):t._e()],1)]}),a("el-dialog",{attrs:{title:"异议申请",visible:t.showDialog},on:{"update:visible":function(e){t.showDialog=e}}},[a("el-form",{attrs:{model:t.dialogForm}},[a("el-form-item",{attrs:{label:"异议日期","label-width":t.formLabelWidth}},[a("el-date-picker",{attrs:{type:"date",placeholder:"选择日期"},model:{value:t.dialogForm.date,callback:function(e){t.$set(t.dialogForm,"date",e)},expression:"dialogForm.date"}})],1),a("el-form-item",{attrs:{label:"当天工时","label-width":t.formLabelWidth}},[a("el-row",{attrs:{gutter:24}},[a("el-col",{attrs:{span:5,align:"left"}},[a("el-tag",{attrs:{type:"primary"}},[t._v("正常工时：8H")])],1),a("el-col",{attrs:{span:5}},[a("el-tag",{attrs:{type:"success"}},[t._v("加班工时：2H")])],1),a("el-col",{attrs:{span:5}},[a("el-tag",{attrs:{type:"danger"}},[t._v("请假工时：0H")])],1)],1)],1),a("el-form-item",{attrs:{label:"申请工时","label-width":t.formLabelWidth}},[a("p",[t._v("正常工时 "),a("el-input-number",{attrs:{min:1,max:10,size:"mini","controls-position":"right"},model:{value:t.dialogForm.num1,callback:function(e){t.$set(t.dialogForm,"num1",e)},expression:"dialogForm.num1"}}),t._v(" H")],1),a("p",[t._v("加班工时 "),a("el-input-number",{attrs:{min:1,max:10,size:"mini","controls-position":"right"},model:{value:t.dialogForm.num2,callback:function(e){t.$set(t.dialogForm,"num2",e)},expression:"dialogForm.num2"}}),t._v(" H")],1),a("p",[t._v("请假工时 "),a("el-input-number",{attrs:{min:1,max:10,size:"mini","controls-position":"right"},model:{value:t.dialogForm.num3,callback:function(e){t.$set(t.dialogForm,"num3",e)},expression:"dialogForm.num3"}}),t._v(" H")],1)]),a("el-form-item",{attrs:{label:"申请理由","label-width":t.formLabelWidth}},[a("el-input",{attrs:{type:"textarea"},model:{value:t.dialogForm.desc,callback:function(e){t.$set(t.dialogForm,"desc",e)},expression:"dialogForm.desc"}})],1),a("el-form-item",{attrs:{label:"附件","label-width":t.formLabelWidth}},[a("el-upload",{staticClass:"upload-demo",attrs:{action:"","list-type":"picture"}},[a("el-button",{attrs:{size:"small",type:"primary"}},[t._v("点击上传")]),a("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("只能上传jpg/png文件，且不超过500kb")])],1)],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.showDialog=!1}}},[t._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:function(e){t.showDialog=!1}}},[t._v("确 定")])],1)],1),a("el-dialog",{attrs:{width:"50%",title:"查询到多条信息, 请选择",visible:t.innerVisible,"append-to-body":"",height:"200"},on:{"update:visible":function(e){t.innerVisible=e}}},[a("el-table",{staticClass:"table",attrs:{data:t.employeeList,border:"",height:"260"}},[a("el-table-column",{attrs:{prop:"name",label:"员工姓名"}}),a("el-table-column",{attrs:{prop:"idNo",label:"身份证号"}}),a("el-table-column",{attrs:{prop:"mobileNo",label:"手机号"}}),a("el-table-column",{attrs:{label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(a){return t.useData(e.row)}}},[t._v("使用")])]}}])})],1)],1)],2)])},r=[],o=(a("a342"),a("4b02"),a("8834"),a("d4aa"),a("fcf9"),{name:"basetable",data:function(){return{queryForm:{custType:"",perId:"",dateRange:"",startDate:"",endDate:""},resData:{},showDialog:!1,dialogForm:{},innerVisible:!1,employeeList:[],queryFormRules:{dateRange:[{required:!0,message:"请输入必填项",trigger:"blur"}]},formLabelWidth:"120px"}},created:function(){this.dictObj=this.$store.state.dict.dictObj,this.jur=this.$store.getters["login/userInfo"].jurisdiction},computed:{},methods:{useData:function(t){this.innerVisible=!1,this.$set(this.queryForm,"perId",t.perId),callback&&callback(this.queryForm)},findByName:function(t,e){var a=this;t&&this.$axios.postForm(this.$api.employee.findbyidandname,{name:t}).then(function(t){if(200===t.code){var l=t.data.data;if(!l.length)return a.$message.error("查不到员工信息"),void(a.resData=[]);if(l.length>1)return a.innerVisible=!0,void(a.employeeList=l);a.$set(a.queryForm,"perId",l[0].perId),e&&e(a.queryForm)}else a.$message.error("查询员工信息失败"),a.resData=[]})},findAll:function(t){var e=this,a=t.userName,l=t.custType;a||l?this.$refs["queryForm"].validate(function(l){l&&(null!=a?e.findByName(a,e.beginQuery):e.beginQuery(t))}):this.$message.error("姓名和客户类别不能同时为空")},beginQuery:function(t){var e=this,a=JSON.parse(JSON.stringify(t))||{},l=a.dateRange;Array.isArray(l)&&(a["startDate"]=this.formatDate(l[0],"yyyy-MM"),a["endDate"]=this.formatDate(l[1],"yyyy-MM"),delete a.dateRange),a.perId=t.perId||"",delete a.userName,this.$axios.get(this.$api.workhours.findAll,a).then(function(t){if(200===t.code){var a=t.data.data;e.resData=e.formateData(a)}else e.$message.error("查询工时信息失败"),e.resData=[]})},formateData:function(t){if(!Object.keys(t).length)return null;var e=[];for(var a in t){var l=t[a],r=l.addedHours,o=l.allHours,s=l.custType,i=l.workingDays,n=l.workingHours;console.log(l);var u={addedHours:r,allHours:o,custType:s,workingDays:i,workingHours:n,month:a,data:[{}]};if(Object.keys(l).length)for(var d in l){var c="day_"+d.split(" ")[0].split("-")[2],m=l[d];u.data[0][c]="出勤-".concat(m[0],"H 加班-").concat(m[1],"H")}"{}"!==JSON.stringify(u.data[0])&&e.push(u)}return console.log(e),e}}}),s=o,i=(a("c510"),a("620d")),n=Object(i["a"])(s,l,r,!1,null,"2f443200",null);e["default"]=n.exports},c510:function(t,e,a){"use strict";var l=a("4326"),r=a.n(l);r.a},fcf9:function(t,e){}}]);