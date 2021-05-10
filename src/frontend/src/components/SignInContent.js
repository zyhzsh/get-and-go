import React from "react";
import styled from "styled-components";
import { Form, Input, Button,notification } from "antd";
import { UserOutlined, LockOutlined } from "@ant-design/icons";
import { Link } from "react-router-dom";
import { useDispatch ,useSelector} from "react-redux";
import { userLogin
 } from "../actions/userAction";
 import { Redirect } from "react-router-dom";
const SignInContent = () => {
  const dispatch = useDispatch();
  const registerResult = useSelector(
    (state) => state.message.systemBack.signupResult
  );
  const userJwt = useSelector((state) => state.user.jwt);
  const userType = useSelector((state) => state.user.usertype);
  const loginResult=useSelector((state) => state.user.result);
  const openNotificationWithIcon = (msg,type) => {

    switch (type) {
      case "success":
        notification[type]({
          message: "Success",
          description: "Your Request is submitted",
        });
        break;
      case "warning":
        notification[type]({
          message: "Warning",
          description: `${msg}`,
        });
      
        break;
      default:
        break;
      }
  };
  if(registerResult==="Request Accepted"){
    openNotificationWithIcon("","success")
    dispatch({ type: "RESET_SIGN_UP_MESSAGE" });
  }
  
  const onFinish = (values) => {
    if (values) {
      dispatch(userLogin(values.email,values.password));
      dispatch({ type: "RESET_SIGN_UP_MESSAGE" });
    }
  };
  if(userJwt&&userType){
    switch(userType){
      case "VENDORUSER":return <Redirect to="/vendor" />;
      case "MANAGERUSER":return <Redirect to="/admin" />;
      case "CUSTOMERUSER":return <Redirect to="/" />;
      default: break;
     }
  }else{
    if(loginResult){
      openNotificationWithIcon(loginResult,"warning");
      dispatch(dispatch({ type: "RESET_LOG_IN_MESSAGE" }));
    }
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
            <Link to="/signup"> register now!</Link>
          </Form.Item>
        </Form>
      </Content>
    );
  };
  }


const Content = styled.div`
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
`;
export default SignInContent;
