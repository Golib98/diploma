package kz.greetgo.diploma.register.test.dao;

import org.apache.ibatis.annotations.Select;

public interface UniversityTestDao {

  @Select("insert into university(title) values (#{title}) returning id")
  String insUniversity(String title);
}
