package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.FindByIdDAOBean;
import com.riding.todoback.bean.Small.ModifyObjectDAOBean;
import com.riding.todoback.bean.Small.SaveDAOBean;
import com.riding.todoback.model.DTO.RequestBoardModify;
import com.riding.todoback.model.entity.BoardEntity;
import com.riding.todoback.model.entity.CashBoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModifyBoardBean {
    FindByIdDAOBean findByIdDAOBean;
    ModifyObjectDAOBean modifyObjectDAOBean;
    SaveDAOBean saveDAOBean;

    @Autowired
    public ModifyBoardBean(FindByIdDAOBean findByIdDAOBean, ModifyObjectDAOBean modifyObjectDAOBean, SaveDAOBean saveDAOBean) {
        this.findByIdDAOBean = findByIdDAOBean;
        this.modifyObjectDAOBean = modifyObjectDAOBean;
        this.saveDAOBean = saveDAOBean;
    }


    public Long exec(RequestBoardModify requestBoardModify){
        // 아이디로 수정할 메모 찾기
        BoardEntity boardEntity = findByIdDAOBean.exec(requestBoardModify);

        // 새로 받을 내용 작성
        BoardEntity modifyBoardEntity = modifyObjectDAOBean.exec(boardEntity, requestBoardModify);

        // 아이디로 수정할 캐시 메모 찾기
        CashBoardEntity cashBoardEntity = findByIdDAOBean.exec(requestBoardModify.getId(), requestBoardModify);

        // 새로 받을 내용 작성
        CashBoardEntity modifyCashBoardEntity = modifyObjectDAOBean.exec(cashBoardEntity, boardEntity);

        // 메모 데이터 저장
        saveDAOBean.exec(modifyBoardEntity);

        // 캐시메모 데이터 저장
        saveDAOBean.exec(modifyCashBoardEntity);
        return requestBoardModify.getId();
    }
}
