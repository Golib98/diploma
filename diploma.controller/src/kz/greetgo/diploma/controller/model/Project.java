package kz.greetgo.diploma.controller.model;

import java.util.Date;
import java.util.List;

public class Project {
  public String id;
  public String title;
  public String description;
  public String author;
  public Date updateDate;
  public Date deadline;
  public Date publishedDate;
  public String files;
  public String requirements;
  public String suggestions;
  public String link;
  public List<FileWrapper> fileIds;
  public boolean isOpened;
  public boolean isResponded;
  public String sphere;
}
