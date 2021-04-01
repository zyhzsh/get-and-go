import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getStoreList } from "../../actions/storeAction";
import { getVendorList } from "../../actions/adminAction";
//Ant Ui
import { Table, Space, Button } from "antd";
import { PlusOutlined } from "@ant-design/icons";
//UI Component
import AdminAddNewStoreForm from "./AdminAddNewStoreForm";


const AdminStoreManagement = () => {
  const [visible_add_new_store_form, set_visible_add_new_store_form] = useState(
    false
  );
  const dispatch = useDispatch();
  const storeslist = useSelector((state) => state.stores.stores);
  const vendorslist = useSelector((state) => state.vendors.vendors);
  const [vendors,Setvendors]=useState(vendorslist);
  const [mount, setMount] = useState(false);
  useEffect(() => {
    const loadstorelist = () => {
      if (!mount) {
        setMount(true);
        dispatch(getStoreList());
        dispatch(getVendorList());
        Setvendors(vendorslist)
      }
    };
    loadstorelist();
  }, [dispatch, storeslist,vendorslist ,mount]);

  const columns = [
    {
      title: "Store ID",
      dataIndex: "store_id",
      key: "store_id",
    },
    {
      title: "Store Name",
      dataIndex: "store_name",
      key: "store_name",
    },
    {
      title: "Vendor ID",
      dataIndex: "vendor_id",
      key: "vendor_id",
    },
    {
      title: "City",
      dataIndex: "city",
      key: "city",
    },
    {
      title: "Address",
      dataIndex: "address",
      key: "address",
    },
    {
      title: "Offical Website",
      dataIndex: "official_website",
      key: "official_website",
    },
    {
      title: "Action",
      key: "action",
      render: (text, record) => (
        <Space size="middle">
          {/* <a>Invite {record.name}</a>
              <a>Delete</a> */}
        </Space>
      ),
    },
  ];
  return (
    <div>
      <h2>Store</h2>
      <Table
        title={() => (
          <>
          <Button
            type="primary"
            shape="round"
            icon={<PlusOutlined />}
            size="middle"
            onClick={() => {
              set_visible_add_new_store_form(true);

            }}
         >
            Add New Store
          </Button>
          <span> </span>
          <Button
            type="primary"
            shape="round"
            icon={<PlusOutlined />}
            size="middle"
            onClick={() => {
              set_visible_add_new_store_form(true);
            }}
          >
            Register A New Vendor 
          </Button>
          </>
        )}
        columns={columns}
        dataSource={storeslist}
        rowKey="store_id"
      />
      <AdminAddNewStoreForm
        visiable={visible_add_new_store_form}
        setvisiable={set_visible_add_new_store_form}
        vendors={vendors}
      />
    </div>
  );
};

export default AdminStoreManagement;
