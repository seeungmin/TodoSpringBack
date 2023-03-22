package com.riding.todoback.bean;

import com.riding.todoback.entity.CashBoardEntity;
import com.riding.todoback.model.RequestPreviewCashBoardAll;
import com.riding.todoback.repository.CashBoardRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllPreviewCashBoardBean {

    @Autowired
    CashBoardRepositoryJPA cashBoardRepositoryJPA;

    public List<RequestPreviewCashBoardAll> exec(){

        List<CashBoardEntity> cashBoardEntityList = cashBoardRepositoryJPA.findAll();

    }
}
