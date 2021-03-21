import axios from "axios";
import {
  all_productsURL,
  all_products_By_Category,
  all_products_By_City,
  all_products_by_Category_City,
} from "../api";

export const loadAllProducts = () => async (dispatch) => {
  //FETCH AXIOS
  const productsData =await axios.get(all_productsURL);
  dispatch({
    type: "FETCH_PRODUCTS",
    payload: {
      products: productsData,
    },
  });
};
export const loadAllProductsByCategory = (category) => async (dispatch) => {
  //FETCH AXIOS
  const productsData = await axios.get(all_products_By_Category(category));
  dispatch({
    type: "FETCH_PRODUCTS",
    payload: {
      products: productsData,
    },
  });
};
export const loadAllProdductsByCity = (city) => async (dispatch) => {
  //FETCH AXIOS
  const productsData = await axios.get(all_products_By_City(city));
  dispatch({
    type: "FETCH_PRODUCTS",
    payload: {
      products: productsData,
    },
  });
};
export const loadAllProdductsByCityAndCategory = (city,category) => async (dispatch) => {
  //FETCH AXIOS
  const productsData = await axios.get(all_products_by_Category_City(city,category));
  dispatch({
    type: "FETCH_PRODUCTS",
    payload: {
      products: productsData,
    },
  });
};
