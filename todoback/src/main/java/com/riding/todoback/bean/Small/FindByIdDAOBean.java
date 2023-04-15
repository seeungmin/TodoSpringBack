package com.riding.todoback.bean.Small;

import com.riding.todoback.model.DTO.RequestFinishTodoDelete;
import com.riding.todoback.model.entity.FinishedTodoEntity;
import com.riding.todoback.model.entity.TodoEntity;
import com.riding.todoback.repository.FinishedTodoRepositoryJPA;
import com.riding.todoback.repository.TodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindByIdDAOBean {

    TodoRepositoryJPA todoRepositoryJPA;
    FinishedTodoRepositoryJPA finishedTodoRepositoryJPA;
    @Autowired
    public FindByIdDAOBean(TodoRepositoryJPA todoRepositoryJPA, FinishedTodoRepositoryJPA finishedTodoRepositoryJPA) {
        this.todoRepositoryJPA = todoRepositoryJPA;
        this.finishedTodoRepositoryJPA = finishedTodoRepositoryJPA;
    }

    // 아이디로 할 일 객체 찾기
    public TodoEntity exec(long id){
        return todoRepositoryJPA.findById(id).get();
    }

    public FinishedTodoEntity exec(RequestFinishTodoDelete requestFinishTodoDelete){
        long id = requestFinishTodoDelete.getId();

        return finishedTodoRepositoryJPA.findById(id).get();
    }
}
