package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.DeleteDAOBean;
import com.riding.todoback.bean.Small.GetBoardDAOBean;
import com.riding.todoback.bean.Small.GetCashBoardDAOBean;
import com.riding.todoback.model.DTO.RequestBoardDelete;
import com.riding.todoback.model.entity.BoardEntity;
import com.riding.todoback.model.entity.CashBoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteBoardBean {

    GetBoardDAOBean getBoardDAOBean;
    GetCashBoardDAOBean getCashBoardDAOBean;
    DeleteDAOBean deleteDAOBean;

    @Autowired
    public DeleteBoardBean(GetBoardDAOBean getBoardDAOBean, GetCashBoardDAOBean getCashBoardDAOBean, DeleteDAOBean deleteDAOBean) {
        this.getBoardDAOBean = getBoardDAOBean;
        this.getCashBoardDAOBean = getCashBoardDAOBean;
        this.deleteDAOBean = deleteDAOBean;
    }

    public Long exec(RequestBoardDelete requestBoardDelete){
        // 아이디 가져오기
        Long id = requestBoardDelete.getId();

        // 메모 객체 받기
        BoardEntity boardEntity = getBoardDAOBean.exec(id);

        // 메모 삭제
        deleteDAOBean.exec(boardEntity);

        // 캐시 메모 객체 받기
        CashBoardEntity cashBoardEntity = getCashBoardDAOBean.exec(id);

        // 캐시 메모 삭제
        deleteDAOBean.exec(cashBoardEntity);

        return requestBoardDelete.getId();
    }
}
