import { Switch, Route } from "react-router-dom";
import { Layout } from "antd";
import React from "react";
import styled from "styled-components";
import NavBar from "../components/HomePageNavBar";
import HomePageMainContent from "../components/HomePageMainContent";
import AboutMainContent from "../components/AboutMainContent";
import NotFound from "../components/NotFound";
import Forbidden from "../components/Forbidden";
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
        <Route exact path="/forbidden" component={Forbidden} />
        <Route exact path="/error" component={Forbidden} />
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
  background: rgb(2, 0, 36);
  background: linear-gradient(
    56deg,
    rgba(2, 0, 36, 1) 0%,
    rgba(114, 190, 180, 1) 66%,
    rgba(120, 131, 191, 1) 100%
  );
  height: 7vh;
`;

export default Home;
