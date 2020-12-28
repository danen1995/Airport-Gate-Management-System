package com.airport.mgmt.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final AccountUserDetailsService accountUserService;

    public SecurityConfig(AccountUserDetailsService accountUserService) {
        this.accountUserService = accountUserService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountUserService);
    }

    // @formatter:off
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                    .disable()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.ALWAYS).and()
                .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "gates/updateAvailability")
                        .hasRole("administrator")
                    .anyRequest().authenticated()
                    .and().httpBasic();
    }
}