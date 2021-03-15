import { combineReducers } from 'redux';
import productsReducer from './productsReducers';
import {userReducer} from './userReducer';

const rootReducer=combineReducers({
    user:userReducer,
    products:productsReducer,
});

export default rootReducer;