package io.oasp.starter.security.impl.rest;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Sends the OK status code upon successful logout.
 *
 * @see JsonUsernamePasswordAuthenticationFilter
 */
public class LogoutSuccessHandlerReturningOkHttpStatusCode implements LogoutSuccessHandler {
  /**
   * Called after a successful logout by the {@link JsonUsernamePasswordAuthenticationFilter}.
   */
  @Override
  public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws IOException, ServletException {

    if (response.isCommitted()) {
      return;
    }
    response.setStatus(HttpServletResponse.SC_OK);
  }
}
