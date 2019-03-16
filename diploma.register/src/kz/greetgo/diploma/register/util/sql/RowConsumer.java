package kz.greetgo.diploma.register.util.sql;

import java.sql.ResultSet;

public interface RowConsumer<T> {

  void accept(ResultSet rs);

}
