package kz.greetgo.diploma.register.impl;

import java.util.ArrayList;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.model.RegistrationDict;
import kz.greetgo.diploma.controller.model.TextPair;
import kz.greetgo.diploma.controller.register.DictRegister;
import kz.greetgo.diploma.register.dao.DictDao;

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
    ret.titles.add(new TextPair("123", "Title1"));
    ret.titles.add(new TextPair("123", "Title2"));

    return ret;
    
  }
}
