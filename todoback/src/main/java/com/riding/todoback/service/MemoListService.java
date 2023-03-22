package com.riding.todoback.service;

import com.riding.todoback.bean.SaveBoardBean;
import com.riding.todoback.bean.InquireDetailBoardBean;
import com.riding.todoback.bean.ShowPreviewCashBoardBean;
import com.riding.todoback.bean.test.SaveTemporaryMemoBean;
import com.riding.todoback.bean.SaveCashBoardBean;
import com.riding.todoback.entity.BoardEntity;
import com.riding.todoback.model.RequestPreviewCashBoardAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoListService {

    SaveCashBoardBean saveCashBoardBean;
    SaveBoardBean saveBoardBean;
    SaveTemporaryMemoBean saveTemporaryMemoBean;
    InquireDetailBoardBean inquireDetailBoardBean;
    ShowPreviewCashBoardBean showPreviewCashBoardBean;

    @Autowired
    public MemoListService(SaveCashBoardBean saveCashBoardBean, SaveBoardBean saveBoardBean, SaveTemporaryMemoBean saveTemporaryMemoBean, InquireDetailBoardBean inquireDetailBoardBean, ShowPreviewCashBoardBean showPreviewCashBoardBean) {
        this.saveCashBoardBean = saveCashBoardBean;
        this.saveBoardBean = saveBoardBean;
        this.saveTemporaryMemoBean = saveTemporaryMemoBean;
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
    public BoardEntity inquireBoardEntity(long id){
        return inquireDetailBoardBean.exec(id);
    }



    /*// 임시저장 데이터 저장
    public void saveTemporaryMemoEntity(){
        saveTemporaryMemoBean.exec();
    }
*/
}
