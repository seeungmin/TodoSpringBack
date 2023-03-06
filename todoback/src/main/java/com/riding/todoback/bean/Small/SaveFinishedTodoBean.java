package com.riding.todoback.bean.Small;

import com.riding.todoback.bean.Small.GenerateUniqueIdBean;
import com.riding.todoback.entity.FinishedTodoEntity;
import com.riding.todoback.repository.FinishedTodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SaveFinishedTodoBean {

    FinishedTodoRepositoryJPA finishedTodoRepositoryJPA;
    GenerateUniqueIdBean generateUniqueIdBean;

    @Autowired
    public SaveFinishedTodoBean(FinishedTodoRepositoryJPA finishedTodoRepositoryJPA, GenerateUniqueIdBean generateUniqueIdBean) {
        this.finishedTodoRepositoryJPA = finishedTodoRepositoryJPA;
        this.generateUniqueIdBean = generateUniqueIdBean;
    }

    // 다 한일 데이터 저장
    public void exec(String input){

        // 아이디 생성
        long id = generateUniqueIdBean.exec();

        // 시간 생성
        LocalDateTime time = LocalDateTime.now();

        // 데이터 저장
        FinishedTodoEntity finishedTodoEntity = new FinishedTodoEntity(id, input, time);
        finishedTodoRepositoryJPA.save(finishedTodoEntity);
    }
}
