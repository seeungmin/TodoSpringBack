package com.riding.todoback.bean.Small;

import com.riding.todoback.model.entity.FinishedTodoEntity;
import com.riding.todoback.repository.FinishedTodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetFinishTodoDAOsBean {
    FinishedTodoRepositoryJPA finishedTodoRepositoryJPA;

    @Autowired
    public GetFinishTodoDAOsBean(FinishedTodoRepositoryJPA finishedTodoRepositoryJPA) {
        this.finishedTodoRepositoryJPA = finishedTodoRepositoryJPA;
    }

    // 다 한일 객체 전부 찾기
    public List<FinishedTodoEntity> exec(){
        return new ArrayList<>(finishedTodoRepositoryJPA.findByMemberId("1"));
    }
}
