import { combineReducers } from 'redux';
import productsReducer from './productsReducer';
import userReducer from './userReducer';
import storesReducer from'./storesReducer';
import vendorsReducer from'./vendorsReducer';
import messageReducer from'./messageReducer';
const rootReducer=combineReducers({
    user:userReducer,
    products:productsReducer,
    stores:storesReducer,
    vendors:vendorsReducer,
    message:messageReducer
});

export default rootReducer;