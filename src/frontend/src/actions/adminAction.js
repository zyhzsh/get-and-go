import axios from "axios";
import { all_vendorsURL ,add_new_store_Api} from "../api";
export const getVendorList = () => async (dispatch) => {
  const vendorlist = await axios.get(all_vendorsURL)
  dispatch({
    type: "FETCH_VENDORS",
    payload: {
      vendors: vendorlist,
    },
  });
};
export const addnewStore = (data) => async (dispatch) => {
  console.log(data);
  await axios.post(add_new_store_Api,{
    "vendor_id":data.vendor_id,
    "store_name":data.store_name,
    "description":data.description,
    "city":data.city.toUpperCase(),
    "address":data.address,
    "img":data.img,
    "official_website":data.website
  })
  dispatch({type: "ADD_NEW_STORE"},{type:"FETCH_STORES"});
};