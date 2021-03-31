import React from "react";
import {
  Nav,
  NavLink,
  Bars,
  NavMenu,
  NavBtn,
  NavBtnLink,
} from "./NavbarElements";
import LOGO from '../images/logo.svg';

const Navbar = () => {
  return (
    <>
      <Nav>
        <NavLink  to="/"><img src={LOGO} alt="logo"/></NavLink>
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
          <NavLink to="/admin" >
            Admin Demo
          </NavLink>
          <NavLink to="/vendor" >
            Vendor Demo
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
