package com.riding.todoback.bean.Small;

import com.riding.todoback.model.entity.FinishedTodoEntity;
import com.riding.todoback.model.entity.TodoEntity;
import com.riding.todoback.repository.FinishedTodoRepositoryJPA;
import com.riding.todoback.repository.TodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SaveDAOBean {

    TodoRepositoryJPA todoRepositoryJPA;
    FinishedTodoRepositoryJPA finishedTodoRepositoryJPA;

    @Autowired
    public SaveDAOBean(TodoRepositoryJPA todoRepositoryJPA, FinishedTodoRepositoryJPA finishedTodoRepositoryJPA) {
        this.todoRepositoryJPA = todoRepositoryJPA;
        this.finishedTodoRepositoryJPA = finishedTodoRepositoryJPA;
    }

    // 할 일 저장하기
    public void exec(TodoEntity todoEntity){
        todoRepositoryJPA.save(todoEntity);
    }


    // 다 한 일 저장하기
    public void exec(FinishedTodoEntity finishedTodoEntity){
        finishedTodoRepositoryJPA.save(finishedTodoEntity);
    }

}
