import React from "react";
import { Modal, Button, Form, Input, Col, Row ,notification} from "antd";
import styled from "styled-components";
import { useDispatch } from "react-redux";
import { orderVoucher } from "../actions/userAction";
const PlaceOrderForm = ({
  Jwt,
  user,
  product,
  voucher,
  visible,
  setvisible,
}) => {

    const dispatch = useDispatch();
    const openNotificationWithIcon = (type) => {
        notification[type]({
          message: "Success",
          description: "Your Oder Submitted",})
  };
//Submit Order
  const SubmitForm = (formdata) => {
    console.log(formdata);
    dispatch(orderVoucher(Jwt,formdata));
    setTimeout(() => {
        openNotificationWithIcon("success");
        setvisible(false);
    }, 1000);
  };
  return (
    <Modal
      visible={visible}
      title="Order Information"
      onCancel={() => setvisible(false)}
      footer={[
        <Button key="back" onClick={() => setvisible(false)}>
          Return
        </Button>,
      ]}
    >
      <GreetingBox>
       <h1> Hi, {user.first_name} {user.last_name}</h1>
      </GreetingBox>
      <ProductInfoBox>
        <h3>Product:</h3>
        <h4>{product.product_name}</h4>
        <h4>{product.store.store_name}</h4>
      </ProductInfoBox>
      <VoucherInfoBox>
         <h3>Voucher:</h3>
        <h4>{voucher.price} EUR</h4>
        <h4>{voucher.title}</h4>
        <p>{voucher.description}</p> 
        
      </VoucherInfoBox>
      <OrderContainer>
           <Form
          layout="vertical"
          onFinish={(value) => {
            SubmitForm(value);
          }}
        >
          <Row gutter={16}>
            <Col span={24}>
              <Form.Item
                name="customer_id"
                label="Your Customer ID"
                rules={[
                  { required: true}
                ]}
                initialValue={user.user_id}
              >
                <Input
                disabled={true}
                  style={{ width: "100%" }}
                />
              </Form.Item>
            </Col>
          </Row>
          <Row gutter={16}>
            <Col span={24}>
              <Form.Item
                name="voucher_id"
                label="Voucher ID"
                rules={[
                  {required: true},
                ]}
                initialValue={voucher.voucher_id}
              >
                <Input 
                disabled
                rows={4} />
              </Form.Item>
              <Form.Item
                name="email"
                label="Contact Email"
                rules={[
                  {required: true},
                ]}
                initialValue={user.email}
              >
                <Input type="email" rows={4} placeholder="example@company.com" />
              </Form.Item>
            </Col>
          </Row>
          <Button type="primary" htmlType="submit">
            Submit
          </Button>
        </Form>
          </OrderContainer>
    </Modal>
  );
};
const GreetingBox = styled.div`
  width: auto;
  background-color: #fcfcfc;
  box-shadow: 5px 5px 5px 5px #19191a33;
  text-align: center;
  border-radius: 8px;
  padding: 1px;
`;
const ProductInfoBox = styled.div`
  margin-top: 10px;
  width: 100%;
  background-color: #fcfcfc;
  box-shadow: 5px 5px 5px 5px #19191a33;
  text-align: center;
  border-radius: 8px;
  padding: 1px;
`;
const VoucherInfoBox = styled.div`
margin-top: 10px;
  width: 100%;
  background-color: #fcfcfc;
  box-shadow: 5px 5px 5px 5px #19191a33;
  text-align: center;
  border-radius: 8px;
  padding: 1px;
`;
const OrderContainer=styled.div`
margin-top: 10px;
padding: 10px;
  background-color: #fcfcfc;
  box-shadow: 5px 5px 5px 5px #19191a33;
  border-radius: 8px;
`;

export default PlaceOrderForm;
