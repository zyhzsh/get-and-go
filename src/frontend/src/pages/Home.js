import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import { Layout } from "antd";
import React, { useEffect, useState } from "react";
import { useDispatch } from "react-redux";
import { loadProducts } from "../actions/productsAction";
import styled from "styled-components";
import NavBar from "../components/HomePageNavBar";
import HomePageMainContent from "../components/HomePageMainContent";
import AboutMainContent from "../components/AboutMainContent";
import NotFound from "../components/NotFound";
import SignInContent from "../components/SignInContent";
import SignUpContent from "../components/SignUpContent";

const Home = () => {
  // const dispatch = useDispatch();
  // useEffect(() => {
  //   dispatch(loadProducts());
  // });
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
      <Footer>GetAndGo BV ©2021</Footer>
    </Layout>
  );
};
const Footer = styled.div`
  margin-top: 1rem;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
  background-color: gray;
`;

export default Home;
