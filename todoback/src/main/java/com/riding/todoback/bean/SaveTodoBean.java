package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.GenerateUniqueIdBean;
import com.riding.todoback.bean.Small.SaveTodoDTOBean;
import com.riding.todoback.entity.TodoEntity;
import com.riding.todoback.model.DTO.RequestTodoInput;
import com.riding.todoback.repository.TodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SaveTodoBean {

    @Autowired
    SaveTodoDTOBean saveTodoDTOBean;

    // 할 일 데이터 저장
    public long exec(RequestTodoInput requestTodoInput){
        return saveTodoDTOBean.exec(requestTodoInput);
    }
}
