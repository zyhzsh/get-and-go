import React, { useRef, useState } from "react";
import {
  Drawer,
  Form,
  Button,
  Col,
  Row,
  Input,
  Select,
  Table
} from "antd";
import styled from "styled-components";
import { useDispatch } from "react-redux";
import { addnewStore } from "../../actions/adminAction";
const AdminAddNewStoreForm = ({ visiable, setvisiable ,vendors}) => {
  const { Option } = Select;
  const dispatch = useDispatch();
  const SubmitForm = (formdata) => {
    alert("add succeed ~ !")
   // console.log(formdata);
    dispatch(addnewStore(formdata))
    form.current.resetFields();
  };  
  // Vendor List Table Configure
  
//  const vendorslist = useSelector((state) => state.vendors.vendors);
  const [value, setValue] = useState("");
  const form=useRef(null);
  const FilterByInput = (placeholder) => (
    <Input
      placeholder={placeholder}
      value={value}
      onChange={(e) => {
        const currValue = e.target.value;
        setValue(currValue);
        const filteredData = vendors.filter((entry) =>
           entry.id.toString().includes(currValue)
        );
        setDataSource(filteredData);
      }}
    />
  );
const [dataSource, setDataSource] = useState(vendors);
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
  const SelectVendor=(selected_vendor_id)=>{
    form.current.setFieldsValue({vendor_id:selected_vendor_id});
  }
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
          </div>
        }
      >
        <h3>Vendor List</h3>
        <VendorList>
          <Table
            onRow={(record) => {
              return {
                onDoubleClick: () => {
                  SelectVendor(record.id);
                },
              };
            }}
            columns={columns}
            dataSource={dataSource}
            scroll={{ y: 300 }}
            pagination={false}
            rowKey="id"
          />
        </VendorList>
        <Form layout="vertical" 
        onFinish={(value)=>{SubmitForm(value)}}
        ref={form}
        >
          <Row gutter={16}>
            <Col span={12}>
              <Form.Item name="vendor_id" label="Vendor ID"rules={[{ required: true, message: "Select vendor from the table above" }]}>
                <Input disabled={true} placeholder="Select vendor from the table above"/>
              </Form.Item>
            </Col>
            <Col span={12}>
            <Form.Item
                name="city"
                label="City"
                rules={[{ required: true, message: "Please select an City" }]}
              >
                <Select placeholder="Please select an City">
                  <Option value="Eindohoven">Eindohoven</Option>
                  <Option value="Tilburg">Tilburg</Option>
                  <Option value="Utrecht">Utrecht</Option>
                  <Option value="Delft">Delft</Option>
                  <Option value="Haarlem">Haarlem</Option>
                  <Option value="Breda">Breda</Option>
                </Select>
              </Form.Item>
            </Col>
          </Row>
          <Row gutter={16}>
            <Col span={12}>
            <Form.Item name="website"label="Offcial Website">
                <Input style={{ width: "100%" }} addonBefore="http://" placeholder="Please enter url"/>
              </Form.Item>
            </Col>
            <Col span={12}>
              <Form.Item
                name="store_name"
                label="Store Name"
                rules={[{ required: true, message: "Please Enter Store Name" }]}
              >
                <Input style={{ width: "100%" }}  placeholder="Please enter store name"/>
              </Form.Item>
            </Col>
          </Row>
          <Row gutter={16}>
            <Col span={12}>
              <Form.Item
                name="address"
                label="Address"
                rules={[
                  { required: true, message: "Please Enter the Address " },
                ]}
              >
                 <Input style={{ width: "100%" }}  placeholder="Please enter the address"/>
              </Form.Item>
            </Col>
            <Col span={12}>
            <Form.Item
                name="img"
                label="Store Img Source"
                rules={[
                  { required: true, message: "Please Enter The Img Source " },
                ]}
              >
                  <Input style={{ width: "100%" }} addonBefore="http://" placeholder="Please enter img source url"/>
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
                    message: "please enter the description about the store",
                  },
                ]}
              >
                <Input.TextArea
                  rows={4}
                  placeholder="please enter the description about the store"
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

const VendorList = styled.div`
  height: 400px;
  padding-top: 10px;
  display: flex;
  flex-direction: column;
  flex-wrap: wrap-reverse;
  justify-content: flex-start;
  align-items: center;
  align-content: stretch;
  background-color: #f0f0f0;
  > div {
    margin: 10px;
    margin-top: 0px;
  }
`;
export default AdminAddNewStoreForm;
