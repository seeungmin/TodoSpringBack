package com.riding.todoback.bean.Small;

import com.riding.todoback.model.entity.CashBoardEntity;
import com.riding.todoback.repository.CashBoardRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetCashBoardDAOBean {
    CashBoardRepositoryJPA cashBoardRepositoryJPA;

    @Autowired
    public GetCashBoardDAOBean(CashBoardRepositoryJPA cashBoardRepositoryJPA) {
        this.cashBoardRepositoryJPA = cashBoardRepositoryJPA;
    }

    // 아이디로 캐시메모 찾기
    public CashBoardEntity exec(Long id){
        return cashBoardRepositoryJPA.findById(id).get();
    }
}
