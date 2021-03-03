import logo from './logo.svg';
import './App.css';
import{getAllProducts} from "./client";
import { useState, useEffect } from "react";
function App() {
  //State...
  const [products,SetProducts]=useState(null);
  //
  useEffect(()=>{
    getAllProducts().then(data=>{
      SetProducts(data.data);
    })
  },[])

if(products&&products.length){
  return products.map((product,index)=>{
    return (
      <div key={index}>
          <h2>{product.name}</h2>
          <p>{product.vendor}</p>
          <p>{product.price}</p>
          <p>{product.sub_description}</p>
          <p>{product.location}</p>
      </div>
    )
  })
}

  return (
    <div className="App">

    </div>
  );
}

export default App;
