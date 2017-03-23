package io.oasp.sample.security.service;

import io.oasp.sample.security.logic.UcManageSample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services/rest")
public class RestService {

  @Autowired
  private UcManageSample ucManageSample;

  @RequestMapping(path = "/test", method = RequestMethod.GET)
  public String test() {
    return ucManageSample.test();
  }
}
