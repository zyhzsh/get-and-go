import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getStoreList } from "../../actions/storeAction";
import { getVendorList } from "../../actions/adminAction";
//Ant Ui
import { Table, Space, Button,Input } from "antd";
import { PlusOutlined } from "@ant-design/icons";
//UI Component
import AdminAddNewStoreForm from "./AdminAddNewStoreForm";

const AdminStoreManagement = () => {
  const [visible_add_new_store_form, set_visible_add_new_store_form] = useState(false);
  const dispatch = useDispatch();
  const storeslist = useSelector((state) => state.stores.stores);
  const vendorslist = useSelector((state) => state.vendors.vendors);
  const [mount, setMount] = useState(false);
  const [value, setValue] = useState("");
  const [datasourcestoreslist,setdatasourcestoreslist]=useState(null);
  const FilterByInput = (placeholder) => (
    <Input
      placeholder={placeholder}
      value={value}
      onChange={(e) => {
        const currValue = e.target.value;
        setValue(currValue);
        const filteredData = storeslist.filter((entry) =>
          entry.store_id.toString().includes(currValue)
        );
        setdatasourcestoreslist(filteredData);
      }}
    />
  );
  useEffect(() => {
    const loadstorelist = () => {
      if (!mount) {
        setMount(true);
        dispatch(getStoreList());
        dispatch(getVendorList());
      }
    };
    loadstorelist();
  }, [dispatch, storeslist, vendorslist, mount]);
  if(datasourcestoreslist==null){
    setTimeout(() => {
      setdatasourcestoreslist(storeslist);
    }, 100);
  }
  const columns = [
    {
      title: FilterByInput("Store ID"),
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
      dataIndex: ["vendor", "user_id"],
      key: ["vendor", "user_id"],
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
          <button>Edit</button>
          <button>Delete</button>
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
        dataSource={datasourcestoreslist}
        rowKey="store_id"
      />
      {visible_add_new_store_form&&(
        <AdminAddNewStoreForm
          visiable={visible_add_new_store_form}
          setvisiable={set_visible_add_new_store_form}
          vendors={vendorslist}
        />
      )}
    </div>
  );
};

export default AdminStoreManagement;
