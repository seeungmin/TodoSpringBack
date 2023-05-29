package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.CheckUserIdDAOBean;
import com.riding.todoback.bean.Small.DeleteDAOBean;
import com.riding.todoback.bean.Small.GetTodoDAOBean;
import com.riding.todoback.model.DTO.RequestTodoDelete;
import com.riding.todoback.model.entity.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteTodoBean {

    GetTodoDAOBean getTodoDAOBean;
    DeleteDAOBean deleteDAOBean;
    CheckUserIdDAOBean checkUserIdDAOBean;

    @Autowired
    public DeleteTodoBean(GetTodoDAOBean getTodoDAOBean, DeleteDAOBean deleteDAOBean, CheckUserIdDAOBean checkUserIdDAOBean) {
        this.getTodoDAOBean = getTodoDAOBean;
        this.deleteDAOBean = deleteDAOBean;
        this.checkUserIdDAOBean = checkUserIdDAOBean;
    }

    // 할 일 삭제
    public Long exec(RequestTodoDelete requestTodoDelete){
        // 할 일 id 찾기
        long id = requestTodoDelete.getId();

        // 아이디로 삭제할 할 일 찾기
        TodoEntity todoEntity = getTodoDAOBean.exec(id);

        // 삭제할 할 일이 해당되는 아이디가 맞는지 확인
        if(checkUserIdDAOBean.exec(todoEntity, requestTodoDelete) == false)
            return null;

        // 할 일 삭제
        deleteDAOBean.exec(todoEntity);

        return id;
    }
}
