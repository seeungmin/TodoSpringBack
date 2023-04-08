package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.SaveFinishedTodoNewDAOBean;
import com.riding.todoback.model.DTO.RequestFinishTodoInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveFinishedTodoBean {

    SaveFinishedTodoNewDAOBean saveFinishedTodoNewDAOBean;

    @Autowired
    public SaveFinishedTodoBean(SaveFinishedTodoNewDAOBean saveFinishedTodoNewDAOBean) {
        this.saveFinishedTodoNewDAOBean = saveFinishedTodoNewDAOBean;
    }

    // 다 한일 데이터 저장
    public void exec(RequestFinishTodoInput requestFinishTodoInput){
        saveFinishedTodoNewDAOBean.exec(requestFinishTodoInput);
    }

}
