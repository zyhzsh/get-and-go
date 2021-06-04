
import React from 'react'
import {
    FacebookOutlined,
    InstagramFilled,
    TwitterCircleFilled,
  } from "@ant-design/icons";
import styled from "styled-components";
const Footer = () => {
    return (
        <Container>
        <FacebookOutlined style={{ fontSize: "1.5rem" }} />
        <InstagramFilled style={{ fontSize: "1.5rem", marginLeft: "2px" }} />
        <TwitterCircleFilled
          style={{ fontSize: "1.5rem", marginLeft: "2px", marginRight: "2px" }}
        />
        GetAndGo BV ©2021
      </Container>

    )
}
const Container = styled.div`
  bottom: 0;
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
  height: 5vh;
`;
export default Footer
