package kz.greetgo.diploma.register.dao;

import java.util.List;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.diploma.controller.model.PersonRecord;
import kz.greetgo.diploma.controller.model.ProfessorInfo;
import org.apache.ibatis.annotations.Select;

@Bean
public interface PersonDao {
  @Select("with cans as (\n" +
    "  select person_id, string_agg(user_can, ', ' order by user_can asc) as cans\n" +
    "  from person_cans\n" +
    "  group by person_id\n" +
    ")\n" +
    "\n" +
    "select id,\n" +
    "       surname||' '||substring(name from 1 for 1)||'. '||substring(patronymic from 1 for 1)||'.' as fio,\n" +
    "       username,\n" +
    "       to_char(birth_date, 'YYYY-MM-DD') as birthDate,\n" +
    "       cans\n" +
    "     from person\n" +
    "     left join cans pc on person_id = id\n" +
    "     where blocked = 0\n" +
    "     order by surname, name")
  List<PersonRecord> list();

  @Select("select x.id, concat_ws(' ', x.surname, x.name, x.patronymic) as fio\n" +
    "from person x\n" +
    "     join professor_assistant x2 on x.id = x2.assistant_id\n" +
    "where x2.professor_id = #{professorId}")
  List<PersonRecord> myAssistants(String professorId);

  @Select("select concat_ws(' ', x.surname, x.name, x.patronymic) as fio,\n" +
    " x.email, x.phone, x.title, x.faculty, " +
    " x.sphere, x.degree, " +
    " x2.title as \"university.title\" " +
    "from person x\n" +
    "     join university x2 on x.university_id = x2.id\n" +
    "where x.id = #{professorId}")
  ProfessorInfo professorInfo(String professorId);

  @Select("select concat_ws(' ', x.surname, x.name, x.patronymic) as fio" +
    "  \n" +
    "from person x\n" +
    "where x.id = #{studentId}")
  ProfessorInfo studentInfo(String personId);

  @Select("select x.id, p.title as projectTitle," +
    " concat_ws(' ', x.surname, x.name, x.patronymic) as fio\n" +
    "from person x\n" +
    "     join project_respond x2 on x.id = x2.student_id\n" +
    "     join projects p on x2.project_id = p.id " +
    "where x2.project_id in (select id from projects where professor_id = #{professorId})" +
    " and x2.isaccepted is null")
  List<PersonRecord> myResponds(String personId);

  @Select("select email from person where id = #{z}")
  String getEmail(String fromIf);
}
