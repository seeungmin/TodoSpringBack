package com.riding.todoback.bean.Small;

import com.riding.todoback.model.entity.CashBoardEntity;
import com.riding.todoback.repository.CashBoardRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetCashBoardDAOsBean {

    CashBoardRepositoryJPA cashBoardRepositoryJPA;

    @Autowired
    public GetCashBoardDAOsBean(CashBoardRepositoryJPA cashBoardRepositoryJPA) {
        this.cashBoardRepositoryJPA = cashBoardRepositoryJPA;
    }

    public List<CashBoardEntity> exec(){
        // 모든 캐시메모 데이터 객체 받기
        return new ArrayList<>(cashBoardRepositoryJPA.findAll());
    }
}
