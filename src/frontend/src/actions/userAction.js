import axios from "axios";
import { loginURL ,register_new_customer_Api,order_voucher_Api} from "../api";

export const userLogin=(email,password) => async (dispatch) => {
  const data=await axios.post(loginURL,{
    "email":email,
    "password":password
  });
  dispatch({
    type: "LOG_IN",
    payload: {
      jwt: data.data.jwt,
      user: data.data.user,
      usertype:data.data.user_type,
      result:data.data.result,
    },
  });
};

export const signUpCustomer=(signupData) => async (dispatch) => {
  dispatch({
    type: "RESET_SIGN_UP_MESSAGE",
    payload: {
      signupResult: [],
    },
  });
  const data=await axios.post(register_new_customer_Api,{
    "email":signupData.email,
    "password":signupData.password,
    "first_name":signupData.first_name,
    "last_name":signupData.last_name
  });
  dispatch({
    type: "SIGN_UP_CUSTOMER",
    payload: {
      signupResult: data.data
    },
  });
};

export const orderVoucher=(Jwt,data)=> async(dispatch)=>{
  const requestHeader = { Authorization: `Bearer ${Jwt}` };
  await axios.post(
    order_voucher_Api,
    {
      customer_id:data.customer_id,
      voucher_id:data.voucher_id,
      email:data.email
    },
    { headers: requestHeader }
  );
  dispatch({ type: "ORDER_VOUCHER" });
}
