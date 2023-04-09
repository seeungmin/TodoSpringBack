package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.ModifyTodoDAOBean;
import com.riding.todoback.model.DTO.RequestTodoModify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ModifyTodoBean {
    ModifyTodoDAOBean modifyTodoDAOBean;

    @Autowired
    public ModifyTodoBean(ModifyTodoDAOBean modifyTodoDAOBean) {
        this.modifyTodoDAOBean = modifyTodoDAOBean;
    }

    // 할 일 데이터 수정
    public boolean exec(RequestTodoModify requestTodoModify){
        return modifyTodoDAOBean.exec(requestTodoModify);
    }

}
