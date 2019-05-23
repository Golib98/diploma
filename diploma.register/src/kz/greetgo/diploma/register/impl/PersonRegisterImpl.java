package kz.greetgo.diploma.register.impl;

import java.util.List;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.model.AllAssistantsIn;
import kz.greetgo.diploma.controller.model.PersonRecord;
import kz.greetgo.diploma.controller.model.ProfessorInfo;
import kz.greetgo.diploma.controller.model.Role;
import kz.greetgo.diploma.controller.register.PersonRegister;
import kz.greetgo.diploma.register.dao.PersonDao;
import kz.greetgo.diploma.register.util.sql.JdbcDiploma;
import kz.greetgo.diploma.register.util.sql.SQL;
import kz.greetgo.email.Email;
import kz.greetgo.email.EmailSender;
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
      ret.university = rs.getString("university");
      return ret;
    });

  }

  @Override
  public List<PersonRecord> myAssistants(String personId) {
    return personDao.get().myAssistants(personId);
  }

  @Override
  public ProfessorInfo professorInfo(String personId) {

    return personDao.get().professorInfo(personId);

  }

  @Override
  public ProfessorInfo studentInfo(String personId) {
    return personDao.get().studentInfo(personId);
  }

  @Override
  public List<PersonRecord> myResponds(String personId) {
    return personDao.get().myResponds(personId);
  }

  public BeanGetter<EmailSender> emailSender;

  @Override
  public void sendMail(String fromIf, String toId, String topic, String body) {

    String emailFrom = personDao.get().getEmail(fromIf);
    String emailTo = personDao.get().getEmail(toId);

    new Thread(() -> {
      Email email = new Email();
      email.setTo(emailTo);
      email.setFrom(emailFrom);
      email.setBody(body);
      email.setSubject(topic);
      emailSender.get().send(email);
    }).start();

  }

  private SQL buildSql(AllAssistantsIn allAssistantsIn) {

    SQL sql = new SQL()
      .select("x.username, concat_ws(' ', x.surname, x.name, x.patronymic) as fio")
      .select("x3.title as university")
      .from("person x")
      .join("role x2 on x2.id = x.role_id")
      .leftjoin("university x3 on x3.id = x.university_id")
      .where("x2.title = :role")
      .setValue("role", Role.STUDENT);

    if (allAssistantsIn != null) {

      if (!Strings.isNullOrEmpty(allAssistantsIn.firstName)) {
        sql.where("x.name ilike :name");
        sql.setValue("name", allAssistantsIn.firstName);
      }

      if (!Strings.isNullOrEmpty(allAssistantsIn.lastName)) {
        sql.where("x.surname ilike :lastName");
        sql.setValue("lastName", allAssistantsIn.lastName);
      }

      if (allAssistantsIn.birthDate != null) {
        sql.where("date_trunc('day', x.birth_date) = date_trunc('day', :birthDate)");
        sql.setValue("birthDate", allAssistantsIn.birthDate);
      }

    }

    return sql;
  }
}
