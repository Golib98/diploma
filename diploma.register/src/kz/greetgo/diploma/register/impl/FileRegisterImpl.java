package kz.greetgo.diploma.register.impl;

import java.lang.reflect.Field;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.model.FileHolder;
import kz.greetgo.diploma.controller.register.FileRegister;
import kz.greetgo.file_storage.FileDataReader;
import kz.greetgo.file_storage.FileStorage;
import kz.greetgo.file_storage.impl.DatabaseNotPrepared;
import kz.greetgo.file_storage.impl.FileStorageMonoDbLogic;
import kz.greetgo.file_storage.impl.MonoDbOperations;

@Bean
public class FileRegisterImpl implements FileRegister {

  public BeanGetter<FileStorage> fileStorage;

  @Override
  public String saveFile(FileHolder file) {

    fileStorage.get();

    try {
      Field monoDbOperations = FileStorageMonoDbLogic.class.getDeclaredField("monoDbOperations");
      monoDbOperations.setAccessible(true);
      Object obj = monoDbOperations.get(fileStorage.get());

      MonoDbOperations.class
        .getMethod("prepareDatabase", DatabaseNotPrepared.class)
        .invoke(obj, new DatabaseNotPrepared());
    } catch (Exception ignore) {
    }

    return fileStorage.get()
      .storing()
      .name(file.name)
      .data(file.data)
      .mimeType(file.contentType)
      .store();

  }

  @Override
  public FileDataReader getFile(String fileId) {
    return fileStorage.get().readOrNull(fileId);
  }
}
