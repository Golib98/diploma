package kz.greetgo.diploma.register.dao;

import java.util.List;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.diploma.controller.model.PersonDisplay;
import kz.greetgo.diploma.controller.model.RegistrationUserType;
import kz.greetgo.diploma.controller.model.UserCan;
import kz.greetgo.diploma.controller.model.UserToSave;
import kz.greetgo.diploma.register.model.PersonLogin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Bean
public interface AuthDao {
  @Select("select * from person where username = #{username} and blocked = 0")
  PersonLogin selectByUsername(String username);

  @Select("select surname||' '||name||' '||patronymic as fio, username, x2.title as role" +
    " from person x join role x2 on x.role_id = x2.id where x.id = #{personId}")
  PersonDisplay loadDisplayPerson(String personId);

  @Select("select user_can from person_cans where person_id = #{personId}")
  List<UserCan> loadCans(String personId);

  @Insert("insert into person (username, surname, name, patronymic, birth_date, encoded_password, role_id, university_id, blocked) values (" +
    "#{userToSave.userName}, " +
    "#{userToSave.lastName}, " +
    "#{userToSave.firstName}, " +
    "'', " +
    "null," +
    "#{encodedPass}, " +
    "#{roleId}, " +
    "#{univerId}, 0 )")
  void insertPerson(@Param("userToSave") UserToSave userToSave,
                    @Param("roleId") String roleId,
                    @Param("univerId") String univerId,
                    @Param("encodedPass") String encodedPass);

  @Select("select id from role where title = #{type}")
  String loadRoleId(RegistrationUserType type);

  @Select("select id from university where title = #{type};")
  String loadUniverId(String title);

}
