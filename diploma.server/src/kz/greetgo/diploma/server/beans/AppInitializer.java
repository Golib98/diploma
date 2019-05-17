package kz.greetgo.diploma.server.beans;

import javax.servlet.ServletContext;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.register.beans.prod.ForwardFilter;
import kz.greetgo.diploma.register.util.App;
import kz.greetgo.diploma.register.util.LiquibaseManager;

@Bean
public class AppInitializer {

  public BeanGetter<LiquibaseManager> liquibaseManager;

  public BeanGetter<ControllerServlet> controllerServlet;

  public BeanGetter<Utf8AndTraceResetFilter> utf8AndTraceResetFilter;

  public BeanGetter<ForwardFilter> forwardFilter;

  public void initialize(ServletContext ctx) throws Exception {
    if (!App.do_not_run_liquibase_on_deploy_war().exists()) {
      liquibaseManager.get().apply();
    }

    utf8AndTraceResetFilter.get().register(ctx);
    forwardFilter.get().register(ctx);

    controllerServlet.get().register(ctx);
  }
}
