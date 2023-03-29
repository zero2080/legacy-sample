package org.example.service;

import java.util.List;
import org.example.model.Todo;

public interface TodoService {
  List<Todo> findAll();
  Todo findById(int id);

  void save(Todo todo);
}
