import React, { useState } from "react";
import { Layout, Menu } from "antd";
import {
  DesktopOutlined,
  PieChartOutlined,
  FileOutlined,
  TeamOutlined,
  UserOutlined,
} from "@ant-design/icons";
import LOGO from '../components/images/logo.svg';
const Admin = () => {
  const { Header, Content, Footer, Sider } = Layout;
  const { SubMenu } = Menu;
  const [collapsed, setcollapsed] = useState(false);
  const onCollapse = (collapsed) => {
    console.log(collapsed);
    setcollapsed(collapsed);
  };
  return (
    <Layout style={{ minHeight: "100vh" }}>
      <Sider collapsible collapsed={collapsed} onCollapse={onCollapse}>
        <img src={LOGO} alt="logo"/>
        <Menu theme="dark" defaultSelectedKeys={["DashBoard"]} mode="inline">
          <Menu.Item key="DashBoard" icon={<PieChartOutlined />}>
            DashBoard
          </Menu.Item>
          {/* <Menu.Item key="2" icon={<DesktopOutlined />}>
           babab
          </Menu.Item>
          <SubMenu key="sub1" icon={<UserOutlined />} title="User">
            <Menu.Item key="3">Tom</Menu.Item>
            <Menu.Item key="4">Bill</Menu.Item>
            <Menu.Item key="5">Alex</Menu.Item>
          </SubMenu>
          <SubMenu key="sub2" icon={<TeamOutlined />} title="Team">
            <Menu.Item key="6">Team 1</Menu.Item>
            <Menu.Item key="8">Team 2</Menu.Item>
          </SubMenu>
          <Menu.Item key="9" icon={<FileOutlined />}>
            Files
          </Menu.Item> */}
        </Menu>
      </Sider>
      <Layout className="site-layout">
        <Header className="site-layout-background" style={{ padding: 0 }} />
        <Content style={{ margin: "0 16px" }}>
          <div
            className="site-layout-background"
            style={{ padding: 24, minHeight: 360 }}
          >
           Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum corrupti recusandae sunt ad ducimus fugiat iusto aperiam et in quasi ullam ratione deleniti, autem nulla laudantium soluta officia reiciendis animi! Ad natus fugiat ut fugit mollitia illo odio dignissimos officiis, et incidunt cupiditate adipisci eum minima fuga veritatis? Soluta iusto libero quae quis voluptatem reiciendis rerum atque sint praesentium, explicabo pariatur architecto quia ut deleniti beatae mollitia excepturi vero provident numquam autem! Est quasi cupiditate soluta, voluptates corrupti, culpa perferendis animi commodi temporibus, voluptas nostrum illo nulla fugit sed obcaecati non recusandae? Aliquam fugiat voluptatem vitae. Explicabo, omnis. Voluptate accusantium vitae debitis eos enim assumenda impedit eius aliquam neque, blanditiis dignissimos libero laboriosam dolore illo esse? Nam adipisci, voluptas quo earum vitae placeat molestias cum tenetur explicabo suscipit beatae distinctio culpa nulla. Corporis hic explicabo libero corrupti, minus voluptates fugiat delectus quisquam dicta consequuntur nisi doloremque cumque error asperiores omnis vero similique sequi quibusdam. Quo repellat obcaecati iusto voluptatibus, asperiores sunt delectus itaque, sapiente nulla eius aperiam libero error dolorem harum suscipit, fuga aliquid voluptas dicta earum explicabo? Beatae consequuntur ex commodi facere, distinctio sunt debitis inventore consequatur nam aspernatur! Eum nam nobis soluta voluptates? Accusantium aliquid esse sed eveniet reprehenderit dolorem blanditiis totam nihil vero provident. Veniam blanditiis eum maiores quia numquam obcaecati iure odit, quibusdam veritatis, exercitationem consequuntur? Vero iste dolorem excepturi et, necessitatibus vitae minima similique nulla fugit consectetur optio adipisci eaque dolor porro? Quo provident maiores tenetur eos et, enim numquam pariatur earum quia eligendi similique inventore porro temporibus dolor sed ex officiis laudantium! In, officia ducimus ratione rem fugiat, quod tempore praesentium excepturi harum facere repellat quo inventore enim unde sint nesciunt laboriosam magnam culpa at mollitia quia aut minus dolorum veritatis! Ex, numquam ipsa voluptatibus recusandae repellat ipsum magnam minus rerum eius laudantium perspiciatis rem dolorem esse, consequatur perferendis. Sit minima, aliquam at quia doloribus ab optio non tempore aliquid iusto corrupti! Harum, minima asperiores delectus doloremque dolore nam sit tenetur blanditiis? Eligendi nam animi mollitia officiis assumenda aspernatur! Nesciunt libero adipisci tempore quaerat, neque quia accusantium fugiat. Aspernatur eos, tempore enim, adipisci aliquid ipsa nemo dolorem dolorum nisi doloremque officiis quasi unde delectus hic id vitae laudantium sit provident consequatur, perferendis possimus! Voluptatum dolorem porro quas temporibus in exercitationem accusamus explicabo quibusdam totam enim repellendus eius, harum nihil molestias illum nobis consectetur natus! Rem commodi dolore sunt. Maiores quae aperiam ipsum quam amet vel obcaecati, modi sed ut animi possimus nemo ullam voluptate hic libero illo assumenda earum nihil nam enim! Impedit, nesciunt nobis accusamus quasi minus eius distinctio iste, consectetur atque veritatis quae sunt dolor culpa repellat vitae debitis? Voluptas veritatis voluptatibus architecto, quisquam accusantium delectus dolore modi quidem incidunt ipsum. Eveniet et minima aliquid ipsum unde consequuntur? Molestiae laudantium deleniti quis officia natus quasi doloribus amet illo porro excepturi numquam ut corrupti voluptatum, inventore unde voluptatibus nisi nulla mollitia optio quos vel architecto perferendis assumenda maxime. Neque minima iure vero accusantium aperiam! Tenetur, ratione voluptatem? Inventore qui consequatur aspernatur enim repellat.
          </div>
        </Content>
        <Footer style={{ textAlign: "center" }}>
          Ant Design ©2018 Created by Ant UED
        </Footer>
      </Layout>
    </Layout>
  );
};




export default Admin;
