import { Switch, Route } from "react-router-dom";
import { Layout } from "antd";
import React from "react";
import NavBar from "../components/HomePageNavBar";
import HomePageMainContent from "../components/HomePageMainContent";
import AboutMainContent from "../components/AboutMainContent";
import NotFound from "../components/NotFound";
import Forbidden from "../components/Forbidden";
import SignInContent from "../components/SignInContent";
import SignUpContent from "../components/SignUpContent";
import Footer from "../components/Footer";

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
      <Footer/>
    </Layout>
  );
};



export default Home;
