package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.DeleteTodoDAOBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteTodoBean {

    DeleteTodoDAOBean deleteTodoDAOBean;

    @Autowired
    public DeleteTodoBean(DeleteTodoDAOBean deleteTodoDAOBean) {
        this.deleteTodoDAOBean = deleteTodoDAOBean;
    }

    // 할 일 삭제
    public boolean exec(long id){
        return deleteTodoDAOBean.exec(id);
    }
}
