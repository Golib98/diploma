package kz.greetgo.diploma.register.impl;

import java.util.List;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.model.AllProjectCard;
import kz.greetgo.diploma.controller.model.Project;
import kz.greetgo.diploma.controller.register.ProjectRegister;
import kz.greetgo.diploma.register.dao.ProjectDao;

@Bean
public class ProjectRegisterImpl implements ProjectRegister {

  public BeanGetter<ProjectDao> projectDao;

  @Override
  public List<Project> getMyProjects(String personId) {
    return projectDao.get().getMyProjects(personId);
  }

  @Override
  public void deleteProject(String projectId) {
    projectDao.get().setRemoved(projectId, true);
  }

  @Override
  public void addProject(String personId, Project project) {
    if (project.id != null) {
      projectDao.get().updateProject(project);
      return;
    }

    projectDao.get().insProject(personId, project);

  }

  @Override
  public List<AllProjectCard> getAllProjects(String personId) {
    return projectDao.get().getAllProjects(personId);
  }

  @Override
  public void likeProject(String personId, String projectId) {
    projectDao.get().likeProject(personId, projectId);
  }

  @Override
  public void dislikeProject(String personId, String projectId) {
    projectDao.get().dislikeProject(personId, projectId);
  }

}

