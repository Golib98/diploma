package kz.greetgo.diploma.register.test.dao;

import kz.greetgo.diploma.controller.model.University;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UniversityTestDao {

  @Select("insert into university(title, description, logo, mainimage) " +
    "values (#{uni.title}, #{uni.description}, #{uni.logo}, #{uni.mainImage}) returning id")
  String insUniversity(@Param("uni") University uni);
}
