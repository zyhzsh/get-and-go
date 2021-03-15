import React, { useEffect } from "react";
import { useDispatch } from "react-redux";
import { loadProducts } from "../actions/productsAction";

const Home = () => {
  const dispatch = useDispatch();
  useEffect(() => {
    dispatch(loadProducts());
  });
  return(
      <div>
          <h1>Home</h1>
      </div>
  );
};
export default Home;
