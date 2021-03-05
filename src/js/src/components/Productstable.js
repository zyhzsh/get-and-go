import { Table,Spin } from "antd";
import styled from "styled-components";

const Productstable = ({ products }) => {
  const columns = [
    {
      title: "Product ID",
      dataIndex: "id",
      key: "id",
    },
    {
      title: "Product Name",
      dataIndex: "name",
      key: "name",
    },
    {
      title: "Vendor",
      dataIndex: "vendor",
      key: "vendor",
    },
    {
      title: "Price",
      dataIndex: "price",
      key: "price",
    },
    {
      title: "Ending Date",
      dataIndex: "endOfDay",
      key: "endOfDay",
    },
  ];
  return (
    <TableContainer>
      <Table
        columns={columns}
        dataSource={products}
        pagination={false}
        rowKey="id"
      />
    </TableContainer>
  );
};

const TableContainer = styled.div`
  width: 1400px;
  margin: 0 auto;
`;

export default Productstable;
