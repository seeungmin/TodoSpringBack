package com.riding.todoback.bean.Small;

import com.riding.todoback.entity.BoardEntity;
import com.riding.todoback.entity.CashBoardEntity;
import com.riding.todoback.model.DTO.RequestBoardDelete;
import com.riding.todoback.repository.CashBoardRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCashBoardDAOBean {
    CashBoardRepositoryJPA cashBoardRepositoryJPA;

    @Autowired
    public DeleteCashBoardDAOBean(CashBoardRepositoryJPA cashBoardRepositoryJPA) {
        this.cashBoardRepositoryJPA = cashBoardRepositoryJPA;
    }

    public boolean exec(RequestBoardDelete requestBoardDelete){
        // 고유 아이디 받기
        long id = requestBoardDelete.getId();

        // 메모 데이터 받기
        CashBoardEntity cashBoardEntity = cashBoardRepositoryJPA.findById(id).get();

        // 받은 데이터 삭제
        if(cashBoardEntity == null)
            return false;
        cashBoardRepositoryJPA.delete(cashBoardEntity);
        return true;
    }
}
