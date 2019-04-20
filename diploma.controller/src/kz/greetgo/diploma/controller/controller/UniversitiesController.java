package kz.greetgo.diploma.controller.controller;

import java.util.Collections;
import java.util.List;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.model.University;
import kz.greetgo.diploma.controller.register.DictRegister;
import kz.greetgo.diploma.controller.security.PublicAccess;
import kz.greetgo.diploma.controller.util.Controller;
import kz.greetgo.mvc.annotations.ToJson;
import kz.greetgo.mvc.annotations.on_methods.ControllerPrefix;
import kz.greetgo.mvc.annotations.on_methods.OnGet;

@Bean
@ControllerPrefix("/universities")
public class UniversitiesController implements Controller {

  @ToJson
  @OnGet("/getAllUniversities")
  @PublicAccess
  public List<University> getAllUniversities() {
    return Collections.singletonList(new University());
  }

  public BeanGetter<DictRegister> dictRegister;
  
  @ToJson
  @OnGet("/sendmail")
  @PublicAccess
  public void sendmail() {
    dictRegister.get().sendMail();
  }

}
