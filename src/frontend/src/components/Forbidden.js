import React from "react";
import { Link } from "react-router-dom";
import { Empty, Button } from "antd";
import styled from "styled-components";
function Forbidden() {
  return (
    <Content>
      <Empty description="Your Request Is Forbidden" />
      <div>
        <Link to="/">
          <Button type="primary" size={"large"}>
            Go Back To Home Page ?
          </Button>
        </Link>
      </div>
    </Content>
  );
}
const Content = styled.div`
  height: 100vh;
  display: flex;
  flex-direction: column;
  flex-wrap: nowrap;
  justify-content: center;
  align-items: center;
  align-content: center;
`;

export default Forbidden;
