import React from "react";
import { Layout, Menu } from "antd";
const { Sider } = Layout;
const HomePageSideBar=({SetCity})=>{
  const SetCityTo=(city)=>{
    SetCity(city);
  }
  return (
    <Sider className="site-layout-background" width={200}>
      <Menu
        mode="inline"
        defaultSelectedKeys={["All"]}
        style={{ height: "100%" }}
      >
        <Menu.Item key="All" onClick={(e)=>{SetCityTo(e.key)}}>All-City</Menu.Item>
        <Menu.Item key="Eindohoven" onClick={(e)=>{SetCityTo(e.key)}}>Eindohoven</Menu.Item>
        <Menu.Item key="Tilburg" onClick={(e)=>{SetCityTo(e.key)}}>Tilburg</Menu.Item>
        <Menu.Item key="Utrecht" onClick={(e)=>{SetCityTo(e.key)}}>Utrecht</Menu.Item>
        <Menu.Item key="Delft" onClick={(e)=>{SetCityTo(e.key)}}>Delft</Menu.Item>
        <Menu.Item key="Haarlem" onClick={(e)=>{SetCityTo(e.key)}}>Haarlem</Menu.Item>
        <Menu.Item key="Breda" onClick={(e)=>{SetCityTo(e.key)}}>Breda</Menu.Item>
      </Menu>
    </Sider>
  );
}
export default HomePageSideBar;
