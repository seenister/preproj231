package ru.mycomp.preproj231.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.mycomp.preproj231.model.Role;

import java.util.Collection;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class UserSecurity implements UserDetails {
    
    private String userName;
    private String password;
    private Boolean isActive;
    private final Set <Role> rolesSet;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return rolesSet;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
