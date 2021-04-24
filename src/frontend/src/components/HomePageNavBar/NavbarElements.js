import styled from "styled-components";
import { NavLink as Link } from "react-router-dom";
import { BarsOutlined } from "@ant-design/icons";
export const Nav = styled.nav`
//  background:#8a6767;
background: rgb(2,0,36);
background: linear-gradient(56deg, rgba(2,0,36,1) 0%, rgba(114,190,180,1) 66%, rgba(120,131,191,1) 100%);
  height: 80px;
  display: flex;
  justify-content: space-between;
  padding: 0.5rem;
  padding: 0.5rem calc((100vw-1000px) / 2);
  z-index: 10;
`;
export const NavLink = styled(Link)`
  color: #fff;
  display: flex;
  align-items: center;
  text-decoration: none;
  padding: 0 1rem;
  height: 100%;
  cursor: pointer;
  &.active {
    color: #15cdfc;
  }
`;
export const Bars = styled(BarsOutlined)`
  display: none;
  color: #fff;

  @media screen and (max-width: 768px) {
    display: block;
    position: absolute;
    top: 0;
    right: 0;
    transform: translate(-100%, 75%);
    font-size: 1.8rem;
    cursor: pointer;
  }
`;

export const NavMenu = styled.div`
  display: flex;
  align-items: center;
  margin-right: -24px;
  @media screen and (max-width: 768px) {
    display: none;
  }
`;
export const NavBtn = styled.nav`
  display: flex;
  align-items: center;
  margin-right: 24px;

  @media screen and (max-width: 768px) {
    display: none;
  }
`;

export const NavBtnLink = styled(Link)`
  border-radius: 4px;
  background: #256ce1;
  padding: 10px 22px;
  color: #fff;
  border: none;
  outline: none;
  cursor: pointer;
  transition: all 0.2s ease-in-out;
  text-decoration: none;

  &:hover {
    transition: all 0.2s ease-in-out;
    background: #fff;
    color: 010606;
  }
`;
