package kz.greetgo.diploma.register.dao;

import java.util.List;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.diploma.controller.model.Blog;
import kz.greetgo.diploma.controller.model.TextPair;
import kz.greetgo.diploma.controller.model.University;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Bean
public interface DictDao {

  @Select("select id as key, title as value from university")
  List<TextPair> getUniversitiesDict();

  @Select("select * from university")
  List<University> getAllUni();

  @Insert("insert into blogs(title, article, imageid) values (#{x.title}, #{x.article}, #{x.imageId})")
  void save(@Param("x") Blog blogToSave);

  @Select("select * from blogs")
  List<Blog> getAllBlogs();

}
