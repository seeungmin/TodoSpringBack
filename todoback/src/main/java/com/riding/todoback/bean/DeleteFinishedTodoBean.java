package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.DeleteFinishedTodoDAOBean;
import com.riding.todoback.model.DTO.RequestFinishTodoDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteFinishedTodoBean {

    DeleteFinishedTodoDAOBean deleteFinishedTodoDAOBean;

    @Autowired
    public DeleteFinishedTodoBean(DeleteFinishedTodoDAOBean deleteFinishedTodoDAOBean) {
        this.deleteFinishedTodoDAOBean = deleteFinishedTodoDAOBean;
    }

    // 다 한 일 삭제
    public boolean exec(RequestFinishTodoDelete requestFinishTodoDelete){
        return deleteFinishedTodoDAOBean.exec(requestFinishTodoDelete);
    }
}
