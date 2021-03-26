package nl.getandgo.application.security;

public enum UserPermission {
    CUSTOMER_READ("customer:read"),
    CUSTOMER_WRITE("customer:write"),
    PRODUCT_READ("product:read"),
    PRODUCT_WRITE("product:write");

    private final String permission;
    UserPermission(String permission){
        this.permission=permission;
    }
    public String getPermission(){
        return permission;
    }
}
