import { Switch, Route } from "react-router-dom";
import { Layout } from "antd";
import React from "react";
import styled from "styled-components";
import NavBar from "../components/HomePageNavBar";
import HomePageMainContent from "../components/HomePageMainContent";
import AboutMainContent from "../components/AboutMainContent";
import NotFound from "../components/NotFound";
import SignInContent from "../components/SignInContent";
import SignUpContent from "../components/SignUpContent";
import {
  FacebookOutlined,
  InstagramFilled,
  TwitterCircleFilled,
} from "@ant-design/icons";

const Home = () => {
  return (
    <Layout style={{ height: "100vh" }}>
      <NavBar />
      <Switch>
        <Route exact path="/" component={HomePageMainContent} />
        <Route exact path="/about" component={AboutMainContent} />
        <Route exact path="/signin" component={SignInContent} />
        <Route exact path="/signup" component={SignUpContent} />
        <Route component={NotFound} />
      </Switch>
      <Footer>
        <FacebookOutlined style={{ fontSize: "1.5rem" }} />
        <InstagramFilled style={{ fontSize: "1.5rem", marginLeft: "2px" }} />
        <TwitterCircleFilled
          style={{ fontSize: "1.5rem", marginLeft: "2px", marginRight: "2px" }}
        />
        GetAndGo BV ©2021
      </Footer>
    </Layout>
  );
};
const Footer = styled.div`
  margin-top: 1rem;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
  background: grey;
  height: 7vh;
`;

export default Home;
