package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.GetBoardEntityBean;
import com.riding.todoback.bean.Small.NewObjectDAOBean;
import com.riding.todoback.model.DTO.RequestDetailBoardInquire;
import com.riding.todoback.model.entity.BoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InquireDetailBoardBean {

    GetBoardEntityBean getBoardEntityBean;
    NewObjectDAOBean newObjectDAOBean;
    
    @Autowired
    public InquireDetailBoardBean(GetBoardEntityBean getBoardEntityBean, NewObjectDAOBean newObjectDAOBean) {
        this.getBoardEntityBean = getBoardEntityBean;
        this.newObjectDAOBean = newObjectDAOBean;
    }

    public RequestDetailBoardInquire exec(long id){
        // 아이디로 메모 객체 찾기
        BoardEntity boardEntity = getBoardEntityBean.exec(id);

        // DTO 객체에 메모 객체 넘기기
        RequestDetailBoardInquire requestDetailBoardInquire = newObjectDAOBean.exec(boardEntity);

        // DTO객체 반환
        return requestDetailBoardInquire;
    }
}
