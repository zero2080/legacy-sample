package org.example.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.example.model.Todo;
import org.example.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class MainController {

  @Autowired
  private TodoService service;

  private static final Logger log = LoggerFactory.getLogger(MainController.class);

  @RequestMapping(method = RequestMethod.GET, value = "/",produces = MediaType.TEXT_HTML_VALUE)
  public String getMain(Model model) {
    model.addAttribute("data", "Hello World");
    model.addAttribute("name","오범수");
    return "index";
  }

  @RequestMapping(method=RequestMethod.GET,value="/",produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody List<Todo> findAll(HttpServletRequest request){
    return service.findAll();
  }

  @RequestMapping(method=RequestMethod.GET,value="/id/{id}")
  @ResponseBody
  public Todo findOne(@PathVariable int id){
    return service.findById(id);
  }

  @RequestMapping(method = RequestMethod.POST,value="/",consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public void save(@RequestBody Todo todo){
    service.save(todo);
  }
}
