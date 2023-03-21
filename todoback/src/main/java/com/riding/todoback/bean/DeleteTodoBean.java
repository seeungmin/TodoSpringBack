package com.riding.todoback.bean;

import com.riding.todoback.entity.TodoEntity;
import com.riding.todoback.repository.TodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteTodoBean {

    @Autowired
    TodoRepositoryJPA todoRepositoryJPA;

    // 할 일 삭제
    public boolean exec(long id){
        // 할일 데이터 받기
        TodoEntity todoEntity = todoRepositoryJPA.findById(id).get();

        // 받은 데이터 삭제
        todoRepositoryJPA.delete(todoEntity);
        return true;
    }
}
