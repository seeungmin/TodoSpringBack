package com.riding.todoback.bean.Small;

import com.riding.todoback.entity.CashBoardEntity;
import com.riding.todoback.repository.CashBoardRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InquirePreviewCashBoardBean {

    @Autowired
    CashBoardRepositoryJPA cashBoardRepositoryJPA;

    public List<CashBoardEntity> exec(){
        return cashBoardRepositoryJPA.findAll();
    }
}
