package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.DeleteDAOBean;
import com.riding.todoback.bean.Small.FindByIdDAOBean;
import com.riding.todoback.model.DTO.RequestBoardDelete;
import com.riding.todoback.model.entity.BoardEntity;
import com.riding.todoback.model.entity.CashBoardEntity;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteBoardBean {

    FindByIdDAOBean findByIdDAOBean;
    DeleteDAOBean deleteDAOBean;

    @Autowired
    public DeleteBoardBean(FindByIdDAOBean findByIdDAOBean, DeleteDAOBean deleteDAOBean) {
        this.findByIdDAOBean = findByIdDAOBean;
        this.deleteDAOBean = deleteDAOBean;
    }

    public Long exec(RequestBoardDelete requestBoardDelete){
        // 메모 객체 받기
        BoardEntity boardEntity = findByIdDAOBean.exec(requestBoardDelete);

        // 메모 삭제
        deleteDAOBean.exec(boardEntity);

        // 캐시 메모 객체 받기
        CashBoardEntity cashBoardEntity = findByIdDAOBean.exec(requestBoardDelete.getId(), requestBoardDelete);

        // 캐시 메모 삭제
        deleteDAOBean.exec(cashBoardEntity);

        return requestBoardDelete.getId();
    }
}
