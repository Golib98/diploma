package kz.greetgo.diploma.register.impl;

import java.util.List;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.model.AllProjectCard;
import kz.greetgo.diploma.controller.model.AllProjectFilter;
import kz.greetgo.diploma.controller.model.FileWrapper;
import kz.greetgo.diploma.controller.model.ProfessorDict;
import kz.greetgo.diploma.controller.model.Project;
import kz.greetgo.diploma.controller.register.ProjectRegister;
import kz.greetgo.diploma.register.dao.ProjectDao;
import kz.greetgo.diploma.register.util.sql.JdbcDiploma;
import kz.greetgo.diploma.register.util.sql.SQL;
import org.fest.util.Strings;

@Bean
public class ProjectRegisterImpl implements ProjectRegister {

  public BeanGetter<ProjectDao> projectDao;
  public BeanGetter<JdbcDiploma> jdbc;

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

    String projectId = projectDao.get().insProject(personId, project);

    if (project.fileIds != null) {
      for (FileWrapper file : project.fileIds) {
        projectDao.get().insProjectAttachments(projectId, file);
      }
    }

  }

  @Override
  public List<AllProjectCard> getAllProjects(String personId, AllProjectFilter filter) {

    SQL sql = buildSql(personId, filter);

    return jdbc.get().queryForList(sql, rs -> {
      AllProjectCard ret = new AllProjectCard();
      ret.id = rs.getString("id");
      ret.description = rs.getString("description");
      ret.publishedDate = rs.getDate("published_date");
      ret.title = rs.getString("title");
      ret.isLiked = rs.getBoolean("isLiked");
      ret.isResponded = rs.getBoolean("isResponded");
      return ret;
    });

  }

  private SQL buildSql(String personId, AllProjectFilter filter) {
    SQL sql = new SQL();
    sql.select("x.*")
      .select("case when x2.student_id is not null then 1 else 0 end as isLiked")
      .select("case when x3.student_id is not null then 1 else 0 end as isResponded")
      .from("projects x")
      .leftjoin("student_like_project x2 on x.id = x2.project_id and x2.student_id = :studentId")
      .leftjoin("project_respond x3 on x3.project_id = x.id")
      .where("x.removed is false")
      .setValue("studentId", personId)
      .order_by("x.published_date desc");

    if (filter == null) return sql;

    if (!Strings.isNullOrEmpty(filter.professorId)) {
      sql.where("x.professor_id = :profId")
        .setValue("profId", filter.professorId);
    }

    if (!Strings.isNullOrEmpty(filter.projectTitle)) {
      sql.where("x.title ilike :title")
        .setValue("title", "%" + filter.projectTitle + "%");
    }

    if (filter.uploadDate != null) {
      sql.where("date_trunc('day', x.published_date) = date_trunc('day'::varchar, :date::timestamp)")
        .setValue("date", filter.uploadDate);
    }

    return sql;
  }

  @Override
  public void likeProject(String personId, String projectId) {
    projectDao.get().likeProject(personId, projectId);
  }

  @Override
  public void dislikeProject(String personId, String projectId) {
    projectDao.get().dislikeProject(personId, projectId);
  }

  @Override
  public List<ProfessorDict> professorsDict() {
    return projectDao.get().getProfessorsDict();
  }

  @Override
  public List<Project> getFavoriteProjects(String personId) {
    return projectDao.get().getFavoriteFor(personId);
  }

  @Override
  public void respondToProject(String projectId, String studentId) {
    projectDao.get().insRespond(projectId, studentId);
  }

  @Override
  public List<Project> accessedProjects(String personId) {
    return projectDao.get().getAccessedProjects(personId);
  }

  @Override
  public Project getProjectDetails(String projectId) {

    Project project = projectDao.get().loadProject(projectId);

    project.author = projectDao.get().loadProjectAuthor(projectId);
    project.fileIds = projectDao.get().getProjectFiles(projectId);

    return project;

  }

  @Override
  public void accept(String assistantId, String projectTitle) {
    String projectId = projectDao.get().getProjectId(projectTitle);

    projectDao.get().accept(assistantId, projectId);

    String professorId = projectDao.get().getProfessorIdByProjectId(projectId);
    projectDao.get().addProfessorAssistant(assistantId, professorId);
  }

  @Override
  public void reject(String assistantId, String projectTitle) {
    String projectId = projectDao.get().getProjectId(projectTitle);
    projectDao.get().reject(assistantId, projectId);
  }

}

