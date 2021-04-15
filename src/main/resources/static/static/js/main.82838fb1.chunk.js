(this.webpackJsonpreactpractice=this.webpackJsonpreactpractice||[]).push([[0],{265:function(e,t,n){"use strict";n.r(t);var a,i,r,c,s,o,l,d,u,j,b=n(0),p=n(20),m=n.n(p),h=n(21),x=n(24),O=n(285),f=n(22),g=n(50),v=n(160),y=f.a.nav(a||(a=Object(h.a)(["\n  background:black;\n  height: 80px;\n  display: flex;\n  justify-content: space-between;\n  padding: 0.5rem;\n  padding: 0.5rem calc((100vw-1000px) / 2);\n  z-index: 10;\n"]))),w=Object(f.a)(g.c)(i||(i=Object(h.a)(["\n  color: #fff;\n  display: flex;\n  align-items: center;\n  text-decoration: none;\n  padding: 0 1rem;\n  height: 100%;\n  cursor: pointer;\n  &.active {\n    color: #15cdfc;\n  }\n"]))),k=Object(f.a)(v.a)(r||(r=Object(h.a)(["\n  display: none;\n  color: #fff;\n\n  @media screen and (max-width: 768px) {\n    display: block;\n    position: absolute;\n    top: 0;\n    right: 0;\n    transform: translate(-100%, 75%);\n    font-size: 1.8rem;\n    cursor: pointer;\n  }\n"]))),S=f.a.div(c||(c=Object(h.a)(["\n  display: flex;\n  align-items: center;\n  margin-right: -24px;\n  @media screen and (max-width: 768px) {\n    display: none;\n  }\n"]))),q=f.a.nav(s||(s=Object(h.a)(["\n  display: flex;\n  align-items: center;\n  margin-right: 24px;\n\n  @media screen and (max-width: 768px) {\n    display: none;\n  }\n"]))),C=Object(f.a)(g.c)(o||(o=Object(h.a)(["\n  border-radius: 4px;\n  background: #256ce1;\n  padding: 10px 22px;\n  color: #fff;\n  border: none;\n  outline: none;\n  cursor: pointer;\n  transition: all 0.2s ease-in-out;\n  text-decoration: none;\n\n  &:hover {\n    transition: all 0.2s ease-in-out;\n    background: #fff;\n    color: 010606;\n  }\n"]))),I=n.p+"static/media/logo.d79996d0.svg",_=n(5),E=function(){return Object(_.jsx)(_.Fragment,{children:Object(_.jsxs)(y,{children:[Object(_.jsx)(w,{to:"/",children:Object(_.jsx)("img",{src:I,alt:"logo"})}),Object(_.jsx)(k,{}),Object(_.jsxs)(S,{children:[Object(_.jsx)(w,{to:"/about",children:"About"}),Object(_.jsx)(w,{to:"/contactus",children:"Contact Us"}),Object(_.jsx)(w,{to:"/signup",children:"Sign Up"}),Object(_.jsx)(w,{to:"/admin",children:"Admin Demo"}),Object(_.jsx)(w,{to:"/vendor",children:"Vendor Demo"})]}),Object(_.jsx)(q,{children:Object(_.jsx)(C,{to:"/signin",children:"Sign In"})})]})})},D=n(42),T=n(41),A=n(28),P=n.n(A),F=n(45),N=n(46),R=n.n(N),B="api/products",H=function(e){return"".concat(B,"?category=").concat(e.toLowerCase())},L=function(e){return"".concat(B,"?city=").concat(e.toLowerCase())},V=function(e,t){return"".concat(B,"?category=").concat(t.toLowerCase(),"&city=").concat(e.toLowerCase())},U=n(293),z=n(76),W=O.a.Sider,G=function(e){var t=e.SetCity,n=function(e){t(e)};return Object(_.jsx)(W,{className:"site-layout-background",width:200,children:Object(_.jsxs)(z.a,{mode:"inline",defaultSelectedKeys:["All"],style:{height:"100%"},children:[Object(_.jsx)(z.a.Item,{onClick:function(e){n(e.key)},children:"All-City"},"All"),Object(_.jsx)(z.a.Item,{onClick:function(e){n(e.key)},children:"Eindohoven"},"Eindohoven"),Object(_.jsx)(z.a.Item,{onClick:function(e){n(e.key)},children:"Tilburg"},"Tilburg"),Object(_.jsx)(z.a.Item,{onClick:function(e){n(e.key)},children:"Utrecht"},"Utrecht"),Object(_.jsx)(z.a.Item,{onClick:function(e){n(e.key)},children:"Delft"},"Delft"),Object(_.jsx)(z.a.Item,{onClick:function(e){n(e.key)},children:"Haarlem"},"Haarlem"),Object(_.jsx)(z.a.Item,{onClick:function(e){n(e.key)},children:"Breda"},"Breda")]})})},Q=n(308),K=n(297),J=n(288),M=n(287),X=n(307),Y=Object(f.a)(Q.a)(l||(l=Object(h.a)(["\n    max-width:250px;\n    margin-left:0.5rem;\n    margin-top:1rem;\n    display:block;\n    height:350px;\n"]))),Z=function(e){var t=e.product;return Object(_.jsx)(Y,{children:Object(_.jsxs)(K.a,{children:[Object(_.jsx)(M.a,{component:"img",alt:"Contemplative Reptile",height:"150",image:t.img,title:"Contemplative Reptile"}),Object(_.jsxs)(J.a,{children:[Object(_.jsx)(X.a,{gutterBottom:!0,variant:"h6",component:"h2",children:t.product_name}),Object(_.jsxs)(X.a,{variant:"body2",color:"textSecondary",component:"p",children:["Price: \u20ac",t.price,Object(_.jsx)("br",{}),t.description]}),Object(_.jsx)(X.a,{variant:"body2",color:"textSecondary",component:"p"})]})]})})},$=n(150),ee=n(295),te=f.a.div(d||(d=Object(h.a)(["\n  padding: 1rem;\n  height: 75vh;\n  overflow: auto;\n  background: #ffffff;\n  display: flex;\n  flex-direction: row;\n  flex-wrap: wrap;\n  justify-content: space-around;\n  align-items: stretch;\n  align-content: stretch;\n\n  &::-webkit-scrollbar {\n    padding-top: 20px;\n    width: 0.5rem;\n  }\n  &::-webkit-scrollbar-thumb {\n    background-color: darkgrey;\n  }\n  &::-webkit-scrollbar-track {\n    background: linear-gradient(\n      to right bottom,\n      rgba(255, 255, 255, 0.7),\n      rgba(255, 255, 255, 0.3)\n    );\n  }\n"]))),ne=function(e){var t=e.productlist;return t.length>0?Object(_.jsx)(te,{children:t.map((function(e,t){return Object(_.jsx)(Z,{product:e},t)}))}):Object(_.jsx)(te,{children:Object(_.jsx)($.a,{tip:"Loading...",children:Object(_.jsx)(ee.a,{message:"Trying to loading latest data...",description:"If there is no news for a long time, it means we may not have such data yet.",type:"info"})})})},ae=U.a.TabPane,ie=O.a.Content,re=f.a.div(u||(u=Object(h.a)(["\n  height:auto;\n  width:auto;\n"]))),ce=function(){var e=Object(b.useState)("All"),t=Object(D.a)(e,2),n=t[0],a=t[1],i=Object(b.useState)("All"),r=Object(D.a)(i,2),c=r[0],s=r[1],o=Object(T.b)(),l=Object(T.c)((function(e){return e.products.products})),d=Object(b.useCallback)((function(){var e,t;"All"===n&&"All"===c?o(function(){var e=Object(F.a)(P.a.mark((function e(t){var n;return P.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,R.a.get(B);case 2:n=e.sent,t({type:"FETCH_PRODUCTS",payload:{products:n}});case 4:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}()):"All"===n&&"All"!==c?o((t=c,function(){var e=Object(F.a)(P.a.mark((function e(n){var a;return P.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,R.a.get(H(t));case 2:a=e.sent,n({type:"FETCH_PRODUCTS",payload:{products:a}});case 4:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}())):"All"!==n&&"All"===c?o((e=n,function(){var t=Object(F.a)(P.a.mark((function t(n){var a;return P.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,R.a.get(L(e));case 2:a=t.sent,n({type:"FETCH_PRODUCTS",payload:{products:a}});case 4:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}())):"All"!==n&&"All"!==c&&o(function(e,t){return function(){var n=Object(F.a)(P.a.mark((function n(a){var i;return P.a.wrap((function(n){for(;;)switch(n.prev=n.next){case 0:return n.next=2,R.a.get(V(e,t));case 2:i=n.sent,a({type:"FETCH_PRODUCTS",payload:{products:i}});case 4:case"end":return n.stop()}}),n)})));return function(e){return n.apply(this,arguments)}}()}(n,c))}),[o,c,n]);return Object(b.useEffect)((function(){d()}),[d]),Object(_.jsx)(ie,{style:{padding:"0 50px"},children:Object(_.jsxs)(O.a,{className:"site-layout-background",style:{padding:"24px 0"},children:[Object(_.jsx)(G,{SetCity:a}),Object(_.jsx)(ie,{style:{padding:"0 24px",minHeight:280},children:Object(_.jsx)(re,{children:Object(_.jsxs)(U.a,{defaultActiveKey:"All",onChange:function(e){return s(e)},children:[Object(_.jsx)(ae,{tab:"All",children:Object(_.jsx)(ne,{productlist:l})},"All"),Object(_.jsx)(ae,{tab:"Food",children:Object(_.jsx)(ne,{productlist:l})},"Food"),Object(_.jsx)(ae,{tab:"Event",children:Object(_.jsx)(ne,{productlist:l})},"Event"),Object(_.jsx)(ae,{tab:"Hotel",children:Object(_.jsx)(ne,{productlist:l})},"Hotel"),Object(_.jsx)(ae,{tab:"Wellness",children:Object(_.jsx)(ne,{productlist:l})},"Wellness"),Object(_.jsx)(ae,{tab:"WorkShop",children:Object(_.jsx)(ne,{productlist:l})},"WorkShop"),Object(_.jsx)(ae,{tab:"Speciality",children:Object(_.jsx)(ne,{productlist:l})},"Speciality")]})})})]})})};var se,oe=f.a.div(j||(j=Object(h.a)(["\n    height:100vh;\n    display: flex;\n\tflex-direction: column;\n\tflex-wrap: wrap;\n\tjustify-content: flex-start;\n\talign-items: center;\n\talign-content: center;\n    h1{\n        line-height:10rem;\n    }\n    p{\n        width:800px;\n    }\n"]))),le=function(){return Object(_.jsxs)(oe,{children:[Object(_.jsx)("h1",{children:"Title"}),Object(_.jsx)("p",{children:"Lorem ipsum, dolor sit amet consectetur adipisicing elit. In, explicabo! Optio doloremque repudiandae laborum quisquam accusamus reici endis autem accusantium. Qui tempora tenetur odio asperiores atque neque! Eaque, necessitatibus ea quisquam optio voluptatum fuga perspiciatis nulla possimus doloribus est quidem amet ab! Autem eveniet explicabo nemo quidem ut assumenda. Dolore corrupti quibusdam numquam voluptatum eos, dicta cumque consequatur suscipit repellendus voluptate illum omnis, maxime eum sit atque veniam aliquam dolor dolorem nisi optio? Dolorem at commodi laboriosam eveniet dolore nam voluptatum dolorum corrupti cumque quia error hic quidem dignissimos optio aspernatur aliquam culpa quis rem ad repellendus minus possimus, quae repudiandae. Vitae totam recusandae eius odit veniam quas ipsum laboriosam quaerat provident fugiat. Quam quibusdam ab, soluta aliquid nemo incidunt assumenda nisi voluptatibus minima iusto dicta aut dolore at magni facere earum accusamus. Expedita alias odio earum totam repellat tempora culpa ratione, iste voluptas sequi eligendi, blanditiis nam illo quis reiciendis."}),Object(_.jsx)("p",{children:"Lorem ipsum dolor sit amet consectetur adipisicing elit. Nesciunt, magni adipisci ipsum assumenda amet itaque delectus ullam tempora odit necessitatibus dicta eum, sit mollitia, suscipit accusantium illum rerum debitis officiis consequatur nisi. Iure quod saepe, veritatis sint molestiae voluptatum commodi at voluptate culpa eum mollitia adipisci vitae nulla blanditiis labore earum, ex tempora voluptatem aspernatur praesentium fugit et nisi ea. Voluptatum libero placeat deleniti enim consequuntur officiis. Est, eveniet? Iste, assumenda! Doloremque dolorum, rem fugiat ex, veritatis iste magnam beatae voluptas asperiores, alias fugit commodi dolore saepe! Quod ipsum repudiandae deserunt veritatis blanditiis illo commodi itaque rem eligendi, modi suscipit ratione iusto illum dignissimos eius alias odio molestias voluptas? In beatae sit similique impedit cupiditate quod. Provident minus incidunt repellat nisi officia autem omnis ipsa! Beatae eligendi tempora natus mollitia ut earum vero repellendus incidunt? Voluptatem officiis voluptatibus perferendis provident expedita iusto molestiae sapiente ipsum impedit pariatur quisquam enim, beatae accusamus harum in odio voluptates autem soluta laborum. Quisquam delectus dolores quam accusamus autem dolor explicabo. Commodi tenetur dolorem ad laborum quod sunt quisquam, eius eligendi dignissimos a molestiae magnam velit distinctio ab sit minima cumque. Quo eos architecto vel quasi, iste animi odio cumque quae pariatur nobis qui ad quos ullam at inventore harum rem modi magnam iusto reiciendis consequuntur. Maxime, soluta. Doloremque repellendus asperiores quis. Quaerat adipisci, eveniet, reprehenderit cupiditate eos vel vero aliquam quod, impedit rerum modi."})]})},de=n(61),ue=n(59);var je,be,pe,me,he=f.a.div(se||(se=Object(h.a)(["\n  height: 100vh;\n  display: flex;\n  flex-direction: column;\n  flex-wrap: nowrap;\n  justify-content: center;\n  align-items: center;\n  align-content: center;\n"]))),xe=function(){return Object(_.jsxs)(he,{children:[Object(_.jsx)(de.a,{description:"Not Found"}),Object(_.jsx)("div",{children:Object(_.jsx)(g.b,{to:"/",children:Object(_.jsx)(ue.a,{type:"primary",size:"large",children:"Go Back To Home Page ?"})})})]})},Oe=n(292),fe=n(296),ge=n(299),ve=n(300),ye=f.a.div(je||(je=Object(h.a)(["\n  height: 100vh;\n  display: flex;\n  justify-content: center;\n  align-items: center;\n"]))),we=function(){var e=Object(T.b)();return Object(_.jsx)(ye,{children:Object(_.jsxs)(Oe.a,{name:"normal_login",className:"login-form",onFinish:function(t){var n,a;t&&e((n=t.email,a=t.password,function(){var e=Object(F.a)(P.a.mark((function e(t){var i;return P.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return console.log(n),e.next=3,R.a.post("api/login",{email:n,password:a});case 3:i=e.sent,t({type:"LOG_IN",payload:{user:i.data}});case 5:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}()))},children:[Object(_.jsx)("h1",{children:"Sign In "}),Object(_.jsx)(Oe.a.Item,{name:"email",rules:[{required:!0,message:"Please input your Email!"}],children:Object(_.jsx)(fe.a,{prefix:Object(_.jsx)(ge.a,{className:"site-form-item-icon"}),placeholder:"Email"})}),Object(_.jsx)(Oe.a.Item,{name:"password",rules:[{required:!0,message:"Please input your Password!"}],children:Object(_.jsx)(fe.a,{prefix:Object(_.jsx)(ve.a,{className:"site-form-item-icon"}),type:"password",placeholder:"Password"})}),Object(_.jsx)(Oe.a.Item,{children:Object(_.jsx)(g.b,{to:"/",children:"Forgot password"})}),Object(_.jsxs)(Oe.a.Item,{children:[Object(_.jsx)(ue.a,{type:"primary",htmlType:"submit",className:"login-form-button",children:"Log in"}),"Or",Object(_.jsx)(g.b,{to:"signup",children:" register now!"})]})]})})},ke=f.a.div(be||(be=Object(h.a)(["\n    height:100vh;\n    display:flex;\n    justify-content:center;\n    align-items:center;\n"]))),Se=function(){return Object(_.jsx)(ke,{children:"SignUp Page"})},qe=n(301),Ce=n(302),Ie=n(303),_e=f.a.div(pe||(pe=Object(h.a)(["\n  margin-top: 1rem;\n  display: flex;\n  justify-content: center;\n  align-items: center;\n  text-align: center;\nbackground:grey;\n  height: 7vh;\n"]))),Ee=function(){return Object(_.jsxs)(O.a,{style:{height:"100vh"},children:[Object(_.jsx)(E,{}),Object(_.jsxs)(x.c,{children:[Object(_.jsx)(x.a,{exact:!0,path:"/",component:ce}),Object(_.jsx)(x.a,{exact:!0,path:"/about",component:le}),Object(_.jsx)(x.a,{exact:!0,path:"/signin",component:we}),Object(_.jsx)(x.a,{exact:!0,path:"/signup",component:Se}),Object(_.jsx)(x.a,{component:xe})]}),Object(_.jsxs)(_e,{children:[Object(_.jsx)(qe.a,{style:{fontSize:"1.5rem"}}),Object(_.jsx)(Ce.a,{style:{fontSize:"1.5rem",marginLeft:"2px"}}),Object(_.jsx)(Ie.a,{style:{fontSize:"1.5rem",marginLeft:"2px",marginRight:"2px"}}),"GetAndGo BV \xa92021"]})]})},De=function(){return Object(_.jsx)("div",{children:Object(_.jsx)("h1",{children:"DashBoard"})})},Te=n(298),Ae=n(291),Pe=n(161),Fe=n(92),Ne=n(294),Re=n(289),Be=n(290),He=f.a.div(me||(me=Object(h.a)(["\n  height: 400px;\n  padding-top: 10px;\n  display: flex;\n  flex-direction: column;\n  flex-wrap: wrap-reverse;\n  justify-content: flex-start;\n  align-items: center;\n  align-content: stretch;\n  background-color: #f0f0f0;\n  > div {\n    margin: 10px;\n    margin-top: 0px;\n  }\n"]))),Le=function(e){var t,n=e.visiable,a=e.setvisiable,i=e.vendors,r=Fe.a.Option,c=Object(T.b)(),s=function(e){var t;alert("add succeed ~ !"),c((t=e,function(){var e=Object(F.a)(P.a.mark((function e(n){return P.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return console.log(t),e.next=3,R.a.post("api/stores",{vendor_id:t.vendor_id,store_name:t.store_name,description:t.description,city:t.city,address:t.address,img:t.img,official_website:t.website});case 3:n({type:"ADD_NEW_STORE"});case 4:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}())),j.current.resetFields()},o=Object(b.useState)(""),l=Object(D.a)(o,2),d=l[0],u=l[1],j=Object(b.useRef)(null),p=Object(b.useState)(i),m=Object(D.a)(p,2),h=m[0],x=m[1],O=[{title:(t="Vendor ID",Object(_.jsx)(fe.a,{placeholder:t,value:d,onChange:function(e){var t=e.target.value;u(t);var n=i.filter((function(e){return e.id.toString().includes(t)}));x(n)}})),dataIndex:"id",key:"id",width:"20%"},{title:"First Name",dataIndex:"first_name",key:"first_name",width:"12%"},{title:"Last Name",dataIndex:"last_name",key:"last_name",width:"12%"},{title:"Email",dataIndex:"email",key:"email"},{title:"Phone",dataIndex:"phone",key:"phone"}];return Object(_.jsx)(_.Fragment,{children:Object(_.jsxs)(Ne.a,{title:"New Store",width:1e3,onClose:function(){a(!1)},visible:n,bodyStyle:{paddingBottom:80},footer:Object(_.jsx)("div",{style:{textAlign:"right"},children:Object(_.jsx)(ue.a,{onClick:function(){a(!1)},style:{marginRight:8},children:"Cancel"})}),children:[Object(_.jsx)("h3",{children:"Vendor List"}),Object(_.jsx)(He,{children:Object(_.jsx)(Ae.a,{onRow:function(e){return{onDoubleClick:function(){var t;t=e.id,j.current.setFieldsValue({vendor_id:t})}}},columns:O,dataSource:h,scroll:{y:300},pagination:!1,rowKey:"id"})}),Object(_.jsxs)(Oe.a,{layout:"vertical",onFinish:function(e){s(e)},ref:j,children:[Object(_.jsxs)(Re.a,{gutter:16,children:[Object(_.jsx)(Be.a,{span:12,children:Object(_.jsx)(Oe.a.Item,{name:"vendor_id",label:"Vendor ID",rules:[{required:!0,message:"Select vendor from the table above"}],children:Object(_.jsx)(fe.a,{disabled:!0,placeholder:"Select vendor from the table above"})})}),Object(_.jsx)(Be.a,{span:12,children:Object(_.jsx)(Oe.a.Item,{name:"city",label:"City",rules:[{required:!0,message:"Please select an City"}],children:Object(_.jsxs)(Fe.a,{placeholder:"Please select an City",children:[Object(_.jsx)(r,{value:"Eindohoven",children:"Eindohoven"}),Object(_.jsx)(r,{value:"Tilburg",children:"Tilburg"}),Object(_.jsx)(r,{value:"Utrecht",children:"Utrecht"}),Object(_.jsx)(r,{value:"Delft",children:"Delft"}),Object(_.jsx)(r,{value:"Haarlem",children:"Haarlem"}),Object(_.jsx)(r,{value:"Breda",children:"Breda"})]})})})]}),Object(_.jsxs)(Re.a,{gutter:16,children:[Object(_.jsx)(Be.a,{span:12,children:Object(_.jsx)(Oe.a.Item,{name:"website",label:"Offcial Website",children:Object(_.jsx)(fe.a,{style:{width:"100%"},addonBefore:"http://",placeholder:"Please enter url"})})}),Object(_.jsx)(Be.a,{span:12,children:Object(_.jsx)(Oe.a.Item,{name:"store_name",label:"Store Name",rules:[{required:!0,message:"Please Enter Store Name"}],children:Object(_.jsx)(fe.a,{style:{width:"100%"},placeholder:"Please enter store name"})})})]}),Object(_.jsxs)(Re.a,{gutter:16,children:[Object(_.jsx)(Be.a,{span:12,children:Object(_.jsx)(Oe.a.Item,{name:"address",label:"Address",rules:[{required:!0,message:"Please Enter the Address "}],children:Object(_.jsx)(fe.a,{style:{width:"100%"},placeholder:"Please enter the address"})})}),Object(_.jsx)(Be.a,{span:12,children:Object(_.jsx)(Oe.a.Item,{name:"img",label:"Store Img Source",rules:[{required:!0,message:"Please Enter The Img Source "}],children:Object(_.jsx)(fe.a,{style:{width:"100%"},addonBefore:"http://",placeholder:"Please enter img source url"})})})]}),Object(_.jsx)(Re.a,{gutter:16,children:Object(_.jsx)(Be.a,{span:24,children:Object(_.jsx)(Oe.a.Item,{name:"description",label:"Description",rules:[{required:!0,message:"please enter the description about the store"}],children:Object(_.jsx)(fe.a.TextArea,{rows:4,placeholder:"please enter the description about the store"})})})}),Object(_.jsx)(ue.a,{type:"primary",htmlType:"submit",children:"Submit"})]})]})})},Ve=function(){var e=Object(b.useState)(!1),t=Object(D.a)(e,2),n=t[0],a=t[1],i=Object(T.b)(),r=Object(T.c)((function(e){return e.stores.stores})),c=Object(T.c)((function(e){return e.vendors.vendors})),s=Object(b.useState)(c),o=Object(D.a)(s,2),l=o[0],d=o[1],u=Object(b.useState)(!1),j=Object(D.a)(u,2),p=j[0],m=j[1];Object(b.useEffect)((function(){p||(m(!0),i(function(){var e=Object(F.a)(P.a.mark((function e(t){var n;return P.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,R.a.get("api/stores");case 2:n=e.sent,t({type:"FETCH_STORES",payload:{store:n}});case 4:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}()),i(function(){var e=Object(F.a)(P.a.mark((function e(t){var n;return P.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,R.a.get("api/vendors");case 2:n=e.sent,t({type:"FETCH_VENDORS",payload:{vendors:n}});case 4:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}()),d(c))}),[i,r,c,p]);var h=[{title:"Store ID",dataIndex:"store_id",key:"store_id"},{title:"Store Name",dataIndex:"store_name",key:"store_name"},{title:"Vendor ID",dataIndex:"vendor_id",key:"vendor_id"},{title:"City",dataIndex:"city",key:"city"},{title:"Address",dataIndex:"address",key:"address"},{title:"Offical Website",dataIndex:"official_website",key:"official_website"},{title:"Action",key:"action",render:function(e,t){return Object(_.jsx)(Te.b,{size:"middle"})}}];return Object(_.jsxs)("div",{children:[Object(_.jsx)("h2",{children:"Store"}),Object(_.jsx)(Ae.a,{title:function(){return Object(_.jsxs)(_.Fragment,{children:[Object(_.jsx)(ue.a,{type:"primary",shape:"round",icon:Object(_.jsx)(Pe.a,{}),size:"middle",onClick:function(){a(!0)},children:"Add New Store"}),Object(_.jsx)("span",{children:" "}),Object(_.jsx)(ue.a,{type:"primary",shape:"round",icon:Object(_.jsx)(Pe.a,{}),size:"middle",onClick:function(){a(!0)},children:"Register A New Vendor"})]})},columns:h,dataSource:r,rowKey:"store_id"}),Object(_.jsx)(Le,{visiable:n,setvisiable:a,vendors:l})]})},Ue=function(){return Object(_.jsx)("div",{children:Object(_.jsx)("h2",{children:"Orders"})})},ze=function(){return Object(_.jsx)("div",{children:Object(_.jsx)("h1",{children:"Reviewssssss"})})},We=n(304),Ge=n(305),Qe=n(306),Ke=function(){var e=O.a.Header,t=O.a.Content,n=O.a.Footer,a=O.a.Sider,i=Object(b.useState)(!1),r=Object(D.a)(i,2),c=r[0],s=r[1],o=Object(b.useState)("DashBoard"),l=Object(D.a)(o,2),d=l[0],u=l[1];return Object(_.jsxs)(O.a,{style:{minHeight:"100vh"},children:[Object(_.jsxs)(a,{collapsible:!0,collapsed:c,onCollapse:function(e){s(e)},children:[Object(_.jsx)("img",{src:I,alt:"logo"}),Object(_.jsxs)(z.a,{theme:"dark",defaultSelectedKeys:["DashBoard"],mode:"inline",children:[Object(_.jsx)(z.a.Item,{onClick:function(e){u(e.key)},icon:Object(_.jsx)(We.a,{}),children:"DashBoard"},"DashBoard"),Object(_.jsx)(z.a.Item,{onClick:function(e){u(e.key)},icon:Object(_.jsx)(Ge.a,{}),children:"Store"},"Store"),Object(_.jsx)(z.a.Item,{onClick:function(e){u(e.key)},icon:Object(_.jsx)(ge.a,{}),children:"Order"},"Order"),Object(_.jsx)(z.a.Item,{onClick:function(e){u(e.key)},icon:Object(_.jsx)(Qe.a,{}),children:"Review"},"Review")]})]}),Object(_.jsxs)(O.a,{className:"site-layout",children:[Object(_.jsx)(e,{className:"site-layout-background",style:{padding:0},children:Object(_.jsx)(ue.a,{})}),Object(_.jsx)(t,{style:{margin:"30px 16px"},children:"DashBoard"===d?Object(_.jsx)(De,{}):"Store"===d?Object(_.jsx)(Ve,{}):"Order"===d?Object(_.jsx)(Ue,{}):"Review"===d?Object(_.jsx)(ze,{}):void 0}),Object(_.jsx)(n,{style:{textAlign:"center"},children:"\xa92021"})]})]})};var Je=function(){return Object(_.jsx)("div",{children:"Vendor Page"})};var Me=function(){return Object(_.jsx)(g.a,{children:Object(_.jsxs)(x.c,{children:[Object(_.jsx)(x.a,{exact:!0,path:"/admin",component:Ke}),Object(_.jsx)(x.a,{exact:!0,path:"/vendor",component:Je}),Object(_.jsx)(x.a,{path:"/",component:Ee})]})})},Xe=function(e){e&&e instanceof Function&&n.e(3).then(n.bind(null,309)).then((function(t){var n=t.getCLS,a=t.getFID,i=t.getFCP,r=t.getLCP,c=t.getTTFB;n(e),a(e),i(e),r(e),c(e)}))},Ye=n(69),Ze=n(31),$e={products:[]},et=function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:$e,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case"FETCH_PRODUCTS":return Object(Ze.a)(Object(Ze.a)({},e),{},{products:t.payload.products.data});default:return Object(Ze.a)({},e)}},tt={user:null,login:null,accounttype:null,userprofile:null},nt=function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:tt,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case"LOG_IN":return Object(Ze.a)(Object(Ze.a)({},e),{},{user:t.payload.user,login:t.payload.login});case"LOG_OUT":return Object(Ze.a)(Object(Ze.a)({},e),{},{user:null});default:return Object(Ze.a)({},e)}},at={stores:[]},it=function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:at,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case"FETCH_STORES":return Object(Ze.a)(Object(Ze.a)({},e),{},{stores:t.payload.store.data});default:return Object(Ze.a)({},e)}},rt={vendors:[]},ct=function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:rt,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case"FETCH_VENDORS":return Object(Ze.a)(Object(Ze.a)({},e),{},{vendors:t.payload.vendors.data});default:return Object(Ze.a)({},e)}},st=Object(Ye.c)({user:nt,products:et,stores:it,vendors:ct}),ot=n(155),lt=(n(264),window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__||Ye.d),dt=Object(Ye.e)(st,lt(Object(Ye.a)(ot.a)));m.a.render(Object(_.jsx)(_.Fragment,{children:Object(_.jsx)(T.a,{store:dt,children:Object(_.jsx)(Me,{})})}),document.getElementById("root")),Xe()}},[[265,1,2]]]);
//# sourceMappingURL=main.82838fb1.chunk.js.map