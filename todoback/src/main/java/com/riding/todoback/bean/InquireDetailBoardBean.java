package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.CheckUserIdDAOBean;
import com.riding.todoback.bean.Small.GetBoardDAOBean;
import com.riding.todoback.bean.Small.NewObjectDAOBean;
import com.riding.todoback.model.DTO.RequestDetailBoardInquire;
import com.riding.todoback.model.entity.BoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InquireDetailBoardBean {

    GetBoardDAOBean getBoardEntityBean;
    NewObjectDAOBean newObjectDAOBean;
    CheckUserIdDAOBean checkUserIdDAOBean;

    @Autowired
    public InquireDetailBoardBean(GetBoardDAOBean getBoardEntityBean, NewObjectDAOBean newObjectDAOBean, CheckUserIdDAOBean checkUserIdDAOBean) {
        this.getBoardEntityBean = getBoardEntityBean;
        this.newObjectDAOBean = newObjectDAOBean;
        this.checkUserIdDAOBean = checkUserIdDAOBean;
    }

    public RequestDetailBoardInquire exec(long id, String userId){
        // 아이디로 메모 객체 찾기
        BoardEntity boardEntity = getBoardEntityBean.exec(id);

        // 삭제할 메모에 해당되는 아이디가 맞는지 확인
        if(checkUserIdDAOBean.exec(boardEntity, userId) == false)
            return null;

        // DTO 객체에 메모 객체 넘기기
        RequestDetailBoardInquire requestDetailBoardInquire = newObjectDAOBean.exec(boardEntity);

        // DTO객체 반환
        return requestDetailBoardInquire;
    }
}
