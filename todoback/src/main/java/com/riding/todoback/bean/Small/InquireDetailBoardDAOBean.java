package com.riding.todoback.bean.Small;

import com.riding.todoback.entity.BoardEntity;
import com.riding.todoback.model.DTO.RequestDetailBoardInquire;
import com.riding.todoback.repository.BoardRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InquireDetailBoardDAOBean {

    BoardRepositoryJPA boardRepositoryJPA;

    @Autowired
    public InquireDetailBoardDAOBean(BoardRepositoryJPA boardRepositoryJPA) {
        this.boardRepositoryJPA = boardRepositoryJPA;
    }

    // 메모 내용 세부 조회
    public RequestDetailBoardInquire exec(long id){

        // 메모 아이디로 메모 객체 받아오기
        BoardEntity boardEntity = boardRepositoryJPA.findById(id).get();

        // DTO 객체에 메모 객체 넘기기
        RequestDetailBoardInquire requestDetailBoardInquire = new RequestDetailBoardInquire();
        requestDetailBoardInquire.setId(boardEntity.getId());
        requestDetailBoardInquire.setContent(boardEntity.getContent());
        requestDetailBoardInquire.setUploadTime(boardEntity.getUploadTime());

        // DTO객체 반환
        return requestDetailBoardInquire;
    }
}
