package kz.greetgo.diploma.register.impl;

import java.util.List;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
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
    projectDao.get().insProject(personId, project);
  }
}
