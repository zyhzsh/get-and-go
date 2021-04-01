const initState = {
    vendors:[]
};
  
  const vendorsReducer = (state = initState, action) => {
    switch (action.type) {
      case "FETCH_VENDORS":
        return { ...state, vendors: action.payload.vendors.data};
      default:
        return { ...state };
    }
  };
  export default vendorsReducer;