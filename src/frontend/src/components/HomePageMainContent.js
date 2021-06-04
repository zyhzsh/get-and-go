import React, { useEffect,useState,useCallback} from "react";
import { useDispatch,useSelector } from "react-redux";
import { loadAllProducts,
  loadAllProductsByCategory,
  loadAllProdductsByCity,
  loadAllProdductsByCityAndCategory
 } from "../actions/productsAction";
import { Tabs,Layout } from "antd";
import styled from "styled-components";
import HomePageSideBar from "./HomePageSideBar";
import ProductList from"./ProductList";
import ProductDetail from "./ProductDetail";
const { TabPane } = Tabs;
const { Content } = Layout;
const HomePageMainContent = () => {
  //Fildering Products
  const [selectedcity,setSelectedCity]=useState("All");
  const [selectedcategory,setSelectedcategory]=useState("All");
  const [toggleProductDetailContent,settoggleProductDetailContent]=useState(null);
  const dispatch = useDispatch();
  const productlist = useSelector(state => state.products.products);
  const updateproductlist=useCallback(()=>{
    if(selectedcity==="All"&&selectedcategory==="All"){
      dispatch(loadAllProducts()); 
    }else if(selectedcity==="All"&&selectedcategory!=="All"){
      dispatch(loadAllProductsByCategory(selectedcategory)); 
    }else if(selectedcity!=="All"&&selectedcategory==="All"){
      dispatch(loadAllProdductsByCity(selectedcity)); 
    }else if(selectedcity!=="All"&&selectedcategory!=="All"){
      dispatch(loadAllProdductsByCityAndCategory(selectedcity,selectedcategory)); 
    }
  },[dispatch,selectedcategory,selectedcity]);
  useEffect(()=>{
    updateproductlist();
  },[updateproductlist])
if(toggleProductDetailContent!==null){
    return <ProductDetail ProductDetail={toggleProductDetailContent} SetToggleDetail={settoggleProductDetailContent}/>
}
else{
  return (
    <Content style={{ padding: "0 50px" }}>
      <Layout className="site-layout-background" style={{ padding: "24px 0" }}>
        <HomePageSideBar SetCity={setSelectedCity}/>
        <Content style={{ padding: "0 24px", minHeight: 280 }}>
          <ContentContainer>
            <Tabs defaultActiveKey="All" onChange={(key)=>setSelectedcategory(key)}>
              <TabPane tab="All" key="All" ><ProductList toggleProductDetail={settoggleProductDetailContent} productlist={productlist}/></TabPane>
              <TabPane tab="Food" key="Food" ><ProductList toggleProductDetail={settoggleProductDetailContent} productlist={productlist}/></TabPane>
              <TabPane tab="Event" key="Event"><ProductList toggleProductDetail={settoggleProductDetailContent} productlist={productlist}/></TabPane>
              <TabPane tab="Hotel" key="Hotel"><ProductList toggleProductDetail={settoggleProductDetailContent} productlist={productlist}/></TabPane>
              <TabPane tab="Wellness" key="Wellness"><ProductList toggleProductDetail={settoggleProductDetailContent} productlist={productlist}/></TabPane>
              <TabPane tab="WorkShop" key="WorkShop"><ProductList toggleProductDetail={settoggleProductDetailContent} productlist={productlist}/></TabPane>
              <TabPane tab="Speciality" key="Speciality"><ProductList toggleProductDetail={settoggleProductDetailContent} productlist={productlist}/></TabPane>
            </Tabs>
          </ContentContainer>
        </Content>
      </Layout>
    </Content>
  );
};
}
  
const ContentContainer=styled.div`

`;

export default HomePageMainContent;
