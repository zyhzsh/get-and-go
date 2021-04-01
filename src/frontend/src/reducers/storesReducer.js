const initState={
    stores:[],
}
const storesReducer=(state=initState,action)=>{
    switch(action.type){
        case "FETCH_STORES":
            return {...state,stores:action.payload.store.data};
        default:
            return {...state};
    }
}

export default storesReducer;