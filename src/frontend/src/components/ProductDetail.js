import React,{useState} from "react";
import styled from "styled-components";
import { Button ,notification} from "antd";
import { SmileOutlined } from '@ant-design/icons';
import {useSelector } from "react-redux";
import PlaceOrderForm from "./PlaceOrderForm";
const ProductDetail = ({ ProductDetail, SetToggleDetail }) => {
//User's Jwt
const Jwt = useSelector((state) => state.user.jwt);
const userType = useSelector((state) => state.user.usertype);
const user = useSelector((state) => state.user.user);
//OrderForm
const [openOrderForm,setOpenOrderForm]=useState(false);
//SelectedVoucher
const [selectedVoucher,setVoucher]=useState(null);

const btn=(<a href="/signin">Login</a>);
//Notification
const openNotification = () => {
    notification.open({
      message: 'You Must Login As Customer To Continue Your Operation, Click Link Below To Login',
      btn,
      icon: <SmileOutlined style={{ color: '#108ee9' }} />,
    });
  };

const OpenPurchaseContent=(voucher)=>{
    //1.If user is not Customer
    if(userType!=="CUSTOMERUSER"){openNotification();return}
    //2.User Are logged in 
    setVoucher(voucher);
    setOpenOrderForm(true);
}
    // Voucher Item
const GetVouchers = (voucher, i) => {
    return (
      <Voucher key={i}>
        <h1>
          {voucher.title} -- {voucher.price} EUR
        </h1>
        <p>{voucher.description}</p>
        <Button onClick={()=>{OpenPurchaseContent(voucher)}}>Buy Now</Button>
      </Voucher>
    );
};


  return (
    <Container>
      <br />
      {Jwt&&selectedVoucher&&(<PlaceOrderForm 
      Jwt={Jwt}
      user={user}
      product={ProductDetail}
      voucher={selectedVoucher}
      visible={openOrderForm} 
      setvisible={setOpenOrderForm}
      />)}
      <ProductShowCase>
        <div><img src={ProductDetail.img} alt="product_img" /></div>
        <div>
          <Button
            color="primary"
            onClick={() => {
              SetToggleDetail(null);
            }}
          >
            Back To Home
          </Button>
          <h1>Product Name: {ProductDetail.product_name}</h1>
          <h2>Sold: {ProductDetail.sold}</h2>
          <h2>Stock: {ProductDetail.current_stock}</h2>
          <h2>Price: {ProductDetail.price} €</h2>
          <h2>Providor: {ProductDetail.store.store_name}</h2>
          <h2>Address: {ProductDetail.store.address}</h2>
          <h2>
            Offical Website:{" "}
            <a
              target="_blank"
              href={"https://" + ProductDetail.store.official_website}
            >
              {ProductDetail.store.official_website}
            </a>
          </h2>
        </div>
      </ProductShowCase>
      <VoucherList>
        <h1>Vouchers:</h1>
        {ProductDetail.vouchers.map((item, i) => GetVouchers(item, i))}
        <br />
      </VoucherList>
      <ProductIntroduction>
        <h1>Detail:</h1>
        {ProductDetail.description}
      </ProductIntroduction>
      <ReviewList>
        <h1>Reviews:</h1>
        <p>Empty...</p>
      </ReviewList>
      <br />
    </Container>
  );
};

const Container = styled.div`
  font-family: "Odibee Sans", cursive;
  height: 90vh;
  overflow: auto;
  width: 100%;
  background: #ffffff;
  align-items: center;
  align-content: center;
  grid-row-gap: 15px;
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
const ProductShowCase = styled.div`
  margin: 0 auto;
  overflow: hidden;
  width: 90%;
  height: 400px;
  background-color: #fcfcfc;
  border-radius: 10px;
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  justify-content: space-around;
  align-items: center;
  align-content: stretch;
  img {
    border-radius: 10px;
    margin: 20px;
  }
  box-shadow: 5px 5px 5px 5px #19191a33;
  @media (max-width: 1400px) {
  display: flex;
	flex-direction: column;
	flex-wrap: wrap;
	justify-content: center;
	align-items: center;
	align-content: stretch;
    height: 800px;
    text-align:center;
  }
  @media (max-width:850px){
    img{
      width: 400px;
    }
  }
`;
const ProductIntroduction = styled.div`
  margin: 0 auto;
  margin-top: 20px;
  padding: 20px;
  width: 90%;
  height: 200px;
  background-color: #fcfcfc;
  border-radius: 10px;
  text-align: center;
  word-wrap: break-word;
  box-shadow: 5px 5px 5px 5px #19191a33;
`;
const VoucherList = styled.div`
  margin: 0 auto;
  margin-top: 20px;
  width: 90%;
  height: 300px;
  background-color: #fcfcfc;
  border-radius: 10px;
  text-align: center;
  font-family: "Odibee Sans", cursive;
  box-shadow: 5px 5px 5px 5px #19191a33;
  display: grid;
  grid-row-gap: 10px;
  overflow: auto;
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
const Voucher = styled.div`
  padding: 10px;
  margin: 15px;
  height: 180px;
  width: auto;
  border-radius: 10px;
  word-wrap: break-word;
  overflow: auto;
  background-color: #fcfcfc;
  box-shadow: 5px 5px 5px 5px #19191a33;
`;
const ReviewList = styled.div`
  margin: 0 auto;
  margin-top: 20px;
  width: 90%;
  height: 600px;
  background-color: #fcfcfc;
  border-radius: 10px;
  text-align: center;
  font-family: "Odibee Sans", cursive;
  box-shadow: 5px 5px 5px 5px #19191a33;
  display: grid;
  grid-row-gap: 10px;
  overflow: auto;
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

export default ProductDetail;
