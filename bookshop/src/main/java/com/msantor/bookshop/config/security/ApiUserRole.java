package com.msantor.bookshop.config.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.msantor.bookshop.config.security.ApiUserPermission.*;

public enum ApiUserRole {

    ADMIN(Sets.newHashSet(ADMIN_READ, ADMIN_WRITE,
            BOOK_READ, BOOK_WRITE,
            CLIENT_READ, CLIENT_WRITE,
            RENT_READ, RENT_WRITE)),

    CLIENT(Sets.newHashSet(BOOK_READ,
            CLIENT_READ, CLIENT_WRITE,
            RENT_READ, RENT_WRITE)),


    GUEST(Sets.newHashSet());

    private final Set<ApiUserPermission> permission;

    ApiUserRole(Set<ApiUserPermission> permission) {
        this.permission = permission;
    }

    public Set<ApiUserPermission> getPermission() {
        return permission;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions = getPermission().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return permissions;
    }

}