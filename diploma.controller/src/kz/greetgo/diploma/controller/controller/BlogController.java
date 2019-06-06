package kz.greetgo.diploma.controller.controller;

import java.util.List;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.model.Blog;
import kz.greetgo.diploma.controller.register.DictRegister;
import kz.greetgo.diploma.controller.util.Controller;
import kz.greetgo.mvc.annotations.Json;
import kz.greetgo.mvc.annotations.Par;
import kz.greetgo.mvc.annotations.ToJson;
import kz.greetgo.mvc.annotations.on_methods.ControllerPrefix;
import kz.greetgo.mvc.annotations.on_methods.OnGet;
import kz.greetgo.mvc.annotations.on_methods.OnPost;

@Bean
@ControllerPrefix("/blog")
public class BlogController implements Controller {

  public BeanGetter<DictRegister> dictRegister;


  @OnPost("/save")
  public void save(@Json @Par("blog") Blog blogToSave) {


    dictRegister.get().save(blogToSave);

  }

  @OnGet("/all")
  @ToJson
  public List<Blog> all() {
    return dictRegister.get().allBlogs();
  }


}
