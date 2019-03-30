package kz.greetgo.diploma.register.util.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import javax.sql.DataSource;
import kz.greetgo.db.AbstractJdbcWithDataSource;
import kz.greetgo.db.TransactionManager;

public class JdbcDiploma extends AbstractJdbcWithDataSource {

  private final DataSource dataSource;
  private final TransactionManager transactionManager;

  public JdbcDiploma(DataSource dataSource, TransactionManager transactionManager) {
    this.dataSource = dataSource;
    this.transactionManager = transactionManager;
  }

  @Override
  protected DataSource getDataSource() {
    return dataSource;
  }

  @Override
  protected TransactionManager getTransactionManager() {
    return transactionManager;
  }


  public void queryWithConsumer(SQL sql, Consumer<ResultSet> consumer) {
    execute(con -> {
      try (PreparedStatement ps = con.prepareStatement(sql.compile())) {
        try (ResultSet rs = sql.applyParameter(ps).executeQuery()) {
          while (rs.next()) {
            consumer.accept(rs);
          }
        }
      }
      return null;
    });

  }

  public <T> T queryForObject(SQL sql, RowMapper<T> rowMapper) {
    List<T> result = queryForList(sql, rowMapper);
    return nullableSingleResult(result);
  }

  public <T> List<T> queryForList(SQL sql, RowMapper<T> rowMapper) {
    List<T> result = new ArrayList<>();
    this.execute(con -> {
      try (PreparedStatement ps = con.prepareStatement(sql.compile())) {
        try (ResultSet rs = sql.applyParameter(ps).executeQuery()) {
          while (rs.next()) {
            T record = rowMapper.mapRow(rs);
            result.add(record);
          }
        }
      }
      return null;
    });
    return result;
  }

  private <T> T nullableSingleResult(Collection<T> results) {
    if (results.isEmpty()) {
      return null;
    }
    if (results.size() > 1) {
      throw new IllegalArgumentException("Result more than 1 row");
    }
    return results.iterator().next();
  }

}
