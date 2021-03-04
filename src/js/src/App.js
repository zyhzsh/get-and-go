import "./App.css";
import { getAllProducts } from "./client";
import { useState, useEffect } from "react";
import { Table} from "antd";
import Productstable from "./components/Productstable";
function App() {
  //State...
  const [products, SetProducts] = useState(null);

  useEffect(() => {
    getAllProducts().then((data) => {
      SetProducts(data.data);
    });
  }, []);
  if (products && products.length) {
    return (
      <Productstable products={products}/>
    );
  }
  return <div className="App"></div>;
}

export default App;
