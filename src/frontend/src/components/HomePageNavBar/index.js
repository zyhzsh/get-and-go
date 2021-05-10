import React from "react";
import {
  Nav,
  NavLink,
  Bars,
  NavMenu,
  NavBtn,
  NavBtnLink,
} from "./NavbarElements";

import {useDispatch, useSelector} from "react-redux";
import LOGO from "../images/logo.svg";
import { Button } from "antd";
const Navbar = () => {
  const dispatch = useDispatch();
  const userJwt = useSelector((state) => state.user.jwt);
  const LogOut=()=>{
    dispatch({ type: "LOG_OUT" });
  }

  function Btn(){
    if(userJwt){
      return(<Button onClick={LogOut} type="primary">Log Out</Button>);
    }
    return(<NavBtnLink to="/signin">Sign In</NavBtnLink>);
  }

  return (
    <>
      <Nav>
        <NavLink to="/">
          <img src={LOGO} alt="logo" />
        </NavLink>
        <Bars />
        <NavMenu>
          <NavLink to="/about">About</NavLink>
          <NavLink to="/contactus">Contact Us</NavLink>
          <NavLink to="/signup">Sign Up</NavLink>
        </NavMenu>
          <NavBtn>
            {<Btn>Sign In</Btn>}
          </NavBtn>
      </Nav>
    </>
  );
};

export default Navbar;
