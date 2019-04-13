package kz.greetgo.diploma.controller.register;

import kz.greetgo.diploma.controller.model.FileHolder;
import kz.greetgo.file_storage.FileDataReader;

public interface FileRegister {

  String saveFile(FileHolder file);

  FileDataReader getFile(String fileId);
}
