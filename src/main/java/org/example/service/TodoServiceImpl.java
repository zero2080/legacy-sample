package org.example.service;

import java.util.List;
import org.example.model.Todo;
import org.example.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService{

  @Autowired
  private TodoRepository repository;

  public List<Todo> findAll(){
    return repository.findAll();
  }

  public Todo findById(int id){
    Todo todo = repository.findById(id);
    return todo;
  }

  public void save(Todo todo){
    repository.save(todo);
  }

  public void delete(int id) {
    repository.delete(id);
  }

}
