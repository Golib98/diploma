package kz.greetgo.diploma.controller.controller;

import java.util.List;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.model.AllAssistantsIn;
import kz.greetgo.diploma.controller.model.PersonRecord;
import kz.greetgo.diploma.controller.model.ProfessorInfo;
import kz.greetgo.diploma.controller.register.PersonRegister;
import kz.greetgo.diploma.controller.util.Controller;
import kz.greetgo.mvc.annotations.Json;
import kz.greetgo.mvc.annotations.Par;
import kz.greetgo.mvc.annotations.ParSession;
import kz.greetgo.mvc.annotations.ToJson;
import kz.greetgo.mvc.annotations.on_methods.ControllerPrefix;
import kz.greetgo.mvc.annotations.on_methods.OnGet;
import kz.greetgo.mvc.annotations.on_methods.OnPost;

@Bean
@ControllerPrefix("/person")
public class PersonController implements Controller {

  public BeanGetter<PersonRegister> personRegister;

  @ToJson
  @OnGet("/list")
  public List<PersonRecord> list() {
    return personRegister.get().list();
  }

  @ToJson
  @OnPost("/allAssistants")
  public List<PersonRecord> allAssistants(@Json @Par("allAssistantsIn") AllAssistantsIn allAssistantsIn) {
    return personRegister.get().listOf(allAssistantsIn);
  }

  @ToJson
  @OnGet("/myAssistants")
  public List<PersonRecord> myAssistants(@ParSession("personId") String personId) {
    return personRegister.get().myAssistants(personId);
  }

  @ToJson
  @OnGet("/myResponds")
  public List<PersonRecord> myResponds(@ParSession("personId") String personId) {
    return personRegister.get().myResponds(personId);
  }

  @ToJson
  @OnGet("/professorInfo")
  public ProfessorInfo getProfessorInfo(@ParSession("personId") String personId) {
    return personRegister.get().professorInfo(personId);
  }

  @ToJson
  @OnGet("/studentInfo")
  public ProfessorInfo getStudentInfo(@ParSession("personId") String personId) {
    return personRegister.get().studentInfo(personId);
  }
}