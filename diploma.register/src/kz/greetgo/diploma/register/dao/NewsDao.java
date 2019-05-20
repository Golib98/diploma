package kz.greetgo.diploma.register.dao;

import java.util.List;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.diploma.controller.model.News;
import org.apache.ibatis.annotations.Select;

@Bean
public interface NewsDao {

  @Select("select id, title, body, publishedat, publishedby, image  from news")
  List<News> getAll();

}
