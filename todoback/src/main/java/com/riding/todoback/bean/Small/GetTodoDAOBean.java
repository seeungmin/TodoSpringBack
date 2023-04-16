package com.riding.todoback.bean.Small;

import com.riding.todoback.model.entity.TodoEntity;
import com.riding.todoback.repository.TodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetTodoDAOBean {
    TodoRepositoryJPA todoRepositoryJPA;

    @Autowired
    public GetTodoDAOBean(TodoRepositoryJPA todoRepositoryJPA) {
        this.todoRepositoryJPA = todoRepositoryJPA;
    }

    // 아이디로 할 일 찾기
    public TodoEntity exec(Long id){
        return todoRepositoryJPA.findById(id).get();
    }
}
