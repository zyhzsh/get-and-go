import { Redirect } from "react-router";

const initState={
    systemBack:[],
}

const messageReducer=(state=initState,action)=>{
    switch(action.type){
        case "SIGN_UP_CUSTOMER":
            return {...state,systemBack:action.payload};
        case "RESET_SIGN_UP_MESSAGE":
            return {...state,systemBack:[]};
        case "REQUEST_FORBIDDEN":
            return <Redirect to="/forbidden" />
        default:
            return {...state};
    }
}

export default messageReducer;