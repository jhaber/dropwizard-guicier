package com.hubspot.dropwizard.guicier;

import com.google.inject.Injector;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import com.sun.jersey.spi.container.servlet.WebConfig;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.dropwizard.setup.Environment;

import javax.inject.Inject;
import javax.servlet.ServletException;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author <a href="mailto:henning@schmiedehausen.org">Henning P. Schmiedehausen</a>
 */
public class DropwizardGuiceContainer extends GuiceContainer {
  @SuppressFBWarnings("BAD_PRACTICE")
  private final Environment environment;

  private static final long serialVersionUID = 1L;

  @Inject
  public DropwizardGuiceContainer(final Injector injector, final Environment environment) {
    super(injector);
    this.environment = checkNotNull(environment, "environment is null");
  }

  @Override
  protected ResourceConfig getDefaultResourceConfig(final Map<String, Object> props, final WebConfig webConfig) throws ServletException {
    return environment.jersey().getResourceConfig();
  }
}
