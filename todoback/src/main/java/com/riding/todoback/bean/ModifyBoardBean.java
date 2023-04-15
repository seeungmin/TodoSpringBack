package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.FindByIdDAOBean;
import com.riding.todoback.bean.Small.ModifyObjectDAOBean;
import com.riding.todoback.bean.Small.SaveDAOBean;
import com.riding.todoback.model.DTO.RequestBoardModify;
import com.riding.todoback.model.entity.BoardEntity;
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
        // 아이디로 수정할 할 일 찾기
        BoardEntity boardEntity = findByIdDAOBean.exec(requestBoardModify);

        // 새로 받을 내용 작성
        BoardEntity modifyBoardEntity = modifyObjectDAOBean.exec(boardEntity, requestBoardModify);

        // 데이터 저장
        saveDAOBean.exec(modifyBoardEntity);

        return requestBoardModify.getId();
    }
}
