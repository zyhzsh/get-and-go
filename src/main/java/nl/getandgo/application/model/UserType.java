package nl.getandgo.application.model;

import lombok.Getter;
import org.springframework.context.annotation.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * User Type:
 * - Customer User,
 * - Manager User;
 * - Vendor User;
 */
public enum UserType {
    CUSTOMERUSER,
    MANAGERUSER,
    VENDORUSER;

    // Anonymous User Authorities:
    @Getter public static final String BROWSER_ON_SALE_PRODUCT = "BROWSER_ON_SALE_PRODUCT";
    @Getter public static final String REGISTER_NEW_CUSTOMER_ACCOUNT = "REGISTER_NEW_CUSTOMER_ACCOUNT";
    @Getter public static final String BROWSER_USERS_REVIEWS = "BROWSER_USERS_REVIEWS";
    @Getter public static final String BROWSER_USERS_COMMENTS = "BROWSER_USERS_COMMENTS";
    @Getter public static final String BROWSER_VOUCHERS = "BROWSER_VOUCHERS";
    @Getter public static final String BROWSER_STORES_INFORMATION = "BROWSER_STORES_INFORMATION";
    @Getter public static final String LOG_IN = "LOG_IN";

    // Customer User Authorities:
    @Getter public static final String BROWSER_USER_INFORMATION = "BROWSER_USER_INFORMATION";
    @Getter public static final String PLACE_ORDER = "PLACE_ORDER";
    @Getter public static final String UPDATE_PERSONAL_PROFILE = "UPDATE_PERSONAL_PROFILE";
    @Getter public static final String BROWSER_PERSONAL_ORDERS = "BROWSER_USER_ORDER";
    @Getter public static final String ADD_REVIEW="ADD_REVIEW";
    @Getter public static final String REMOVE_REVIEW="REMOVE_REVIEW";
    @Getter public static final String UPDATE_REVIEW="UPDATE_REVIEW";
    @Getter public static final String ADD_COMMENT="ADD_COMMENT";
    @Getter public static final String UPDATE_COMMENT="UPDATE_COMMENT";
    @Getter public static final String REMOVE_COMMENT="REMOVE_COMMENT";

    // ProductManager User Authorities:
    @Getter public static final String ADD_NEW_STORE = "ADD_NEW_STORE";
    @Getter public static final String ADD_NEW_VENDOR = "ADD_NEW_VENDOR";
    @Getter public static final String UPDATE_STORE_INFORMATION = "UPDATE_STORE_INFORMATION";
    @Getter public static final String BROWSER_VENDORS_INFORMATION = "BROWSER_VENDORS";

    /**
     * Anonymous User Authority:
     * - BROWSER_ON_SALE_PRODUCT
     * - REGISTER_NEW_CUSTOMER_ACCOUNT
     * - BROWSER_USERS_REVIEWS
     * - BROWSER_USERS_COMMENTS
     * - BROWSER_VOUCHERS
     * - BROWSER_STORES_INFORMATION
     * - LOG_IN
     */

    @Getter
    private final List<String> AnonymousUserAuthorities = new ArrayList<>(List.of(
            BROWSER_ON_SALE_PRODUCT,
            REGISTER_NEW_CUSTOMER_ACCOUNT,
            BROWSER_USERS_REVIEWS,
            BROWSER_USERS_COMMENTS,
            BROWSER_VOUCHERS,
            BROWSER_STORES_INFORMATION,
            LOG_IN
    ));

    /**
     * Customers User Authority:
     * - All Authority From Anonymous User
     * - PLACE_ORDER
     * - BROWSER_USER_INFORMATION
     * - UPDATE_PERSONAL_PROFILE
     * - BROWSER_PERSONAL_ORDERS
     **/
    @Getter
    private final List<String> CustomerUserAuthorities = new ArrayList<>(
            List.of(
                    BROWSER_ON_SALE_PRODUCT,
                    REGISTER_NEW_CUSTOMER_ACCOUNT,
                    BROWSER_USERS_REVIEWS,
                    BROWSER_USERS_COMMENTS,
                    BROWSER_VOUCHERS,
                    BROWSER_STORES_INFORMATION,
                    BROWSER_USER_INFORMATION,
                    LOG_IN,
                    PLACE_ORDER,
                    UPDATE_PERSONAL_PROFILE,
                    BROWSER_PERSONAL_ORDERS,
                    ADD_REVIEW,
                    REMOVE_REVIEW,
                    UPDATE_REVIEW,
                    ADD_COMMENT,
                    UPDATE_COMMENT,
                    REMOVE_COMMENT
            )
    );
    /**
     * ProductManager User Authority:
     * - All Authority From Anonymous User
     * - PLACE_ORDER
     * - BROWSER_USER_INFORMATION
     * - UPDATE_PERSONAL_PROFILE
     * - BROWSER_PERSONAL_ORDERS
     **/
    @Getter
    private final List<String> ProductManagerUserAuthorities =  new ArrayList<>(
            List.of(
                    BROWSER_ON_SALE_PRODUCT,
                    REGISTER_NEW_CUSTOMER_ACCOUNT,
                    BROWSER_USERS_REVIEWS,
                    BROWSER_USERS_COMMENTS,
                    BROWSER_VOUCHERS,
                    BROWSER_STORES_INFORMATION,
                    BROWSER_USER_INFORMATION,
                    LOG_IN,
                    PLACE_ORDER,
                    UPDATE_PERSONAL_PROFILE,
                    BROWSER_PERSONAL_ORDERS
            )
    );

    @Getter
    private final List<String> VendorUserAuthorities = new ArrayList<>(

    );

    /**
     * Get Authorities
     */
    public List<String> GetAuthorities() {
        switch (this) {
            case CUSTOMERUSER:
                return CustomerUserAuthorities;
            case MANAGERUSER:
                return ProductManagerUserAuthorities;
            case VENDORUSER:
                return VendorUserAuthorities;
        }
        return AnonymousUserAuthorities;
    }
}