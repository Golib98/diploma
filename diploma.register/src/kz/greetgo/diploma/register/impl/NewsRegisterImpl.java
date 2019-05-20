package kz.greetgo.diploma.register.impl;

import java.util.List;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.model.News;
import kz.greetgo.diploma.controller.register.NewsRegister;
import kz.greetgo.diploma.register.dao.NewsDao;

@Bean
public class NewsRegisterImpl implements NewsRegister {

  public BeanGetter<NewsDao> newsDao;
  
  @Override
  public List<News> getAll() {
    
    return newsDao.get().getAll();
    
  }
}
