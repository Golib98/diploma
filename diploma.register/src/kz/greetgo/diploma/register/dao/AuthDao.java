package kz.greetgo.diploma.register.dao;

import java.util.List;
import kz.greetgo.diploma.controller.model.PersonDisplay;
import kz.greetgo.diploma.controller.model.UserCan;
import kz.greetgo.diploma.register.model.PersonLogin;
import org.apache.ibatis.annotations.Select;

public interface AuthDao {
  @Select("select * from person where username = #{username} and blocked = 0")
  PersonLogin selectByUsername(String username);

  @Select("select surname||' '||name||' '||patronymic as fio, username, x2.title as role" +
    " from person x join role x2 on x.role_id = x2.id where x.id = #{personId}")
  PersonDisplay loadDisplayPerson(String personId);

  @Select("select user_can from person_cans where person_id = #{personId}")
  List<UserCan> loadCans(String personId);

}
