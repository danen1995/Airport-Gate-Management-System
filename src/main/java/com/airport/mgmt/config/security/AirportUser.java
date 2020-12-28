package com.airport.mgmt.config.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.airport.mgmt.domain.Account;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class AirportUser implements UserDetails {
    private final Account account;
    private final Set<GrantedAuthority> authorities;

    public AirportUser(Account account) {
        this.account = account;
        this.authorities = new HashSet<>(account.getRoles());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
