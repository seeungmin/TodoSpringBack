package com.riding.todoback.bean;

import com.riding.todoback.entity.FinishedTodoEntity;
import com.riding.todoback.repository.FinishedTodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeleteFinishedTodoBean {

    @Autowired
    FinishedTodoRepositoryJPA finishedTodoRepositoryJPA;

    // 다 한 일 삭제
    public boolean exec(long id){
        // 다 한일 데이터 받기
        FinishedTodoEntity finishedTodoEntity = finishedTodoRepositoryJPA.findById(id).get();

        // 받은 데이터 삭제
        finishedTodoRepositoryJPA.delete(finishedTodoEntity);
        return true;
    }
}
