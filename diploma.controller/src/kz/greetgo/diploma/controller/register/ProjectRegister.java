package kz.greetgo.diploma.controller.register;

import java.util.List;
import kz.greetgo.diploma.controller.model.AllProjectCard;
import kz.greetgo.diploma.controller.model.Project;

public interface ProjectRegister {
  List<Project> getMyProjects(String personId);

  void deleteProject(String projectId);

  void addProject(String personId, Project project);

  List<AllProjectCard> getAllProjects(String personId);

  void likeProject(String personId, String projectId);

  void dislikeProject(String personId, String projectId);
}
