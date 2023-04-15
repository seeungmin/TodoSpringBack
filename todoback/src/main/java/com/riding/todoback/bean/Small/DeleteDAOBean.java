package com.riding.todoback.bean.Small;

import com.riding.todoback.model.entity.FinishedTodoEntity;
import com.riding.todoback.model.entity.TodoEntity;
import com.riding.todoback.repository.FinishedTodoRepositoryJPA;
import com.riding.todoback.repository.TodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteDAOBean {

    TodoRepositoryJPA todoRepositoryJPA;
    FinishedTodoRepositoryJPA finishedTodoRepositoryJPA;

    @Autowired
    public DeleteDAOBean(TodoRepositoryJPA todoRepositoryJPA, FinishedTodoRepositoryJPA finishedTodoRepositoryJPA) {
        this.todoRepositoryJPA = todoRepositoryJPA;
        this.finishedTodoRepositoryJPA = finishedTodoRepositoryJPA;
    }

    // 할 일 삭제
    public void exec(TodoEntity todoEntity){
        todoRepositoryJPA.delete(todoEntity);
    }

    // 다 한 일 삭제
    public void exec(FinishedTodoEntity finishedTodoEntity){
        finishedTodoRepositoryJPA.delete(finishedTodoEntity);
    }
}
