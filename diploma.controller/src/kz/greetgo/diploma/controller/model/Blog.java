package kz.greetgo.diploma.controller.model;

public class Blog {
  
  public String id;
  public String title;
  public String article;
  public String imageId;


  @Override
  public String toString() {
    return "Blog{" +
      "id='" + id + '\'' +
      ", title='" + title + '\'' +
      ", article='" + article + '\'' +
      ", imagesId='" + imageId + '\'' +
      '}';
  }
}
