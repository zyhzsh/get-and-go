import React, { useRef } from "react";
import { useDispatch, useSelector } from "react-redux";
import { Form, Button, Col, Row, Input, notification } from "antd";
import { signUpCustomer } from "../actions/userAction";
import styled from "styled-components";
import { Redirect } from "react-router-dom";

const SignUpContent = () => {
  const form = useRef(null);
  const dispatch = useDispatch();
  const openNotificationWithIcon = (type) => {
        notification[type]({
          message: "Warning",
          description: registerResult, //"Email address has been taken",
        })
  };
  const SubmitForm = (formdata) => {
    dispatch(signUpCustomer(formdata));
  };
  const registerResult = useSelector(
    (state) => state.message.systemBack.signupResult
  );

  if (registerResult === "Request Accepted") {
    return <Redirect to="/signin" />;
  } else {
    registerResult && openNotificationWithIcon("info");
    return (
      <Content>
        <h2>Sign Up</h2>
        <Form
          layout="vertical"
          onFinish={(value) => {
            SubmitForm(value);
          }}
          ref={form}
        >
          <Row gutter={16}>
            <Col span={24}>
              <Form.Item
                name="email"
                label="Email"
                rules={[{ required: true, message: "Email is required ~!" }]}
              >
                <Input
                  style={{ width: "100%" }}
                  type="email"
                  placeholder="Please enter your Email"
                />
              </Form.Item>
            </Col>
          </Row>
          <Row gutter={16}>
            <Col span={24}>
              <Form.Item
                name="password"
                label="Password"
                rules={[
                  { required: true, message: "Please Enter the password" },
                ]}
              >
                <Input
                  type="password"
                  style={{ width: "100%" }}
                  placeholder="Password"
                />
              </Form.Item>
            </Col>
          </Row>
          <Row gutter={16}>
            <Col span={24}>
              <Form.Item
                name="first_name"
                label="First Name"
                rules={[
                  {
                    required: true,
                    message: "Please Enter Your First Name ",
                  },
                ]}
              >
                <Input style={{ width: "100%" }} placeholder="First Name" />
              </Form.Item>
            </Col>
          </Row>

          <Row gutter={16}>
            <Col span={24}>
              <Form.Item
                name="last_name"
                label="Last Name"
                rules={[
                  { required: true, message: "Please Enter Your Last Name" },
                ]}
              >
                <Input style={{ width: "100%" }} placeholder="Last Name" />
              </Form.Item>
            </Col>
          </Row>
          <Button type="primary" htmlType="submit">
            Sign Up
          </Button>
        </Form>
      </Content>
    );
  }
};
const Content = styled.div`
  height: 100vh;
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
  align-content: stretch;
`;
export default SignUpContent;
