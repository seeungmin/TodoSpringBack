package com.riding.todoback.bean.Small;

import com.riding.todoback.entity.BoardEntity;
import com.riding.todoback.entity.CashBoardEntity;
import com.riding.todoback.repository.BoardRepositoryJPA;
import com.riding.todoback.repository.CashBoardRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SaveStoryBoardDTOBean {

    GenerateUniqueIdBean generateUniqueIdBean;
    SaveCashBoardBean saveCashBoardBean;
    CashBoardRepositoryJPA cashBoardRepositoryJPA;


    @Autowired
    public SaveStoryBoardDTOBean(GenerateUniqueIdBean generateUniqueIdBean, SaveCashBoardBean saveCashBoardBean, CashBoardRepositoryJPA cashBoardRepositoryJPA) {
        this.generateUniqueIdBean = generateUniqueIdBean;
        this.saveCashBoardBean = saveCashBoardBean;
        this.cashBoardRepositoryJPA = cashBoardRepositoryJPA;
    }

    // 메모장 데이터와 스토리보드 캐시 데이터 저장
    public boolean exec(String title, String input){

        // 아이디 생성
        long id = generateUniqueIdBean.exec();

        // 시간 생성
        LocalDateTime uTime = LocalDateTime.now();
        LocalDateTime mTime = LocalDateTime.now();


        // 일부 데이터 캐시로 저장
        String cashData =saveCashBoardBean.exec(input);

        // 스토리보드 데이터 저장
        CashBoardEntity cashBoardEntity = new CashBoardEntity(id, "1", title, cashData, uTime, mTime);


        if (cashBoardRepositoryJPA.save(cashBoardEntity) == null)
            return false;
        return true;
    }
}
