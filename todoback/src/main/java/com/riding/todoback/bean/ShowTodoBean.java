package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.ShowTodoAllDAOBean;
import com.riding.todoback.model.DTO.RequestPreviewTodoAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowTodoBean {

    ShowTodoAllDAOBean showTodoAllDAOBean;

    @Autowired
    public ShowTodoBean(ShowTodoAllDAOBean showTodoAllDAOBean) {
        this.showTodoAllDAOBean = showTodoAllDAOBean;
    }

    public List<RequestPreviewTodoAll> exec(){
        return showTodoAllDAOBean.exec();
    }
}
