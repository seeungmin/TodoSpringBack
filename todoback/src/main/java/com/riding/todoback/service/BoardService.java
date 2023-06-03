package com.riding.todoback.service;

import com.riding.todoback.bean.*;
import com.riding.todoback.model.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    SaveBoardBean saveBoardBean;
    InquireDetailBoardBean inquireDetailBoardBean;
    ModifyBoardBean modifyBoardBean;
    DeleteBoardBean deleteBoardBean;

    @Autowired
    public BoardService(SaveBoardBean saveBoardBean, InquireDetailBoardBean inquireDetailBoardBean, ModifyBoardBean modifyBoardBean, DeleteBoardBean deleteBoardBean) {
        this.saveBoardBean = saveBoardBean;
        this.inquireDetailBoardBean = inquireDetailBoardBean;
        this.modifyBoardBean = modifyBoardBean;
        this.deleteBoardBean = deleteBoardBean;
    }

    // 메모 조회
    public RequestDetailBoardInquire getBoardEntity(long id, String userId){
        return inquireDetailBoardBean.exec(id, userId);
    }


    // 메모 데이터 저장
    public Long saveBoardEntity(RequestBoardInput requestBoardInput){
        return saveBoardBean.exec(requestBoardInput);
    }


    // 메모 수정
    public Long modifyBoardEntity(RequestBoardModify requestBoardModify){
        return modifyBoardBean.exec(requestBoardModify);
    }


    // 메모 삭제
    public Long deleteBoardEntity(RequestBoardDelete requestBoardDelete){
        return deleteBoardBean.exec(requestBoardDelete);
    }


    /*// 임시저장 데이터 저장
    public void saveTemporaryMemoEntity(){
        saveTemporaryMemoBean.exec();
    }
*/
}
