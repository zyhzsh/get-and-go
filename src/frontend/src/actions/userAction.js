import axios from "axios";
import { loginURL ,register_new_customer_Api} from "../api";

export const userLogin=(email,password) => async (dispatch) => {
  const data=await axios.post(loginURL,{
    "email":email,
    "password":password
  });
  console.log(data.data);
  dispatch({
    type: "LOG_IN",
    payload: {
      user: data.data
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
