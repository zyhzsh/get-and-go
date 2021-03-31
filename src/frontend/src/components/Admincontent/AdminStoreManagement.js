import React, { useEffect, useCallback } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getStoreList } from "../../actions/storeAction";
import { Table, Space } from 'antd';

const AdminStoreManagement = () => {
    const dispatch = useDispatch();
    const storeslist = useSelector(state => state.store.store);
    const loadstorelist=useCallback(()=>{
        dispatch(getStoreList()); 
        console.log(storeslist);
    },[dispatch,storeslist]);
    useEffect(()=>{
        loadstorelist();
    },[loadstorelist])

    const columns = [
        {
          title: 'Store ID',
          dataIndex: 'store_id',
          key: 'store_id',
        },
        {
          title: 'Store Name',
          dataIndex: 'store_name',
          key: 'store_name',
        },
        {
          title: 'Owner ID',
          dataIndex: 'owner_id',
          key: 'owner_id',
        },
        {
          title: 'City',
          dataIndex: 'city',
          key: 'city',
        },
        {
          title: 'Address',
          dataIndex: 'address',
          key: 'address',
        },
        {
          title: 'Offical Website',
          dataIndex: 'official_website',
          key: 'official_website',
        },
        {
          title: 'Action',
          key: 'action',
          render: (text, record) => (
            <Space size="middle">
              <a>Invite {record.name}</a>
              <a>Delete</a>
            </Space>
          ),
        },
      ];
  return (
    <div>
        <h2>Store</h2>
        <Table columns={columns} dataSource={storeslist} />
    </div>
  );
};




export default AdminStoreManagement;
