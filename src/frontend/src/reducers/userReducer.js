const initState = {
  jwt: null,
  usertype:null,
  result:null
};

const userReducer = (state = initState, action) => {
  switch (action.type) {
    case "LOG_IN":
      return { 
        ...state, 
        jwt: action.payload.jwt,
        usertype:action.payload.usertype,
        result:action.payload.result,
        user:action.payload.user
      };
    case "LOG_OUT":
      return { ...state, 
        jwt:null,
        usertype:null,
        result: null
      };
    case "RESET_LOG_IN_MESSAGE":
      return {...state,result:null}
    default:
      return { ...state };
  }
};
export default userReducer;