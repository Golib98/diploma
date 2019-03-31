package kz.greetgo.diploma.controller.controller;

import java.util.List;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.model.AllProjectCard;
import kz.greetgo.diploma.controller.model.Project;
import kz.greetgo.diploma.controller.register.ProjectRegister;
import kz.greetgo.diploma.controller.util.Controller;
import kz.greetgo.mvc.annotations.Json;
import kz.greetgo.mvc.annotations.Par;
import kz.greetgo.mvc.annotations.ParSession;
import kz.greetgo.mvc.annotations.ToJson;
import kz.greetgo.mvc.annotations.on_methods.ControllerPrefix;
import kz.greetgo.mvc.annotations.on_methods.OnGet;
import kz.greetgo.mvc.annotations.on_methods.OnPost;

@Bean
@ControllerPrefix("/projects")
public class ProjectController implements Controller {

  public BeanGetter<ProjectRegister> projectRegister;

  @ToJson
  @OnGet("/myProjects")
  public List<Project> myProjects(@ParSession("personId") String personId) {
    return projectRegister.get().getMyProjects(personId);
  }

  @ToJson
  @OnGet("/allProjects")
  public List<AllProjectCard> allProjects(@ParSession("personId") String personId) {
    return projectRegister.get().getAllProjects(personId);
  }

  @OnGet("/deleteProject")
  public void deleteProject(@Par("projectId") String projectId) {
    projectRegister.get().deleteProject(projectId);
  }

  @OnPost("/addProject")
  public void addProject(@ParSession("personId") String personId,
                         @Json @Par("project") Project project) {
    projectRegister.get().addProject(personId, project);
  }

  @OnGet("/likeProject")
  public void likeProject(@ParSession("personId") String personId,
                          @Par("projectId") String projectId) {
    projectRegister.get().likeProject(personId, projectId);
  }

  @OnGet("/dislikeProject")
  public void dislikeProject(@ParSession("personId") String personId,
                             @Par("projectId") String projectId) {
    projectRegister.get().dislikeProject(personId, projectId);
  }

}
