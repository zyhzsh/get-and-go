import { combineReducers } from 'redux';
import productsReducer from './productsReducers';
import userReducer from './userReducer';
import storesReducer from'./storesReducer';

const rootReducer=combineReducers({
    user:userReducer,
    products:productsReducer,
    store:storesReducer,
});

export default rootReducer;