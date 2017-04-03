package io.oasp.starter.security;

import io.oasp.starter.security.api.accesscontrol.AccessControlProvider;
import io.oasp.starter.security.base.accesscontrol.AccessControlSchemaProvider;
import io.oasp.starter.security.impl.accesscontrol.AccessControlProviderImpl;
import io.oasp.starter.security.impl.accesscontrol.AccessControlSchemaProviderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityAutoConfiguration {

  @Bean
  public AccessControlProvider accessControlProvider() {

    return new AccessControlProviderImpl();
  }

  @Bean
  public AccessControlSchemaProvider accessControlSchemaProvider() {

    return new AccessControlSchemaProviderImpl();
  }

}
