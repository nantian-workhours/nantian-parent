(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-06d0097e"],{"07b1":function(t,i,s){"use strict";var e=s("fec8"),a=s.n(e);a.a},"1b3c":function(t,i,s){var e;
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
(function(a,h){e=function(){return h(a)}.call(i,s,i,t),void 0===e||(t.exports=e)})(this,function(t){"use strict";function i(t,i,s,e){this.canvas=document.getElementById(t),this.ctx=this.canvas.getContext("2d"),this.dpi=window.devicePixelRatio||1,this.type=i,this.data=s,this.dataLength=this.data.length,this.showValue=!0,this.autoWidth=!1,this.width=this.canvas.width*this.dpi,this.height=this.canvas.height*this.dpi,this.topPadding=50*this.dpi,this.leftPadding=50*this.dpi,this.rightPadding=0*this.dpi,this.bottomPadding=50*this.dpi,this.yEqual=5,this.yLength=0,this.xLength=0,this.yFictitious=0,this.yRatio=0,this.bgColor="#ffffff",this.fillColor="#1E9FFF",this.axisColor="#666666",this.contentColor="#eeeeee",this.titleColor="#000000",this.title="",this.titlePosition="top",this.radius=100*this.dpi,this.innerRadius=70*this.dpi,this.colorList=["#1E9FFF","#13CE66","#F7BA2A","#FF4949","#72f6ff","#199475","#e08031","#726dd1"],this.legendColor="#000000",this.legendTop=40*this.dpi,this.totalValue=this.getTotalValue(),this.init(e)}return i.prototype={init:function(t){if(0===this.dataLength)return!1;if(t){var i=["topPadding","leftPadding","rightPadding","bottomPadding","radius","innerRadius","legendTop"];for(var s in t)"colorList"===s&&Array.isArray(t[s])?this[s]=t[s].concat(this[s]):i.indexOf(s)>-1?this[s]=t[s]*this.dpi:this[s]=t[s]}t.autoWidth?(this.width=this.canvas.width=this.canvas.parentNode.offsetWidth*this.dpi,this.height=this.canvas.height=this.canvas.parentNode.offsetHeight*this.dpi,this.canvas.setAttribute("style","width:"+this.canvas.parentNode.offsetWidth+"px;height:"+this.canvas.parentNode.offsetHeight+"px;")):(this.canvas.setAttribute("style","width:"+this.canvas.width+"px;height:"+this.canvas.height+"px;"),this.canvas.width*=this.dpi,this.canvas.height*=this.dpi),"bar"===this.type||"line"===this.type?(this.yLength=Math.floor((this.height-this.topPadding-this.bottomPadding-10)/this.yEqual),this.xLength=Math.floor((this.width-this.leftPadding-this.rightPadding-10)/this.dataLength),this.yFictitious=this.getYFictitious(this.data),this.yRatio=this.yLength/this.yFictitious,this.drawBarUpdate()):this.drawPieUpdate()},drawBarUpdate:function(){this.ctx.fillStyle=this.bgColor,this.ctx.fillRect(0,0,this.width,this.height),this.drawAxis(),this.drawPoint(),this.drawTitle(),this.drawBarChart()},drawPieUpdate:function(){this.ctx.fillStyle=this.bgColor,this.ctx.fillRect(0,0,this.width,this.height),this.drawLegend(),this.drawTitle(),this.drawPieChart()},drawBarChart:function(){this.ctx.fillStyle=this.fillColor,this.ctx.strokeStyle=this.fillColor;for(var t=0;t<this.dataLength;t++)this.data[t].left=this.leftPadding+this.xLength*(t+.25),this.data[t].top=this.height-this.bottomPadding-this.data[t].value*this.yRatio,this.data[t].right=this.leftPadding+this.xLength*(t+.75),this.data[t].bottom=this.height-this.bottomPadding,"line"===this.type?(this.ctx.beginPath(),this.ctx.arc(this.data[t].left+this.xLength/4,this.data[t].top,2,0,2*Math.PI,!0),this.ctx.fill(),0!==t&&(this.ctx.moveTo(this.data[t].left+this.xLength/4,this.data[t].top),this.ctx.lineTo(this.data[t-1].left+this.xLength/4,this.data[t-1].top)),this.ctx.stroke()):"bar"===this.type&&this.ctx.fillRect(this.data[t].left,this.data[t].top,this.data[t].right-this.data[t].left,this.data[t].bottom-this.data[t].top),this.showValue&&(this.ctx.font=12*this.dpi+"px Arial",this.ctx.fillText(this.data[t].value,this.data[t].left+this.xLength/4,this.data[t].top-5))},drawPieChart:function(){for(var t=this.width/2,i=this.height/2,s=0,e=0,a=0;a<this.dataLength;a++)this.ctx.beginPath(),this.ctx.fillStyle=this.colorList[a],this.ctx.moveTo(t,i),this.data[a].start=0===a?-Math.PI/2:this.data[a-1].end,this.data[a].end=this.data[a].start+this.data[a].value/this.totalValue*2*Math.PI,this.ctx.arc(t,i,this.radius,this.data[a].start,this.data[a].end),this.ctx.closePath(),this.ctx.fill(),this.data[a].middle=(this.data[a].start+this.data[a].end)/2,s=Math.ceil(Math.abs(this.radius*Math.cos(this.data[a].middle))),e=Math.floor(Math.abs(this.radius*Math.sin(this.data[a].middle))),this.ctx.strokeStyle=this.colorList[a],this.showValue&&(this.data[a].middle<=0?(this.ctx.textAlign="left",this.ctx.moveTo(t+s,i-e),this.ctx.lineTo(t+s+10,i-e-10),this.ctx.moveTo(t+s+10,i-e-10),this.ctx.lineTo(t+s+this.radius/2,i-e-10),this.ctx.stroke(),this.ctx.fillText(this.data[a].value,t+s+5+this.radius/2,i-e-5)):this.data[a].middle>0&&this.data[a].middle<=Math.PI/2?(this.ctx.textAlign="left",this.ctx.moveTo(t+s,i+e),this.ctx.lineTo(t+s+10,i+e+10),this.ctx.moveTo(t+s+10,i+e+10),this.ctx.lineTo(t+s+this.radius/2,i+e+10),this.ctx.stroke(),this.ctx.fillText(this.data[a].value,t+s+5+this.radius/2,i+e+15)):this.data[a].middle>Math.PI/2&&this.data[a].middle<Math.PI?(this.ctx.textAlign="right",this.ctx.moveTo(t-s,i+e),this.ctx.lineTo(t-s-10,i+e+10),this.ctx.moveTo(t-s-10,i+e+10),this.ctx.lineTo(t-s-this.radius/2,i+e+10),this.ctx.stroke(),this.ctx.fillText(this.data[a].value,t-s-5-this.radius/2,i+e+15)):(this.ctx.textAlign="right",this.ctx.moveTo(t-s,i-e),this.ctx.lineTo(t-s-10,i-e-10),this.ctx.moveTo(t-s-10,i-e-10),this.ctx.lineTo(t-s-this.radius/2,i-e-10),this.ctx.stroke(),this.ctx.fillText(this.data[a].value,t-s-5-this.radius/2,i-e-5)));"ring"===this.type&&(this.ctx.beginPath(),this.ctx.fillStyle=this.bgColor,this.ctx.arc(t,i,this.innerRadius,0,2*Math.PI),this.ctx.fill())},drawAxis:function(){this.ctx.beginPath(),this.ctx.strokeStyle=this.axisColor,this.ctx.moveTo(this.leftPadding+.5,this.height-this.bottomPadding+.5),this.ctx.lineTo(this.leftPadding+.5,this.topPadding+.5),this.ctx.moveTo(this.leftPadding+.5,this.height-this.bottomPadding+.5),this.ctx.lineTo(this.width-this.rightPadding-.5,this.height-this.bottomPadding+.5),this.ctx.stroke()},drawPoint:function(){this.ctx.beginPath(),this.ctx.font=12*this.dpi+"px Microsoft YaHei",this.ctx.textAlign="center",this.ctx.fillStyle=this.axisColor;for(var t=0;t<this.dataLength;t++){var i=this.data[t].name,s=this.xLength*(t+1);this.ctx.moveTo(this.leftPadding+s+.5,this.height-this.bottomPadding+.5),this.ctx.lineTo(this.leftPadding+s+.5,this.height-this.bottomPadding+5.5),this.ctx.fillText(i,this.leftPadding+s-this.xLength/2,this.height-this.bottomPadding+15*this.dpi)}this.ctx.stroke(),this.ctx.beginPath(),this.ctx.font=12*this.dpi+"px Microsoft YaHei",this.ctx.textAlign="right",this.ctx.fillStyle=this.axisColor,this.ctx.moveTo(this.leftPadding+.5,this.height-this.bottomPadding+.5),this.ctx.lineTo(this.leftPadding-4.5,this.height-this.bottomPadding+.5),this.ctx.fillText(0,this.leftPadding-10,this.height-this.bottomPadding+5);for(t=0;t<this.yEqual;t++){var e=this.yFictitious*(t+1),a=this.yLength*(t+1);this.ctx.beginPath(),this.ctx.strokeStyle=this.axisColor,this.ctx.moveTo(this.leftPadding+.5,this.height-this.bottomPadding-a+.5),this.ctx.lineTo(this.leftPadding-4.5,this.height-this.bottomPadding-a+.5),this.ctx.stroke(),this.ctx.fillText(e,this.leftPadding-10,this.height-this.bottomPadding-a+5),this.ctx.beginPath(),this.ctx.strokeStyle=this.contentColor,this.ctx.moveTo(this.leftPadding+.5,this.height-this.bottomPadding-a+.5),this.ctx.lineTo(this.width-this.rightPadding-.5,this.height-this.bottomPadding-a+.5),this.ctx.stroke()}},drawTitle:function(){this.title&&(this.ctx.beginPath(),this.ctx.textAlign="center",this.ctx.fillStyle=this.titleColor,this.ctx.font=16*this.dpi+"px Microsoft YaHei","bottom"===this.titlePosition&&this.bottomPadding>=40?this.ctx.fillText(this.title,this.width/2,this.height-5):this.ctx.fillText(this.title,this.width/2,this.topPadding/2+5))},drawLegend:function(){for(var t=0;t<this.dataLength;t++)this.ctx.fillStyle=this.colorList[t],this.ctx.fillRect(10,this.legendTop+15*t*this.dpi,20,11),this.ctx.fillStyle=this.legendColor,this.ctx.font=12*this.dpi+"px Microsoft YaHei",this.ctx.textAlign="left",this.ctx.fillText(this.data[t].name,35,this.legendTop+10+15*t*this.dpi)},getYFictitious:function(t){var i=t.slice(0);i.sort(function(t,i){return-(t.value-i.value)});var s=Math.ceil(i[0].value/this.yEqual),e=s.toString().length-1;return e=e>2?2:e,Math.ceil(s/Math.pow(10,e))*Math.pow(10,e)},getTotalValue:function(){for(var t=0,i=0;i<this.dataLength;i++)t+=this.data[i].value;return t}},i})},"21f4":function(t,i,s){"use strict";s.d(i,"b",function(){return n}),s.d(i,"a",function(){return o});s("4b02");var e=s("b6db"),a=s.n(e),h=s("d4aa");function n(t){return a.a.get(h["a"].params.subTypeQuery+"?dicType="+t)}function o(){var t=this;return new Promise(function(i,s){t.$axios.get(t.$api.department.findAll).then(function(e){if(200==e.code){var a=[],h=e.data.data;h.forEach(function(t){a.push({label:t.deptName,value:t.deptId})}),i(a)}else t.$message.error("部门列表数据查询失败: "+e.message),s(e.message)}).catch(function(i){t.$message.error("部门列表数据查询失败"),s("部门列表数据查询失败")})})}},7159:function(t,i,s){t.exports=s.p+"img/img.146655c9.jpg"},"7ed4":function(t,i,s){"use strict";var e=s("652e"),a=new e["default"];i["a"]=a},9395:function(t,i,s){(function(t){var e="undefined"!==typeof t&&t||"undefined"!==typeof self&&self||window,a=Function.prototype.apply;function h(t,i){this._id=t,this._clearFn=i}i.setTimeout=function(){return new h(a.call(setTimeout,e,arguments),clearTimeout)},i.setInterval=function(){return new h(a.call(setInterval,e,arguments),clearInterval)},i.clearTimeout=i.clearInterval=function(t){t&&t.close()},h.prototype.unref=h.prototype.ref=function(){},h.prototype.close=function(){this._clearFn.call(e,this._id)},i.enroll=function(t,i){clearTimeout(t._idleTimeoutId),t._idleTimeout=i},i.unenroll=function(t){clearTimeout(t._idleTimeoutId),t._idleTimeout=-1},i._unrefActive=i.active=function(t){clearTimeout(t._idleTimeoutId);var i=t._idleTimeout;i>=0&&(t._idleTimeoutId=setTimeout(function(){t._onTimeout&&t._onTimeout()},i))},s("989d"),i.setImmediate="undefined"!==typeof self&&self.setImmediate||"undefined"!==typeof t&&t.setImmediate||this&&this.setImmediate,i.clearImmediate="undefined"!==typeof self&&self.clearImmediate||"undefined"!==typeof t&&t.clearImmediate||this&&this.clearImmediate}).call(this,s("3b9d"))},"94eb":function(t,i,s){"use strict";var e=function(){var t=this,i=t.$createElement,s=t._self._c||i;return s("div",[s("canvas",{attrs:{id:t.canvasId}})])},a=[],h=s("1b3c"),n=s.n(h),o={data:function(){return{schart:null,opt:{}}},props:{canvasId:{type:String,default:""},type:{type:String,default:"bar"},data:{type:Array,default:[]},options:{type:Object,required:!1}},mounted:function(){this.renderChart()},methods:{renderChart:function(){this.schart=null,this.opt=this.options,this.width&&this.height||(this.opt?this.opt["autoWidth"]=!0:this.opt={autoWidth:!0}),this.schart=new n.a(this.canvasId,this.type,this.data,this.opt)}},watch:{data:function(){this.renderChart()},options:function(){this.renderChart()},type:function(){this.renderChart()}}},d=o,r=s("620d"),l=Object(r["a"])(d,e,a,!1,null,null,null);i["a"]=l.exports},"989d":function(t,i,s){(function(t,i){(function(t,s){"use strict";if(!t.setImmediate){var e,a=1,h={},n=!1,o=t.document,d=Object.getPrototypeOf&&Object.getPrototypeOf(t);d=d&&d.setTimeout?d:t,"[object process]"==={}.toString.call(t.process)?u():g()?p():t.MessageChannel?x():o&&"onreadystatechange"in o.createElement("script")?v():m(),d.setImmediate=r,d.clearImmediate=l}function r(t){"function"!==typeof t&&(t=new Function(""+t));for(var i=new Array(arguments.length-1),s=0;s<i.length;s++)i[s]=arguments[s+1];var n={callback:t,args:i};return h[a]=n,e(a),a++}function l(t){delete h[t]}function c(t){var i=t.callback,e=t.args;switch(e.length){case 0:i();break;case 1:i(e[0]);break;case 2:i(e[0],e[1]);break;case 3:i(e[0],e[1],e[2]);break;default:i.apply(s,e);break}}function f(t){if(n)setTimeout(f,0,t);else{var i=h[t];if(i){n=!0;try{c(i)}finally{l(t),n=!1}}}}function u(){e=function(t){i.nextTick(function(){f(t)})}}function g(){if(t.postMessage&&!t.importScripts){var i=!0,s=t.onmessage;return t.onmessage=function(){i=!1},t.postMessage("","*"),t.onmessage=s,i}}function p(){var i="setImmediate$"+Math.random()+"$",s=function(s){s.source===t&&"string"===typeof s.data&&0===s.data.indexOf(i)&&f(+s.data.slice(i.length))};t.addEventListener?t.addEventListener("message",s,!1):t.attachEvent("onmessage",s),e=function(s){t.postMessage(i+s,"*")}}function x(){var t=new MessageChannel;t.port1.onmessage=function(t){var i=t.data;f(i)},e=function(i){t.port2.postMessage(i)}}function v(){var t=o.documentElement;e=function(i){var s=o.createElement("script");s.onreadystatechange=function(){f(i),s.onreadystatechange=null,t.removeChild(s),s=null},t.appendChild(s)}}function m(){e=function(t){setTimeout(f,0,t)}}})("undefined"===typeof self?"undefined"===typeof t?this:t:self)}).call(this,s("3b9d"),s("f14f"))},e2ad:function(t,i,s){"use strict";s.r(i);var e=function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("div",[e("el-row",{attrs:{gutter:20}},[e("el-col",{attrs:{span:8}},[e("el-card",{staticClass:"mgb20",staticStyle:{height:"252px"},attrs:{shadow:"hover"}},[e("div",{staticClass:"user-info"},[e("img",{staticClass:"user-avator",attrs:{src:s("7159"),alt:""}}),e("div",{staticClass:"user-info-cont"},[e("div",{staticClass:"user-info-name"},[t._v(t._s(t.userInfo.name))]),e("div",[t._v(t._s(t.role))]),e("div",[t._v(t._s(t.deptName))])])]),e("div",{staticClass:"user-info-list"},[e("span",{staticClass:"lableTxt"},[t._v("上次登录时间：")]),e("span",[t._v(t._s(t.loginInfo.loginTime))])]),e("div",{staticClass:"user-info-list"},[e("span",{staticClass:"lableTxt"},[t._v("上次登录IP地址：")]),e("span",[t._v(t._s(t.loginInfo.ip))])])]),e("el-card",{staticStyle:{height:"189px"},attrs:{shadow:"hover"}},[e("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[e("span",[t._v("基本信息")])]),e("div",{staticClass:"base-info"},[e("p",[e("el-tag",[t._v("手机号: "+t._s(t.userInfo.mobileNo))])],1),e("p",[e("el-tag",{attrs:{type:"success"}},[t._v("公司邮箱: "+t._s(t.userInfo.companyEmail))])],1),e("p",[e("el-tag",{attrs:{type:"danger"}},[t._v("入司日期: "+t._s(t.userInfo.entryDate.split(" ")[0]))])],1)])])],1),e("el-col",{attrs:{span:16}},[e("el-row",{staticClass:"mgb20",attrs:{gutter:20}},[e("el-col",{attrs:{span:8}},[e("el-card",{attrs:{shadow:"hover","body-style":{padding:"0px"}}},[e("div",{staticClass:"grid-content grid-con-1"},[e("i",{staticClass:"el-icon-lx-calendar grid-con-icon"}),e("div",{staticClass:"grid-cont-right"},[e("div",{staticClass:"grid-num"},[t._v(t._s(t.workDays)+"天")]),e("div",[t._v(t._s(t.currentMonth)+"月正常上班天数")])])])])],1),e("el-col",{attrs:{span:8}},[e("el-card",{attrs:{shadow:"hover","body-style":{padding:"0px"}}},[e("div",{staticClass:"grid-content grid-con-2"},[e("i",{staticClass:"el-icon-lx-time grid-con-icon"}),e("div",{staticClass:"grid-cont-right"},[e("div",{staticClass:"grid-num"},[t._v(t._s(t.workHours)+"小时")]),e("div",[t._v(t._s(t.currentMonth)+"月加班小时数")])])])])],1),e("el-col",{attrs:{span:8}},[e("el-card",{attrs:{shadow:"hover","body-style":{padding:"0px"}}},[e("div",{staticClass:"grid-content grid-con-3"},[e("i",{staticClass:"el-icon-lx-calendar grid-con-icon"}),e("div",{staticClass:"grid-cont-right"},[e("div",{staticClass:"grid-num"},[t._v(t._s(t.leaveDays)+"天")]),e("div",[t._v(t._s(t.currentMonth)+"月请假数")])])])])],1)],1)],1),e("el-col",{attrs:{span:16}},[e("el-card",{attrs:{shadow:"hover"}},[e("schart",{ref:"line",staticClass:"schart",attrs:{canvasId:"line",data:t.vistedCountList,type:"line",options:t.options}})],1)],1)],1)],1)},a=[],h=s("94eb"),n=(s("7ed4"),s("21f4")),o=s("9395"),d={name:"dashboard",data:function(){return{userInfo:{},loginInfo:{},dictObj:{},deptList:[],currentMonth:"-",leaveDays:0,workHours:0,workDays:0,todoList:[],vistedCountList:[],options:{title:"最近七天每天的用户访问量",showValue:!0,fillColor:"rgb(45, 140, 240)",bottomPadding:30,topPadding:30}}},components:{Schart:h["a"]},computed:{role:function(){var t=this,i=this.dictObj["SYS_POWER"],s=i.filter(function(i){return i.dicCode===t.userInfo.jurisdiction});return s[0].dicValue},deptName:function(){var t=this,i=this.deptList.filter(function(i){return i.value==t.userInfo.deptId});return i.length?i[0].label:"-"}},created:function(){this.initLoginInfo(),this.dictObj=this.$store.state.dict.dictObj,this.initCurrentMonth(),this.initVistedData()},deactivated:function(){},methods:{initCurrentMonth:function(){var t=new Date;this.currentMonth=t.getMonth()+1},initLoginInfo:function(){var t=this;this.userInfo=this.$store.getters["login/userInfo"],this.loginInfo=this.$store.getters["login/loginInfo"],this.todoList=this.$store.getters["login/todoList"],this.leaveDays=this.userInfo.leaveDays,this.workHours=this.userInfo.workHours,this.workDays=this.userInfo.workDays,n["a"].call(this).then(function(i){t.deptList=i})},initVistedData:function(){var t=this;this.$axios.postForm(this.$api.statistics.views).then(function(i){if(200===i.code){var s=i.data.data;Object(o["setTimeout"])(function(){t.formatVistedData(s)},500)}})},formatVistedData:function(t){var i=[];for(var s in t){var e=t[s];i.push({name:e["date"].substr(5),value:e["views"]})}this.vistedCountList=i}}},r=d,l=(s("07b1"),s("620d")),c=Object(l["a"])(r,e,a,!1,null,"2b102134",null);i["default"]=c.exports},fec8:function(t,i,s){}}]);