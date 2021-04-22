import axios from "axios";
import { all_vendorsURL ,
  add_new_store_Api,
  register_new_vendor_Api,
  delete_store_Api,
  update_store_Api
} from "../api";
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
  await axios.post(add_new_store_Api,{
    "vendor_id":data.vendor_id,
    "store_name":data.store_name,
    "description":data.description,
    "city":data.city.toUpperCase(),
    "address":data.address,
    "img":data.img,
    "official_website":data.website
  })
  dispatch({type: "ADD_NEW_STORE"});
};

export const registernewVendor=(data)=>async(dispatch)=>{
  await axios.post(register_new_vendor_Api,{
    "email":data.email,
    "password":data.password,
    "first_name":data.first_name,
    "last_name":data.last_name,
    "avatar_link":data.avatar_link,
    "phone":data.phone
  })
  dispatch({type:"REGISTER_NEW_VENDOR"});
}
export const deleteStorebyid=(store_id)=>async(dispatch)=>{
  await axios.delete(delete_store_Api(store_id))
  dispatch({type:"DELETE_STORE"});
}
export const editStoreInfomation=(data)=>async(dispatch)=>{
  await axios.put(update_store_Api,data)
  dispatch({type:"UPDATE_STORE"});
}