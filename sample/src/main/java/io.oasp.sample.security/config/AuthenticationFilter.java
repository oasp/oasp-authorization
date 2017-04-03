package io.oasp.sample.security.config;

import io.oasp.starter.security.api.accesscontrol.AccessControl;
import io.oasp.starter.security.api.accesscontrol.AccessControlProvider;
import io.oasp.starter.security.base.accesscontrol.AccessControlGrantedAuthority;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class AuthenticationFilter implements Filter {

  @Inject
  private AccessControlProvider accessControlProvider;

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws IOException, ServletException {

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null) {
      HttpServletRequest request = (HttpServletRequest) req;
      HttpServletResponse response = (HttpServletResponse) res;
      Collection<GrantedAuthority> authorities = getAuthorities();
      AppAuthentication appAuthentication = new AppAuthentication(authentication, authorities);
      SecurityContextHolder.getContext().setAuthentication(appAuthentication);
    }
    chain.doFilter(req, res);
  }

  private Collection<GrantedAuthority> getAuthorities() {

    Set<AccessControl> permissions = new HashSet<>();
    Set<GrantedAuthority> authorities = new HashSet<>();
    accessControlProvider.collectAccessControls("Admin", permissions);
    for (AccessControl accessControl : permissions) {
      authorities.add(new AccessControlGrantedAuthority(accessControl));
    }
    return authorities;
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void destroy() {

  }

}
