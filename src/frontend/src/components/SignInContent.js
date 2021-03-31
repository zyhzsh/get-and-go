import React from "react";
import styled from "styled-components";
import { Form, Input, Button } from "antd";
import { UserOutlined, LockOutlined } from "@ant-design/icons";
import { Link } from "react-router-dom";
import { useDispatch } from "react-redux";
import { userLogin
 } from "../actions/userAction";
const SignInContent = () => {
  const dispatch = useDispatch();

  const onFinish = (values) => {
    if (values) {
    //  console.log(values.email);
     // console.log(values.password);
      dispatch(userLogin(values.email,values.password))
    }
  };

  return (
    <Content>
      <Form name="normal_login" className="login-form" onFinish={onFinish}>
        <h1>Sign In </h1>
        <Form.Item
          name="email"
          rules={[
            {
              required: true,
              message: "Please input your Email!",
            },
          ]}
        >
          <Input
            prefix={<UserOutlined className="site-form-item-icon" />}
            placeholder="Email"
          />
        </Form.Item>
        <Form.Item
          name="password"
          rules={[
            {
              required: true,
              message: "Please input your Password!",
            },
          ]}
        >
          <Input
            prefix={<LockOutlined className="site-form-item-icon" />}
            type="password"
            placeholder="Password"
          />
        </Form.Item>
        <Form.Item>
          <Link to="/">Forgot password</Link>
        </Form.Item>
        <Form.Item>
          <Button
            type="primary"
            htmlType="submit"
            className="login-form-button"
          >
            Log in
          </Button>
          Or
          <Link to="signup"> register now!</Link>
        </Form.Item>
      </Form>
    </Content>
  );
};
const Content = styled.div`
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
`;
export default SignInContent;
