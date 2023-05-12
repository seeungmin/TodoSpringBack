package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.*;
import com.riding.todoback.model.DTO.RequestFinishTodoInput;
import com.riding.todoback.model.entity.FinishedTodoEntity;
import com.riding.todoback.model.entity.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveFinishedTodoBean {

    GetTodoDAOBean getTodoDAOBean;
    NewObjectDAOBean newObjectDAOBean;
    SaveDAOBean saveDAOBean;
    DeleteDAOBean deleteDAOBean;

    @Autowired
    public SaveFinishedTodoBean(GetTodoDAOBean getTodoDAOBean, NewObjectDAOBean newObjectDAOBean, SaveDAOBean saveDAOBean, DeleteDAOBean deleteDAOBean) {
        this.getTodoDAOBean = getTodoDAOBean;
        this.newObjectDAOBean = newObjectDAOBean;
        this.saveDAOBean = saveDAOBean;
        this.deleteDAOBean = deleteDAOBean;
    }

    // 다 한일 데이터 저장
    public Long exec(RequestFinishTodoInput requestFinishTodoInput){

        // 할 일아이디 받기
        long id = requestFinishTodoInput.getId();

        // 아이디로 할 일 객체 받아오기
        TodoEntity todoEntity = getTodoDAOBean.exec(id);

        // 다 한 일 저장할 객체 생성
        FinishedTodoEntity finishedTodoEntity = newObjectDAOBean.exec(todoEntity);

        // 데이터 저장
        saveDAOBean.exec(finishedTodoEntity);

        // 다 한 일로 옮긴 할 일 삭제
        deleteDAOBean.exec(todoEntity);

        return id;
    }

}
