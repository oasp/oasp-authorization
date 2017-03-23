package io.oasp.sample.security.logic;

import io.oasp.starter.security.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.security.RolesAllowed;

@Component
public class UcManageSample {

  @Autowired
  private TestBean testBean;

  @RolesAllowed("ADMIN")
  public String test() {
    return testBean.getSuccess();
  }
}
