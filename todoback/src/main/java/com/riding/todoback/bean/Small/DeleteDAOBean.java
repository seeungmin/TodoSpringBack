package com.riding.todoback.bean.Small;

import com.riding.todoback.model.entity.TodoEntity;
import com.riding.todoback.repository.TodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteDAOBean {

    TodoRepositoryJPA todoRepositoryJPA;

    @Autowired
    public DeleteDAOBean(TodoRepositoryJPA todoRepositoryJPA) {
        this.todoRepositoryJPA = todoRepositoryJPA;
    }

    public void exec(TodoEntity todoEntity){
        todoRepositoryJPA.delete(todoEntity);
    }
}
