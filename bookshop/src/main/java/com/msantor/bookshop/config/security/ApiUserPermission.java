package com.msantor.bookshop.config.security;

public enum ApiUserPermission {

    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write"),

    BOOK_READ("book:read"),
    BOOK_WRITE("book:write"),

    CLIENT_READ("client:read"),
    CLIENT_WRITE("client:write"),

    RENT_READ("order:read"),
    RENT_WRITE("order:write");

    private final String permission;

    ApiUserPermission(String permission){
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}