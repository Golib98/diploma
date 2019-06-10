package kz.greetgo.diploma.register.impl;

import java.util.ArrayList;
import java.util.List;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.model.Blog;
import kz.greetgo.diploma.controller.model.RegistrationDict;
import kz.greetgo.diploma.controller.model.TextPair;
import kz.greetgo.diploma.controller.model.University;
import kz.greetgo.diploma.controller.register.DictRegister;
import kz.greetgo.diploma.register.dao.DictDao;
import kz.greetgo.email.Email;
import kz.greetgo.email.EmailSender;
import kz.greetgo.file_storage.FileStorage;

@Bean
public class DictRegisterImpl implements DictRegister {

  public BeanGetter<DictDao> dictDao;

  @Override
  public RegistrationDict getRegistrationDict() {

    RegistrationDict ret = new RegistrationDict();

    ret.universities = dictDao.get().getUniversitiesDict();

    ret.faculties = new ArrayList<>();
    ret.faculties.add(new TextPair("123", "RET"));
    ret.faculties.add(new TextPair("123", "IS"));

    ret.titles = new ArrayList<>();
    ret.titles.add(new TextPair("123", "Professor"));
    ret.titles.add(new TextPair("124", "Director"));
    ret.titles.add(new TextPair("124", "Lecturer"));
    ret.titles.add(new TextPair("124", "Senior-lecturer"));

    return ret;

  }

  public BeanGetter<FileStorage> fileStorage;

  public void initFS() {
    fileStorage.get().storing()
      .data(new byte[10])
      .name("Asdf")
      .mimeType("application/java-archive")
      .store();

  }

  public BeanGetter<EmailSender> emailSender;

  @Override
  public void sendMail() {
    Email email = new Email();
    email.setTo("golibjon98@gmail.com");
    email.setFrom("golibjon98@gmail.com");
    email.setSubject("theme");
    email.setBody("body");

    emailSender.get().send(email);
  }

  @Override
  public List<University> getUniList() {

    List<University> ret =  dictDao.get().getAllUni();

    return ret;
  }

  @Override
  public void save(Blog blogToSave) {

    dictDao.get().save(blogToSave);    
    
  }

  @Override
  public List<Blog> allBlogs() {

    return dictDao.get().getAllBlogs();
  }

}
