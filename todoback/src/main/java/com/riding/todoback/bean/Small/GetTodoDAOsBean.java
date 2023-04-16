package com.riding.todoback.bean.Small;

import com.riding.todoback.model.entity.TodoEntity;
import com.riding.todoback.repository.TodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetTodoDAOsBean {
    TodoRepositoryJPA todoRepositoryJPA;

    @Autowired
    public GetTodoDAOsBean(TodoRepositoryJPA todoRepositoryJPA) {
        this.todoRepositoryJPA = todoRepositoryJPA;
    }

    // 할 일 전부 찾아서 반환
    public List<TodoEntity> exec(){
        return new ArrayList<>(todoRepositoryJPA.findAll());
    }
}
