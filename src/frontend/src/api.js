
//Products
export const all_productsURL='/api/products';
export const all_products_By_Category=(category)=>`${all_productsURL}?category=${category.toLowerCase()}`;
export const all_products_By_City=(city)=>`${all_productsURL}?city=${city.toLowerCase()}`;
export const all_products_by_Category_City=(city,category)=>`${all_productsURL}?category=${category.toLowerCase()}&city=${city.toLowerCase()}`;

//Login
export const loginURL='api/login';
/***
 * Sign Up
 * - Vendor User
 * - Customer User
 * */ 
export const register_new_vendor_Api="api/vendor/signup";
export const register_new_customer_Api="api/customer/signup"

//Store
export const all_storesURL='api/stores';
export const add_new_store_Api='api/stores';
export const update_store_Api='api/stores';
export const delete_store_Api=(store_id)=>`api/stores?id=${store_id}`;

//Vendor
export const all_vendorsURL="api/vendors";
export const update_vendor_information_Api="api/vendor/edit";

//Order 
export const order_voucher_Api="api/orders";