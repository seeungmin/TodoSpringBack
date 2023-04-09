package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.ShowPreviewCashBoardDAOBean;
import com.riding.todoback.model.DTO.RequestPreviewCashBoardAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowPreviewCashBoardBean {

    ShowPreviewCashBoardDAOBean showPreviewCashBoardDAOBean;

    @Autowired
    public ShowPreviewCashBoardBean(ShowPreviewCashBoardDAOBean showPreviewCashBoardDAOBean) {
        this.showPreviewCashBoardDAOBean = showPreviewCashBoardDAOBean;
    }

    public List<RequestPreviewCashBoardAll> exec(){
        return showPreviewCashBoardDAOBean.exec();
    }
}
