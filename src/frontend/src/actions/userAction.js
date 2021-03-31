import axios from "axios";
import { loginURL } from "../api";

export const userLogin=(email,password) => async (dispatch) => {
  console.log(email);
  const data=await axios.post(loginURL,{
    "email":email,
    "password":password
  });
  dispatch({
    type: "LOG_IN",
    payload: {
      user: data.data
    },
  });
};
