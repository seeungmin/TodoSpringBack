package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.DeleteDAOBean;
import com.riding.todoback.bean.Small.FindByIdDAOBean;
import com.riding.todoback.model.DTO.RequestFinishTodoDelete;
import com.riding.todoback.model.entity.FinishedTodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteFinishedTodoBean {

    FindByIdDAOBean findByIdDAOBean;
    DeleteDAOBean deleteDAOBean;

    @Autowired
    public DeleteFinishedTodoBean(FindByIdDAOBean findByIdDAOBean, DeleteDAOBean deleteDAOBean) {
        this.findByIdDAOBean = findByIdDAOBean;
        this.deleteDAOBean = deleteDAOBean;
    }

    // 다 한 일 삭제
    public Long exec(RequestFinishTodoDelete requestFinishTodoDelete){

        // 아이디로 삭제할 할 일 찾기
        FinishedTodoEntity finishedTodoEntity = findByIdDAOBean.exec(requestFinishTodoDelete);

        // 할 일 삭제
        deleteDAOBean.exec(finishedTodoEntity);

        return requestFinishTodoDelete.getId();
    }
}
