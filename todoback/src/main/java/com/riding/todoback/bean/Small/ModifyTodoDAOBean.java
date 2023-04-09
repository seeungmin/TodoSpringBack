package com.riding.todoback.bean.Small;

import com.riding.todoback.entity.TodoEntity;
import com.riding.todoback.model.DTO.RequestTodoModify;
import com.riding.todoback.repository.TodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ModifyTodoDAOBean {

    TodoRepositoryJPA todoRepositoryJPA;

    @Autowired
    public ModifyTodoDAOBean(TodoRepositoryJPA todoRepositoryJPA) {
        this.todoRepositoryJPA = todoRepositoryJPA;
    }

    public boolean exec(RequestTodoModify requestTodoModify){

        long id = requestTodoModify.getId();
        String content = requestTodoModify.getContent();

        // 아이디로 수정할 할 일 찾기
        TodoEntity todoEntity = todoRepositoryJPA.findById(id).get();

        // 새로 받을 내용 작성
        todoEntity.setContent(content);
        todoEntity.setModifyTime(LocalDateTime.now());

        // 새로운 데이터 기존 아이디에 저장
        if(todoRepositoryJPA.save(todoEntity) == null)
            return false;
        return true;
    }

}
