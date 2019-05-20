package kz.greetgo.diploma.register.test.dao.postgres;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.diploma.controller.model.News;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

@Bean
public interface NewsTestDao {

  @Insert("insert into news(title, body, publishedat, publishedBy, image) " +
    "values (#{news.title}, #{news.body}, now(), #{news.publishedBy}, #{news.image})")
  void insNews(@Param("news") News news);

}
