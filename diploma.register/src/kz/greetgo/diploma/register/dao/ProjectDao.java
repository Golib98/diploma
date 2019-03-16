package kz.greetgo.diploma.register.dao;

import java.util.List;
import kz.greetgo.diploma.controller.model.Project;
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
  void insProject(String personId, Project project);
}
