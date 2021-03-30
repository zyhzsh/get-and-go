package nl.getandgo.application.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

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

    public Set<SimpleGrantedAuthority>getGrantedAuthorities() {
       Set<SimpleGrantedAuthority> permissions=getPermissions()
                .stream()
                .map(permission->new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
       permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return permissions;
    }


}
