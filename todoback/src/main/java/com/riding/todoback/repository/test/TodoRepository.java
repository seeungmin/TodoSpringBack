package com.riding.todoback.repository.test;

import com.riding.todoback.entity.TodoEntity;
import com.riding.todoback.repository.TodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepository {

    @Autowired
    TodoRepositoryJPA todoRepositoryJPA;

    public void save(TodoEntity todoEntity){
        todoRepositoryJPA.save(todoEntity);
    }
}
