import axios from "axios";
import {
  all_vendorsURL,
  add_new_store_Api,
  register_new_vendor_Api,
  delete_store_Api,
  update_store_Api,
} from "../api";

export const getVendorList = (Jwt) => async (dispatch) => {
  const requestHeader = { Authorization: `Bearer ${Jwt}` };
  try {
    const vendorlist = await axios.get(all_vendorsURL, {
      headers: requestHeader,
    });
    dispatch({
      type: "FETCH_VENDORS",
      payload: {
        vendors: vendorlist,
      },
    });
  } catch (err) {
    return (window.location.href = "/forbidden");
  }
};
export const addnewStore = (data, Jwt) => async (dispatch) => {
  const requestHeader = { Authorization: `Bearer ${Jwt}` };
  await axios.post(
    add_new_store_Api,
    {
      vendor_id: data.vendor_id,
      store_name: data.store_name,
      description: data.description,
      city: data.city.toUpperCase(),
      address: data.address,
      img: data.img,
      official_website: data.website,
    },
    { headers: requestHeader }
  );
  dispatch({ type: "ADD_NEW_STORE" });
};

export const registernewVendor = (data,Jwt) => async (dispatch) => {
  const requestHeader = { Authorization: `Bearer ${Jwt}` };
  console.log(requestHeader);
  await axios.post(register_new_vendor_Api, {
    email: data.email,
    password: data.password,
    first_name: data.first_name,
    last_name: data.last_name,
    avatar_link: data.avatar_link,
    phone: data.phone,
  },
  { headers: requestHeader }
  );
  dispatch({ type: "REGISTER_NEW_VENDOR" });
};

export const deleteStorebyid = (store_id,Jwt) => async (dispatch) => {
  const requestHeader = { Authorization: `Bearer ${Jwt}`};
  await axios.delete(delete_store_Api(store_id),{headers:requestHeader,data:null});
  dispatch({ type: "DELETE_STORE" });
};
export const editStoreInfomation = (data,Jwt) => async (dispatch) => {
  const requestHeader = { Authorization: `Bearer ${Jwt}` };
  await axios.put(update_store_Api, data,{ headers: requestHeader });
  dispatch({ type: "UPDATE_STORE" });
};
