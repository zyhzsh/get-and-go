const initState = {
  user: null,
  login:null,
  accounttype:null,
  userprofile:null
};

const userReducer = (state = initState, action) => {
  switch (action.type) {
    case "LOG_IN":
      return { ...state, user: action.payload.user ,login:action.payload.login};
    case "LOG_OUT":
      return { ...state, user: null };
    default:
      return { ...state };
  }
};
export default userReducer;