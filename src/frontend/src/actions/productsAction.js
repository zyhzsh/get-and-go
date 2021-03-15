import axios from 'axios';
import {all_productsURL} from '../api';

export const loadProducts=()=>async(dispatch)=>{
    //FETCH AXIOS
    const productsData=await axios.get(all_productsURL);
    dispatch({
        type:"FETCH_PRODUCTS",
        payload:{
            products:productsData,
        }
    })
}