package kz.greetgo.diploma.controller.model;

import java.util.Date;

public class Project {
  public String id;
  public String title;
  public String description;
  public Date updateDate;
  public Date publishedDate;
  public boolean isOpened;

  @Override
  public String toString() {
    return "Project{" +
      "id='" + id + '\'' +
      ", title='" + title + '\'' +
      ", description='" + description + '\'' +
      ", updateDate=" + updateDate +
      ", publishedDate=" + publishedDate +
      ", isOpened=" + isOpened +
      '}';
  }
}
