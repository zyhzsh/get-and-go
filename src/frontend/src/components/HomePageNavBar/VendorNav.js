import React from "react";
import {
  Nav,
  NavLink,
  Bars,
  NavMenu,
  NavBtn
} from "./NavbarElements";

import {useDispatch, useSelector} from "react-redux";
import LOGO from "../images/logo.svg";
import { Button } from "antd";
import { Redirect } from "react-router";
const VendorNav = () => {
  const dispatch = useDispatch();
  const userType = useSelector((state) => state.user.usertype);
  const LogOut=()=>{

    dispatch({ type: "LOG_OUT" });
  }
  function Check(){
    if(userType!=="VENDORUSER"){
      return <Redirect to="/signin"/>;
    }
  }
  return (
    <>
      {Check()}
      <Nav>
        <NavLink to="/vendor">
          <img src={LOGO} alt="logo" />
        </NavLink>
        <Bars />
        <NavMenu>
 
        </NavMenu>
          <NavBtn>
            {<Button onClick={LogOut} type="primary">Log Out</Button>}
          </NavBtn>
      </Nav>
    </>
  );
};

export default VendorNav;
