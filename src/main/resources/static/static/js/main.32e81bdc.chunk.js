(this.webpackJsonpreactpractice=this.webpackJsonpreactpractice||[]).push([[0],{284:function(e,t,n){"use strict";n.r(t);var a,i,r,s,c,o,l,d,u,j,b=n(0),m=n(16),p=n.n(m),h=n(22),O=n(25),x=n(304),f=n(23),g=n(58),v=n(179),y=f.a.nav(a||(a=Object(h.a)(["\n  background:black;\n  height: 80px;\n  display: flex;\n  justify-content: space-between;\n  padding: 0.5rem;\n  padding: 0.5rem calc((100vw-1000px) / 2);\n  z-index: 10;\n"]))),w=Object(f.a)(g.c)(i||(i=Object(h.a)(["\n  color: #fff;\n  display: flex;\n  align-items: center;\n  text-decoration: none;\n  padding: 0 1rem;\n  height: 100%;\n  cursor: pointer;\n  &.active {\n    color: #15cdfc;\n  }\n"]))),S=Object(f.a)(v.a)(r||(r=Object(h.a)(["\n  display: none;\n  color: #fff;\n\n  @media screen and (max-width: 768px) {\n    display: block;\n    position: absolute;\n    top: 0;\n    right: 0;\n    transform: translate(-100%, 75%);\n    font-size: 1.8rem;\n    cursor: pointer;\n  }\n"]))),k=f.a.div(s||(s=Object(h.a)(["\n  display: flex;\n  align-items: center;\n  margin-right: -24px;\n  @media screen and (max-width: 768px) {\n    display: none;\n  }\n"]))),q=f.a.nav(c||(c=Object(h.a)(["\n  display: flex;\n  align-items: center;\n  margin-right: 24px;\n\n  @media screen and (max-width: 768px) {\n    display: none;\n  }\n"]))),_=Object(f.a)(g.c)(o||(o=Object(h.a)(["\n  border-radius: 4px;\n  background: #256ce1;\n  padding: 10px 22px;\n  color: #fff;\n  border: none;\n  outline: none;\n  cursor: pointer;\n  transition: all 0.2s ease-in-out;\n  text-decoration: none;\n\n  &:hover {\n    transition: all 0.2s ease-in-out;\n    background: #fff;\n    color: 010606;\n  }\n"]))),C=n.p+"static/media/logo.d79996d0.svg",I=n(3),E=function(){return Object(I.jsx)(I.Fragment,{children:Object(I.jsxs)(y,{children:[Object(I.jsx)(w,{to:"/",children:Object(I.jsx)("img",{src:C,alt:"logo"})}),Object(I.jsx)(S,{}),Object(I.jsxs)(k,{children:[Object(I.jsx)(w,{to:"/about",children:"About"}),Object(I.jsx)(w,{to:"/contactus",children:"Contact Us"}),Object(I.jsx)(w,{to:"/signup",children:"Sign Up"}),Object(I.jsx)(w,{to:"/admin",children:"Admin Demo"}),Object(I.jsx)(w,{to:"/vendor",children:"Vendor Demo"})]}),Object(I.jsx)(q,{children:Object(I.jsx)(_,{to:"/signin",children:"Sign In"})})]})})},P=n(31),T=n(36),D=n(21),A=n.n(D),R=n(42),N=n(43),F=n.n(N),V="api/products",B=function(e){return"".concat(V,"?category=").concat(e.toLowerCase())},L=function(e){return"".concat(V,"?city=").concat(e.toLowerCase())},H=function(e,t){return"".concat(V,"?category=").concat(t.toLowerCase(),"&city=").concat(e.toLowerCase())},U=function(e){return"api/stores?id=".concat(e)},W=n(311),z=n(85),G=x.a.Sider,Q=function(e){var t=e.SetCity,n=function(e){t(e)};return Object(I.jsx)(G,{className:"site-layout-background",width:200,children:Object(I.jsxs)(z.a,{mode:"inline",defaultSelectedKeys:["All"],style:{height:"100%"},children:[Object(I.jsx)(z.a.Item,{onClick:function(e){n(e.key)},children:"All-City"},"All"),Object(I.jsx)(z.a.Item,{onClick:function(e){n(e.key)},children:"Eindohoven"},"Eindohoven"),Object(I.jsx)(z.a.Item,{onClick:function(e){n(e.key)},children:"Tilburg"},"Tilburg"),Object(I.jsx)(z.a.Item,{onClick:function(e){n(e.key)},children:"Utrecht"},"Utrecht"),Object(I.jsx)(z.a.Item,{onClick:function(e){n(e.key)},children:"Delft"},"Delft"),Object(I.jsx)(z.a.Item,{onClick:function(e){n(e.key)},children:"Haarlem"},"Haarlem"),Object(I.jsx)(z.a.Item,{onClick:function(e){n(e.key)},children:"Breda"},"Breda")]})})},K=n(329),Y=n(315),M=n(307),J=n(306),X=n(328),Z=Object(f.a)(K.a)(l||(l=Object(h.a)(["\n    max-width:250px;\n    margin-left:0.5rem;\n    margin-top:1rem;\n    display:block;\n    height:350px;\n"]))),$=function(e){var t=e.product;return Object(I.jsx)(Z,{children:Object(I.jsxs)(Y.a,{children:[Object(I.jsx)(J.a,{component:"img",alt:"Contemplative Reptile",height:"150",image:t.img,title:"Contemplative Reptile"}),Object(I.jsxs)(M.a,{children:[Object(I.jsx)(X.a,{gutterBottom:!0,variant:"h6",component:"h2",children:t.product_name}),Object(I.jsxs)(X.a,{variant:"body2",color:"textSecondary",component:"p",children:["Price: \u20ac",t.price,Object(I.jsx)("br",{}),t.description]}),Object(I.jsx)(X.a,{variant:"body2",color:"textSecondary",component:"p"})]})]})})},ee=n(167),te=n(317),ne=f.a.div(d||(d=Object(h.a)(["\n  padding: 1rem;\n  height: 75vh;\n  overflow: auto;\n  background: #ffffff;\n  display: flex;\n  flex-direction: row;\n  flex-wrap: wrap;\n  justify-content: space-around;\n  align-items: stretch;\n  align-content: stretch;\n\n  &::-webkit-scrollbar {\n    padding-top: 20px;\n    width: 0.5rem;\n  }\n  &::-webkit-scrollbar-thumb {\n    background-color: darkgrey;\n  }\n  &::-webkit-scrollbar-track {\n    background: linear-gradient(\n      to right bottom,\n      rgba(255, 255, 255, 0.7),\n      rgba(255, 255, 255, 0.3)\n    );\n  }\n"]))),ae=function(e){var t=e.productlist;return t.length>0?Object(I.jsx)(ne,{children:t.map((function(e,t){return Object(I.jsx)($,{product:e},t)}))}):Object(I.jsx)(ne,{children:Object(I.jsx)(ee.a,{tip:"Loading...",children:Object(I.jsx)(te.a,{message:"Trying to loading latest data...",description:"If there is no news for a long time, it means we may not have such data yet.",type:"info"})})})},ie=W.a.TabPane,re=x.a.Content,se=f.a.div(u||(u=Object(h.a)(["\n  height:auto;\n  width:auto;\n"]))),ce=function(){var e=Object(b.useState)("All"),t=Object(P.a)(e,2),n=t[0],a=t[1],i=Object(b.useState)("All"),r=Object(P.a)(i,2),s=r[0],c=r[1],o=Object(T.b)(),l=Object(T.c)((function(e){return e.products.products})),d=Object(b.useCallback)((function(){var e,t;"All"===n&&"All"===s?o(function(){var e=Object(R.a)(A.a.mark((function e(t){var n;return A.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,F.a.get(V);case 2:n=e.sent,t({type:"FETCH_PRODUCTS",payload:{products:n}});case 4:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}()):"All"===n&&"All"!==s?o((t=s,function(){var e=Object(R.a)(A.a.mark((function e(n){var a;return A.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,F.a.get(B(t));case 2:a=e.sent,n({type:"FETCH_PRODUCTS",payload:{products:a}});case 4:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}())):"All"!==n&&"All"===s?o((e=n,function(){var t=Object(R.a)(A.a.mark((function t(n){var a;return A.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,F.a.get(L(e));case 2:a=t.sent,n({type:"FETCH_PRODUCTS",payload:{products:a}});case 4:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}())):"All"!==n&&"All"!==s&&o(function(e,t){return function(){var n=Object(R.a)(A.a.mark((function n(a){var i;return A.a.wrap((function(n){for(;;)switch(n.prev=n.next){case 0:return n.next=2,F.a.get(H(e,t));case 2:i=n.sent,a({type:"FETCH_PRODUCTS",payload:{products:i}});case 4:case"end":return n.stop()}}),n)})));return function(e){return n.apply(this,arguments)}}()}(n,s))}),[o,s,n]);return Object(b.useEffect)((function(){d()}),[d]),Object(I.jsx)(re,{style:{padding:"0 50px"},children:Object(I.jsxs)(x.a,{className:"site-layout-background",style:{padding:"24px 0"},children:[Object(I.jsx)(Q,{SetCity:a}),Object(I.jsx)(re,{style:{padding:"0 24px",minHeight:280},children:Object(I.jsx)(se,{children:Object(I.jsxs)(W.a,{defaultActiveKey:"All",onChange:function(e){return c(e)},children:[Object(I.jsx)(ie,{tab:"All",children:Object(I.jsx)(ae,{productlist:l})},"All"),Object(I.jsx)(ie,{tab:"Food",children:Object(I.jsx)(ae,{productlist:l})},"Food"),Object(I.jsx)(ie,{tab:"Event",children:Object(I.jsx)(ae,{productlist:l})},"Event"),Object(I.jsx)(ie,{tab:"Hotel",children:Object(I.jsx)(ae,{productlist:l})},"Hotel"),Object(I.jsx)(ie,{tab:"Wellness",children:Object(I.jsx)(ae,{productlist:l})},"Wellness"),Object(I.jsx)(ie,{tab:"WorkShop",children:Object(I.jsx)(ae,{productlist:l})},"WorkShop"),Object(I.jsx)(ie,{tab:"Speciality",children:Object(I.jsx)(ae,{productlist:l})},"Speciality")]})})})]})})};var oe,le=f.a.div(j||(j=Object(h.a)(["\n    height:100vh;\n    display: flex;\n\tflex-direction: column;\n\tflex-wrap: wrap;\n\tjustify-content: flex-start;\n\talign-items: center;\n\talign-content: center;\n    h1{\n        line-height:10rem;\n    }\n    p{\n        width:800px;\n    }\n"]))),de=function(){return Object(I.jsxs)(le,{children:[Object(I.jsx)("h1",{children:"Title"}),Object(I.jsx)("p",{children:"Lorem ipsum, dolor sit amet consectetur adipisicing elit. In, explicabo! Optio doloremque repudiandae laborum quisquam accusamus reici endis autem accusantium. Qui tempora tenetur odio asperiores atque neque! Eaque, necessitatibus ea quisquam optio voluptatum fuga perspiciatis nulla possimus doloribus est quidem amet ab! Autem eveniet explicabo nemo quidem ut assumenda. Dolore corrupti quibusdam numquam voluptatum eos, dicta cumque consequatur suscipit repellendus voluptate illum omnis, maxime eum sit atque veniam aliquam dolor dolorem nisi optio? Dolorem at commodi laboriosam eveniet dolore nam voluptatum dolorum corrupti cumque quia error hic quidem dignissimos optio aspernatur aliquam culpa quis rem ad repellendus minus possimus, quae repudiandae. Vitae totam recusandae eius odit veniam quas ipsum laboriosam quaerat provident fugiat. Quam quibusdam ab, soluta aliquid nemo incidunt assumenda nisi voluptatibus minima iusto dicta aut dolore at magni facere earum accusamus. Expedita alias odio earum totam repellat tempora culpa ratione, iste voluptas sequi eligendi, blanditiis nam illo quis reiciendis."}),Object(I.jsx)("p",{children:"Lorem ipsum dolor sit amet consectetur adipisicing elit. Nesciunt, magni adipisci ipsum assumenda amet itaque delectus ullam tempora odit necessitatibus dicta eum, sit mollitia, suscipit accusantium illum rerum debitis officiis consequatur nisi. Iure quod saepe, veritatis sint molestiae voluptatum commodi at voluptate culpa eum mollitia adipisci vitae nulla blanditiis labore earum, ex tempora voluptatem aspernatur praesentium fugit et nisi ea. Voluptatum libero placeat deleniti enim consequuntur officiis. Est, eveniet? Iste, assumenda! Doloremque dolorum, rem fugiat ex, veritatis iste magnam beatae voluptas asperiores, alias fugit commodi dolore saepe! Quod ipsum repudiandae deserunt veritatis blanditiis illo commodi itaque rem eligendi, modi suscipit ratione iusto illum dignissimos eius alias odio molestias voluptas? In beatae sit similique impedit cupiditate quod. Provident minus incidunt repellat nisi officia autem omnis ipsa! Beatae eligendi tempora natus mollitia ut earum vero repellendus incidunt? Voluptatem officiis voluptatibus perferendis provident expedita iusto molestiae sapiente ipsum impedit pariatur quisquam enim, beatae accusamus harum in odio voluptates autem soluta laborum. Quisquam delectus dolores quam accusamus autem dolor explicabo. Commodi tenetur dolorem ad laborum quod sunt quisquam, eius eligendi dignissimos a molestiae magnam velit distinctio ab sit minima cumque. Quo eos architecto vel quasi, iste animi odio cumque quae pariatur nobis qui ad quos ullam at inventore harum rem modi magnam iusto reiciendis consequuntur. Maxime, soluta. Doloremque repellendus asperiores quis. Quaerat adipisci, eveniet, reprehenderit cupiditate eos vel vero aliquam quod, impedit rerum modi."})]})},ue=n(74),je=n(45);var be,me,pe,he,Oe=f.a.div(oe||(oe=Object(h.a)(["\n  height: 100vh;\n  display: flex;\n  flex-direction: column;\n  flex-wrap: nowrap;\n  justify-content: center;\n  align-items: center;\n  align-content: center;\n"]))),xe=function(){return Object(I.jsxs)(Oe,{children:[Object(I.jsx)(ue.a,{description:"Not Found"}),Object(I.jsx)("div",{children:Object(I.jsx)(g.b,{to:"/",children:Object(I.jsx)(je.a,{type:"primary",size:"large",children:"Go Back To Home Page ?"})})})]})},fe=n(312),ge=n(314),ve=n(319),ye=n(320),we=f.a.div(be||(be=Object(h.a)(["\n  height: 100vh;\n  display: flex;\n  justify-content: center;\n  align-items: center;\n"]))),Se=function(){var e=Object(T.b)();return Object(I.jsx)(we,{children:Object(I.jsxs)(fe.a,{name:"normal_login",className:"login-form",onFinish:function(t){var n,a;t&&e((n=t.email,a=t.password,function(){var e=Object(R.a)(A.a.mark((function e(t){var i;return A.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return console.log(n),e.next=3,F.a.post("api/login",{email:n,password:a});case 3:i=e.sent,t({type:"LOG_IN",payload:{user:i.data}});case 5:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}()))},children:[Object(I.jsx)("h1",{children:"Sign In "}),Object(I.jsx)(fe.a.Item,{name:"email",rules:[{required:!0,message:"Please input your Email!"}],children:Object(I.jsx)(ge.a,{prefix:Object(I.jsx)(ve.a,{className:"site-form-item-icon"}),placeholder:"Email"})}),Object(I.jsx)(fe.a.Item,{name:"password",rules:[{required:!0,message:"Please input your Password!"}],children:Object(I.jsx)(ge.a,{prefix:Object(I.jsx)(ye.a,{className:"site-form-item-icon"}),type:"password",placeholder:"Password"})}),Object(I.jsx)(fe.a.Item,{children:Object(I.jsx)(g.b,{to:"/",children:"Forgot password"})}),Object(I.jsxs)(fe.a.Item,{children:[Object(I.jsx)(je.a,{type:"primary",htmlType:"submit",className:"login-form-button",children:"Log in"}),"Or",Object(I.jsx)(g.b,{to:"signup",children:" register now!"})]})]})})},ke=f.a.div(me||(me=Object(h.a)(["\n    height:100vh;\n    display:flex;\n    justify-content:center;\n    align-items:center;\n"]))),qe=function(){return Object(I.jsx)(ke,{children:"SignUp Page"})},_e=n(321),Ce=n(322),Ie=n(323),Ee=f.a.div(pe||(pe=Object(h.a)(["\n  margin-top: 1rem;\n  display: flex;\n  justify-content: center;\n  align-items: center;\n  text-align: center;\n  background: grey;\n  height: 7vh;\n"]))),Pe=function(){return Object(I.jsxs)(x.a,{style:{height:"100vh"},children:[Object(I.jsx)(E,{}),Object(I.jsxs)(O.c,{children:[Object(I.jsx)(O.a,{exact:!0,path:"/",component:ce}),Object(I.jsx)(O.a,{exact:!0,path:"/about",component:de}),Object(I.jsx)(O.a,{exact:!0,path:"/signin",component:Se}),Object(I.jsx)(O.a,{exact:!0,path:"/signup",component:qe}),Object(I.jsx)(O.a,{component:xe})]}),Object(I.jsxs)(Ee,{children:[Object(I.jsx)(_e.a,{style:{fontSize:"1.5rem"}}),Object(I.jsx)(Ce.a,{style:{fontSize:"1.5rem",marginLeft:"2px"}}),Object(I.jsx)(Ie.a,{style:{fontSize:"1.5rem",marginLeft:"2px",marginRight:"2px"}}),"GetAndGo BV \xa92021"]})]})},Te=function(){return Object(I.jsx)("div",{children:Object(I.jsx)("h1",{children:"DashBoard"})})},De=n(178),Ae=n(318),Re=n(310),Ne=n(316),Fe=n(324),Ve=n(180),Be=n(107),Le=n(313),He=n(308),Ue=n(309),We=f.a.div(he||(he=Object(h.a)(["\n  height: 400px;\n  padding-top: 10px;\n  display: flex;\n  flex-direction: column;\n  flex-wrap: wrap-reverse;\n  justify-content: flex-start;\n  align-items: center;\n  align-content: stretch;\n  background-color: #f0f0f0;\n  > div {\n    margin: 10px;\n    margin-top: 0px;\n  }\n"]))),ze=function(e){var t=e.visiable,n=e.setvisiable,a=e.vendors,i=Be.a.Option,r=Object(T.b)(),s=function(e){var t,n;t="success",De.a[t]({message:"Success",description:"Your Request is submitted"}),r((n=e,function(){var e=Object(R.a)(A.a.mark((function e(t){return A.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,F.a.post("api/stores",{vendor_id:n.vendor_id,store_name:n.store_name,description:n.description,city:n.city.toUpperCase(),address:n.address,img:n.img,official_website:n.website});case 2:t({type:"ADD_NEW_STORE"});case 3:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}())),u.current.resetFields()},c=Object(b.useState)(""),o=Object(P.a)(c,2),l=o[0],d=o[1],u=Object(b.useRef)(null),j=Object(b.useState)(null),m=Object(P.a)(j,2),p=m[0],h=m[1];null==p&&h(a);var O,x=[{title:(O="Vendor ID",Object(I.jsx)(ge.a,{placeholder:O,value:l,onChange:function(e){var t=e.target.value;d(t);var n=a.filter((function(e){return e.user_id.toString().includes(t)}));h(n)}})),dataIndex:"user_id",key:"user_id",width:"20%"},{title:"First Name",dataIndex:"first_name",key:"first_name",width:"12%"},{title:"Last Name",dataIndex:"last_name",key:"last_name",width:"12%"},{title:"Email",dataIndex:"email",key:"email"},{title:"Phone",dataIndex:"phone",key:"phone"}];return Object(I.jsxs)(I.Fragment,{children:[Object(I.jsx)(Ae.b,{}),Object(I.jsxs)(Le.a,{title:"New Store (Double click table row to select vendor)",width:1e3,onClose:function(){n(!1)},visible:t,bodyStyle:{paddingBottom:80},footer:Object(I.jsx)("div",{style:{textAlign:"right"},children:Object(I.jsx)(je.a,{onClick:function(){n(!1)},style:{marginRight:8},children:"Cancel"})}),children:[Object(I.jsx)("h3",{children:"Vendor List"}),Object(I.jsx)(We,{children:Object(I.jsx)(Re.a,{onRow:function(e){return{onDoubleClick:function(){var t;t=e.user_id,u.current.setFieldsValue({vendor_id:t})}}},columns:x,dataSource:p,scroll:{y:300},pagination:!1,rowKey:"user_id"})}),Object(I.jsxs)(fe.a,{layout:"vertical",onFinish:function(e){s(e)},ref:u,children:[Object(I.jsxs)(He.a,{gutter:16,children:[Object(I.jsx)(Ue.a,{span:12,children:Object(I.jsx)(fe.a.Item,{name:"vendor_id",label:"Vendor ID",rules:[{required:!0,message:"Select vendor from the table above by double click table row"}],children:Object(I.jsx)(ge.a,{disabled:!0,placeholder:"Select vendor from the table above by double click table row"})})}),Object(I.jsx)(Ue.a,{span:12,children:Object(I.jsx)(fe.a.Item,{name:"city",label:"City",rules:[{required:!0,message:"Please select an City"}],children:Object(I.jsxs)(Be.a,{placeholder:"Please select an City",children:[Object(I.jsx)(i,{value:"Eindohoven",children:"Eindohoven"}),Object(I.jsx)(i,{value:"Tilburg",children:"Tilburg"}),Object(I.jsx)(i,{value:"Utrecht",children:"Utrecht"}),Object(I.jsx)(i,{value:"Delft",children:"Delft"}),Object(I.jsx)(i,{value:"Haarlem",children:"Haarlem"}),Object(I.jsx)(i,{value:"Breda",children:"Breda"})]})})})]}),Object(I.jsxs)(He.a,{gutter:16,children:[Object(I.jsx)(Ue.a,{span:12,children:Object(I.jsx)(fe.a.Item,{name:"website",label:"Offcial Website",children:Object(I.jsx)(ge.a,{style:{width:"100%"},addonBefore:"http://",placeholder:"Please enter url"})})}),Object(I.jsx)(Ue.a,{span:12,children:Object(I.jsx)(fe.a.Item,{name:"store_name",label:"Store Name",rules:[{required:!0,message:"Please Enter Store Name"}],children:Object(I.jsx)(ge.a,{style:{width:"100%"},placeholder:"Please enter store name"})})})]}),Object(I.jsxs)(He.a,{gutter:16,children:[Object(I.jsx)(Ue.a,{span:12,children:Object(I.jsx)(fe.a.Item,{name:"address",label:"Address",rules:[{required:!0,message:"Please Enter the Address "}],children:Object(I.jsx)(ge.a,{style:{width:"100%"},placeholder:"Please enter the address"})})}),Object(I.jsx)(Ue.a,{span:12,children:Object(I.jsx)(fe.a.Item,{name:"img",label:"Store Img Source",rules:[{required:!0,message:"Please Enter The Img Source "}],children:Object(I.jsx)(ge.a,{style:{width:"100%"},addonBefore:"http://",placeholder:"Please enter img source url"})})})]}),Object(I.jsx)(He.a,{gutter:16,children:Object(I.jsx)(Ue.a,{span:24,children:Object(I.jsx)(fe.a.Item,{name:"description",label:"Description",rules:[{required:!0,message:"please enter the description about the store"}],children:Object(I.jsx)(ge.a.TextArea,{rows:4,placeholder:"please enter the description about the store"})})})}),Object(I.jsx)(je.a,{type:"primary",htmlType:"submit",children:"Submit"})]})]})]})},Ge=function(e){var t=e.visiable,n=e.setvisiable,a=e.vendors,i=Object(T.b)(),r=function(e){switch(e){case"success":De.a[e]({message:"Success",description:"Your Request is submitted"});break;case"warning":De.a[e]({message:"Warning",description:"Email address has been taken"})}},s=function(e){var t;r("success"),i((t=e,function(){var e=Object(R.a)(A.a.mark((function e(n){return A.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,F.a.post("api/vendor/signup",{email:t.email,password:t.password,first_name:t.first_name,last_name:t.last_name,avatar_link:t.avatar_link,phone:t.phone});case 2:n({type:"REGISTER_NEW_VENDOR"});case 3:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}())),c.current.resetFields()},c=Object(b.useRef)(null);return Object(I.jsxs)(I.Fragment,{children:[Object(I.jsx)(Ae.b,{}),Object(I.jsx)(Le.a,{title:"Register an new vendor user here",width:1e3,onClose:function(){n(!1)},visible:t,bodyStyle:{paddingBottom:80},footer:Object(I.jsx)("div",{style:{textAlign:"right"},children:Object(I.jsx)(je.a,{onClick:function(){n(!1)},style:{marginRight:8},children:"Cancel"})}),children:Object(I.jsxs)(fe.a,{layout:"vertical",onFinish:function(e){s(e)},ref:c,children:[Object(I.jsx)(He.a,{gutter:16,children:Object(I.jsx)(Ue.a,{span:24,children:Object(I.jsx)(fe.a.Item,{name:"email",label:"Email Address",rules:[{required:!0,message:"Please Enter Vendor's Email"}],children:Object(I.jsx)(ge.a,{onChange:function(e){a.forEach((function(t){t.email===e.target.value&&r("warning")}))},placeholder:"Vendor Email"})})})}),Object(I.jsxs)(He.a,{gutter:16,children:[Object(I.jsx)(Ue.a,{span:24,children:Object(I.jsx)(fe.a.Item,{name:"password",label:"Password",rules:[{required:!0,message:"Please Enter Vendor's Password"}],children:Object(I.jsx)(ge.a,{style:{width:"100%"},type:"password",placeholder:"Password"})})}),Object(I.jsx)(Ue.a,{span:24,children:Object(I.jsx)(fe.a.Item,{name:"first_name",label:"First Name",rules:[{required:!0,message:"Please Enter Vendor's First Name"}],children:Object(I.jsx)(ge.a,{style:{width:"100%"},placeholder:"Please enter first name"})})})]}),Object(I.jsxs)(He.a,{gutter:16,children:[Object(I.jsx)(Ue.a,{span:24,children:Object(I.jsx)(fe.a.Item,{name:"last_name",label:"Last Name",rules:[{required:!0,message:"Please Enter the Last Name "}],children:Object(I.jsx)(ge.a,{style:{width:"100%"},placeholder:"Please enter the last name"})})}),Object(I.jsx)(Ue.a,{span:24,children:Object(I.jsx)(fe.a.Item,{name:"avatar_link",label:"Avatar Img Source",children:Object(I.jsx)(ge.a,{style:{width:"100%"},addonBefore:"http://",placeholder:"Optional Please enter img source url"})})})]}),Object(I.jsx)(He.a,{gutter:16,children:Object(I.jsx)(Ue.a,{span:24,children:Object(I.jsx)(fe.a.Item,{name:"phone",label:"Phone Number",rules:[{required:!0,message:"Please enter the contact number"}],children:Object(I.jsx)(ge.a,{rows:4,placeholder:"Please enter the phone number"})})})}),Object(I.jsx)(je.a,{type:"primary",htmlType:"submit",children:"Submit"})]})})]})},Qe=function(e){var t=e.visiable,n=e.setvisiable,a=e.store,i=Be.a.Option,r=Object(T.b)(),s=function(e){var t;r((t=e,function(){var e=Object(R.a)(A.a.mark((function e(n){return A.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,F.a.put("api/stores",t);case 2:n({type:"UPDATE_STORE"});case 3:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}())),setTimeout((function(){var e;e="success",De.a[e]({message:"Success",description:"Your Request is submitted"}),n(!1)}),1e3),c.current.resetFields()},c=Object(b.useRef)(null);return Object(I.jsxs)(I.Fragment,{children:[Object(I.jsx)(Ae.b,{}),Object(I.jsx)(Le.a,{title:"Edit Store Information Here:",width:1e3,onClose:function(){n(!1)},visible:t,bodyStyle:{paddingBottom:80},footer:Object(I.jsx)("div",{style:{textAlign:"right"},children:Object(I.jsx)(je.a,{onClick:function(){n(!1)},style:{marginRight:8},children:"Cancel"})}),children:Object(I.jsxs)(fe.a,{layout:"vertical",onFinish:function(e){s(e)},ref:c,children:[Object(I.jsx)("h3",{style:{textAlign:"center"},children:"Store Owner: ".concat(a.vendor.first_name," ").concat(a.vendor.lasr_name)}),Object(I.jsx)("h3",{style:{textAlign:"center"},children:"Contact Number: ".concat(a.vendor.phone)}),Object(I.jsxs)(He.a,{gutter:16,children:[Object(I.jsx)(Ue.a,{span:12,children:Object(I.jsx)(fe.a.Item,{name:"vendor_id",label:"Vendor ID",rules:[{required:!0,message:"Vendor id is required"}],initialValue:a.vendor.user_id,children:Object(I.jsx)(ge.a,{disabled:!0,placeholder:"Vendor ID"})})}),Object(I.jsx)(Ue.a,{span:12,children:Object(I.jsx)(fe.a.Item,{name:"store_id",label:"Store ID",rules:[{required:!0,message:"Store id is required"}],initialValue:a.store_id,children:Object(I.jsx)(ge.a,{disabled:!0,placeholder:"Vendor ID"})})})]}),Object(I.jsxs)(He.a,{gutter:16,children:[Object(I.jsx)(Ue.a,{span:24,children:Object(I.jsx)(fe.a.Item,{name:"store_name",label:"Store Name",rules:[{required:!0,message:"Please enter store name"}],initialValue:a.store_name,children:Object(I.jsx)(ge.a,{style:{width:"100%"},placeholder:"Store Name"})})}),Object(I.jsx)(Ue.a,{span:12,children:Object(I.jsx)(fe.a.Item,{name:"city",label:"City",rules:[{required:!0,message:"Please select an City"}],initialValue:a.city,children:Object(I.jsxs)(Be.a,{placeholder:"Please select an City",children:[Object(I.jsx)(i,{value:"EINDOHOVEN",children:"Eindohoven"}),Object(I.jsx)(i,{value:"TILBURG",children:"Tilburg"}),Object(I.jsx)(i,{value:"UTRECHT",children:"Utrecht"}),Object(I.jsx)(i,{value:"DELFT",children:"Delft"}),Object(I.jsx)(i,{value:"HAARLEM",children:"Haarlem"}),Object(I.jsx)(i,{value:"BREDA",children:"Breda"})]})})}),Object(I.jsx)(Ue.a,{span:12,children:Object(I.jsx)(fe.a.Item,{name:"address",label:"Address",rules:[{required:!0,message:"Please Enter the Address "}],initialValue:a.address,children:Object(I.jsx)(ge.a,{style:{width:"100%"},placeholder:"Please enter the Address"})})})]}),Object(I.jsx)(He.a,{gutter:16,children:Object(I.jsx)(Ue.a,{span:24,children:Object(I.jsx)(fe.a.Item,{name:"official_website",initialValue:a.official_website,label:"Official Website",children:Object(I.jsx)(ge.a,{style:{width:"100%"},addonBefore:"http://",placeholder:"Optional Please enter official website"})})})}),Object(I.jsx)(He.a,{gutter:16,children:Object(I.jsx)(Ue.a,{span:24,children:Object(I.jsx)(fe.a.Item,{name:"img",rules:[{required:!0,message:"Please Enter the Address "}],label:"Store Picture",initialValue:a.img,children:Object(I.jsx)(ge.a,{style:{width:"100%"},addonBefore:"http://",placeholder:"Optional Please enter official website"})})})}),Object(I.jsx)(He.a,{gutter:16,children:Object(I.jsx)(Ue.a,{span:24,children:Object(I.jsx)(fe.a.Item,{name:"description",label:"Description",rules:[{required:!0,message:"Please enter the description about the store"}],initialValue:a.description,children:Object(I.jsx)(ge.a.TextArea,{rows:4,placeholder:"Please enter the description about the store"})})})}),Object(I.jsx)(je.a,{type:"primary",htmlType:"submit",children:"Submit"})]})})]})},Ke=function(){var e=Object(b.useState)(!1),t=Object(P.a)(e,2),n=t[0],a=t[1],i=Object(b.useState)(!1),r=Object(P.a)(i,2),s=r[0],c=r[1],o=Object(b.useState)(!1),l=Object(P.a)(o,2),d=l[0],u=l[1],j=Object(T.b)(),m=Object(T.c)((function(e){return e.stores.stores})),p=Object(T.c)((function(e){return e.vendors.vendors})),h=Object(b.useState)(!1),O=Object(P.a)(h,2),x=O[0],f=O[1],g=Object(b.useState)(""),v=Object(P.a)(g,2),y=v[0],w=v[1],S=Object(b.useState)(null),k=Object(P.a)(S,2),q=k[0],_=k[1],C=Object(b.useState)(!1),E=Object(P.a)(C,2),D=E[0],N=E[1],V=Object(b.useState)(!1),B=Object(P.a)(V,2),L=B[0],H=B[1],W=Object(b.useState)(null),z=Object(P.a)(W,2),G=z[0],Q=z[1],K=Object(b.useState)(null),Y=Object(P.a)(K,2),M=Y[0],J=Y[1];Object(b.useEffect)((function(){x||(f(!0),j(function(){var e=Object(R.a)(A.a.mark((function e(t){var n;return A.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,F.a.get("api/stores");case 2:n=e.sent,t({type:"FETCH_STORES",payload:{store:n}});case 4:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}()),j(function(){var e=Object(R.a)(A.a.mark((function e(t){var n;return A.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,F.a.get("api/vendors");case 2:n=e.sent,t({type:"FETCH_VENDORS",payload:{vendors:n}});case 4:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}()))}),[j,m,p,x]),null==q&&setTimeout((function(){_(m)}),200);var X,Z=[{title:(X="Store ID",Object(I.jsx)(ge.a,{placeholder:X,value:y,onChange:function(e){var t=e.target.value;w(t);var n=m.filter((function(e){return e.store_id.toString().includes(t)}));_(n)}})),dataIndex:"store_id",key:"store_id",sorter:{compare:function(e,t){return e.store_id-t.store_id},multiple:1},width:"10%"},{title:"Store Name",dataIndex:"store_name",key:"store_name",width:"15%"},{title:"Vendor ID",dataIndex:["vendor","user_id"],key:["vendor","user_id"],width:"10%"},{title:"City",dataIndex:"city",key:"city",width:"10%"},{title:"Address",dataIndex:"address",key:"address",width:"20%"},{title:"Offical Website",render:function(e){return Object(I.jsx)("span",{onClick:function(e){console.log(e.target.innerText),window.open("https://"+e.target.innerText,"_blank")},children:e.official_website})},key:"official_website",width:"20%"},{title:"Action",key:"action",render:function(e){return Object(I.jsxs)(Ae.b,{size:"middle",children:[Object(I.jsx)(je.a,{onClick:function(){!function(e){u(!0),J(e)}(e)},children:"Edit"}),Object(I.jsx)(je.a,{onClick:function(){!function(e){N(!0),Q(e)}(e)},children:"Delete"})]})},width:"15%"}];return Object(I.jsxs)("div",{children:[Object(I.jsx)("h2",{children:"Store"}),x&&Object(I.jsx)(Re.a,{title:function(){return Object(I.jsxs)(I.Fragment,{children:[Object(I.jsx)(je.a,{onClick:function(){_(null),f(!1)},type:"primary",shape:"round",children:Object(I.jsx)(Fe.a,{})}),Object(I.jsx)("span",{children:" "}),Object(I.jsx)(je.a,{type:"primary",shape:"round",icon:Object(I.jsx)(Ve.a,{}),size:"middle",onClick:function(){a(!0)},children:"Add New Store"}),Object(I.jsx)("span",{children:" "}),Object(I.jsx)(je.a,{type:"primary",shape:"round",icon:Object(I.jsx)(Ve.a,{}),size:"middle",onClick:function(){c(!0)},children:"Register A New Vendor"})]})},columns:Z,dataSource:q,rowKey:"store_id"}),q&&Object(I.jsx)(ze,{visiable:n,setvisiable:a,vendors:p}),q&&Object(I.jsx)(Ge,{visiable:s,setvisiable:c,vendors:p}),M&&Object(I.jsx)(Qe,{visiable:d,setvisiable:u,store:M}),G&&Object(I.jsxs)(Ne.a,{title:"Delete confirmation",visible:D,onOk:function(){H(!0),setTimeout((function(){var e,t;j((e=G.store_id,function(){var t=Object(R.a)(A.a.mark((function t(n){return A.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return console.log(U(e)),t.next=3,F.a.delete(U(e));case 3:n({type:"DELETE_STORE"});case 4:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}())),N(!1),H(!1),t="success",De.a[t]({message:"Your request has been send"})}),1e3)},confirmLoading:L,onCancel:function(){N(!1)},children:[Object(I.jsx)("p",{children:"Are Your Sure to Delete Store: "}),Object(I.jsx)("p",{children:"".concat(G.store_name)}),Object(I.jsx)("p",{children:"Store ID: ".concat(G.store_id)}),Object(I.jsx)("p",{children:"City: ".concat(G.city)}),Object(I.jsx)("p",{children:"Address: ".concat(G.address)})]})]})},Ye=function(){return Object(I.jsx)("div",{children:Object(I.jsx)("h2",{children:"Orders"})})},Me=function(){return Object(I.jsx)("div",{children:Object(I.jsx)("h1",{children:"Reviewssssss"})})},Je=n(325),Xe=n(326),Ze=n(327),$e=function(){var e=x.a.Header,t=x.a.Content,n=x.a.Footer,a=x.a.Sider,i=Object(b.useState)(!1),r=Object(P.a)(i,2),s=r[0],c=r[1],o=Object(b.useState)("DashBoard"),l=Object(P.a)(o,2),d=l[0],u=l[1];return Object(I.jsxs)(x.a,{style:{minHeight:"100vh"},children:[Object(I.jsxs)(a,{collapsible:!0,collapsed:s,onCollapse:function(e){c(e)},children:[Object(I.jsx)("img",{src:C,alt:"logo"}),Object(I.jsxs)(z.a,{theme:"dark",defaultSelectedKeys:["DashBoard"],mode:"inline",children:[Object(I.jsx)(z.a.Item,{onClick:function(e){u(e.key)},icon:Object(I.jsx)(Je.a,{}),children:"DashBoard"},"DashBoard"),Object(I.jsx)(z.a.Item,{onClick:function(e){u(e.key)},icon:Object(I.jsx)(Xe.a,{}),children:"Store"},"Store"),Object(I.jsx)(z.a.Item,{onClick:function(e){u(e.key)},icon:Object(I.jsx)(ve.a,{}),children:"Order"},"Order"),Object(I.jsx)(z.a.Item,{onClick:function(e){u(e.key)},icon:Object(I.jsx)(Ze.a,{}),children:"Review"},"Review")]})]}),Object(I.jsxs)(x.a,{className:"site-layout",children:[Object(I.jsx)(e,{className:"site-layout-background",style:{padding:0},children:Object(I.jsx)(je.a,{})}),Object(I.jsx)(t,{style:{margin:"30px 16px"},children:"DashBoard"===d?Object(I.jsx)(Te,{}):"Store"===d?Object(I.jsx)(Ke,{}):"Order"===d?Object(I.jsx)(Ye,{}):"Review"===d?Object(I.jsx)(Me,{}):void 0}),Object(I.jsx)(n,{style:{textAlign:"center"},children:"\xa92021"})]})]})};var et=function(){return Object(I.jsx)("div",{children:"Vendor Page"})};var tt=function(){return Object(I.jsx)(g.a,{children:Object(I.jsxs)(O.c,{children:[Object(I.jsx)(O.a,{exact:!0,path:"/admin",component:$e}),Object(I.jsx)(O.a,{exact:!0,path:"/vendor",component:et}),Object(I.jsx)(O.a,{path:"/",component:Pe})]})})},nt=function(e){e&&e instanceof Function&&n.e(3).then(n.bind(null,330)).then((function(t){var n=t.getCLS,a=t.getFID,i=t.getFCP,r=t.getLCP,s=t.getTTFB;n(e),a(e),i(e),r(e),s(e)}))},at=n(78),it=n(34),rt={products:[]},st=function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:rt,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case"FETCH_PRODUCTS":return Object(it.a)(Object(it.a)({},e),{},{products:t.payload.products.data});default:return Object(it.a)({},e)}},ct={user:null,login:null,accounttype:null,userprofile:null},ot=function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:ct,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case"LOG_IN":return Object(it.a)(Object(it.a)({},e),{},{user:t.payload.user,login:t.payload.login});case"LOG_OUT":return Object(it.a)(Object(it.a)({},e),{},{user:null});default:return Object(it.a)({},e)}},lt={stores:[]},dt=function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:lt,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case"FETCH_STORES":return Object(it.a)(Object(it.a)({},e),{},{stores:t.payload.store.data});default:return Object(it.a)({},e)}},ut={vendors:[]},jt=function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:ut,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case"FETCH_VENDORS":return Object(it.a)(Object(it.a)({},e),{},{vendors:t.payload.vendors.data});default:return Object(it.a)({},e)}},bt=Object(at.c)({user:ot,products:st,stores:dt,vendors:jt}),mt=n(172),pt=(n(283),window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__||at.d),ht=Object(at.e)(bt,pt(Object(at.a)(mt.a)));p.a.render(Object(I.jsx)(I.Fragment,{children:Object(I.jsx)(T.a,{store:ht,children:Object(I.jsx)(tt,{})})}),document.getElementById("root")),nt()}},[[284,1,2]]]);
//# sourceMappingURL=main.32e81bdc.chunk.js.map