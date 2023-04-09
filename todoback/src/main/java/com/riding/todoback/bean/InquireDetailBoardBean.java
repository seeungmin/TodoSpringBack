package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.InquireDetailBoardDAOBean;
import com.riding.todoback.model.DTO.RequestDetailBoardInquire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InquireDetailBoardBean {

    InquireDetailBoardDAOBean inquireDetailBoardDAOBean;

    @Autowired
    public InquireDetailBoardBean(InquireDetailBoardDAOBean inquireDetailBoardDAOBean) {
        this.inquireDetailBoardDAOBean = inquireDetailBoardDAOBean;
    }

    public RequestDetailBoardInquire exec(long id){
        return inquireDetailBoardDAOBean.exec(id);
    }
}
