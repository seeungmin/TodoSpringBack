package com.riding.todoback.bean.Small;

import com.riding.todoback.model.entity.TodoEntity;
import com.riding.todoback.model.DTO.RequestTodoInput;
import com.riding.todoback.repository.TodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SaveDAOBean {

    TodoRepositoryJPA todoRepositoryJPA;

    @Autowired
    public SaveDAOBean(TodoRepositoryJPA todoRepositoryJPA) {
        this.todoRepositoryJPA = todoRepositoryJPA;
    }

    // 할 일 저장하기
    public void exec(TodoEntity todoEntity){
        todoRepositoryJPA.save(todoEntity);
    }

}
