package kz.greetgo.diploma.controller.model;

public class ProfessorInfo {

  public University university;
  public String fio;
  public String title;
  public String email;
  public String phone;
  public String faculty;
  public String degree;
  public String sphere;


  @Override
  public String toString() {
    return "ProfessorInfo{" +
      "university=" + university +
      ", fio='" + fio + '\'' +
      ", title='" + title + '\'' +
      ", email='" + email + '\'' +
      ", phone='" + phone + '\'' +
      ", faculty='" + faculty + '\'' +
      ", degree='" + degree + '\'' +
      ", sphere='" + sphere + '\'' +
      '}';
  }
}
