import axios from "axios";
import { all_storesURL } from "../api";
export const getStoreList = () => async (dispatch) => {
  const storelist = await axios.get(all_storesURL);
  dispatch({
    type: "FETCH_STORES",
    payload: {
      store: storelist,
    },
  });
};
