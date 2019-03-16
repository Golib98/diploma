package kz.greetgo.diploma.register.test.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AuthTestDao {
  @Insert("insert into Person (id, username, encoded_password, blocked) " +
    "values (#{id}, #{username}, #{encodedPassword}, 0)")
  void insertPerson(@Param("id") String id,
                    @Param("username") String username,
                    @Param("encodedPassword") String encodedPassword
  );

  @Update("update Person set ${fieldName} = #{fieldValue} where id = #{id}")
  void updatePersonField(@Param("id") String id,
                         @Param("fieldName") String fieldName,
                         @Param("fieldValue") Object fieldValue);

  @Insert("insert into user_can (user_can, description) values (#{can}, 'description of '||#{can})" +
    " on conflict (user_can) do nothing")
  void upsert(@Param("can") String can);

  @Insert("insert into person_cans (person_id, user_can)" +
    " select p.id as person_id, #{can} as user_can" +
    " from person p, user_can where p.username = #{username} and p.blocked = 0" +
    " on conflict (person_id, user_can) do nothing")
  void personCan(@Param("username") String username, @Param("can") String can);

  @Select("select id from role where title = #{role}")
  String getRoleId(String role);

  @Insert("insert into role(id, title) values (#{id}, #{role})")
  void insertRole(@Param("id") String id, @Param("role") String role);

  @Insert("insert into person_role(role_id, person_id) " +
    "VALUES (#{roleId}, #{personId}) ")
  void insertPersonRole(@Param("personId") String person, @Param("roleId") String roleId);

  @Select("select id from person where username = #{person} ")
  String getPersonId(String person);

  @Select("insert into professor_assistant (professor_id, assistant_id)\n" +
    "values (#{professorId}, #{studentId})")
  void insertPersonAssistant(@Param("professorId") String professorId,
                             @Param("studentId") String studentId);
}
