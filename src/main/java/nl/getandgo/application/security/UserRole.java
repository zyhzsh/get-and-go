package nl.getandgo.application.security;

import com.google.common.collect.Sets;
import java.util.Set;

import static nl.getandgo.application.security.UserPermission.*;

public enum UserRole {
    Vendor(Sets.newHashSet()),
    Manager(Sets.newHashSet(CUSTOMER_READ,CUSTOMER_WRITE,PRODUCT_READ,PRODUCT_WRITE)),
    Customer(Sets.newHashSet(CUSTOMER_READ,CUSTOMER_WRITE,PRODUCT_READ));

    private final Set<UserPermission> permissions;
    UserRole(Set<UserPermission> permissions){
        this.permissions=permissions;
    }

    public Set<UserPermission> getPermissions(){
        return permissions;
    }
}
