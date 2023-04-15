package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.DeleteDAOBean;
import com.riding.todoback.bean.Small.FindByIdDAOBean;
import com.riding.todoback.model.DTO.RequestFinishTodoDelete;
import com.riding.todoback.model.entity.FinishedTodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteFinishedTodoBean {

    DeleteDAOBean deleteDAOBean;
    FindByIdDAOBean findByIdDAOBean;

    @Autowired
    public DeleteFinishedTodoBean(DeleteDAOBean deleteDAOBean, FindByIdDAOBean findByIdDAOBean) {
        this.deleteDAOBean = deleteDAOBean;
        this.findByIdDAOBean = findByIdDAOBean;
    }

    // 다 한 일 삭제
    public Long exec(RequestFinishTodoDelete requestFinishTodoDelete){

        // 다 한일 객체 받기
        FinishedTodoEntity finishedTodoEntity = findByIdDAOBean.exec(requestFinishTodoDelete);

        // 받은 데이터 삭제
       deleteDAOBean.exec(finishedTodoEntity);

       return requestFinishTodoDelete.getId();
    }
}
