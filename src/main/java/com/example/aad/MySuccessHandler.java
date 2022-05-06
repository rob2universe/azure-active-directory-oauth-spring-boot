package com.example.aad;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class MySuccessHandler implements AuthenticationSuccessHandler {


  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

    OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();
    log.info("Info from AAD oauth2USer: {}", oauth2User);
    log.info("Name: {}", oauth2User.getName());
    log.info("Authorities: {}", oauth2User.getAuthorities());
    log.info("Attributes: {}", oauth2User.getAttributes());

    response.sendRedirect("/admin");
  }
}
