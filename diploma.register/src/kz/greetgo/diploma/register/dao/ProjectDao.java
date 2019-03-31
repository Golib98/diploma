package kz.greetgo.diploma.register.dao;

import java.util.List;
import kz.greetgo.diploma.controller.model.AllProjectCard;
import kz.greetgo.diploma.controller.model.Project;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ProjectDao {
  @Select("select  * from projects where professor_id = #{projectId} and removed is false")
  List<Project> getMyProjects(String personId);

  @Update("update projects set removed = #{removed}::boolean where id = #{projectId}")
  void setRemoved(@Param("projectId") String projectId, @Param("removed") boolean removed);

  @Insert("insert into projects(professor_id, title, description) " +
    "VALUES (#{personId}, #{project.title}, #{project.description})")
  void insProject(@Param("personId") String personId, @Param("project") Project project);

  @Select(
    "select x.*, case when x2.student_id is not null then 1 else 0 end as isLiked\n" +
      "from projects x\n" +
      "     left join student_like_project x2 on x.id = x2.project_id and x2.student_id = #{studentId}\n" +
      "where x.removed is false")
  List<AllProjectCard> getAllProjects(String personId);

  @Insert("insert into student_like_project(student_id, project_id) " +
    " values (#{personId}, #{projectId})")
  void likeProject(@Param("personId") String personId,
                   @Param("projectId") String projectId);

  @Delete("delete from student_like_project where student_id = #{personId} and project_id = #{projectId}")
  void dislikeProject(@Param("personId") String personId,
                      @Param("projectId") String projectId);
}
