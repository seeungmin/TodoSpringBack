package com.riding.todoback.bean.Small;

import com.riding.todoback.model.entity.FinishedTodoEntity;
import com.riding.todoback.repository.FinishedTodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetFinishTodoDAOBean {
    FinishedTodoRepositoryJPA finishedTodoRepositoryJPA;

    @Autowired
    public GetFinishTodoDAOBean(FinishedTodoRepositoryJPA finishedTodoRepositoryJPA) {
        this.finishedTodoRepositoryJPA = finishedTodoRepositoryJPA;
    }

    // 아이디로 다 한 일 찾기
    public FinishedTodoEntity exec(Long id){
        return finishedTodoRepositoryJPA.findById(id).get();
    }
}
