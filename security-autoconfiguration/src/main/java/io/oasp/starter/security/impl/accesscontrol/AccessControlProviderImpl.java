package io.oasp.starter.security.impl.accesscontrol;

import io.oasp.starter.security.base.accesscontrol.AbstractAccessControlProvider;
import io.oasp.starter.security.base.accesscontrol.AccessControlSchemaProvider;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * This is the default implementation of {@link io.oasp.starter.security.api.accesscontrol.AccessControlProvider}.
 */
public class AccessControlProviderImpl extends AbstractAccessControlProvider {

  private AccessControlSchemaProvider accessControlSchemaProvider;

  /**
   * The constructor.
   */
  public AccessControlProviderImpl() {

    super();
  }

  /**
   * Initializes this class.
   */
  @PostConstruct
  public void initialize() {

    if (this.accessControlSchemaProvider == null) {
      this.accessControlSchemaProvider = new AccessControlSchemaProviderImpl();
    }
    initialize(this.accessControlSchemaProvider.loadSchema());
  }

  /**
   * @return accessControlSchemaProvider
   */
  public AccessControlSchemaProvider getAccessControlSchemaProvider() {

    return this.accessControlSchemaProvider;
  }

  /**
   * @param accessControlSchemaProvider the {@link AccessControlSchemaProvider} to {@link Inject}.
   */
  public void setAccessControlSchemaProvider(AccessControlSchemaProvider accessControlSchemaProvider) {

    this.accessControlSchemaProvider = accessControlSchemaProvider;
  }

}
