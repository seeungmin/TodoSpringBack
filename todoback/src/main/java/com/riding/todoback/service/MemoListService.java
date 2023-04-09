package com.riding.todoback.service;

import com.riding.todoback.bean.*;
import com.riding.todoback.model.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoListService {

    SaveBoardBean saveBoardBean;
    InquireDetailBoardBean inquireDetailBoardBean;
    ShowPreviewCashBoardBean showPreviewCashBoardBean;
    ModifyBoardBean modifyBoardBean;
    DeleteBoardBean deleteBoardBean;

    @Autowired
    public MemoListService(SaveBoardBean saveBoardBean, InquireDetailBoardBean inquireDetailBoardBean, ShowPreviewCashBoardBean showPreviewCashBoardBean, ModifyBoardBean modifyBoardBean, DeleteBoardBean deleteBoardBean) {
        this.saveBoardBean = saveBoardBean;
        this.inquireDetailBoardBean = inquireDetailBoardBean;
        this.showPreviewCashBoardBean = showPreviewCashBoardBean;
        this.modifyBoardBean = modifyBoardBean;
        this.deleteBoardBean = deleteBoardBean;
    }


    // 메모장 데이터 저장
    public boolean saveBoardEntity(RequestBoardInput requestBoardInput){
        return saveBoardBean.exec(requestBoardInput);
    }

    // 메모장 preview 조회
    public List<RequestPreviewCashBoardAll> allCashBoardEntity(){
       return showPreviewCashBoardBean.exec();
    }

    // 메모장 detail 조회
    public RequestDetailBoardInquire inquireBoardEntity(long id){
        return inquireDetailBoardBean.exec(id);
    }


    // 메모장 수정
    public boolean modifyBoardEntity(RequestBoardModify requestBoardModify){
        return modifyBoardBean.exec(requestBoardModify);
    }

    // 메모장 삭제
    public boolean deleteBoardEntity(RequestBoardDelete requestBoardDelete){
        return deleteBoardBean.exec(requestBoardDelete);
    }



    /*// 임시저장 데이터 저장
    public void saveTemporaryMemoEntity(){
        saveTemporaryMemoBean.exec();
    }
*/
}
