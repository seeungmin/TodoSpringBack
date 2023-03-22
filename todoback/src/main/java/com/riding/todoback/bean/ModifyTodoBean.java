package com.riding.todoback.bean;

import com.riding.todoback.entity.TodoEntity;
import com.riding.todoback.repository.TodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ModifyTodoBean {

    @Autowired
    TodoRepositoryJPA todoRepositoryJPA;

    // 할 일 데이터 수정
    public boolean exec(long id, String content){

        // 아이디로 수정할 할 일 찾기
        TodoEntity todoEntity = todoRepositoryJPA.findById(id).get();

        // 새로 받을 내용 작성
        todoEntity.setContent(content);
        todoEntity.setUploadTime(LocalDateTime.now());

        // 새로운 데이터 기존 아이디에 저장
        todoRepositoryJPA.save(todoEntity);
        return true;
    }

}
