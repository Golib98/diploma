package kz.greetgo.diploma.register.dao;

import java.util.List;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.diploma.controller.model.AllProjectCard;
import kz.greetgo.diploma.controller.model.FileWrapper;
import kz.greetgo.diploma.controller.model.ProfessorDict;
import kz.greetgo.diploma.controller.model.Project;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Bean
public interface ProjectDao {
  @Select("select  *  from projects where professor_id = #{projectId} and removed is false order by published_date desc")
  List<Project> getMyProjects(String personId);

  @Update("update projects set removed = #{removed}::boolean where id = #{projectId}")
  void setRemoved(@Param("projectId") String projectId, @Param("removed") boolean removed);

  @Select("insert into projects(professor_id, title, description, isopened, deadline, requirements, suggestions, link) " +
    "VALUES (#{personId}, #{project.title}, #{project.description}, #{project.isOpened}::boolean, #{project.deadline},#{project.requirements},#{project.suggestions},#{project.link})" +
    " returning id")
  String insProject(@Param("personId") String personId, @Param("project") Project project);

  @Select(
    "select x.*, case when x2.student_id is not null then 1 else 0 end as isLiked\n" +
      "from projects x\n" +
      "     left join student_like_project x2 on x.id = x2.project_id and x2.student_id = #{studentId}\n" +
      "where x.removed is false order by x.published_date desc")
  List<AllProjectCard> getAllProjects(String personId);

  @Insert("insert into student_like_project(student_id, project_id) " +
    " values (#{personId}, #{projectId})")
  void likeProject(@Param("personId") String personId,
                   @Param("projectId") String projectId);

  @Delete("delete from student_like_project where student_id = #{personId} and project_id = #{projectId}")
  void dislikeProject(@Param("personId") String personId,
                      @Param("projectId") String projectId);

  @Update("update projects set title = #{x.title}, " +
    "description = #{x.description}, " +
    "deadline = #{x.deadline}, " +
    "suggestions = #{x.suggestions}," +
    "requirements = #{x.requirements}," +
    "link = #{x.link} " +
    "where id = #{x.id}")
  void updateProject(@Param("x") Project project);

  @Select("select x.id, concat_ws(' ', x.surname, x.name, x.patronymic) as fio from " +
    " person x join role r on x.role_id = r.id where r.title = 'PROFESSOR'")
  List<ProfessorDict> getProfessorsDict();

  @Select("select * from projects x join student_like_project slp on x.id = slp.project_id" +
    " and slp.student_id = #{studentId}")
  List<Project> getFavoriteFor(String personId);

  @Insert("insert into project_attachments(projectid, filename, fileid) " +
    "values (#{projectId}, #{file.name}, #{file.id})")
  void insProjectAttachments(@Param("projectId") String projectId, @Param("file") FileWrapper file);

  @Insert("insert into project_respond(project_id, student_id) values (#{project}, #{student})")
  void insRespond(@Param("project") String projectId, @Param("student") String studentId);

  @Select("select x.*, pr.isAccepted::int as isResponded " +
    "from projects x\n" +
    "join project_respond pr on x.id = pr.project_id\n" +
    "where pr.student_id = #{personId}")
  List<Project> getAccessedProjects(String personId);

  @Select("select * from projects where id = #{projectId}")
  Project loadProject(String projectId);

  @Select("select fileid as id, filename as name from project_attachments x where projectid = #{projectId}")
  List<FileWrapper> getProjectFiles(String projectId);

  @Select("select concat_ws(' ', p.surname, p.name, p.patronymic) as fio " +
    "from projects x join person p on x.professor_id = p.id where x.id = #{projectId}")
  String loadProjectAuthor(String projectId);

  @Update("update project_respond" +
    " set isaccepted = true " +
    " where student_id = #{studId}" +
    " and project_id = #{projId}")
  void accept(@Param("studId") String assistantId,
              @Param("projId") String projectId);

  @Select("select id from projects where title = #{title} limit 1")
  String getProjectId(String projectTitle);


  @Update("update project_respond" +
    " set isaccepted = false " +
    " where student_id = #{studId}" +
    " and project_id = #{projId}")
  void reject(@Param("studId") String assistantId,
              @Param("projId") String projectId);

  @Insert("insert  into professor_assistant(professor_id, assistant_id) " +
    "VALUES (#{profId}, #{studId}) on conflict do nothing ")
  void addProfessorAssistant(@Param("studId") String assistantId,
                             @Param("profId") String professorId);

  @Select("select professor_id from projects where id = #{id}")
  String getProfessorIdByProjectId(String projectId);
}
