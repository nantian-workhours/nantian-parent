(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-56a2f6ba"],{"1b3c":function(t,i,e){var a;
/*!
 * sChart JavaScript Library v2.0.1
 * http://blog.gdfengshuo.com/example/sChart/ | Released under the MIT license
 * Date: 2018-04-16T18:59Z
 */
/*!
 * sChart JavaScript Library v2.0.1
 * http://blog.gdfengshuo.com/example/sChart/ | Released under the MIT license
 * Date: 2018-04-16T18:59Z
 */
(function(s,h){a=function(){return h(s)}.call(i,e,i,t),void 0===a||(t.exports=a)})(this,function(t){"use strict";function i(t,i,e,a){this.canvas=document.getElementById(t),this.ctx=this.canvas.getContext("2d"),this.dpi=window.devicePixelRatio||1,this.type=i,this.data=e,this.dataLength=this.data.length,this.showValue=!0,this.autoWidth=!1,this.width=this.canvas.width*this.dpi,this.height=this.canvas.height*this.dpi,this.topPadding=50*this.dpi,this.leftPadding=50*this.dpi,this.rightPadding=0*this.dpi,this.bottomPadding=50*this.dpi,this.yEqual=5,this.yLength=0,this.xLength=0,this.yFictitious=0,this.yRatio=0,this.bgColor="#ffffff",this.fillColor="#1E9FFF",this.axisColor="#666666",this.contentColor="#eeeeee",this.titleColor="#000000",this.title="",this.titlePosition="top",this.radius=100*this.dpi,this.innerRadius=70*this.dpi,this.colorList=["#1E9FFF","#13CE66","#F7BA2A","#FF4949","#72f6ff","#199475","#e08031","#726dd1"],this.legendColor="#000000",this.legendTop=40*this.dpi,this.totalValue=this.getTotalValue(),this.init(a)}return i.prototype={init:function(t){if(0===this.dataLength)return!1;if(t){var i=["topPadding","leftPadding","rightPadding","bottomPadding","radius","innerRadius","legendTop"];for(var e in t)"colorList"===e&&Array.isArray(t[e])?this[e]=t[e].concat(this[e]):i.indexOf(e)>-1?this[e]=t[e]*this.dpi:this[e]=t[e]}t.autoWidth?(this.width=this.canvas.width=this.canvas.parentNode.offsetWidth*this.dpi,this.height=this.canvas.height=this.canvas.parentNode.offsetHeight*this.dpi,this.canvas.setAttribute("style","width:"+this.canvas.parentNode.offsetWidth+"px;height:"+this.canvas.parentNode.offsetHeight+"px;")):(this.canvas.setAttribute("style","width:"+this.canvas.width+"px;height:"+this.canvas.height+"px;"),this.canvas.width*=this.dpi,this.canvas.height*=this.dpi),"bar"===this.type||"line"===this.type?(this.yLength=Math.floor((this.height-this.topPadding-this.bottomPadding-10)/this.yEqual),this.xLength=Math.floor((this.width-this.leftPadding-this.rightPadding-10)/this.dataLength),this.yFictitious=this.getYFictitious(this.data),this.yRatio=this.yLength/this.yFictitious,this.drawBarUpdate()):this.drawPieUpdate()},drawBarUpdate:function(){this.ctx.fillStyle=this.bgColor,this.ctx.fillRect(0,0,this.width,this.height),this.drawAxis(),this.drawPoint(),this.drawTitle(),this.drawBarChart()},drawPieUpdate:function(){this.ctx.fillStyle=this.bgColor,this.ctx.fillRect(0,0,this.width,this.height),this.drawLegend(),this.drawTitle(),this.drawPieChart()},drawBarChart:function(){this.ctx.fillStyle=this.fillColor,this.ctx.strokeStyle=this.fillColor;for(var t=0;t<this.dataLength;t++)this.data[t].left=this.leftPadding+this.xLength*(t+.25),this.data[t].top=this.height-this.bottomPadding-this.data[t].value*this.yRatio,this.data[t].right=this.leftPadding+this.xLength*(t+.75),this.data[t].bottom=this.height-this.bottomPadding,"line"===this.type?(this.ctx.beginPath(),this.ctx.arc(this.data[t].left+this.xLength/4,this.data[t].top,2,0,2*Math.PI,!0),this.ctx.fill(),0!==t&&(this.ctx.moveTo(this.data[t].left+this.xLength/4,this.data[t].top),this.ctx.lineTo(this.data[t-1].left+this.xLength/4,this.data[t-1].top)),this.ctx.stroke()):"bar"===this.type&&this.ctx.fillRect(this.data[t].left,this.data[t].top,this.data[t].right-this.data[t].left,this.data[t].bottom-this.data[t].top),this.showValue&&(this.ctx.font=12*this.dpi+"px Arial",this.ctx.fillText(this.data[t].value,this.data[t].left+this.xLength/4,this.data[t].top-5))},drawPieChart:function(){for(var t=this.width/2,i=this.height/2,e=0,a=0,s=0;s<this.dataLength;s++)this.ctx.beginPath(),this.ctx.fillStyle=this.colorList[s],this.ctx.moveTo(t,i),this.data[s].start=0===s?-Math.PI/2:this.data[s-1].end,this.data[s].end=this.data[s].start+this.data[s].value/this.totalValue*2*Math.PI,this.ctx.arc(t,i,this.radius,this.data[s].start,this.data[s].end),this.ctx.closePath(),this.ctx.fill(),this.data[s].middle=(this.data[s].start+this.data[s].end)/2,e=Math.ceil(Math.abs(this.radius*Math.cos(this.data[s].middle))),a=Math.floor(Math.abs(this.radius*Math.sin(this.data[s].middle))),this.ctx.strokeStyle=this.colorList[s],this.showValue&&(this.data[s].middle<=0?(this.ctx.textAlign="left",this.ctx.moveTo(t+e,i-a),this.ctx.lineTo(t+e+10,i-a-10),this.ctx.moveTo(t+e+10,i-a-10),this.ctx.lineTo(t+e+this.radius/2,i-a-10),this.ctx.stroke(),this.ctx.fillText(this.data[s].value,t+e+5+this.radius/2,i-a-5)):this.data[s].middle>0&&this.data[s].middle<=Math.PI/2?(this.ctx.textAlign="left",this.ctx.moveTo(t+e,i+a),this.ctx.lineTo(t+e+10,i+a+10),this.ctx.moveTo(t+e+10,i+a+10),this.ctx.lineTo(t+e+this.radius/2,i+a+10),this.ctx.stroke(),this.ctx.fillText(this.data[s].value,t+e+5+this.radius/2,i+a+15)):this.data[s].middle>Math.PI/2&&this.data[s].middle<Math.PI?(this.ctx.textAlign="right",this.ctx.moveTo(t-e,i+a),this.ctx.lineTo(t-e-10,i+a+10),this.ctx.moveTo(t-e-10,i+a+10),this.ctx.lineTo(t-e-this.radius/2,i+a+10),this.ctx.stroke(),this.ctx.fillText(this.data[s].value,t-e-5-this.radius/2,i+a+15)):(this.ctx.textAlign="right",this.ctx.moveTo(t-e,i-a),this.ctx.lineTo(t-e-10,i-a-10),this.ctx.moveTo(t-e-10,i-a-10),this.ctx.lineTo(t-e-this.radius/2,i-a-10),this.ctx.stroke(),this.ctx.fillText(this.data[s].value,t-e-5-this.radius/2,i-a-5)));"ring"===this.type&&(this.ctx.beginPath(),this.ctx.fillStyle=this.bgColor,this.ctx.arc(t,i,this.innerRadius,0,2*Math.PI),this.ctx.fill())},drawAxis:function(){this.ctx.beginPath(),this.ctx.strokeStyle=this.axisColor,this.ctx.moveTo(this.leftPadding+.5,this.height-this.bottomPadding+.5),this.ctx.lineTo(this.leftPadding+.5,this.topPadding+.5),this.ctx.moveTo(this.leftPadding+.5,this.height-this.bottomPadding+.5),this.ctx.lineTo(this.width-this.rightPadding-.5,this.height-this.bottomPadding+.5),this.ctx.stroke()},drawPoint:function(){this.ctx.beginPath(),this.ctx.font=12*this.dpi+"px Microsoft YaHei",this.ctx.textAlign="center",this.ctx.fillStyle=this.axisColor;for(var t=0;t<this.dataLength;t++){var i=this.data[t].name,e=this.xLength*(t+1);this.ctx.moveTo(this.leftPadding+e+.5,this.height-this.bottomPadding+.5),this.ctx.lineTo(this.leftPadding+e+.5,this.height-this.bottomPadding+5.5),this.ctx.fillText(i,this.leftPadding+e-this.xLength/2,this.height-this.bottomPadding+15*this.dpi)}this.ctx.stroke(),this.ctx.beginPath(),this.ctx.font=12*this.dpi+"px Microsoft YaHei",this.ctx.textAlign="right",this.ctx.fillStyle=this.axisColor,this.ctx.moveTo(this.leftPadding+.5,this.height-this.bottomPadding+.5),this.ctx.lineTo(this.leftPadding-4.5,this.height-this.bottomPadding+.5),this.ctx.fillText(0,this.leftPadding-10,this.height-this.bottomPadding+5);for(t=0;t<this.yEqual;t++){var a=this.yFictitious*(t+1),s=this.yLength*(t+1);this.ctx.beginPath(),this.ctx.strokeStyle=this.axisColor,this.ctx.moveTo(this.leftPadding+.5,this.height-this.bottomPadding-s+.5),this.ctx.lineTo(this.leftPadding-4.5,this.height-this.bottomPadding-s+.5),this.ctx.stroke(),this.ctx.fillText(a,this.leftPadding-10,this.height-this.bottomPadding-s+5),this.ctx.beginPath(),this.ctx.strokeStyle=this.contentColor,this.ctx.moveTo(this.leftPadding+.5,this.height-this.bottomPadding-s+.5),this.ctx.lineTo(this.width-this.rightPadding-.5,this.height-this.bottomPadding-s+.5),this.ctx.stroke()}},drawTitle:function(){this.title&&(this.ctx.beginPath(),this.ctx.textAlign="center",this.ctx.fillStyle=this.titleColor,this.ctx.font=16*this.dpi+"px Microsoft YaHei","bottom"===this.titlePosition&&this.bottomPadding>=40?this.ctx.fillText(this.title,this.width/2,this.height-5):this.ctx.fillText(this.title,this.width/2,this.topPadding/2+5))},drawLegend:function(){for(var t=0;t<this.dataLength;t++)this.ctx.fillStyle=this.colorList[t],this.ctx.fillRect(10,this.legendTop+15*t*this.dpi,20,11),this.ctx.fillStyle=this.legendColor,this.ctx.font=12*this.dpi+"px Microsoft YaHei",this.ctx.textAlign="left",this.ctx.fillText(this.data[t].name,35,this.legendTop+10+15*t*this.dpi)},getYFictitious:function(t){var i=t.slice(0);i.sort(function(t,i){return-(t.value-i.value)});var e=Math.ceil(i[0].value/this.yEqual),a=e.toString().length-1;return a=a>2?2:a,Math.ceil(e/Math.pow(10,a))*Math.pow(10,a)},getTotalValue:function(){for(var t=0,i=0;i<this.dataLength;i++)t+=this.data[i].value;return t}},i})},"1d4c":function(t,i,e){},"21f4":function(t,i,e){"use strict";e.d(i,"b",function(){return o}),e.d(i,"a",function(){return l});e("4b02");var a=e("b6db"),s=e.n(a),h=e("d4aa");function o(t){return s.a.get(h["a"].params.subTypeQuery+"?dicType="+t)}function l(){var t=this;return new Promise(function(i,e){t.$axios.get(t.$api.department.findAll).then(function(a){if(200==a.code){var s=[],h=a.data.data;h.forEach(function(t){s.push({label:t.deptName,value:t.deptId})}),i(s)}else t.$message.error("部门列表数据查询失败: "+a.message),e(a.message)}).catch(function(i){t.$message.error("部门列表数据查询失败"),e("部门列表数据查询失败")})})}},"33cb":function(t,i,e){"use strict";e.r(i);var a=function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("div",[e("div",{staticClass:"crumbs"},[e("el-breadcrumb",{attrs:{separator:"/"}},[e("el-breadcrumb-item",[e("i",{staticClass:"el-icon-lx-recharge"}),t._v(" 统计查询")]),e("el-breadcrumb-item",[t._v(" 请假统计")])],1)],1),e("div",{staticClass:"container"},[e("el-tabs",{on:{"tab-click":t.tabToggleFn},model:{value:t.activeName,callback:function(i){t.activeName=i},expression:"activeName"}},[e("el-tab-pane",{attrs:{label:"按部门查",name:"second"}},[e("el-form",{ref:"deptForm",attrs:{inline:!0,model:t.deptForm,rules:t.deptFormRules,"label-width":"80px"}},[e("el-form-item",{attrs:{label:"部门名称",prop:"deptId"}},[e("el-select",{attrs:{clearable:""},model:{value:t.deptForm.deptId,callback:function(i){t.$set(t.deptForm,"deptId",i)},expression:"deptForm.deptId"}},t._l(t.deptList,function(t,i){return e("el-option",{key:i,attrs:{label:t.label,value:t.value}})}),1)],1),e("el-form-item",{attrs:{label:"选择日期",prop:"dateRange",required:""}},[e("el-date-picker",{attrs:{type:"monthrange",align:"right","unlink-panels":"","range-separator":"至","start-placeholder":"开始月份","end-placeholder":"结束月份","picker-options":t.pickerOptions},model:{value:t.deptForm.dateRange,callback:function(i){t.$set(t.deptForm,"dateRange",i)},expression:"deptForm.dateRange"}})],1),e("el-form-item",{attrs:{label:""}},[e("el-button",{attrs:{type:"primary"},on:{click:function(i){return t.query("deptForm",t.deptForm)}}},[t._v("查询")])],1)],1)],1),e("el-tab-pane",{attrs:{label:"按员工查",name:"third"}},[e("el-form",{ref:"employForm",attrs:{inline:!0,model:t.employForm,rules:t.employFormRules,"label-width":"80px"}},[e("el-form-item",{attrs:{label:"员工姓名",prop:"name"}},[e("el-input",{attrs:{placeholder:"请输入姓名查询身份证号"},on:{input:function(i){return t.findByName(t.employForm)}},model:{value:t.employForm.name,callback:function(i){t.$set(t.employForm,"name",i)},expression:"employForm.name"}})],1),e("el-form-item",{attrs:{label:"身份证号",prop:"idNo"}},[e("el-input",{attrs:{readonly:"",placeholder:"根据姓名查询后自动带入"},model:{value:t.employForm.idNo,callback:function(i){t.$set(t.employForm,"idNo",i)},expression:"employForm.idNo"}})],1),e("el-form-item",{attrs:{label:"选择日期",prop:"dateRange",required:""}},[e("el-date-picker",{attrs:{type:"monthrange",align:"right","unlink-panels":"","range-separator":"至","start-placeholder":"开始月份","end-placeholder":"结束月份","picker-options":t.pickerOptions},model:{value:t.employForm.dateRange,callback:function(i){t.$set(t.employForm,"dateRange",i)},expression:"employForm.dateRange"}})],1),e("el-form-item",{attrs:{label:""}},[e("el-button",{attrs:{type:"primary"},on:{click:function(i){return t.query("employForm",t.employForm)}}},[t._v("查询")])],1)],1)],1)],1),"third"!==t.activeName?e("el-table",{staticClass:"table",attrs:{data:t.tableNumsData,border:""}},[e("el-table-column",{attrs:{prop:"hol_1_nums",label:"事假人数"}}),e("el-table-column",{attrs:{prop:"hol_2_nums",label:"年假人数"}}),e("el-table-column",{attrs:{prop:"hol_3_nums",label:"调休人数"}}),e("el-table-column",{attrs:{prop:"hol_4_nums",label:"婚假人数"}}),e("el-table-column",{attrs:{prop:"hol_5_nums",label:"丧假人数"}}),e("el-table-column",{attrs:{prop:"hol_6_nums",label:"产假人数"}})],1):t._e(),e("el-table",{staticClass:"table",staticStyle:{"margin-top":"10px"},attrs:{data:t.tableHoursData,border:""}},[e("el-table-column",{attrs:{prop:"hol_1_hours",label:"事假时长"}}),e("el-table-column",{attrs:{prop:"hol_2_hours",label:"年假时长"}}),e("el-table-column",{attrs:{prop:"hol_3_hours",label:"调休时长"}}),e("el-table-column",{attrs:{prop:"hol_4_hours",label:"婚假时长"}}),e("el-table-column",{attrs:{prop:"hol_5_hours",label:"丧假时长"}}),e("el-table-column",{attrs:{prop:"hol_6_hours",label:"产假时长"}})],1),e("el-dialog",{attrs:{width:"50%",title:"查询到多条信息, 请选择",visible:t.innerVisible,"append-to-body":"",height:"200"},on:{"update:visible":function(i){t.innerVisible=i}}},[e("el-table",{staticClass:"table",attrs:{data:t.employeeList,border:"",height:"260"}},[e("el-table-column",{attrs:{prop:"name",label:"员工姓名"}}),e("el-table-column",{attrs:{prop:"idNo",label:"身份证号"}}),e("el-table-column",{attrs:{prop:"mobileNo",label:"手机号"}}),e("el-table-column",{attrs:{label:"操作"},scopedSlots:t._u([{key:"default",fn:function(i){return[e("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(e){return t.useData(i.row)}}},[t._v("使用")])]}}])})],1)],1)],1)])},s=[],h=(e("e6f7"),e("94eb")),o=e("21f4"),l=(e("fcf9"),{data:function(){return{activeName:"first",custForm:{},deptForm:{},employForm:{},deptList:[],employeeList:[],innerVisible:!1,tableNumsData:[],tableHoursData:[],totalNumMap:[],totalNumOptions:{title:"中国银行团队-请假统计(人)",legendColor:"#444",radius:120,innerRadius:80},totalHoursMap:[],totalHoursOptions:{title:"中国银行团队-请假统计(小时)",legendColor:"#444",radius:120,innerRadius:80},pickerOptions:{shortcuts:[{text:"本月",onClick:function(t){t.$emit("pick",[new Date,new Date])}},{text:"今年至今",onClick:function(t){var i=new Date,e=new Date((new Date).getFullYear(),0);t.$emit("pick",[e,i])}},{text:"最近六个月",onClick:function(t){var i=new Date,e=new Date;e.setMonth(e.getMonth()-6),t.$emit("pick",[e,i])}}]},custFormRules:{custType:[{required:!0,message:"请输入必填项",trigger:"blur"}],dateRange:[{required:!0,message:"请输入必填项",trigger:"blur"}]},deptFormRules:{deptId:[{required:!0,message:"请输入必填项",trigger:"blur"}],dateRange:[{required:!0,message:"请输入必填项",trigger:"blur"}]},employFormRules:{name:[{required:!0,message:"请输入必填项",trigger:"blur"}],idNo:[{required:!0,message:"请输入必填项",trigger:"blur"}],dateRange:[{required:!0,message:"请输入必填项",trigger:"blur"}]}}},components:{Schart:h["a"]},created:function(){var t=this;this.dictObj=this.$store.state.dict.dictObj,o["a"].call(this).then(function(i){t.deptList=i})},methods:{tabToggleFn:function(){this.tableNumsData=[],this.tableHoursData=[]},useData:function(t){this.innerVisible=!1,this.$set(this.employForm,"idNo",t.idNo),this.$set(this.employForm,"perId",t.perId)},findByName:function(t){var i=this,e=t.name;e&&this.$axios.postForm(this.$api.employee.findbyidandname,{name:e}).then(function(e){if(200===e.code){var a=e.data.data;if(!a.length)return i.$message.error("查不到员工信息"),void(t.idNo&&i.$set(t,"idNo",""));if(a.length>1)return i.innerVisible=!0,void(i.employeeList=a);i.$set(t,"idNo",a[0].idNo),i.$set(t,"perId",a[0].perId)}})},query:function(t,i){var e=this;this.$refs[t].validate(function(t){if(t){var a=i;a.begDateStr=e.formatDate(a.dateRange[0],"yyyy-MM-dd"),a.endDateStr=e.formatDate(a.dateRange[1],"yyyy-MM-dd"),e.$axios.postForm(e.$api.statistics.leave,a).then(function(t){if(200===t.code){e.tableNumsData=[],e.tableHoursData=[];var i=t.data.data,a=i.totalNumMap,s=i.totalHoursMap;e.tableNumsData.push(a),e.tableHoursData.push(s);var h={hol_1_nums:"事假人数",hol_2_nums:"年假人数",hol_3_nums:"调休人数",hol_4_nums:"婚假人数",hol_5_nums:"丧假人数",hol_6_nums:"产假人数"},o=[];for(var l in h)o.push({name:h[l],value:a[l]});e.totalNumMap=o}else e.$message.error("查询失败")})}})}}}),n=l,r=(e("885a"),e("620d")),d=Object(r["a"])(n,a,s,!1,null,"544c69e4",null);i["default"]=d.exports},"885a":function(t,i,e){"use strict";var a=e("1d4c"),s=e.n(a);s.a},"94eb":function(t,i,e){"use strict";var a=function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("div",[e("canvas",{attrs:{id:t.canvasId}})])},s=[],h=e("1b3c"),o=e.n(h),l={data:function(){return{schart:null,opt:{}}},props:{canvasId:{type:String,default:""},type:{type:String,default:"bar"},data:{type:Array,default:[]},options:{type:Object,required:!1}},mounted:function(){this.renderChart()},methods:{renderChart:function(){this.schart=null,this.opt=this.options,this.width&&this.height||(this.opt?this.opt["autoWidth"]=!0:this.opt={autoWidth:!0}),this.schart=new o.a(this.canvasId,this.type,this.data,this.opt)}},watch:{data:function(){this.renderChart()},options:function(){this.renderChart()},type:function(){this.renderChart()}}},n=l,r=e("620d"),d=Object(r["a"])(n,a,s,!1,null,null,null);i["a"]=d.exports},fcf9:function(t,i){}}]);