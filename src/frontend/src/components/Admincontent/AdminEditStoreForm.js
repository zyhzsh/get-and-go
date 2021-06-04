import React, { useEffect, useRef } from "react";
import {
  Drawer,
  Form,
  Button,
  Col,
  Row,
  Input,
  notification,
  Space,
  Select
} from "antd";

import {useSelector } from "react-redux";
import { useDispatch } from "react-redux";
import { editStoreInfomation } from "../../actions/adminAction";
const AdminEditStoreForm = ({visiable,setvisiable,store}) => {
  
    const { Option } = Select;
    const dispatch = useDispatch();
    const Jwt = useSelector((state) => state.user.jwt);
    //Submit New Store From
    const openNotificationWithIcon = (type) => {
          notification[type]({
            message: "Success",
            description: "Your Request is submitted",})
    };
    const SubmitForm = (formdata) => {
      dispatch(editStoreInfomation(formdata,Jwt));
      setTimeout(() => {
          openNotificationWithIcon("success");
          setvisiable(false)
      }, 1000);
      form.current.resetFields();
    };
    const form = useRef(null);
    
    useEffect(() => {
      form.current.resetFields();
    }, [visiable]);


    return (
      <>
        <Space />
        <Drawer
          title="Edit Store Information Here:"
          width={1000}
          onClose={() => {
            setvisiable(false);
          }}
          visible={visiable}
          bodyStyle={{ paddingBottom: 80 }}
          footer={
            <div
              style={{textAlign: "right"}}
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
              <h3 style={{textAlign: "center"}}>{`Store Owner: ${store.vendor.first_name} ${store.vendor.lasr_name}`}</h3>
              <h3 style={{textAlign: "center"}}>{`Contact Number: ${store.vendor.phone}`}</h3>
            <Row gutter={16}>
              <Col span={12}>
                <Form.Item
                  name="vendor_id"
                  label="Vendor ID"
                  rules={[{required: true,message:"Vendor id is required"}]}
                  initialValue={store.vendor.user_id}
                >
                  <Input disabled={true} placeholder="Vendor ID"/>
                </Form.Item>
              </Col>
              <Col span={12}>
                <Form.Item
                  name="store_id"
                  label="Store ID"
                  rules={[{required: true,message:"Store id is required"}]}
                  initialValue={store.store_id}
                >
                  <Input disabled={true} placeholder="Vendor ID"/>
                </Form.Item>
              </Col>
            </Row>
            <Row gutter={16}>
              <Col span={24}>
                <Form.Item
                  name="store_name"
                  label="Store Name"
                  rules={[
                    {
                      required: true,
                      message: "Please enter store name",
                    },
                  ]}
                  initialValue={store.store_name}
                >
                  <Input
                    style={{ width: "100%" }}
                    placeholder="Store Name"
                  />
                </Form.Item>
              </Col>
              <Col span={12}>
              <Form.Item
                name="city"
                label="City"
                rules={[{ required: true, message: "Please select an City" }]}
                initialValue={store.city}
              >
                <Select placeholder="Please select an City">
                  <Option value="EINDOHOVEN">Eindohoven</Option>
                  <Option value="TILBURG">Tilburg</Option>
                  <Option value="UTRECHT">Utrecht</Option>
                  <Option value="DELFT">Delft</Option>
                  <Option value="HAARLEM">Haarlem</Option>
                  <Option value="BREDA">Breda</Option>
                </Select>
              </Form.Item>
              </Col>
              <Col span={12}>
                <Form.Item
                  name="address"
                  label="Address"
                  rules={[
                    { required: true, message: "Please Enter the Address " },
                  ]}
                  initialValue={store.address}
                >
                  <Input
                    style={{ width: "100%" }}
                    placeholder="Please enter the Address"
                  />
                </Form.Item>
              </Col>
            </Row>
            <Row gutter={16}>
              <Col span={24}>
                <Form.Item 
                name="official_website" 
                initialValue={store.official_website}
                label="Official Website"
                >
                  <Input
                    style={{ width: "100%" }}
                    addonBefore="http://"
                    placeholder="Optional Please enter official website"
                  />
                </Form.Item>
              </Col>
            </Row>
            <Row gutter={16}>
            <Col span={24}>
                <Form.Item 
                name="img"
                rules={[
                    { required: true, message: "Please Enter the Address " },
                  ]}
                 label="Store Picture"
                 initialValue={store.img}
                 >
                  <Input
                    style={{ width: "100%" }}
                    addonBefore="http://"
                    placeholder="Optional Please enter official website"
                  />
                </Form.Item>
              </Col>
            </Row>
            <Row gutter={16}>
            <Col span={24}>
              <Form.Item
                name="description"
                label="Description"
                rules={[
                  {
                    required: true,
                    message: "Please enter the description about the store",
                  },
                ]}
                initialValue={store.description}
              >
                <Input.TextArea
                  rows={4}
                  placeholder="Please enter the description about the store"
                />
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
export default AdminEditStoreForm;
