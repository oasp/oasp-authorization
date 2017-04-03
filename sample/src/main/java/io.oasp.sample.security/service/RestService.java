package io.oasp.sample.security.service;

import io.oasp.sample.security.logic.UcManageSample;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Collection;

@RestController
@RequestMapping("/services/rest")
public class RestService {

  @Inject
  private UcManageSample ucManageSample;

  @RequestMapping(path = "/test", method = RequestMethod.GET)
  public String test() {
    Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    for (GrantedAuthority authority : authorities) {
      System.out.println(authority.getAuthority());
    }
    return ucManageSample.test();
  }

  @RequestMapping(path = "/read-user-data", method = RequestMethod.GET)
  public String readUserData() {
    return ucManageSample.readUserData();
  }

  @RequestMapping(path = "/read-admin-data", method = RequestMethod.GET)
  public String readAdminData() {
    return ucManageSample.readAdminData();
  }
}
