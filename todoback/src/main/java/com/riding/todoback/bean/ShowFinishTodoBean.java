package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.ShowFinishTodoDAOBean;
import com.riding.todoback.model.DTO.RequestPreviewFinishTodoAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowFinishTodoBean {
    ShowFinishTodoDAOBean showFinishTodoDAOBean;

    @Autowired
    public ShowFinishTodoBean(ShowFinishTodoDAOBean showFinishTodoDAOBean) {
        this.showFinishTodoDAOBean = showFinishTodoDAOBean;
    }

    public List<RequestPreviewFinishTodoAll> exec(){
        return showFinishTodoDAOBean.exec();
    }
}
