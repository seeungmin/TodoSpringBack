package com.riding.todoback.service;

import com.riding.todoback.bean.SaveBoardBean;
import com.riding.todoback.bean.InquireDetailBoardBean;
import com.riding.todoback.bean.ShowPreviewCashBoardBean;
import com.riding.todoback.model.DTO.RequestDetailBoardInquire;
import com.riding.todoback.model.DTO.RequestPreviewCashBoardAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoListService {

    SaveBoardBean saveBoardBean;
    InquireDetailBoardBean inquireDetailBoardBean;
    ShowPreviewCashBoardBean showPreviewCashBoardBean;

    @Autowired
    public MemoListService(SaveBoardBean saveBoardBean, InquireDetailBoardBean inquireDetailBoardBean, ShowPreviewCashBoardBean showPreviewCashBoardBean) {
        this.saveBoardBean = saveBoardBean;
        this.inquireDetailBoardBean = inquireDetailBoardBean;
        this.showPreviewCashBoardBean = showPreviewCashBoardBean;
    }


    // 메모장 데이터 저장
    public boolean saveBoardEntity(String input){
        return saveBoardBean.exec(input);
    }

    // 메모장 preview 조회
    public List<RequestPreviewCashBoardAll> allCashBoardEntity(){
       return showPreviewCashBoardBean.exec();
    }

    // 메모장 detail 조회
    public RequestDetailBoardInquire inquireBoardEntity(long id){
        return inquireDetailBoardBean.exec(id);
    }



    /*// 임시저장 데이터 저장
    public void saveTemporaryMemoEntity(){
        saveTemporaryMemoBean.exec();
    }
*/
}
