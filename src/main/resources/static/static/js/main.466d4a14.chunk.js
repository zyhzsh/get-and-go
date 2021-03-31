(this.webpackJsonpreactpractice=this.webpackJsonpreactpractice||[]).push([[0],{258:function(e,t,n){"use strict";n.r(t);var i,a,c,r,s,o,l,u,d,j,p=n(0),m=n(20),b=n.n(m),x=n(22),O=n(24),h=n(278),f=n(23),g=n(46),v=n(155),y=f.a.nav(i||(i=Object(x.a)(["\n  background:black;\n  height: 80px;\n  display: flex;\n  justify-content: space-between;\n  padding: 0.5rem;\n  padding: 0.5rem calc((100vw-1000px) / 2);\n  z-index: 10;\n"]))),w=Object(f.a)(g.c)(a||(a=Object(x.a)(["\n  color: #fff;\n  display: flex;\n  align-items: center;\n  text-decoration: none;\n  padding: 0 1rem;\n  height: 100%;\n  cursor: pointer;\n  &.active {\n    color: #15cdfc;\n  }\n"]))),k=Object(f.a)(v.a)(c||(c=Object(x.a)(["\n  display: none;\n  color: #fff;\n\n  @media screen and (max-width: 768px) {\n    display: block;\n    position: absolute;\n    top: 0;\n    right: 0;\n    transform: translate(-100%, 75%);\n    font-size: 1.8rem;\n    cursor: pointer;\n  }\n"]))),q=f.a.div(r||(r=Object(x.a)(["\n  display: flex;\n  align-items: center;\n  margin-right: -24px;\n  @media screen and (max-width: 768px) {\n    display: none;\n  }\n"]))),C=f.a.nav(s||(s=Object(x.a)(["\n  display: flex;\n  align-items: center;\n  margin-right: 24px;\n\n  @media screen and (max-width: 768px) {\n    display: none;\n  }\n"]))),S=Object(f.a)(g.c)(o||(o=Object(x.a)(["\n  border-radius: 4px;\n  background: #256ce1;\n  padding: 10px 22px;\n  color: #fff;\n  border: none;\n  outline: none;\n  cursor: pointer;\n  transition: all 0.2s ease-in-out;\n  text-decoration: none;\n\n  &:hover {\n    transition: all 0.2s ease-in-out;\n    background: #fff;\n    color: 010606;\n  }\n"]))),I=n.p+"static/media/logo.ac835373.svg",_=n(6),E=function(){return Object(_.jsx)(_.Fragment,{children:Object(_.jsxs)(y,{children:[Object(_.jsx)(w,{to:"/",children:Object(_.jsx)("img",{src:I,alt:"logo"})}),Object(_.jsx)(k,{}),Object(_.jsxs)(q,{children:[Object(_.jsx)(w,{to:"/about",children:"About"}),Object(_.jsx)(w,{to:"/contactus",children:"Contact Us"}),Object(_.jsx)(w,{to:"/signup",children:"Sign Up"}),Object(_.jsx)(w,{to:"/admin",children:"Admin Demo"}),Object(_.jsx)(w,{to:"/vendor",children:"Vendor Demo"})]}),Object(_.jsx)(C,{children:Object(_.jsx)(S,{to:"/signin",children:"Sign In"})})]})})},T=n(65),A=n(50),D=n(35),F=n.n(D),P=n(54),L=n(55),N=n.n(L),H="api/products",R=function(e){return"".concat(H,"?category=").concat(e.toLowerCase())},B=function(e){return"".concat(H,"?city=").concat(e.toLowerCase())},U=function(e,t){return"".concat(H,"?category=").concat(t.toLowerCase(),"&city=").concat(e.toLowerCase())},z=n(284),V=n(74),G=h.a.Sider,Q=function(e){var t=e.SetCity,n=function(e){t(e)};return Object(_.jsx)(G,{className:"site-layout-background",width:200,children:Object(_.jsxs)(V.a,{mode:"inline",defaultSelectedKeys:["All"],style:{height:"100%"},children:[Object(_.jsx)(V.a.Item,{onClick:function(e){n(e.key)},children:"All-City"},"All"),Object(_.jsx)(V.a.Item,{onClick:function(e){n(e.key)},children:"Eindohoven"},"Eindohoven"),Object(_.jsx)(V.a.Item,{onClick:function(e){n(e.key)},children:"Tilburg"},"Tilburg"),Object(_.jsx)(V.a.Item,{onClick:function(e){n(e.key)},children:"Utrecht"},"Utrecht"),Object(_.jsx)(V.a.Item,{onClick:function(e){n(e.key)},children:"Delft"},"Delft"),Object(_.jsx)(V.a.Item,{onClick:function(e){n(e.key)},children:"Haarlem"},"Haarlem"),Object(_.jsx)(V.a.Item,{onClick:function(e){n(e.key)},children:"Breda"},"Breda")]})})},W=n(299),K=n(287),J=n(281),M=n(280),X=n(298),Y=Object(f.a)(W.a)(l||(l=Object(x.a)(["\n    max-width:250px;\n    margin-left:0.5rem;\n    margin-top:1rem;\n    display:block;\n    height:350px;\n"]))),Z=function(e){var t=e.product;return Object(_.jsx)(Y,{children:Object(_.jsxs)(K.a,{children:[Object(_.jsx)(M.a,{component:"img",alt:"Contemplative Reptile",height:"150",image:t.img,title:"Contemplative Reptile"}),Object(_.jsxs)(J.a,{children:[Object(_.jsx)(X.a,{gutterBottom:!0,variant:"h6",component:"h2",children:t.product_name}),Object(_.jsxs)(X.a,{variant:"body2",color:"textSecondary",component:"p",children:["Price: \u20ac",t.price,Object(_.jsx)("br",{}),t.description]}),Object(_.jsx)(X.a,{variant:"body2",color:"textSecondary",component:"p"})]})]})})},$=n(145),ee=n(285),te=f.a.div(u||(u=Object(x.a)(["\n  padding: 1rem;\n  height: 75vh;\n  overflow: auto;\n  background: #ffffff;\n  display: flex;\n  flex-direction: row;\n  flex-wrap: wrap;\n  justify-content: space-around;\n  align-items: stretch;\n  align-content: stretch;\n\n  &::-webkit-scrollbar {\n    padding-top: 20px;\n    width: 0.5rem;\n  }\n  &::-webkit-scrollbar-thumb {\n    background-color: darkgrey;\n  }\n  &::-webkit-scrollbar-track {\n    background: linear-gradient(\n      to right bottom,\n      rgba(255, 255, 255, 0.7),\n      rgba(255, 255, 255, 0.3)\n    );\n  }\n"]))),ne=function(e){var t=e.productlist;return t.length>0?Object(_.jsx)(te,{children:t.map((function(e,t){return Object(_.jsx)(Z,{product:e},t)}))}):Object(_.jsx)(te,{children:Object(_.jsx)($.a,{tip:"Loading...",children:Object(_.jsx)(ee.a,{message:"Trying to loading latest data...",description:"If there is no news for a long time, it means we may not have such data yet.",type:"info"})})})},ie=z.a.TabPane,ae=h.a.Content,ce=f.a.div(d||(d=Object(x.a)(["\n  height:auto;\n  width:auto;\n"]))),re=function(){var e=Object(p.useState)("All"),t=Object(T.a)(e,2),n=t[0],i=t[1],a=Object(p.useState)("All"),c=Object(T.a)(a,2),r=c[0],s=c[1],o=Object(A.b)(),l=Object(A.c)((function(e){return e.products.products})),u=Object(p.useCallback)((function(){var e,t;"All"===n&&"All"===r?o(function(){var e=Object(P.a)(F.a.mark((function e(t){var n;return F.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,N.a.get(H);case 2:n=e.sent,t({type:"FETCH_PRODUCTS",payload:{products:n}});case 4:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}()):"All"===n&&"All"!==r?o((t=r,function(){var e=Object(P.a)(F.a.mark((function e(n){var i;return F.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,N.a.get(R(t));case 2:i=e.sent,n({type:"FETCH_PRODUCTS",payload:{products:i}});case 4:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}())):"All"!==n&&"All"===r?o((e=n,function(){var t=Object(P.a)(F.a.mark((function t(n){var i;return F.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,N.a.get(B(e));case 2:i=t.sent,n({type:"FETCH_PRODUCTS",payload:{products:i}});case 4:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}())):"All"!==n&&"All"!==r&&o(function(e,t){return function(){var n=Object(P.a)(F.a.mark((function n(i){var a;return F.a.wrap((function(n){for(;;)switch(n.prev=n.next){case 0:return n.next=2,N.a.get(U(e,t));case 2:a=n.sent,i({type:"FETCH_PRODUCTS",payload:{products:a}});case 4:case"end":return n.stop()}}),n)})));return function(e){return n.apply(this,arguments)}}()}(n,r))}),[o,r,n]);return Object(p.useEffect)((function(){u()}),[u]),Object(_.jsx)(ae,{style:{padding:"0 50px"},children:Object(_.jsxs)(h.a,{className:"site-layout-background",style:{padding:"24px 0"},children:[Object(_.jsx)(Q,{SetCity:i}),Object(_.jsx)(ae,{style:{padding:"0 24px",minHeight:280},children:Object(_.jsx)(ce,{children:Object(_.jsxs)(z.a,{defaultActiveKey:"All",onChange:function(e){return s(e)},children:[Object(_.jsx)(ie,{tab:"All",children:Object(_.jsx)(ne,{productlist:l})},"All"),Object(_.jsx)(ie,{tab:"Food",children:Object(_.jsx)(ne,{productlist:l})},"Food"),Object(_.jsx)(ie,{tab:"Event",children:Object(_.jsx)(ne,{productlist:l})},"Event"),Object(_.jsx)(ie,{tab:"Hotel",children:Object(_.jsx)(ne,{productlist:l})},"Hotel"),Object(_.jsx)(ie,{tab:"Wellness",children:Object(_.jsx)(ne,{productlist:l})},"Wellness"),Object(_.jsx)(ie,{tab:"WorkShop",children:Object(_.jsx)(ne,{productlist:l})},"WorkShop"),Object(_.jsx)(ie,{tab:"Speciality",children:Object(_.jsx)(ne,{productlist:l})},"Speciality")]})})})]})})};var se,oe=f.a.div(j||(j=Object(x.a)(["\n    height:100vh;\n    display: flex;\n\tflex-direction: column;\n\tflex-wrap: wrap;\n\tjustify-content: flex-start;\n\talign-items: center;\n\talign-content: center;\n    h1{\n        line-height:10rem;\n    }\n    p{\n        width:800px;\n    }\n"]))),le=function(){return Object(_.jsxs)(oe,{children:[Object(_.jsx)("h1",{children:"Title"}),Object(_.jsx)("p",{children:"Lorem ipsum, dolor sit amet consectetur adipisicing elit. In, explicabo! Optio doloremque repudiandae laborum quisquam accusamus reici endis autem accusantium. Qui tempora tenetur odio asperiores atque neque! Eaque, necessitatibus ea quisquam optio voluptatum fuga perspiciatis nulla possimus doloribus est quidem amet ab! Autem eveniet explicabo nemo quidem ut assumenda. Dolore corrupti quibusdam numquam voluptatum eos, dicta cumque consequatur suscipit repellendus voluptate illum omnis, maxime eum sit atque veniam aliquam dolor dolorem nisi optio? Dolorem at commodi laboriosam eveniet dolore nam voluptatum dolorum corrupti cumque quia error hic quidem dignissimos optio aspernatur aliquam culpa quis rem ad repellendus minus possimus, quae repudiandae. Vitae totam recusandae eius odit veniam quas ipsum laboriosam quaerat provident fugiat. Quam quibusdam ab, soluta aliquid nemo incidunt assumenda nisi voluptatibus minima iusto dicta aut dolore at magni facere earum accusamus. Expedita alias odio earum totam repellat tempora culpa ratione, iste voluptas sequi eligendi, blanditiis nam illo quis reiciendis."}),Object(_.jsx)("p",{children:"Lorem ipsum dolor sit amet consectetur adipisicing elit. Nesciunt, magni adipisci ipsum assumenda amet itaque delectus ullam tempora odit necessitatibus dicta eum, sit mollitia, suscipit accusantium illum rerum debitis officiis consequatur nisi. Iure quod saepe, veritatis sint molestiae voluptatum commodi at voluptate culpa eum mollitia adipisci vitae nulla blanditiis labore earum, ex tempora voluptatem aspernatur praesentium fugit et nisi ea. Voluptatum libero placeat deleniti enim consequuntur officiis. Est, eveniet? Iste, assumenda! Doloremque dolorum, rem fugiat ex, veritatis iste magnam beatae voluptas asperiores, alias fugit commodi dolore saepe! Quod ipsum repudiandae deserunt veritatis blanditiis illo commodi itaque rem eligendi, modi suscipit ratione iusto illum dignissimos eius alias odio molestias voluptas? In beatae sit similique impedit cupiditate quod. Provident minus incidunt repellat nisi officia autem omnis ipsa! Beatae eligendi tempora natus mollitia ut earum vero repellendus incidunt? Voluptatem officiis voluptatibus perferendis provident expedita iusto molestiae sapiente ipsum impedit pariatur quisquam enim, beatae accusamus harum in odio voluptates autem soluta laborum. Quisquam delectus dolores quam accusamus autem dolor explicabo. Commodi tenetur dolorem ad laborum quod sunt quisquam, eius eligendi dignissimos a molestiae magnam velit distinctio ab sit minima cumque. Quo eos architecto vel quasi, iste animi odio cumque quae pariatur nobis qui ad quos ullam at inventore harum rem modi magnam iusto reiciendis consequuntur. Maxime, soluta. Doloremque repellendus asperiores quis. Quaerat adipisci, eveniet, reprehenderit cupiditate eos vel vero aliquam quod, impedit rerum modi."})]})},ue=n(60),de=n(58);var je,pe,me,be=f.a.div(se||(se=Object(x.a)(["\n  height: 100vh;\n  display: flex;\n  flex-direction: column;\n  flex-wrap: nowrap;\n  justify-content: center;\n  align-items: center;\n  align-content: center;\n"]))),xe=function(){return Object(_.jsxs)(be,{children:[Object(_.jsx)(ue.a,{description:"Not Found"}),Object(_.jsx)("div",{children:Object(_.jsx)(g.b,{to:"/",children:Object(_.jsx)(de.a,{type:"primary",size:"large",children:"Go Back To Home Page ?"})})})]})},Oe=n(283),he=n(286),fe=n(289),ge=n(290),ve=f.a.div(je||(je=Object(x.a)(["\n  height: 100vh;\n  display: flex;\n  justify-content: center;\n  align-items: center;\n"]))),ye=function(){var e=Object(A.b)();return Object(_.jsx)(ve,{children:Object(_.jsxs)(Oe.a,{name:"normal_login",className:"login-form",onFinish:function(t){var n,i;t&&e((n=t.email,i=t.password,function(){var e=Object(P.a)(F.a.mark((function e(t){var a;return F.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return console.log(n),e.next=3,N.a.post("api/login",{email:n,password:i});case 3:a=e.sent,t({type:"LOG_IN",payload:{user:a.data}});case 5:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}()))},children:[Object(_.jsx)("h1",{children:"Sign In "}),Object(_.jsx)(Oe.a.Item,{name:"email",rules:[{required:!0,message:"Please input your Email!"}],children:Object(_.jsx)(he.a,{prefix:Object(_.jsx)(fe.a,{className:"site-form-item-icon"}),placeholder:"Email"})}),Object(_.jsx)(Oe.a.Item,{name:"password",rules:[{required:!0,message:"Please input your Password!"}],children:Object(_.jsx)(he.a,{prefix:Object(_.jsx)(ge.a,{className:"site-form-item-icon"}),type:"password",placeholder:"Password"})}),Object(_.jsx)(Oe.a.Item,{children:Object(_.jsx)(g.b,{to:"/",children:"Forgot password"})}),Object(_.jsxs)(Oe.a.Item,{children:[Object(_.jsx)(de.a,{type:"primary",htmlType:"submit",className:"login-form-button",children:"Log in"}),"Or",Object(_.jsx)(g.b,{to:"signup",children:" register now!"})]})]})})},we=f.a.div(pe||(pe=Object(x.a)(["\n    height:100vh;\n    display:flex;\n    justify-content:center;\n    align-items:center;\n"]))),ke=function(){return Object(_.jsx)(we,{children:"SignUp Page"})},qe=n(291),Ce=n(292),Se=n(293),Ie=f.a.div(me||(me=Object(x.a)(["\n  margin-top: 1rem;\n  display: flex;\n  justify-content: center;\n  align-items: center;\n  text-align: center;\nbackground:grey;\n  height: 7vh;\n"]))),_e=function(){return Object(_.jsxs)(h.a,{style:{height:"100vh"},children:[Object(_.jsx)(E,{}),Object(_.jsxs)(O.c,{children:[Object(_.jsx)(O.a,{exact:!0,path:"/",component:re}),Object(_.jsx)(O.a,{exact:!0,path:"/about",component:le}),Object(_.jsx)(O.a,{exact:!0,path:"/signin",component:ye}),Object(_.jsx)(O.a,{exact:!0,path:"/signup",component:ke}),Object(_.jsx)(O.a,{component:xe})]}),Object(_.jsxs)(Ie,{children:[Object(_.jsx)(qe.a,{style:{fontSize:"1.5rem"}}),Object(_.jsx)(Ce.a,{style:{fontSize:"1.5rem",marginLeft:"2px"}}),Object(_.jsx)(Se.a,{style:{fontSize:"1.5rem",marginLeft:"2px",marginRight:"2px"}}),"GetAndGo BV \xa92021"]})]})},Ee=function(){return Object(_.jsx)("div",{children:Object(_.jsx)("h1",{children:"DashBoard"})})},Te=n(288),Ae=n(282),De=n(294),Fe=function(){var e=Object(A.b)(),t=Object(A.c)((function(e){return e.store.store})),n=Object(p.useState)(!1),i=Object(T.a)(n,2),a=i[0],c=i[1];Object(p.useEffect)((function(){a||(c(!0),e(function(){var e=Object(P.a)(F.a.mark((function e(t){var n;return F.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,N.a.get("api/stores");case 2:n=e.sent,t({type:"FETCH_STORES",payload:{store:n}});case 4:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}()),console.log(t))}),[e,t,a]);var r=[{title:"Store ID",dataIndex:"store_id",key:"store_id"},{title:"Store Name",dataIndex:"store_name",key:"store_name"},{title:"Owner ID",dataIndex:"owner_id",key:"owner_id"},{title:"City",dataIndex:"city",key:"city"},{title:"Address",dataIndex:"address",key:"address"},{title:"Offical Website",dataIndex:"official_website",key:"official_website"},{title:"Action",key:"action",render:function(e,t){return Object(_.jsx)(Te.b,{size:"middle"})}}];return Object(_.jsxs)("div",{children:[Object(_.jsx)("h2",{children:"Store"}),Object(_.jsx)(Ae.a,{title:function(){return Object(_.jsx)(de.a,{type:"primary",shape:"round",icon:Object(_.jsx)(De.a,{}),size:"large",children:"Add New"})},columns:r,dataSource:t})]})},Pe=function(){return Object(_.jsx)("div",{children:Object(_.jsx)("h2",{children:"Orders"})})},Le=function(){return Object(_.jsx)("div",{children:Object(_.jsx)("h1",{children:"Reviewssssss"})})},Ne=n(295),He=n(296),Re=n(297),Be=function(){var e=h.a.Header,t=h.a.Content,n=h.a.Footer,i=h.a.Sider,a=Object(p.useState)(!1),c=Object(T.a)(a,2),r=c[0],s=c[1],o=Object(p.useState)("DashBoard"),l=Object(T.a)(o,2),u=l[0],d=l[1];return Object(_.jsxs)(h.a,{style:{minHeight:"100vh"},children:[Object(_.jsxs)(i,{collapsible:!0,collapsed:r,onCollapse:function(e){s(e)},children:[Object(_.jsx)("img",{src:I,alt:"logo"}),Object(_.jsxs)(V.a,{theme:"dark",defaultSelectedKeys:["DashBoard"],mode:"inline",children:[Object(_.jsx)(V.a.Item,{onClick:function(e){d(e.key)},icon:Object(_.jsx)(Ne.a,{}),children:"DashBoard"},"DashBoard"),Object(_.jsx)(V.a.Item,{onClick:function(e){d(e.key)},icon:Object(_.jsx)(He.a,{}),children:"Store"},"Store"),Object(_.jsx)(V.a.Item,{onClick:function(e){d(e.key)},icon:Object(_.jsx)(fe.a,{}),children:"Order"},"Order"),Object(_.jsx)(V.a.Item,{onClick:function(e){d(e.key)},icon:Object(_.jsx)(Re.a,{}),children:"Review"},"Review")]})]}),Object(_.jsxs)(h.a,{className:"site-layout",children:[Object(_.jsx)(e,{className:"site-layout-background",style:{padding:0},children:Object(_.jsx)(de.a,{})}),Object(_.jsx)(t,{style:{margin:"30px 16px"},children:"DashBoard"===u?Object(_.jsx)(Ee,{}):"Store"===u?Object(_.jsx)(Fe,{}):"Order"===u?Object(_.jsx)(Pe,{}):"Review"===u?Object(_.jsx)(Le,{}):void 0}),Object(_.jsx)(n,{style:{textAlign:"center"},children:"\xa92021"})]})]})};var Ue=function(){return Object(_.jsx)("div",{children:"Vendor Page"})};var ze=function(){return Object(_.jsx)(g.a,{children:Object(_.jsxs)(O.c,{children:[Object(_.jsx)(O.a,{exact:!0,path:"/admin",component:Be}),Object(_.jsx)(O.a,{exact:!0,path:"/vendor",component:Ue}),Object(_.jsx)(O.a,{path:"/",component:_e})]})})},Ve=function(e){e&&e instanceof Function&&n.e(3).then(n.bind(null,300)).then((function(t){var n=t.getCLS,i=t.getFID,a=t.getFCP,c=t.getLCP,r=t.getTTFB;n(e),i(e),a(e),c(e),r(e)}))},Ge=n(64),Qe=n(37),We={products:[]},Ke=function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:We,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case"FETCH_PRODUCTS":return Object(Qe.a)(Object(Qe.a)({},e),{},{products:t.payload.products.data});default:return Object(Qe.a)({},e)}},Je={user:null,login:null,accounttype:null,userprofile:null},Me=function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:Je,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case"LOG_IN":return Object(Qe.a)(Object(Qe.a)({},e),{},{user:t.payload.user,login:t.payload.login});case"LOG_OUT":return Object(Qe.a)(Object(Qe.a)({},e),{},{user:null});default:return Object(Qe.a)({},e)}},Xe={store:[]},Ye=function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:Xe,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case"FETCH_STORES":return Object(Qe.a)(Object(Qe.a)({},e),{},{store:t.payload.store.data});default:return Object(Qe.a)({},e)}},Ze=Object(Ge.c)({user:Me,products:Ke,store:Ye}),$e=n(150),et=(n(257),window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__||Ge.d),tt=Object(Ge.e)(Ze,et(Object(Ge.a)($e.a)));b.a.render(Object(_.jsx)(_.Fragment,{children:Object(_.jsx)(A.a,{store:tt,children:Object(_.jsx)(ze,{})})}),document.getElementById("root")),Ve()}},[[258,1,2]]]);
//# sourceMappingURL=main.466d4a14.chunk.js.map