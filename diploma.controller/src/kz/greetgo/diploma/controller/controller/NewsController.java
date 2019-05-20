package kz.greetgo.diploma.controller.controller;

import java.util.List;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.model.News;
import kz.greetgo.diploma.controller.register.NewsRegister;
import kz.greetgo.diploma.controller.security.PublicAccess;
import kz.greetgo.diploma.controller.util.Controller;
import kz.greetgo.mvc.annotations.ToJson;
import kz.greetgo.mvc.annotations.on_methods.ControllerPrefix;
import kz.greetgo.mvc.annotations.on_methods.OnGet;

@Bean
@ControllerPrefix("/news")
public class NewsController implements Controller {

  public BeanGetter<NewsRegister> newsRegister;

  @PublicAccess
  @OnGet("/getAll")
  @ToJson
  public List<News> getAll() {
    return newsRegister.get().getAll();
  }

}
