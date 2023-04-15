package com.riding.todoback.bean.Small;

import com.riding.todoback.model.DTO.RequestTodoInput;
import com.riding.todoback.model.entity.FinishedTodoEntity;
import com.riding.todoback.model.entity.TodoEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class NewObjectDAOBean {

    // 할 일 객체 생성
    public TodoEntity exec(Long id, RequestTodoInput requestTodoInput) {
        // 내용 받기
        String input = requestTodoInput.getContent();

        // 시간 생성
        LocalDateTime uTime = LocalDateTime.now();
        LocalDateTime mTime = LocalDateTime.now();

        // 데이터 저장
        return new TodoEntity(id, "1", input, uTime,mTime);
    }

    // 다 한 일 객체 생성
    public FinishedTodoEntity exec(TodoEntity todoEntity){

        // 내용 받기
        FinishedTodoEntity finishedTodoEntity = new FinishedTodoEntity();
        finishedTodoEntity.setId(todoEntity.getId());
        finishedTodoEntity.setMember_Id(todoEntity.getMember_Id());
        finishedTodoEntity.setContent(todoEntity.getContent());
        finishedTodoEntity.setUploadTime(todoEntity.getUploadTime());
        finishedTodoEntity.setCompletionTime(LocalDateTime.now());

        return finishedTodoEntity;
    }
}
