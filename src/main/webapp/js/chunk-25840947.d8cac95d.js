(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-25840947"],{"0863":function(t,i,e){},"33cb":function(t,i,e){"use strict";e.r(i);var s=function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("div",[e("div",{staticClass:"crumbs"},[e("el-breadcrumb",{attrs:{separator:"/"}},[e("el-breadcrumb-item",[e("i",{staticClass:"el-icon-lx-recharge"}),t._v(" 统计查询")]),e("el-breadcrumb-item",[t._v(" 请假统计")])],1)],1),e("div",{staticClass:"container"},[e("el-tabs",{model:{value:t.activeName,callback:function(i){t.activeName=i},expression:"activeName"}},[e("el-tab-pane",{attrs:{label:"按客户查",name:"first"}},[e("el-form",{attrs:{inline:!0,model:t.form1,"label-width":"80px"}},[e("el-form-item",{attrs:{label:"客户类别"}},[e("el-select",{model:{value:t.form1.custtype,callback:function(i){t.$set(t.form1,"custtype",i)},expression:"form1.custtype"}},[e("el-option",{attrs:{label:"中国银行",value:"1"}}),e("el-option",{attrs:{label:"中国人寿",value:"2"}}),e("el-option",{attrs:{label:"公司内部系统",value:"3"}})],1)],1),e("el-form-item",{attrs:{label:"项目名称"}},[e("el-select",{model:{value:t.form1.proname,callback:function(i){t.$set(t.form1,"proname",i)},expression:"form1.proname"}},[e("el-option",{attrs:{label:"中国银行etc项目",value:"1"}}),e("el-option",{attrs:{label:"中国银行合肥分中心",value:"2"}})],1)],1),e("el-form-item",{attrs:{label:"选择日期"}},[e("el-date-picker",{staticStyle:{width:"140px"},attrs:{type:"month",placeholder:"开始日期"},model:{value:t.form1.startDate,callback:function(i){t.$set(t.form1,"startDate",i)},expression:"form1.startDate"}}),t._v(" -\r\n                        "),e("el-date-picker",{staticStyle:{width:"140px"},attrs:{type:"month",placeholder:"结束日期"},model:{value:t.form1.endDate,callback:function(i){t.$set(t.form1,"endDate",i)},expression:"form1.endDate"}})],1),e("el-form-item",[e("el-button",{attrs:{type:"primary"}},[t._v("查询")])],1)],1)],1),e("el-tab-pane",{attrs:{label:"按部门查",name:"second"}},[e("el-form",{attrs:{inline:!0,model:t.form2,"label-width":"80px"}},[e("el-form-item",{attrs:{label:"部门名称"}},[e("el-select",{model:{value:t.form2.dept,callback:function(i){t.$set(t.form2,"dept",i)},expression:"form2.dept"}},[e("el-option",{attrs:{label:"软件资源二中心一部",value:"1"}}),e("el-option",{attrs:{label:"软件资源二中心二部",value:"2"}}),e("el-option",{attrs:{label:"软件资源二中心三部",value:"2"}}),e("el-option",{attrs:{label:"软件资源二中心四部",value:"2"}})],1)],1),e("el-form-item",{attrs:{label:"选择日期"}},[e("el-date-picker",{staticStyle:{width:"140px"},attrs:{type:"month",placeholder:"开始日期"},model:{value:t.form2.startDate,callback:function(i){t.$set(t.form2,"startDate",i)},expression:"form2.startDate"}}),t._v(" -\r\n                        "),e("el-date-picker",{staticStyle:{width:"140px"},attrs:{type:"month",placeholder:"结束日期"},model:{value:t.form2.endDate,callback:function(i){t.$set(t.form2,"endDate",i)},expression:"form2.endDate"}})],1),e("el-form-item",[e("el-button",{attrs:{type:"primary"}},[t._v("查询")])],1)],1)],1),e("el-tab-pane",{attrs:{label:"按员工查",name:"third"}},[e("el-form",{attrs:{inline:!0,model:t.form3,"label-width":"80px"}},[e("el-form-item",{attrs:{label:"姓名"}},[e("el-input",{attrs:{placeholder:"请输入"}})],1),e("el-form-item",{attrs:{label:"身份证号"}},[e("el-input",{attrs:{placeholder:"请输入"}})],1),e("el-form-item",{attrs:{label:"选择日期"}},[e("el-date-picker",{staticStyle:{width:"140px"},attrs:{type:"month",placeholder:"开始日期"},model:{value:t.form3.startDate,callback:function(i){t.$set(t.form3,"startDate",i)},expression:"form3.startDate"}}),t._v(" -\r\n                        "),e("el-date-picker",{staticStyle:{width:"140px"},attrs:{type:"month",placeholder:"结束日期"},model:{value:t.form3.endDate,callback:function(i){t.$set(t.form3,"endDate",i)},expression:"form3.endDate"}})],1),e("el-form-item",[e("el-button",{attrs:{type:"primary"}},[t._v("查询")])],1)],1)],1)],1),e("div",{staticClass:"schart-box"},[e("div",{staticClass:"content-title"},[t._v("时间: 2019-01至2019-03")]),e("schart",{staticClass:"schart",attrs:{canvasId:"pie",data:t.data,type:"pie",options:t.options}})],1),e("div",{staticClass:"schart-box"},[e("div",{staticClass:"content-title"},[t._v("时间: 2019-01至2019-03")]),e("schart",{staticClass:"schart",attrs:{canvasId:"pie2",data:t.data2,type:"pie",options:t.options2}})],1)],1)])},a=[],h=e("f5ac"),o={data:function(){return{activeName:"first",form1:{},form2:{},form3:{},data:[{name:"调休",value:10},{name:"病假",value:2},{name:"事假",value:8},{name:"年假",value:1}],options:{title:"中国银行团队-请假统计(人)",legendColor:"#444",radius:120,innerRadius:80},data2:[{name:"调休",value:100},{name:"病假",value:20},{name:"事假",value:30},{name:"年假",value:10}],options2:{title:"中国银行团队-请假统计(小时)",legendColor:"#444",radius:120,innerRadius:80}}},components:{Schart:h["a"]}},l=o,n=(e("e346"),e("2877")),d=Object(n["a"])(l,s,a,!1,null,"7e4c262c",null);d.options.__file="Leave.vue";i["default"]=d.exports},"8c93":function(t,i,e){var s;
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
(function(a,h){s=function(){return h(a)}.call(i,e,i,t),void 0===s||(t.exports=s)})(this,function(t){"use strict";function i(t,i,e,s){this.canvas=document.getElementById(t),this.ctx=this.canvas.getContext("2d"),this.dpi=window.devicePixelRatio||1,this.type=i,this.data=e,this.dataLength=this.data.length,this.showValue=!0,this.autoWidth=!1,this.width=this.canvas.width*this.dpi,this.height=this.canvas.height*this.dpi,this.topPadding=50*this.dpi,this.leftPadding=50*this.dpi,this.rightPadding=0*this.dpi,this.bottomPadding=50*this.dpi,this.yEqual=5,this.yLength=0,this.xLength=0,this.yFictitious=0,this.yRatio=0,this.bgColor="#ffffff",this.fillColor="#1E9FFF",this.axisColor="#666666",this.contentColor="#eeeeee",this.titleColor="#000000",this.title="",this.titlePosition="top",this.radius=100*this.dpi,this.innerRadius=70*this.dpi,this.colorList=["#1E9FFF","#13CE66","#F7BA2A","#FF4949","#72f6ff","#199475","#e08031","#726dd1"],this.legendColor="#000000",this.legendTop=40*this.dpi,this.totalValue=this.getTotalValue(),this.init(s)}return i.prototype={init:function(t){if(0===this.dataLength)return!1;if(t){var i=["topPadding","leftPadding","rightPadding","bottomPadding","radius","innerRadius","legendTop"];for(var e in t)"colorList"===e&&Array.isArray(t[e])?this[e]=t[e].concat(this[e]):i.indexOf(e)>-1?this[e]=t[e]*this.dpi:this[e]=t[e]}t.autoWidth?(this.width=this.canvas.width=this.canvas.parentNode.offsetWidth*this.dpi,this.height=this.canvas.height=this.canvas.parentNode.offsetHeight*this.dpi,this.canvas.setAttribute("style","width:"+this.canvas.parentNode.offsetWidth+"px;height:"+this.canvas.parentNode.offsetHeight+"px;")):(this.canvas.setAttribute("style","width:"+this.canvas.width+"px;height:"+this.canvas.height+"px;"),this.canvas.width*=this.dpi,this.canvas.height*=this.dpi),"bar"===this.type||"line"===this.type?(this.yLength=Math.floor((this.height-this.topPadding-this.bottomPadding-10)/this.yEqual),this.xLength=Math.floor((this.width-this.leftPadding-this.rightPadding-10)/this.dataLength),this.yFictitious=this.getYFictitious(this.data),this.yRatio=this.yLength/this.yFictitious,this.drawBarUpdate()):this.drawPieUpdate()},drawBarUpdate:function(){this.ctx.fillStyle=this.bgColor,this.ctx.fillRect(0,0,this.width,this.height),this.drawAxis(),this.drawPoint(),this.drawTitle(),this.drawBarChart()},drawPieUpdate:function(){this.ctx.fillStyle=this.bgColor,this.ctx.fillRect(0,0,this.width,this.height),this.drawLegend(),this.drawTitle(),this.drawPieChart()},drawBarChart:function(){this.ctx.fillStyle=this.fillColor,this.ctx.strokeStyle=this.fillColor;for(var t=0;t<this.dataLength;t++)this.data[t].left=this.leftPadding+this.xLength*(t+.25),this.data[t].top=this.height-this.bottomPadding-this.data[t].value*this.yRatio,this.data[t].right=this.leftPadding+this.xLength*(t+.75),this.data[t].bottom=this.height-this.bottomPadding,"line"===this.type?(this.ctx.beginPath(),this.ctx.arc(this.data[t].left+this.xLength/4,this.data[t].top,2,0,2*Math.PI,!0),this.ctx.fill(),0!==t&&(this.ctx.moveTo(this.data[t].left+this.xLength/4,this.data[t].top),this.ctx.lineTo(this.data[t-1].left+this.xLength/4,this.data[t-1].top)),this.ctx.stroke()):"bar"===this.type&&this.ctx.fillRect(this.data[t].left,this.data[t].top,this.data[t].right-this.data[t].left,this.data[t].bottom-this.data[t].top),this.showValue&&(this.ctx.font=12*this.dpi+"px Arial",this.ctx.fillText(this.data[t].value,this.data[t].left+this.xLength/4,this.data[t].top-5))},drawPieChart:function(){for(var t=this.width/2,i=this.height/2,e=0,s=0,a=0;a<this.dataLength;a++)this.ctx.beginPath(),this.ctx.fillStyle=this.colorList[a],this.ctx.moveTo(t,i),this.data[a].start=0===a?-Math.PI/2:this.data[a-1].end,this.data[a].end=this.data[a].start+this.data[a].value/this.totalValue*2*Math.PI,this.ctx.arc(t,i,this.radius,this.data[a].start,this.data[a].end),this.ctx.closePath(),this.ctx.fill(),this.data[a].middle=(this.data[a].start+this.data[a].end)/2,e=Math.ceil(Math.abs(this.radius*Math.cos(this.data[a].middle))),s=Math.floor(Math.abs(this.radius*Math.sin(this.data[a].middle))),this.ctx.strokeStyle=this.colorList[a],this.showValue&&(this.data[a].middle<=0?(this.ctx.textAlign="left",this.ctx.moveTo(t+e,i-s),this.ctx.lineTo(t+e+10,i-s-10),this.ctx.moveTo(t+e+10,i-s-10),this.ctx.lineTo(t+e+this.radius/2,i-s-10),this.ctx.stroke(),this.ctx.fillText(this.data[a].value,t+e+5+this.radius/2,i-s-5)):this.data[a].middle>0&&this.data[a].middle<=Math.PI/2?(this.ctx.textAlign="left",this.ctx.moveTo(t+e,i+s),this.ctx.lineTo(t+e+10,i+s+10),this.ctx.moveTo(t+e+10,i+s+10),this.ctx.lineTo(t+e+this.radius/2,i+s+10),this.ctx.stroke(),this.ctx.fillText(this.data[a].value,t+e+5+this.radius/2,i+s+15)):this.data[a].middle>Math.PI/2&&this.data[a].middle<Math.PI?(this.ctx.textAlign="right",this.ctx.moveTo(t-e,i+s),this.ctx.lineTo(t-e-10,i+s+10),this.ctx.moveTo(t-e-10,i+s+10),this.ctx.lineTo(t-e-this.radius/2,i+s+10),this.ctx.stroke(),this.ctx.fillText(this.data[a].value,t-e-5-this.radius/2,i+s+15)):(this.ctx.textAlign="right",this.ctx.moveTo(t-e,i-s),this.ctx.lineTo(t-e-10,i-s-10),this.ctx.moveTo(t-e-10,i-s-10),this.ctx.lineTo(t-e-this.radius/2,i-s-10),this.ctx.stroke(),this.ctx.fillText(this.data[a].value,t-e-5-this.radius/2,i-s-5)));"ring"===this.type&&(this.ctx.beginPath(),this.ctx.fillStyle=this.bgColor,this.ctx.arc(t,i,this.innerRadius,0,2*Math.PI),this.ctx.fill())},drawAxis:function(){this.ctx.beginPath(),this.ctx.strokeStyle=this.axisColor,this.ctx.moveTo(this.leftPadding+.5,this.height-this.bottomPadding+.5),this.ctx.lineTo(this.leftPadding+.5,this.topPadding+.5),this.ctx.moveTo(this.leftPadding+.5,this.height-this.bottomPadding+.5),this.ctx.lineTo(this.width-this.rightPadding-.5,this.height-this.bottomPadding+.5),this.ctx.stroke()},drawPoint:function(){this.ctx.beginPath(),this.ctx.font=12*this.dpi+"px Microsoft YaHei",this.ctx.textAlign="center",this.ctx.fillStyle=this.axisColor;for(var t=0;t<this.dataLength;t++){var i=this.data[t].name,e=this.xLength*(t+1);this.ctx.moveTo(this.leftPadding+e+.5,this.height-this.bottomPadding+.5),this.ctx.lineTo(this.leftPadding+e+.5,this.height-this.bottomPadding+5.5),this.ctx.fillText(i,this.leftPadding+e-this.xLength/2,this.height-this.bottomPadding+15*this.dpi)}this.ctx.stroke(),this.ctx.beginPath(),this.ctx.font=12*this.dpi+"px Microsoft YaHei",this.ctx.textAlign="right",this.ctx.fillStyle=this.axisColor,this.ctx.moveTo(this.leftPadding+.5,this.height-this.bottomPadding+.5),this.ctx.lineTo(this.leftPadding-4.5,this.height-this.bottomPadding+.5),this.ctx.fillText(0,this.leftPadding-10,this.height-this.bottomPadding+5);for(t=0;t<this.yEqual;t++){var s=this.yFictitious*(t+1),a=this.yLength*(t+1);this.ctx.beginPath(),this.ctx.strokeStyle=this.axisColor,this.ctx.moveTo(this.leftPadding+.5,this.height-this.bottomPadding-a+.5),this.ctx.lineTo(this.leftPadding-4.5,this.height-this.bottomPadding-a+.5),this.ctx.stroke(),this.ctx.fillText(s,this.leftPadding-10,this.height-this.bottomPadding-a+5),this.ctx.beginPath(),this.ctx.strokeStyle=this.contentColor,this.ctx.moveTo(this.leftPadding+.5,this.height-this.bottomPadding-a+.5),this.ctx.lineTo(this.width-this.rightPadding-.5,this.height-this.bottomPadding-a+.5),this.ctx.stroke()}},drawTitle:function(){this.title&&(this.ctx.beginPath(),this.ctx.textAlign="center",this.ctx.fillStyle=this.titleColor,this.ctx.font=16*this.dpi+"px Microsoft YaHei","bottom"===this.titlePosition&&this.bottomPadding>=40?this.ctx.fillText(this.title,this.width/2,this.height-5):this.ctx.fillText(this.title,this.width/2,this.topPadding/2+5))},drawLegend:function(){for(var t=0;t<this.dataLength;t++)this.ctx.fillStyle=this.colorList[t],this.ctx.fillRect(10,this.legendTop+15*t*this.dpi,20,11),this.ctx.fillStyle=this.legendColor,this.ctx.font=12*this.dpi+"px Microsoft YaHei",this.ctx.textAlign="left",this.ctx.fillText(this.data[t].name,35,this.legendTop+10+15*t*this.dpi)},getYFictitious:function(t){var i=t.slice(0);i.sort(function(t,i){return-(t.value-i.value)});var e=Math.ceil(i[0].value/this.yEqual),s=e.toString().length-1;return s=s>2?2:s,Math.ceil(e/Math.pow(10,s))*Math.pow(10,s)},getTotalValue:function(){for(var t=0,i=0;i<this.dataLength;i++)t+=this.data[i].value;return t}},i})},e346:function(t,i,e){"use strict";var s=e("0863"),a=e.n(s);a.a},f5ac:function(t,i,e){"use strict";var s=function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("div",[e("canvas",{attrs:{id:t.canvasId}})])},a=[],h=(e("cadf"),e("551c"),e("097d"),e("8c93")),o=e.n(h),l={data:function(){return{schart:null,opt:{}}},props:{canvasId:{type:String,default:""},type:{type:String,default:"bar"},data:{type:Array,default:[]},options:{type:Object,required:!1}},mounted:function(){this.renderChart()},methods:{renderChart:function(){this.schart=null,this.opt=this.options,this.width&&this.height||(this.opt?this.opt["autoWidth"]=!0:this.opt={autoWidth:!0}),this.schart=new o.a(this.canvasId,this.type,this.data,this.opt)}},watch:{data:function(){this.renderChart()},options:function(){this.renderChart()},type:function(){this.renderChart()}}},n=l,d=e("2877"),r=Object(d["a"])(n,s,a,!1,null,null,null);r.options.__file="vue-schart.vue";i["a"]=r.exports}}]);