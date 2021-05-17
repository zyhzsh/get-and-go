import axios from "axios";
import { all_storesURL } from "../api";
export const getStoreList = (Jwt) => async (dispatch) => {
  const requestHeader={Authorization: `Bearer ${Jwt}`};
 try {const storelist = await axios.get(all_storesURL,{headers:requestHeader});
 dispatch({
  type: "FETCH_STORES",
  payload: {
    store: storelist,
  },
});
}catch(err){
  return (window.location.href = "/forbidden");
}
 
};
