package kz.greetgo.diploma.register.test.beans.develop;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.model.UserCan;
import kz.greetgo.diploma.register.beans.all.IdGenerator;
import kz.greetgo.diploma.register.test.dao.AuthTestDao;
import kz.greetgo.diploma.register.test.dao.ProjectTestDao;
import kz.greetgo.security.password.PasswordEncoder;
import org.apache.log4j.Logger;
import org.fest.util.Strings;

@Bean
public class DbLoader {
  final Logger logger = Logger.getLogger(getClass());

  public BeanGetter<AuthTestDao> authTestDao;
  public BeanGetter<IdGenerator> idGenerator;
  public BeanGetter<PasswordEncoder> passwordEncoder;
  public BeanGetter<ProjectTestDao> projectTestDao;

  public void loadTestData() throws Exception {

    loadPersons();
    loadRoles();
    loadAssistants();
    loadProjects();

    logger.info("FINISH");
  }

  private void loadProjects() {
    createProjectForProfessor("Title1", "pushkin");
    createProjectForProfessor("Title2", "pushkin");
    createProjectForProfessor("Title3", "pushkin");
    createProjectForProfessor("Title4", "pushkin");
    createProjectForProfessor("Title4", "esenin");
  }

  private void createProjectForProfessor(String title, String professor) {

    String professorId = authTestDao.get().getPersonId(professor);
    projectTestDao.get().insertProject(idGenerator.get().newId(), title, professorId);

  }

  private void loadAssistants() {
    giveAssistantTo("pushkin", "stalin");
    giveAssistantTo("pushkin", "esenin");
  }

  private void giveAssistantTo(String professor, String student) {

    String professorId = authTestDao.get().getPersonId(professor);
    String studentId = authTestDao.get().getPersonId(student);

    authTestDao.get().insertPersonAssistant(professorId, studentId);
  }

  private void loadRoles() {
    giveRoleToUser("pushkin", "PROFESSOR");
    giveRoleToUser("stalin", "STUDENT");
    giveRoleToUser("esenin", "STUDENT");
  }

  private void giveRoleToUser(String person, String role) {

    String roleId = authTestDao.get().getRoleId(role);

    if (Strings.isNullOrEmpty(roleId)) {
      roleId = idGenerator.get().newId();
      authTestDao.get().insertRole(roleId, role);
    }

    String personId = authTestDao.get().getPersonId(person);
    authTestDao.get().updatePersonField(personId, "role_id", roleId);

  }

  private void loadPersons() throws Exception {

    user("Пушкин Александр Сергеевич", "1799-06-06", "pushkin");
    user("Сталин Иосиф Виссарионович", "1878-12-18", "stalin");
    user("Берия Лаврентий Павлович", "1899-03-17", "beria");
    user("Есенин Сергей Александрович", "1895-09-21", "esenin");
    user("Путин Владимир Владимирович", "1952-10-07", "putin");
    user("Назарбаев Нурсултан Абишевич", "1940-07-06", "papa");
    user("Менделеев Дмитрий Иванович", "1834-02-08", "mendeleev");
    user("Ломоносов Михаил Васильевич", "1711-11-19", "lomonosov");
    user("Бутлеров Александр Михайлович", "1828-09-15", "butlerov");

    add_can("pushkin", UserCan.VIEW_USERS);
    add_can("stalin", UserCan.VIEW_USERS);
    add_can("stalin", UserCan.VIEW_ABOUT);

  }

  private void user(String fioStr, String birthDateStr, String accountName) throws Exception {
    String id = idGenerator.get().newId();
    String[] fio = fioStr.split("\\s+");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date birthDate = sdf.parse(birthDateStr);
    String encryptPassword = passwordEncoder.get().encode("111");

    authTestDao.get().insertPerson(id, accountName, encryptPassword);
    authTestDao.get().updatePersonField(id, "birth_date", new Timestamp(birthDate.getTime()));
    authTestDao.get().updatePersonField(id, "surname", fio[0]);
    authTestDao.get().updatePersonField(id, "name", fio[1]);
    authTestDao.get().updatePersonField(id, "patronymic", fio[2]);
  }

  private void add_can(String username, UserCan... cans) {
    for (UserCan can : cans) {
      authTestDao.get().upsert(can.name());
      authTestDao.get().personCan(username, can.name());
    }
  }
}
