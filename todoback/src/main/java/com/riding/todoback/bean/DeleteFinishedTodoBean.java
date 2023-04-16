package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.DeleteDAOBean;
import com.riding.todoback.bean.Small.GetFinishTodoDAOBean;
import com.riding.todoback.model.DTO.RequestFinishTodoDelete;
import com.riding.todoback.model.entity.FinishedTodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteFinishedTodoBean {

    GetFinishTodoDAOBean getFinishTodoDAOBean;
    DeleteDAOBean deleteDAOBean;

    @Autowired
    public DeleteFinishedTodoBean(GetFinishTodoDAOBean getFinishTodoDAOBean, DeleteDAOBean deleteDAOBean) {
        this.getFinishTodoDAOBean = getFinishTodoDAOBean;
        this.deleteDAOBean = deleteDAOBean;
    }

    // 다 한 일 삭제
    public Long exec(RequestFinishTodoDelete requestFinishTodoDelete){
        // 아이디 찾기
        Long id = requestFinishTodoDelete.getId();;

        // 다 한일 객체 받기
        FinishedTodoEntity finishedTodoEntity = getFinishTodoDAOBean.exec(id);

        // 받은 데이터 삭제
       deleteDAOBean.exec(finishedTodoEntity);

       return requestFinishTodoDelete.getId();
    }
}
