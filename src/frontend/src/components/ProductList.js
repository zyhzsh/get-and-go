import React from "react";
import styled from "styled-components";
import ProductCard from "./ProductCard";
import NotFound from "./NotFound";
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
        <NotFound />
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
  justify-content: center;
  align-items: flex-end;
  align-content: flex-start;
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
