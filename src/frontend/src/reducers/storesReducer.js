const initState={
    store:[],
}
const storesReducer=(state=initState,action)=>{
    switch(action.type){
        case "FETCH_STORES":
            return {...state,store:action.payload.store.data};
        default:
            return {...state};
    }
}

export default storesReducer;