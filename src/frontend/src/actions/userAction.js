import axios from "axios";
import { loginURL } from "../api";

export const userLogin=(user) => async (dispatch) => {

  const data=await axios.post(loginURL,{
    username:user.username,
    email:user.email,
    password:user.password
  });
  dispatch({
    type: "LOG_IN",
    payload: {
      user: data.data,
      login:true,
    },
  });
};
