import React, { useRef } from "react";
import {
  Drawer,
  Form,
  Button,
  Col,
  Row,
  Input,
  notification,
  Space,
} from "antd";
import { useDispatch } from "react-redux";
import { registernewVendor } from "../../actions/adminAction";
const AdminAddNewStoreForm = ({ visiable, setvisiable, vendors }) => {
  const dispatch = useDispatch();
  //Submit New Store From
  const openNotificationWithIcon = (type) => {
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
          description: "Email address has been taken",
        });
        break;
      default:
        break;
    }
  };
  const SubmitForm = (formdata) => {
    openNotificationWithIcon("success");
    dispatch(registernewVendor(formdata));
    form.current.resetFields();
  };
  const form = useRef(null);
  return (
    <>
      <Space />
      <Drawer
        title="Register an new vendor user here"
        width={1000}
        onClose={() => {
          setvisiable(false);
        }}
        visible={visiable}
        bodyStyle={{ paddingBottom: 80 }}
        footer={
          <div
            style={{
              textAlign: "right",
            }}
          >
            <Button
              onClick={() => {
                setvisiable(false);
              }}
              style={{ marginRight: 8 }}
            >
              Cancel
            </Button>
          </div>
        }
      >
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
                label="Email Address"
                rules={[
                  {
                    required: true,
                    message: "Please Enter Vendor's Email",
                  },
                ]}
              >
                <Input
                  onChange={(e) => {
                    vendors.forEach((v) => {
                      if (v.email === e.target.value) {
                        openNotificationWithIcon("warning");
                      }
                    });
                  }}
                  placeholder="Vendor Email"
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
                  {
                    required: true,
                    message: "Please Enter Vendor's Password",
                  },
                ]}
              >
                <Input
                  style={{ width: "100%" }}
                  type="password"
                  placeholder="Password"
                />
              </Form.Item>
            </Col>
            <Col span={24}>
              <Form.Item
                name="first_name"
                label="First Name"
                rules={[
                  {
                    required: true,
                    message: "Please Enter Vendor's First Name",
                  },
                ]}
              >
                <Input
                  style={{ width: "100%" }}
                  placeholder="Please enter first name"
                />
              </Form.Item>
            </Col>
          </Row>
          <Row gutter={16}>
            <Col span={24}>
              <Form.Item
                name="last_name"
                label="Last Name"
                rules={[
                  { required: true, message: "Please Enter the Last Name " },
                ]}
              >
                <Input
                  style={{ width: "100%" }}
                  placeholder="Please enter the last name"
                />
              </Form.Item>
            </Col>
            <Col span={24}>
              <Form.Item name="avatar_link" label="Avatar Img Source">
                <Input
                  style={{ width: "100%" }}
                  addonBefore="http://"
                  placeholder="Optional Please enter img source url"
                />
              </Form.Item>
            </Col>
          </Row>
          <Row gutter={16}>
            <Col span={24}>
              <Form.Item
                name="phone"
                label="Phone Number"
                rules={[
                  {
                    required: true,
                    message: "Please enter the contact number",
                  },
                ]}
              >
                <Input rows={4} placeholder="Please enter the phone number" />
              </Form.Item>
            </Col>
          </Row>
          <Button type="primary" htmlType="submit">
            Submit
          </Button>
        </Form>
      </Drawer>
    </>
  );
};

export default AdminAddNewStoreForm;
