import React, { useRef, useState } from "react";
import {
  Drawer,
  Form,
  Button,
  Col,
  Row,
  Input,
  Select,
  DatePicker,
  Table,
} from "antd";
import styled from "styled-components";

const AdminAddNewStoreForm = ({ visiable, setvisiable }) => {
  const { Option } = Select;
  const name = useRef(null);
  const onFinish = () => {
    setvisiable(false);
    console.log(name.current.state.value);
  };

  const data = [
    {
      id: "1",
      first_name: "Jojn",
      last_name: "Clous",
      email: "vendor1@gmail.com",
      phone: "12321651",
    },
    {
      id: "2",
      first_name: "Tom",
      last_name: "fjdi",
      email: "vendor2@gmail.com",
      phone: "12321651",
    },
    {
      id: "3",
      first_name: "Jim",
      last_name: "Brown",
      email: "vendor3@gmail.com",
      phone: "12321651",
    },
    {
      id: "7",
      first_name: "Jim",
      last_name: "jackiasd",
      email: "vendor3@gmail.com",
      phone: "12321651",
    },
    {
      id: "81",
      first_name: "Jim",
      last_name: "jackiasd",
      email: "vendor3@gmail.com",
      phone: "12321651",
    },
    {
      id: "484",
      first_name: "Jim",
      last_name: "jackiasd",
      email: "vendor3@gmail.com",
      phone: "12321651",
    },
  ];

  // Vendor List Table Configure
  const [dataSource, setDataSource] = useState(data);
  const [value, setValue] = useState("");
  const FilterByInput = (placeholder) => (
    <Input
      placeholder={placeholder}
      value={value}
      onChange={(e) => {
        const currValue = e.target.value;
        setValue(currValue);
        const filteredData = data.filter((entry) =>
          entry.id.includes(currValue)
        );
        setDataSource(filteredData);
      }}
    />
  );
  const columns = [
    {
      title: FilterByInput("Vendor ID"),
      dataIndex: "id",
      key: "id",
      width: "20%",
    },
    {
      title: "First Name",
      dataIndex: "first_name",
      key: "first_name",
      width: "12%",
    },
    {
      title: "Last Name",
      dataIndex: "last_name",
      key: "last_name",
      width: "12%",
    },
    {
      title: "Email",
      dataIndex: "email",
      key: "email",
    },
    {
      title: "Phone",
      dataIndex: "phone",
      key: "phone",
    },
  ];
  return (
    <>
      <Drawer
        title="New Store"
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
            <Button onClick={onFinish} type="primary">
              Submit
            </Button>
          </div>
        }
      >
        <VendorList>
          <h3>Vendor List</h3>
          <Table
            columns={columns}
            dataSource={dataSource}
            scroll={{ y:300 }}
            pagination={false}
          />
        </VendorList>
        <Form layout="vertical" hideRequiredMark>
          <Row gutter={16}>
            <Col span={12}>
              <Form.Item
                name="name"
                label="Name"
                rules={[{ required: true, message: "Please enter user name" }]}
              >
                <Input ref={name} placeholder="Please enter user name" />
              </Form.Item>
            </Col>
            <Col span={12}>
              <Form.Item
                name="url"
                label="Url"
                rules={[{ required: true, message: "Please enter url" }]}
              >
                <Input
                  style={{ width: "100%" }}
                  addonBefore="http://"
                  addonAfter=".com"
                  placeholder="Please enter url"
                />
              </Form.Item>
            </Col>
          </Row>
          <Row gutter={16}>
            <Col span={12}>
              <Form.Item
                name="owner"
                label="Owner"
                rules={[{ required: true, message: "Please select an owner" }]}
              >
                <Select placeholder="Please select an owner">
                  <Option value="xiao">Xiaoxiao Fu</Option>
                  <Option value="mao">Maomao Zhou</Option>
                </Select>
              </Form.Item>
            </Col>
            <Col span={12}>
              <Form.Item
                name="type"
                label="Type"
                rules={[{ required: true, message: "Please choose the type" }]}
              >
                <Select placeholder="Please choose the type">
                  <Option value="private">Private</Option>
                  <Option value="public">Public</Option>
                </Select>
              </Form.Item>
            </Col>
          </Row>
          <Row gutter={16}>
            <Col span={12}>
              <Form.Item
                name="approver"
                label="Approver"
                rules={[
                  { required: true, message: "Please choose the approver" },
                ]}
              >
                <Select placeholder="Please choose the approver">
                  <Option value="jack">Jack Ma</Option>
                  <Option value="tom">Tom Liu</Option>
                </Select>
              </Form.Item>
            </Col>
            <Col span={12}>
              <Form.Item
                name="dateTime"
                label="DateTime"
                rules={[
                  { required: true, message: "Please choose the dateTime" },
                ]}
              >
                <DatePicker.RangePicker
                  style={{ width: "100%" }}
                  getPopupContainer={(trigger) => trigger.parentElement}
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
                    message: "please enter url description",
                  },
                ]}
              >
                <Input.TextArea
                  rows={4}
                  placeholder="please enter url description"
                />
              </Form.Item>
            </Col>
          </Row>
        </Form>
      </Drawer>
    </>
  );
};

const VendorList = styled.div`
  height: 400px;
  padding-top: 10px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  background-color: #f0f0f0;
  > div {
    height: 100%;
    margin: 20px;
    margin-top: 0px;
  }
`;
export default AdminAddNewStoreForm;
