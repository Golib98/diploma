package kz.greetgo.diploma.register.test.beans.develop;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.model.News;
import kz.greetgo.diploma.controller.model.University;
import kz.greetgo.diploma.controller.model.UserCan;
import kz.greetgo.diploma.register.beans.all.IdGenerator;
import kz.greetgo.diploma.register.test.dao.AuthTestDao;
import kz.greetgo.diploma.register.test.dao.ProjectTestDao;
import kz.greetgo.diploma.register.test.dao.UniversityTestDao;
import kz.greetgo.diploma.register.test.dao.postgres.NewsTestDao;
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
  public BeanGetter<UniversityTestDao> universityTestDao;
  public BeanGetter<NewsTestDao> newsTestDao;

  public void loadTestData() throws Exception {
    logger.info("START");

    loadPersons();
    loadRoles();
    loadAssistants();
    loadProjects();
    loadUniversities();
    loadNews();

    logger.info("FINISH");
  }

  private void loadNews() {

    News x = new News();
    x.title = "Dear teachers, doctoral students invite you to the Scientific Workshop!";
    x.body = "Dear teachers, doctoral students invite you to the Scientific Workshop!\n" +
      "3.05.2019 (Friday) at 11.00 in the Conference hall the following topics will be held:\n" +
      "“Development of an expert system for the early detection of cancer patients of the Republic of Kazakhstan”, speaker: Seidakhmetova K.S.\n" +
      "\n" +
      "“Payment framework based on the blockchain, as a solution for the implementation of the high-tech basis of the payment system of Kazakhstan”, speaker: A. Zhusupova\n" +
      "\n" +
      "“Research and development of an adaptive online educational process based on smart technologies”, speaker: E. Yulenov\n" +
      "\n" +
      "“Development of methods and models for the extraction of knowledge from unstructured data” speaker: Umarov F.\n";
    x.publishedBy = "IITU";
    x.image = "newsiitu.jpg";
    newsTestDao.get().insNews(x);

    x.title = "Alumni meeting";
    x.body = "When? - 25.05.2019 at 15:00 \n" +
      "Where? – IITU, Assembly Hall of the Educational and Sports Complex named after Gumarbek Daukeev\n" +
      "Almaty University of Power Engineering and Telecommunications invites you to the Annual Meeting of Alumni from different years of graduation in order to:\n" +
      "\n" +
      "- continuity of the connection of generations;\n" +
      "\n" +
      "- Strengthen the relationship of the university with graduates;\n" +
      "\n" +
      "- propaganda of professional achievements of graduates;\n" +
      "\n" +
      "- expansion of scientific and technical cooperation of the university with enterprises.\n" +
      "\n" +
      "  The meeting will be held on May 25, 2019 at 15:00, in the assembly hall of the Training and Sports Complex named after Gumarbek Daukeev.\n";
    x.publishedBy = "AUPET";
    x.image = "newsaupet.jpg";
    newsTestDao.get().insNews(x);

    x.body = "When? - 14.05.2019 at 10:00 am\n" +
      "Where? – Almaty, al-Farabi Ave., 71.\n" +
      "May 25, Faculty of History, Archeology and Ethnology, KazNU. Al-Farabi invites you to a solemn event to celebrate the Day of graduates!\n" +
      "\n" +
      "From 10 am graduates of different generations will gather at the Arc de Triomphe \"Magіlіk el.\" They will lay flowers at the monument to the great scientist of the East Abu-Nasyr al-Farabi and the monument to academician U.A. Dzholdasbekova. The grand meeting will be held at the Palace of Students. W.A. Dzholdasbekova. Participants will hear the report of the rector, academician G. Mutanov and the report of the Alumni Association. The program also includes a gala concert.\n" +
      "\n" +
      "From 13 o'clock meetings with graduates will be continued at faculties. Graduates of the Faculty of History, Archeology and Ethnology will visit the Al-Farabi library, academic buildings and audiences, talk with the new generation of students, and get acquainted with the achievements of the faculty. The best students will be awarded scholarships. It is expected the arrival of graduates who graduated from the university 50,40,30,25,10 years ago !!!\n" +
      "\n" +
      "By tradition, the holiday will end with the Graduates' Evening Ball in the library. al-Farabi.\n" +
      "\n" +
      "Graduates Day will be held at: Almaty, al-Farabi Ave., 71. Start: May 25, 2019 at 10 am\n";
    x.image = "newskaznu.jpg";
    x.publishedBy = "KazNU";
    newsTestDao.get().insNews(x);

  }

  private void loadUniversities() {
    {
      University university = new University();
      university.title = "IITU";
      university.description = "International IT University (IITU)";
      university.logo = "iitu.png";
      String universityId = universityTestDao.get().insUniversity(university);
      authTestDao.get().updatePersonFieldAll("university_id", universityId);
    }

    {
      University university = new University();
      university.title = "AUPET";
      university.description = "Almaty University of Power Engineering and Telecommunications (AUPET)";
      university.logo = "aupet.png";
      universityTestDao.get().insUniversity(university);
    }

    {
      University university = new University();
      university.title = "KazNAU";
      university.description = "Kazakh Research Institute of Livestock and Feed Production";
      university.logo = "kazres.png";
      universityTestDao.get().insUniversity(university);
    }

    {
      University university = new University();
      university.title = "KazNU";
      university.description = "Kazakh National University (KazNU)";
      university.logo = "kaznu.png";
      universityTestDao.get().insUniversity(university);
    }

    {
      University university = new University();
      university.title = "Satbayev University";
      university.description = "Satbayev University";
      university.logo = "satbay.png";
      universityTestDao.get().insUniversity(university);
    }


  }

  private void loadProjects() {
    createProjectForProfessor("Title1", "papa");
    createProjectForProfessor("Title2", "papa");
    createProjectForProfessor("Title3", "papa");
    createProjectForProfessor("Title4", "papa");
  }

  private void createProjectForProfessor(String title, String professor) {

    String professorId = authTestDao.get().getPersonId(professor);
    projectTestDao.get().insertProject(idGenerator.get().newId(), title, professorId);

  }

  private void loadAssistants() {
//    giveAssistantTo("pushkin", "stalin");
//    giveAssistantTo("pushkin", "esenin");
  }

  private void giveAssistantTo(String professor, String student) {

    String professorId = authTestDao.get().getPersonId(professor);
    String studentId = authTestDao.get().getPersonId(student);

    authTestDao.get().insertPersonAssistant(professorId, studentId);
  }

  private void loadRoles() {
    giveRoleToUser("mussabayev_bakitzhan", "PROFESSOR");
    giveRoleToUser("papa", "PROFESSOR");
    giveRoleToUser("zhansaya", "STUDENT");
    giveRoleToUser("tom", "STUDENT");
    giveRoleToUser("ulan", "STUDENT");
    giveRoleToUser("daniyar", "STUDENT");
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

    user("Adyrbek Zhansaya", "1799-06-06", "zhansaya");
    user("Zeinelkozha Tomiris", "1878-12-18", "tom");
    user("Zheniserov Ulan", "1899-03-17", "ulan");
    user("Asset Daniyar", "1895-09-21", "daniyar");
    user("Путин Владимир Владимирович", "1952-10-07", "putin");
    user("Назарбаев Нурсултан Абишевич", "1940-07-06", "papa");
    user("Менделеев Дмитрий Иванович", "1834-02-08", "mendeleev");
    user("Ломоносов Михаил Васильевич", "1711-11-19", "lomonosov");
    user("Бутлеров Александр Михайлович", "1828-09-15", "butlerov");
    user("Mussabayev Bakitzhan  ", "1956-09-15", "mussabayev_bakitzhan");

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
    authTestDao.get().updatePersonField(id, "email", "test@test.kz");
    authTestDao.get().updatePersonField(id, "title", "Title1");
    authTestDao.get().updatePersonField(id, "faculty", "IS");
    authTestDao.get().updatePersonField(id, "phone", "87782377330");
    if (fio.length > 2) {
      authTestDao.get().updatePersonField(id, "patronymic", fio[2]);
    }

  }

  private void add_can(String username, UserCan... cans) {
    for (UserCan can : cans) {
      authTestDao.get().upsert(can.name());
      authTestDao.get().personCan(username, can.name());
    }
  }
}
