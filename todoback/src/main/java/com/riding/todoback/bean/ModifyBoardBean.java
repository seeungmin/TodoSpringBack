package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.ModifyBoardDAOBean;
import com.riding.todoback.model.DTO.RequestBoardModify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModifyBoardBean {
    ModifyBoardDAOBean modifyBoardDAOBean;

    @Autowired
    public ModifyBoardBean(ModifyBoardDAOBean modifyBoardDAOBean) {
        this.modifyBoardDAOBean = modifyBoardDAOBean;
    }

    public boolean exec(RequestBoardModify requestBoardModify){
        return modifyBoardDAOBean.exec(requestBoardModify);
    }
}
