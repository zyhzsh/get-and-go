
//Products
export const all_productsURL='api/products';
export const all_products_By_Category=(category)=>`${all_productsURL}?category=${category.toLowerCase()}`;
export const all_products_By_City=(city)=>`${all_productsURL}?city=${city.toLowerCase()}`;
export const all_products_by_Category_City=(city,category)=>`${all_productsURL}?category=${category.toLowerCase()}&city=${city.toLowerCase()}`;

//Login
export const loginURL='api/login';


//Store
export const all_storesURL='api/stores';
export const add_new_store_Api='api/stores';
//Vendor
export const all_vendorsURL="api/vendors";
export const register_new_vendor_Api="api/vendor/signup";