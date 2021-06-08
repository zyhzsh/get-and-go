import styled from "styled-components";
import VendorNav from "../components/HomePageNavBar/VendorNav";
import Footer from "../components/Footer";
import { Line } from "@ant-design/charts";
import { useState, useEffect } from "react";
import { useSelector } from "react-redux";
import { notification } from "antd";
const Vendor = () => {
  const [data, setData] = useState([]);

  const openNotificationWithIcon = (type) => {
    notification[type]({
      message: "News",
      description: "Your Just Recevied An New Order",
    });
  };

  const Jwt = useSelector((state) => state.user.jwt);
  const user = useSelector((state)=>state.user);
 
  //const [logout, SetLogOut] = useState(false);
  let websocket = null;
  useEffect(() => {
    const asyncFetch = () => {
        let Email="";  
        try{
          Email=user.user.email;
          if ("WebSocket" in window) {
            websocket = new WebSocket(
              "ws://localhost:8080/vendor/" + Email + "/" + Jwt
            );
          } else {
            alert("Your Browser Not Support Websocket~!");
          }
          websocket.onopen = function (event) {
            console.log("connect");
          };
          websocket.onclose = function (event) {
            console.log("close");
          };
          websocket.onmessage = function (event) {
            console.log("recevied:" + event.data);
            if(event.data!=="[]"){
              openNotificationWithIcon("success"); 
            }
            const obj = JSON.parse(event.data);
            setData(obj);
          };
          websocket.onerror = function () {
            alert("Websocket error");
          };
          window.onbeforeunload = function () {
            websocket.close();
          };
        }catch(e){}
      }
    asyncFetch();
  }, []);

  var config = {
    data: data,
    xField: "month",
    yField: "quantity",
    seriesField: "store_name",
    yAxis: {
      label: {
        formatter: function formatter(v) {
          return "".concat(v / 1, "");
        },
      },
    },
    legend: { position: "top" },
    smooth: true,
    animation: {
      appear: {
        animation: "path-in",
        duration: 1000,
      },
    },
  };

  return (
    <>
      <Container>
        <VendorNav />
        <Content>
          <br />
          <br />
          <br />
          <br />
          <br />
          <h1>Order Quantity Statistics By Your Store(s)</h1>
          <Line {...config} />
        </Content>
      </Container>
      <Footer />
    </>
  );
};
const Container = styled.div`
  height: 93.45vh;
  flex-direction: column;
  flex-wrap: wrap;
  justify-content: center;
  align-items: stretch;
  align-content: stretch;
`;
const Content = styled.div`
  margin: auto;
  align-items: center;
  align-content: center;
  h1 {
    text-align: center;
  }
  width: 80%;
`;
export default Vendor;
