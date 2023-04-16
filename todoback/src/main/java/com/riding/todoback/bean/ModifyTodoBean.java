package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.GetTodoDAOBean;
import com.riding.todoback.bean.Small.ModifyObjectDAOBean;
import com.riding.todoback.bean.Small.SaveDAOBean;
import com.riding.todoback.model.DTO.RequestTodoModify;
import com.riding.todoback.model.entity.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ModifyTodoBean {
    GetTodoDAOBean getTodoDAOBean;
    ModifyObjectDAOBean modifyObjectDAOBean;
    SaveDAOBean saveDAOBean;

    @Autowired
    public ModifyTodoBean(GetTodoDAOBean getTodoDAOBean, ModifyObjectDAOBean modifyObjectDAOBean, SaveDAOBean saveDAOBean) {
        this.getTodoDAOBean = getTodoDAOBean;
        this.modifyObjectDAOBean = modifyObjectDAOBean;
        this.saveDAOBean = saveDAOBean;
    }

    // 할 일 데이터 수정
    public Long exec(RequestTodoModify requestTodoModify) {
        // 할 일아이디 받기
        long id = requestTodoModify.getId();

        // 아이디로 수정할 할 일 찾기
        TodoEntity todoEntity = getTodoDAOBean.exec(id);

        // 할 일 수정
        TodoEntity modifyTodoEntity = modifyObjectDAOBean.exec(todoEntity, requestTodoModify);

        // 데이터 저장
        saveDAOBean.exec(modifyTodoEntity);

        return id;
    }

}
