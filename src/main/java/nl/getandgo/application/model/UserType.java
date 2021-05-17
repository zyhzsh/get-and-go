package nl.getandgo.application.model;

import lombok.Getter;

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

    // Customer User Authorities:
    @Getter public static final String BROWSER_PERSONAL_INFORMATION = "BROWSER_PERSONAL_INFORMATION";
    @Getter public static final String PLACE_ORDER = "PLACE_ORDER";
    @Getter public static final String UPDATE_PERSONAL_PROFILE = "UPDATE_PERSONAL_PROFILE";
    @Getter public static final String BROWSER_PERSONAL_ORDERS = "BROWSER_PERSONAL_ORDERS";
    @Getter public static final String ADD_REVIEW="ADD_REVIEW";
    @Getter public static final String REMOVE_REVIEW="REMOVE_REVIEW";
    @Getter public static final String UPDATE_REVIEW="UPDATE_REVIEW";
    @Getter public static final String ADD_COMMENT="ADD_COMMENT";
    @Getter public static final String UPDATE_COMMENT="UPDATE_COMMENT";
    @Getter public static final String REMOVE_COMMENT="REMOVE_COMMENT";

    // ProductManager User Authorities:
    @Getter public static final String GET_ALL_STORES="GET_ALL_STORES";
    @Getter public static final String ADD_NEW_STORE = "ADD_NEW_STORE";
    @Getter public static final String ADD_NEW_VENDOR = "ADD_NEW_VENDOR";
    @Getter public static final String UPDATE_STORE_INFORMATION = "UPDATE_STORE_INFORMATION";
    @Getter public static final String DELETE_STORE="DELETE_STORE";
    @Getter public static final String GET_ALL_VENDORS="GET_ALL_VENDORS";
    @Getter public static final String GET_ALL_STATUS_PRODUCTS="GET_ALL_STATUS_PRODUCTS";

    // Vendor User Authorities:
    @Getter public static final String GET_STORE_SELLING_HISTORY="GET_STORE_SELLING_HISTORY";


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
                    BROWSER_PERSONAL_INFORMATION,
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
                    ADD_NEW_VENDOR,
                    GET_ALL_STORES,
                    ADD_NEW_STORE ,
                    ADD_NEW_VENDOR ,
                    UPDATE_STORE_INFORMATION ,
                    DELETE_STORE,
                    GET_ALL_VENDORS,
                    GET_ALL_STATUS_PRODUCTS
            )
    );
    @Getter
    private final List<String> VendorUserAuthorities = new ArrayList<>(
            List.of(GET_STORE_SELLING_HISTORY)
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
        return null;
    }
}