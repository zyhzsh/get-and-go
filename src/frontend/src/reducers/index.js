import { combineReducers } from 'redux';
import productsReducer from './productsReducers';
import userReducer from './userReducer';
import storesReducer from'./storesReducer';
import vendorsReducer from'./vendorsReducer';
const rootReducer=combineReducers({
    user:userReducer,
    products:productsReducer,
    stores:storesReducer,
    vendors:vendorsReducer
});

export default rootReducer;