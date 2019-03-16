package kz.greetgo.diploma.controller.register;

import java.util.List;
import kz.greetgo.diploma.controller.model.Project;

public interface ProjectRegister {
  List<Project> getMyProjects(String personId);

  void deleteProject(String projectId);

  void addProject(String personId, Project project);
}
