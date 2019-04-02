package kz.greetgo.diploma.controller.controller;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.model.RegistrationDict;
import kz.greetgo.diploma.controller.register.DictRegister;
import kz.greetgo.diploma.controller.security.PublicAccess;
import kz.greetgo.diploma.controller.util.Controller;
import kz.greetgo.mvc.annotations.ToJson;
import kz.greetgo.mvc.annotations.on_methods.ControllerPrefix;
import kz.greetgo.mvc.annotations.on_methods.OnGet;


@Bean
@ControllerPrefix("/dict")
public class DictController implements Controller {

  public BeanGetter<DictRegister> dictRegister;

  @PublicAccess
  @OnGet("/registration")
  @ToJson
  public RegistrationDict registration() {
    return dictRegister.get().getRegistrationDict();
  }

}
