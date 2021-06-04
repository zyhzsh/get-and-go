import styled from "styled-components";
import VendorNav from "../components/HomePageNavBar/VendorNav";
import Footer from "../components/Footer";
import { Line } from '@ant-design/charts';
import { useState,useEffect } from "react";
const Vendor = () => {
  const [data, setData] = useState([]);
  useEffect(() => {
    asyncFetch();
  }, []);
  const asyncFetch = () => {
    fetch('https://gw.alipayobjects.com/os/bmw-prod/e00d52f4-2fa6-47ee-a0d7-105dd95bde20.json')
      .then((response) => response.json())
      .then((json) => setData(json))
      .catch((error) => {
        console.log('fetch data failed', error);
      });
      console.log(data);
  };
  var config = {
    data: data,
    xField: 'year',
    yField: 'gdp',
    seriesField: 'name',
    yAxis: {
      label: {
        formatter: function formatter(v) {
          return ''.concat((v / 1000).toFixed(1), ' Euro');
        },
      },
    },
    legend: { position: 'top' },
    smooth: true,
    animation: {
      appear: {
        animation: 'path-in',
        duration: 5000,
      },
    },
  };

  return (
    <Container>
      <VendorNav />
      <Content>
        <h1>sdsd</h1>
      <Line {...config} />
      </Content>
      <Footer />
    </Container>
  );
};
const Container =styled.div`
 display: flex;
	flex-direction: column;
	flex-wrap: wrap;
	justify-content: center;
	align-items: stretch;
	align-content: stretch;
`;
const Content =styled.div`

`;
export default Vendor;
