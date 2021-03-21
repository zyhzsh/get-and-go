import React from "react";
import styled from "styled-components";
import ProductCard from "./ProductCard";
import { Spin, Alert } from "antd";
const ProductList = ({ productlist }) => {
  if (productlist.length > 0) {
    return (
      <Content>
        {productlist.map((p, i) => {
          return <ProductCard key={i} product={p} />;
        })}
      </Content>
    );
  } else {
    return (
      <Content>
        <Spin tip="Loading...">
          <Alert
            message="Trying to loading latest data..."
            description="If there is no news for a long time, it means we may not have such data yet."
            type="info"
          />
        </Spin>
      </Content>
    );
  }
};
const Content = styled.div`
  padding: 1rem;
  height: 75vh;
  overflow: auto;
  background: #ffffff;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-around;
  align-items: stretch;
  align-content: stretch;

  &::-webkit-scrollbar {
    padding-top: 20px;
    width: 0.5rem;
  }
  &::-webkit-scrollbar-thumb {
    background-color: darkgrey;
  }
  &::-webkit-scrollbar-track {
    background: linear-gradient(
      to right bottom,
      rgba(255, 255, 255, 0.7),
      rgba(255, 255, 255, 0.3)
    );
  }
`;
export default ProductList;
