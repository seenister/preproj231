package ru.mycomp.preproj231.model;

import org.springframework.security.core.GrantedAuthority;

import javax.annotation.PostConstruct;

public enum Role implements GrantedAuthority {

    USER,
    ADMIN;

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }
}
