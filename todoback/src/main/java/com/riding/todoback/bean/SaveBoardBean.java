package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.GenerateUniqueIdBean;
import com.riding.todoback.bean.Small.SaveCashBoardBean;
import com.riding.todoback.entity.BoardEntity;
import com.riding.todoback.entity.CashBoardEntity;
import com.riding.todoback.repository.BoardRepositoryJPA;
import com.riding.todoback.repository.CashBoardRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SaveBoardBean {

    BoardRepositoryJPA boardRepositoryJPA;
    GenerateUniqueIdBean generateUniqueIdBean;
    SaveCashBoardBean saveCashBoardBean;
    CashBoardRepositoryJPA cashBoardRepositoryJPA;

    @Autowired
    public SaveBoardBean(BoardRepositoryJPA boardRepositoryJPA, GenerateUniqueIdBean generateUniqueIdBean, SaveCashBoardBean saveCashBoardBean, CashBoardRepositoryJPA cashBoardRepositoryJPA) {
        this.boardRepositoryJPA = boardRepositoryJPA;
        this.generateUniqueIdBean = generateUniqueIdBean;
        this.saveCashBoardBean = saveCashBoardBean;
        this.cashBoardRepositoryJPA = cashBoardRepositoryJPA;
    }

    // 아이디를 입력받고 쿼리문으로 데이터 찾아보는과정을 넣으면 되려나?
    // 메모장 데이터와 스토리보드 캐시 데이터 저장
    public boolean exec(String input){

        // 아이디 생성
        long id = generateUniqueIdBean.exec();

        // 시간 생성
        LocalDateTime time = LocalDateTime.now();

        // 메모장 데이터 저장
        BoardEntity boardEntity = new BoardEntity(id, input, time);
        boardRepositoryJPA.save(boardEntity);


        // 일부 데이터 캐시로 저장
        String cashData =saveCashBoardBean.exec(input);

        // 스토리보드 데이터 저장
        CashBoardEntity cashBoardEntity = new CashBoardEntity(id, cashData, time);
        cashBoardRepositoryJPA.save(cashBoardEntity);
        return true;
    }

}
