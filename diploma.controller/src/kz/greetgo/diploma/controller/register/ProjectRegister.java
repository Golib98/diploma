package kz.greetgo.diploma.controller.register;

import java.util.List;
import kz.greetgo.diploma.controller.model.AllProjectCard;
import kz.greetgo.diploma.controller.model.AllProjectFilter;
import kz.greetgo.diploma.controller.model.ProfessorDict;
import kz.greetgo.diploma.controller.model.Project;

public interface ProjectRegister {
  List<Project> getMyProjects(String personId);

  void deleteProject(String projectId);

  void addProject(String personId, Project project);

  List<AllProjectCard> getAllProjects(String personId, AllProjectFilter filter);

  void likeProject(String personId, String projectId);

  void dislikeProject(String personId, String projectId);

  List<ProfessorDict> professorsDict();

  List<Project> getFavoriteProjects(String personId);

  void respondToProject(String projectId, String studentId);

  List<Project> accessedProjects(String personId);

  Project getProjectDetails(String projectId);

  void accept(String assistantId, String projectTitle);

  void reject(String assistantId, String projectTitle);
}
