(function(t){function e(e){for(var o,i,c=e[0],u=e[1],l=e[2],d=0,p=[];d<c.length;d++)i=c[d],Object.prototype.hasOwnProperty.call(r,i)&&r[i]&&p.push(r[i][0]),r[i]=0;for(o in u)Object.prototype.hasOwnProperty.call(u,o)&&(t[o]=u[o]);s&&s(e);while(p.length)p.shift()();return a.push.apply(a,l||[]),n()}function n(){for(var t,e=0;e<a.length;e++){for(var n=a[e],o=!0,c=1;c<n.length;c++){var u=n[c];0!==r[u]&&(o=!1)}o&&(a.splice(e--,1),t=i(i.s=n[0]))}return t}var o={},r={app:0},a=[];function i(e){if(o[e])return o[e].exports;var n=o[e]={i:e,l:!1,exports:{}};return t[e].call(n.exports,n,n.exports,i),n.l=!0,n.exports}i.m=t,i.c=o,i.d=function(t,e,n){i.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:n})},i.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},i.t=function(t,e){if(1&e&&(t=i(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var n=Object.create(null);if(i.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var o in t)i.d(n,o,function(e){return t[e]}.bind(null,o));return n},i.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return i.d(e,"a",e),e},i.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},i.p="/";var c=window["webpackJsonp"]=window["webpackJsonp"]||[],u=c.push.bind(c);c.push=e,c=c.slice();for(var l=0;l<c.length;l++)e(c[l]);var s=u;a.push([0,"chunk-vendors"]),n()})({0:function(t,e,n){t.exports=n("56d7")},"034f":function(t,e,n){"use strict";n("85ec")},"4e22":function(t,e,n){},"56d7":function(t,e,n){"use strict";n.r(e);n("e260"),n("e6cf"),n("cca6"),n("a79d");var o=n("2b0e"),r=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"app"}},[n("board-header"),n("router-view")],1)},a=[],i=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("h1",[t._v("Happy House Board")]),n("div",[n("router-link",{attrs:{to:"/list"}},[t._v("게시글 목록")]),t._v(" "),n("router-link",{attrs:{to:"/register"}},[t._v("게시글 추가")])],1)])},c=[],u={},l=u,s=n("2877"),d=Object(s["a"])(l,i,c,!1,null,null,null),p=d.exports,f={name:"App",components:{BoardHeader:p}},v=f,b=(n("034f"),Object(s["a"])(v,r,a,!1,null,null,null)),h=b.exports,m=n("8c4f"),_=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("section",[n("transition-group",{attrs:{name:"list",tag:"ul"}},t._l(t.boardlist,(function(e){return n("li",{key:e.no,staticClass:"shadow",on:{click:function(n){return t.showDetailBoard(e.no)}}},[n("span",[t._v(" "+t._s(e.no)+". "+t._s(e.content)+" "+t._s(e.writer)+" ")])])})),0),n("BoardFooter")],1)},O=[],g=n("5530"),w=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("router-link",{attrs:{to:"/register"}},[t._v("등록하기")])],1)},y=[],j={},x=j,A=Object(s["a"])(x,w,y,!1,null,null,null),B=A.exports,D=n("2f62"),$={components:{BoardFooter:B},created:function(){this.$store.dispatch("ALLBOARD")},computed:Object(g["a"])({},Object(D["b"])(["boardlist"])),methods:{showDetailBoard:function(t){this.$router.push("/detail/"+t)}}},R=$,L=(n("d398"),Object(s["a"])(R,_,O,!1,null,"e15be59a",null)),k=L.exports,P=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"inputBox shadow"},[n("span",[t._v(" 제목 "),n("input",{directives:[{name:"model",rawName:"v-model",value:t.title,expression:"title"}],attrs:{type:"text"},domProps:{value:t.title},on:{input:function(e){e.target.composing||(t.title=e.target.value)}}}),n("br")]),n("span",[t._v(" 작성자 "),n("input",{directives:[{name:"model",rawName:"v-model",value:t.writer,expression:"writer"}],attrs:{type:"text"},domProps:{value:t.writer},on:{input:function(e){e.target.composing||(t.writer=e.target.value)}}}),n("br")]),n("span",[t._v(" 내용 "),n("input",{directives:[{name:"model",rawName:"v-model",value:t.content,expression:"content"}],attrs:{type:"text"},domProps:{value:t.content},on:{input:function(e){e.target.composing||(t.content=e.target.value)}}}),n("br")]),n("button",{on:{click:t.addTodo}},[t._v("등록")]),t._v(" "),n("button",{on:{click:t.cancle}},[t._v("돌아가기")])])},S=[],H={data:function(){return{title:null,content:null,writer:null}},methods:{addTodo:function(){if(null!=this.title&&null!=this.content&&null!=this.writer){var t={title:this.title,content:this.content,writer:this.writer};this.$store.dispatch("ADDBOARD",t),this.$router.push("/")}else alert("내용을 입력해 주세요")},cancle:function(){this.$router.push("/")}}},E=H,T=(n("c428"),Object(s["a"])(E,P,S,!1,null,null,null)),M=T.exports,W=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("table",[n("tbody",[n("tr",[n("td",[t._v("번호")]),n("td",[t._v(" "+t._s(t.board.no)+" ")])]),n("tr",[n("td",[t._v("제목")]),n("td",[t._v(" "+t._s(t.board.title)+" ")])]),n("tr",[n("td",[t._v("내용")]),n("td",[t._v(" "+t._s(t.board.content)+" ")])]),n("tr",[n("td",[t._v("글쓴이")]),n("td",[t._v(" "+t._s(t.board.writer)+" ")])]),n("tr",[n("td",[t._v("날짜")]),n("td",[t._v(" "+t._s(t.board.wdate)+" ")])])])])])},q=[],C={created:function(){var t=this.$route.params.no;console.log("boardno: ",t),this.$store.dispatch("SHOWBOARD",{num:t})},computed:Object(g["a"])({},Object(D["b"])(["board"]))},N=C,F=(n("f7a7"),Object(s["a"])(N,W,q,!1,null,"6b078e50",null)),J=F.exports;o["a"].use(m["a"]);var U=new m["a"]({mode:"history",routes:[{path:"/",component:k},{path:"/list",component:k},{path:"/register",component:M},{path:"/detail/:no",component:J}]}),z=n("bc3a"),G=n.n(z),I=G.a.create({baseURL:"http://localhost",headers:{"Content-type":"application/json"}});o["a"].use(D["a"]);var K=new D["a"].Store({state:{boardlist:[],board:null},getters:{boardlist:function(t){return t.boardlist},board:function(t){return t.board}},actions:{ALLBOARD:function(t){I.get("/api/qna").then((function(e){t.commit("ALLBOARD",{boardlist:e.data})})).catch((function(t){console.log(t)}))},SHOWBOARD:function(t,e){console.log(e),I.get("/api/qna/"+e.num).then((function(e){t.commit("SHOWBOARD",{board:e.data}),console.log("조회 처리하였습니다.")})).catch((function(t){return alert("조회 처리에 실패하였습니다."+t)}))},ADDBOARD:function(t,e){console.log(e),I.post("/api/qna",e).then((function(){console.log("추가 처리했습니다"),t.dispatch("ALLBOARD")})).catch((function(t){return alert("추가 처리에 실패하였습니다."+t)}))}},mutations:{ALLBOARD:function(t,e){t.boardlist=e.boardlist},SHOWBOARD:function(t,e){t.board=e.board}}});o["a"].config.productionTip=!1,new o["a"]({router:U,store:K,render:function(t){return t(h)}}).$mount("#app")},8433:function(t,e,n){},"85ec":function(t,e,n){},c428:function(t,e,n){"use strict";n("4e22")},d398:function(t,e,n){"use strict";n("8433")},f7a7:function(t,e,n){"use strict";n("fa4c")},fa4c:function(t,e,n){}});
//# sourceMappingURL=app.136e5ee7.js.map