package org.example.repository;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.example.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepository {

  @Autowired
  private SqlSession sessionTemplate;
  public List<Todo> findAll(){
    return sessionTemplate.selectList("findAll");
  }

  public Todo findById(int id) {
    return sessionTemplate.selectOne("findById",id);
  }

  public void save(Todo todo) {
    sessionTemplate.insert("save",todo);
  }

  public void delete(int id) {
    sessionTemplate.delete("delete",id);
  }
}
