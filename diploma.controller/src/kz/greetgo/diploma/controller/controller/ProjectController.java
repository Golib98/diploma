package kz.greetgo.diploma.controller.controller;

import java.util.List;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.model.AllProjectCard;
import kz.greetgo.diploma.controller.model.AllProjectFilter;
import kz.greetgo.diploma.controller.model.ProfessorDict;
import kz.greetgo.diploma.controller.model.Project;
import kz.greetgo.diploma.controller.register.FileRegister;
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
  public BeanGetter<FileRegister> fileRegister;

  @ToJson
  @OnGet("/myProjects")
  public List<Project> myProjects(@ParSession("personId") String personId) {
    return projectRegister.get().getMyProjects(personId);
  }

  @ToJson
  @OnGet("/allProjects")
  public List<AllProjectCard> allProjects(@ParSession("personId") String personId,
                                          @Json @Par("allProjectFilter") AllProjectFilter filter) {
    return projectRegister.get().getAllProjects(personId, filter);
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

  @ToJson
  @OnGet("/professorsDict")
  public List<ProfessorDict> professorsDict() {
    return projectRegister.get().professorsDict();
  }

  @ToJson
  @OnGet("/favorite")
  public List<Project> favorite(@ParSession("personId") String personId) {
    return projectRegister.get().getFavoriteProjects(personId);
  }

  @OnGet("/toRespond")
  public void toRespond(@ParSession("personId") String personId, @Par("projectId") String projectId) {
    projectRegister.get().respondToProject(projectId, personId);
  }

  @ToJson
  @OnGet("/accessed-projects")
  public List<Project> accessedProjects(@ParSession("personId") String personId) {
    return projectRegister.get().accessedProjects(personId);
  }

  @ToJson
  @OnGet("/detailFor")
  public Project detailFor(@Par("id") String projectId) {
    return projectRegister.get().getProjectDetails(projectId);
  }

  @OnGet("/acceptProject")
  public void acceptProject(@Par("assistantId") String assistantId,
                            @Par("projectTitle") String projectTitle) {
    projectRegister.get().accept(assistantId, projectTitle);
  }

  @OnGet("/rejectProject")
  public void rejectProject(@Par("assistantId") String assistantId,
                            @Par("projectTitle") String projectTitle) {
    projectRegister.get().reject(assistantId, projectTitle);
  }
}
