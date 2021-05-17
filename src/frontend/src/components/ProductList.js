import React, { useState } from "react";
import styled from "styled-components";
import ProductCard from "./ProductCard";
import { AnimateSharedLayout, AnimatePresence } from "framer-motion";
import { Spin, Alert } from "antd";
const ProductList = ({ productlist }) => {
const [toggleToOpenProductDetail,settoggleToOpenProductDetail]=useState(null);
const ProductShelf=()=>{
  // if(toggleToOpenProductDetail!=null){
  //   return(<AnimatePresence><ProductDetailShowCase>{toggleToOpenProductDetail.product_id}</ProductDetailShowCase></AnimatePresence>);
  // }else{
  //   productlist.map((p, i) => {
  //     return <ProductCard key={i} product={p} toggleOpenDetail={settoggleToOpenProductDetail}/>;
  //   })
  // }



}
  if (productlist.length > 0) {
    return (
      <Content>
        <AnimateSharedLayout type="crossfade">
       {productlist.map((p, i) => {
       return <ProductCard key={i} product={p} toggleOpenDetail={settoggleToOpenProductDetail}/>;
     })}
        <AnimatePresence>{toggleToOpenProductDetail&&<ProductDetailShowCase>{toggleToOpenProductDetail.product_id}</ProductDetailShowCase>}</AnimatePresence>
      </AnimateSharedLayout>
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
const ProductDetailShowCase=styled.div`
  height:70vh;
  width:50%;
  position:absolute;
  background: #96babe;
`;
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
