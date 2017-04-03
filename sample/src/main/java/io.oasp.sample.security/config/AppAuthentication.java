package io.oasp.sample.security.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class AppAuthentication extends User implements Authentication {

  private Authentication authentication;

  AppAuthentication(Authentication authentication, Collection<GrantedAuthority> authorities) {
    super(authentication.getName(), authentication.getName(), authorities);
    this.authentication = authentication;
  }

  @Override
  public Object getCredentials() {
    return authentication.getCredentials();
  }

  @Override
  public Object getDetails() {
    return authentication.getDetails();
  }

  @Override
  public Object getPrincipal() {
    return authentication.getPrincipal();
  }

  @Override
  public boolean isAuthenticated() {
    return true;
  }

  @Override
  public void setAuthenticated(boolean b) throws IllegalArgumentException {
    authentication.setAuthenticated(b);
  }

  @Override
  public String getName() {
    return authentication.getName();
  }
}
