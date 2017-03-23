package io.oasp.starter.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@Configuration
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class SecurityAutoConfiguration {

  @Bean
  public TestBean testBean() {
    return new TestBean();
  }
}
