package kz.greetgo.diploma.register.impl;

import java.util.List;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.model.AllAssistantsIn;
import kz.greetgo.diploma.controller.model.PersonRecord;
import kz.greetgo.diploma.controller.model.Role;
import kz.greetgo.diploma.controller.register.PersonRegister;
import kz.greetgo.diploma.register.dao.PersonDao;
import kz.greetgo.diploma.register.util.sql.JdbcDiploma;
import kz.greetgo.diploma.register.util.sql.SQL;
import org.fest.util.Strings;

@Bean
public class PersonRegisterImpl implements PersonRegister {
  public BeanGetter<PersonDao> personDao;
  public BeanGetter<JdbcDiploma> jdbc;

  @Override
  public List<PersonRecord> list() {
    return personDao.get().list();
  }

  @Override
  public List<PersonRecord> listOf(AllAssistantsIn allAssistantsIn) {

    SQL sql = buildSql(allAssistantsIn);

    return jdbc.get().queryForList(sql, rs -> {
      PersonRecord ret = new PersonRecord();
      ret.fio = rs.getString("fio");
      return ret;
    });

  }

  @Override
  public List<PersonRecord> myAssistants(String personId) {
    return personDao.get().myAssistants(personId);
  }

  private SQL buildSql(AllAssistantsIn allAssistantsIn) {

    SQL sql = new SQL()
      .select("x.username, concat_ws(' ', x.surname, x.name, x.patronymic) as fio")
      .from("person x")
      .join("role x2 on x2.id = x.role_id")
      .where("x2.title = :role")
      .setValue("role", Role.STUDENT);

    if (allAssistantsIn != null) {

      if (!Strings.isNullOrEmpty(allAssistantsIn.name)) {
        sql.where("x.name ilike :name");
        sql.setValue("name", allAssistantsIn.name);
      }

      if (allAssistantsIn.birthDate != null) {
        sql.where("date_trunc('day', x.birth_date) = date_trunc('day', :birthDate)");
        sql.setValue("birthDate", allAssistantsIn.birthDate);
      }

    }

    return sql;
  }
}
