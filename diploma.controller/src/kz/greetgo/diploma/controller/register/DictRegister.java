package kz.greetgo.diploma.controller.register;

import java.util.List;
import kz.greetgo.diploma.controller.model.Blog;
import kz.greetgo.diploma.controller.model.RegistrationDict;
import kz.greetgo.diploma.controller.model.University;

public interface DictRegister {
  RegistrationDict getRegistrationDict();

  void initFS();

  void sendMail();

  List<University> getUniList();

  void save(Blog blogToSave);

  List<Blog> allBlogs();
}
