package kz.greetgo.diploma.register.beans.all;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.file_storage.FileStorage;
import kz.greetgo.file_storage.impl.FileStorageBuilder;
import kz.greetgo.file_storage.impl.MimeTypeBaseConfigurator;

@Bean
public class FStorage {

  public BeanGetter<DbSessionFactory> dbSessionFactory;

  @Bean
  public FileStorage fileStorage() {

    return FileStorageBuilder
      .newBuilder()
      .configureFrom(MimeTypeBaseConfigurator.get())
      .mandatoryMimeType(true)
      .mandatoryName(true)
      .inDb(dbSessionFactory.get().getDataSource())
      .build();

  }

}

