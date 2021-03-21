import React,{useState} from "react";
import {
  Nav,
  NavLink,
  Bars,
  NavMenu,
  NavBtn,
  NavBtnLink,
} from "./NavbarElements";
const Navbar = () => {
  return (
    <>
      <Nav>
        <NavLink  to="/">Logo</NavLink>
        <Bars />
        <NavMenu>
          <NavLink to="/about" >
            About
          </NavLink>
          <NavLink to="/contactus" >
            Contact Us
          </NavLink>
          <NavLink to="/signup" >
            Sign Up
          </NavLink>
          {/* Second Nav */}
          {/* <NavBtnLink to='/sign-in'>Sign In</NavBtnLink> */}
        </NavMenu>
        <NavBtn>
          <NavBtnLink to="/signin">Sign In</NavBtnLink>
        </NavBtn>
      </Nav>
    </>
  );
};

export default Navbar;
