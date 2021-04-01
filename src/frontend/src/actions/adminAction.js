import axios from "axios";
import { all_vendorsURL } from "../api";
export const getVendorList = () => async (dispatch) => {
  const vendorlist = await axios.get(all_vendorsURL)
  dispatch({
    type: "FETCH_VENDORS",
    payload: {
      vendors: vendorlist,
    },
  });
};
