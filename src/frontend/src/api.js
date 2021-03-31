
//Products
export const all_productsURL='api/products';
export const all_products_By_Category=(category)=>`${all_productsURL}?category=${category.toLowerCase()}`;
export const all_products_By_City=(city)=>`${all_productsURL}?city=${city.toLowerCase()}`;
export const all_products_by_Category_City=(city,category)=>`${all_productsURL}?category=${category.toLowerCase()}&city=${city.toLowerCase()}`;

//User
export const loginURL='api/login';


//Store
export const all_storesURL='api/stores';