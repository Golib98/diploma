package kz.greetgo.diploma.register.test.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface ProjectTestDao {

  @Insert("insert into projects(id, professor_id, title, description) " +
    "VALUES (#{id}, #{professorId}, #{title}, 'Description')")
  void insertProject(@Param("id") String id, @Param("title") String title, @Param("professorId") String professorId);
}
