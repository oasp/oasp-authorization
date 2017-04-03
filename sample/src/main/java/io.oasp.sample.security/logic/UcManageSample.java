package io.oasp.sample.security.logic;

import org.springframework.stereotype.Component;

import javax.annotation.security.RolesAllowed;

@Component
public class UcManageSample {

  @RolesAllowed("ReadTest")
  public String test() {
    return "Success";
  }

  @RolesAllowed("ReadUserData")
  public String readUserData() {
    return "ReadUserData";
  }

  @RolesAllowed("ReadAdminData")
  public String readAdminData() {
    return "ReadAdminData";
  }
}
