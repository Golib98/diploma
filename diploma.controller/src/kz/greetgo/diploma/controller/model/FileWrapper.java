package kz.greetgo.diploma.controller.model;


public class FileWrapper {
  public String name;
  public String id;

  //The following code would be not removed after regenerating
  ///LEAVE_FURTHER


  public FileWrapper(String saveFile, String fileName) {
    this.id = saveFile;
    this.name = fileName;
  }

  public FileWrapper() {
  }
}
