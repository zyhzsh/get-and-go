import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getStoreList } from "../../actions/storeAction";
import { getVendorList, deleteStorebyid } from "../../actions/adminAction";
//Ant Ui
import { Table, Space, Button, Input, Modal, notification } from "antd";
import { PlusOutlined, SyncOutlined ,ShopOutlined,UserAddOutlined} from "@ant-design/icons";
//UI Component
import AdminAddNewStoreForm from "./AdminAddNewStoreForm";
import AdminRegisterNewVendorForm from "./AdminRegisterNewVendorForm";
import AdminEditStoreForm from "./AdminEditStoreForm";

const AdminStoreManagement = () => {
  const [visible_add_new_store_form, set_visible_add_new_store_form] = useState(false);
  const [
    visible_register_new_vendor_form,
    set_visible_register_new_vendor_form,
  ] = useState(false);
  const [visible_edit_store_form, set_visible_edit_store_form] = useState(
    false
  );

  const dispatch = useDispatch();
  const storeslist = useSelector((state) => state.stores.stores);
  const vendorslist = useSelector((state) => state.vendors.vendors);
  const Jwt = useSelector((state) => state.user.jwt);
  const [mount, setMount] = useState(false);
  const [value, setValue] = useState("");

  const [datasourcestoreslist, setdatasourcestoreslist] = useState(null);
  const [deletestoremodal, setdeletestoremodal] = useState(false);
  const [confirmdeletedloading, setConfirmdeleted] = useState(false);
  const [deletedstore, setdeletedstore] = useState(null);
  const [editstore, seteditstore] = useState(null);
  const editstorehandler = (e) => {
    seteditstore(e);
    set_visible_edit_store_form(true);
  };
  const openNotificationWithIcon = (type) => {
    notification[type]({
      message: "Your request has been send",
    });
  };
  const showDeletedModal = (e) => {
    setdeletestoremodal(true);
    setdeletedstore(e);
  };
  const handleDeleted = () => {
    setConfirmdeleted(true);
    setTimeout(() => {
      dispatch(deleteStorebyid(deletedstore.store_id,Jwt));
      setdeletestoremodal(false);
      setConfirmdeleted(false);
      openNotificationWithIcon("success");
    }, 1000);
  };

  const handleCancel = () => {
    setdeletestoremodal(false);
  };

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
        dispatch(getStoreList(Jwt));
        dispatch(getVendorList(Jwt));
      }
    };
    loadstorelist();
  }, [dispatch, storeslist, vendorslist, mount,Jwt]);
  if (datasourcestoreslist == null) {
    setTimeout(() => {
      setdatasourcestoreslist(storeslist);
    }, 200);
  }
  const columns = [
    {
      title: FilterByInput("Store ID"),
      dataIndex: "store_id",
      key: "store_id",
      sorter: {
        compare: (a, b) => a.store_id - b.store_id,
        multiple: 1,
      },
      width: "10%",
    },
    {
      title: "Store Name",
      dataIndex: "store_name",
      key: "store_name",
      width: "15%",
    },
    {
      title: "Vendor ID",
      dataIndex: ["vendor", "user_id"],
      key: ["vendor", "user_id"],
      width: "10%",
    },
    {
      title: "City",
      dataIndex: "city",
      key: "city",
      width: "10%",
    },
    {
      title: "Address",
      dataIndex: "address",
      key: "address",
      width: "20%",
    },
    {
      title: "Offical Website",
      render: (x) => (
        <span
          onClick={(e) => {
            console.log(e.target.innerText);
            window.open("https://" + e.target.innerText, "_blank");
          }}
        >
          {x.official_website}
        </span>
      ),
      key: "official_website",
      width: "20%",
    },
    {
      title: "Action",
      key: "action",
      render: (e) => (
        <Space size="middle">
          <Button
            onClick={() => {
              editstorehandler(e);
            }}
          >
            Edit
          </Button>
          <Button
            onClick={() => {
              showDeletedModal(e);
            }}
          >
            Delete
          </Button>
        </Space>
      ),
      width: "15%",
    },
  ];
  return (
    <div>
      <h2>Store</h2>
      {mount && (
  <Table
          title={() => (
            <>
              <Button
                onClick={() => {
                  setdatasourcestoreslist(null);
                  setMount(false);
                }}
                type="primary"
                shape="round"
              >
                <SyncOutlined />
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
              <ShopOutlined />  Add New Store
              </Button>
              <span> </span>
              <Button
                type="primary"
                shape="round"
                icon={<PlusOutlined />}
                size="middle"
                onClick={() => {
                  set_visible_register_new_vendor_form(true);
                }}
              >
              <UserAddOutlined />  Register A New Vendor
              </Button>
            </>
          )}
          columns={columns}
          dataSource={datasourcestoreslist}
          rowKey="store_id"
          pagination={{ pageSize: 4 } }
          showHeader={true}
        />
      )}
      {datasourcestoreslist && (
        <AdminAddNewStoreForm
          visiable={visible_add_new_store_form}
          setvisiable={set_visible_add_new_store_form}
          vendors={vendorslist}
        />
      )}
      {datasourcestoreslist && (
        <AdminRegisterNewVendorForm
          visiable={visible_register_new_vendor_form}
          setvisiable={set_visible_register_new_vendor_form}
          vendors={vendorslist}
        />
      )}
      {editstore && (
        <AdminEditStoreForm
          visiable={visible_edit_store_form}
          setvisiable={set_visible_edit_store_form}
          store={editstore}
        />
      )}

      {deletedstore && (
        <Modal
          title="Delete confirmation"
          visible={deletestoremodal}
          onOk={handleDeleted}
          confirmLoading={confirmdeletedloading}
          onCancel={handleCancel}
        >
          <p>Are Your Sure to Delete Store: </p>
          <p>{`${deletedstore.store_name}`}</p>
          <p>{`Store ID: ${deletedstore.store_id}`}</p>
          <p>{`City: ${deletedstore.city}`}</p>
          <p>{`Address: ${deletedstore.address}`}</p>
        </Modal>
      )}
    </div>
  );
};

export default AdminStoreManagement;
