package com.riding.todoback.bean.Small;

import com.riding.todoback.model.DTO.RequestBoardInput;
import com.riding.todoback.model.DTO.RequestTodoInput;
import com.riding.todoback.model.entity.BoardEntity;
import com.riding.todoback.model.entity.TodoEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class NewObjectDAOBean {

    public NewObjectDAOBean() {
    }

    public TodoEntity exec(Long id, RequestTodoInput requestTodoInput) {
        // 내용 받기
        String input = requestTodoInput.getContent();

        // 시간 생성
        LocalDateTime uTime = LocalDateTime.now();
        LocalDateTime mTime = LocalDateTime.now();

        // 데이터 저장
        return new TodoEntity(id, "1", input, uTime,mTime);
    }
}
