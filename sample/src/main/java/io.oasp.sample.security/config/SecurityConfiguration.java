package io.oasp.sample.security.config;

import io.oasp.starter.security.base.accesscontrol.AccessControlSchemaProvider;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.inject.Inject;

@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Inject
  private AccessControlSchemaProvider accessControlSchemaProvider;

  protected void configure(HttpSecurity http) throws Exception {

    http
        .authorizeRequests()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .and()
        .httpBasic();
  }

  @Bean
  public UserDetailsService userDetailsService() {

    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(User.withUsername("user").password("user").roles("User").build());
    manager.createUser(User.withUsername("admin").password("admin").roles("Admin").build());
    return manager;
  }

  @Bean
  public FilterRegistrationBean filterRegistrationBean(AuthenticationFilter authenticationFilter) {

    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(authenticationFilter);
    registration.addUrlPatterns("/*");
    registration.setEnabled(true);
    return registration;
  }

  @Bean
  public AuthenticationFilter getAuthenticationFilter() {

    return new AuthenticationFilter();
  }
}
