package io.oasp.starter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityAutoConfiguration {

  @Bean
  public TestBean testBean() {
    return new TestBean();
  }
}
