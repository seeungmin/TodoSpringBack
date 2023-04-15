package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.*;
import com.riding.todoback.model.DTO.RequestBoardInput;
import com.riding.todoback.model.entity.BoardEntity;
import com.riding.todoback.model.entity.CashBoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveBoardBean {

    GenerateUniqueIdBean generateUniqueIdBean;
    NewObjectDAOBean newObjectDAOBean;
    SaveDAOBean saveDAOBean;

    @Autowired
    public SaveBoardBean(GenerateUniqueIdBean generateUniqueIdBean, NewObjectDAOBean newObjectDAOBean, SaveDAOBean saveDAOBean) {
        this.generateUniqueIdBean = generateUniqueIdBean;
        this.newObjectDAOBean = newObjectDAOBean;
        this.saveDAOBean = saveDAOBean;
    }

    // 아이디를 입력받고 쿼리문으로 데이터 찾아보는과정을 넣으면 되려나?
    // 메모장 데이터와 스토리보드 캐시 데이터 저장
    public Long exec(RequestBoardInput requestBoardInput){
        // 아이디 생성
        long id = generateUniqueIdBean.exec();

        // 메모 저장 후 객체 생성
        BoardEntity boardEntity = newObjectDAOBean.exec(id, requestBoardInput);

        // 메모 저장
        saveDAOBean.exec(boardEntity);

        // 캐시 메모 저장 후 객체 생성
        CashBoardEntity cashBoardEntity = newObjectDAOBean.exec(id, boardEntity);

        // 캐시 메모 저장
        saveDAOBean.exec(cashBoardEntity);

        return id;
    }

}
