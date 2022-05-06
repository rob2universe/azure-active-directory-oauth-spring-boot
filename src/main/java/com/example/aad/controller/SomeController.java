package com.example.aad.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {
    @GetMapping("admin")
    @ResponseBody
//    @PreAuthorize("hasAuthority('APPROLE_admin')")
    public String Admin() {
        return getUser().toString();
    }

    public OidcUser getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            if (authentication.getPrincipal() instanceof OidcUser) {
                OidcUser user = (OidcUser) authentication.getPrincipal();
                return user;
            }
        }
        return null;
    }
}