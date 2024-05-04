package com.vote.config;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collection;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        if (authorities.stream().anyMatch(r -> r.getAuthority().equals("USER"))) {
            redirectStrategy.sendRedirect(request, response, "/api1/user/dashboard");
        } else if (authorities.stream().anyMatch(r -> r.getAuthority().equals("ADMIN"))) {
            redirectStrategy.sendRedirect(request, response, "/api2/admin/dashboard");
        } else {
            redirectStrategy.sendRedirect(request, response, "/login");
        }
    }
}

