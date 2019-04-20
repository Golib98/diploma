package kz.greetgo.diploma.register.dao;

import java.util.List;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.diploma.controller.model.TextPair;
import org.apache.ibatis.annotations.Select;

@Bean
public interface DictDao {

  @Select("select id as key, title as value from university")
  List<TextPair> getUniversitiesDict();
}
