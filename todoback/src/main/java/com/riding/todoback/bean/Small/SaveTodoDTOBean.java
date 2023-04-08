package com.riding.todoback.bean.Small;

import com.riding.todoback.entity.TodoEntity;
import com.riding.todoback.model.DTO.RequestTodoInput;
import com.riding.todoback.repository.TodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SaveTodoDTOBean {

    GenerateUniqueIdBean generateUniqueIdBean;
    TodoRepositoryJPA todoRepositoryJPA;

    @Autowired
    public SaveTodoDTOBean(GenerateUniqueIdBean generateUniqueIdBean, TodoRepositoryJPA todoRepositoryJPA) {
        this.generateUniqueIdBean = generateUniqueIdBean;
        this.todoRepositoryJPA = todoRepositoryJPA;
    }

    public long exec(RequestTodoInput requestTodoInput){

        // 아이디 생성
        long id = generateUniqueIdBean.exec();

        // 내용 받기
        String input = requestTodoInput.getContent();

        // 시간 생성
        LocalDateTime uTime = LocalDateTime.now();
        LocalDateTime mTime = LocalDateTime.now();

        // 데이터 저장
        TodoEntity todoEntity = new TodoEntity(id, "1", input, uTime,mTime);
        todoRepositoryJPA.save(todoEntity);
        return id;
    }
}
