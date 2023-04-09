package com.riding.todoback.bean.Small;

import com.riding.todoback.entity.TodoEntity;
import com.riding.todoback.model.DTO.RequestFinishTodoInput;
import com.riding.todoback.model.DTO.RequestTodoDelete;
import com.riding.todoback.repository.TodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeleteTodoDAOBean {

    TodoRepositoryJPA todoRepositoryJPA;

    @Autowired
    public DeleteTodoDAOBean(TodoRepositoryJPA todoRepositoryJPA) {
        this.todoRepositoryJPA = todoRepositoryJPA;
    }

    public void exec(Optional<TodoEntity> data){
        // 할일 데이터 받기
        TodoEntity todoEntity = data.get();

        // 받은 데이터 삭제
        todoRepositoryJPA.delete(todoEntity);
    }

    public boolean exec(RequestTodoDelete requestTodoDelete){
        // 고유 id 찾기
        long id = requestTodoDelete.getId();

        // 할일 데이터 받기
        TodoEntity todoEntity = todoRepositoryJPA.findById(id).get();

        // 받은 데이터 삭제
        if(todoEntity == null)
            return false;
        todoRepositoryJPA.delete(todoEntity);
        return true;
    }
}
