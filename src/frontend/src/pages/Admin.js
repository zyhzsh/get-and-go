import React, { useState } from "react";
import {useSelector } from "react-redux";
//Admin Content element
import AdminDashBoard from "../components/Admincontent/AdminDashBoard";
import AdminStoreManagement from "../components/Admincontent/AdminStoreManagement";
import AdminOrderManagement from "../components/Admincontent/AdminOrderManagement";
import AdminReviewManagement from "../components/Admincontent/AdminReviewManagement";
//Ant Ui
import { Layout, Menu, Button } from "antd";
import {
  UserOutlined,
  PieChartOutlined,
  BankOutlined,
  CommentOutlined,
} from "@ant-design/icons";
import LOGO from "../components/images/logo.svg";
import { Redirect } from "react-router";
const Admin = () => {
  const { Header, Content, Footer, Sider } = Layout;
  const [collapsed, setcollapsed] = useState(false);
  const [selectedcontent, Setselectedcontent] = useState("DashBoard");
  const Role = useSelector((state) => state.user);
  console.log(Role.usertype);
  if(Role.usertype!=="MANAGERUSER"){return <Redirect to= "/error"/>}
  const SelectedContent = () => {
    if (selectedcontent === "DashBoard") {
      return <AdminDashBoard />;
    } else if (selectedcontent === "Store") {
        return <AdminStoreManagement />;
    } else if (selectedcontent === "Order") {
      return <AdminOrderManagement />;
    } else if (selectedcontent === "Review") {
      return <AdminReviewManagement />;
    }
  };
  const onCollapse = (collapsed) => {
    setcollapsed(collapsed);
  };
  return (
    <Layout className="ss" style={{ minHeight: "100vh"}}>
      <Sider collapsible collapsed={collapsed} onCollapse={onCollapse}>
        <img src={LOGO} alt="logo" />
        <Menu theme="dark" defaultSelectedKeys={["DashBoard"]} mode="inline">
          <Menu.Item
            key="DashBoard"
            onClick={(e) => {
              Setselectedcontent(e.key);
            }}
            icon={<PieChartOutlined />}
          >
            DashBoard
          </Menu.Item>
          <Menu.Item
            key="Store"
            onClick={(e) => {
              Setselectedcontent(e.key);
            }}
            icon={<BankOutlined />}
          >
            Store
          </Menu.Item>
          <Menu.Item
            key="Order"
            onClick={(e) => {
              Setselectedcontent(e.key);
            }}
            icon={<UserOutlined />}
          >
            Order
          </Menu.Item>
          <Menu.Item
            key="Review"
            onClick={(e) => {
              Setselectedcontent(e.key);
            }}
            icon={<CommentOutlined />}
          >
            Review
          </Menu.Item>
        </Menu>
      </Sider>
      <Layout className="site-layout">
        <Header className="site-layout-background" style={{ padding: 0 }}>
          <Button></Button>
        </Header>
        <Content style={{ margin: "30px 16px" }}>{SelectedContent()}</Content>
        <Footer style={{ textAlign: "center" }}>©2021</Footer>
      </Layout>
    </Layout>
  );
};



export default Admin;
