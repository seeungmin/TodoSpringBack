package com.riding.todoback.service;

import com.riding.todoback.bean.SaveBoardBean;
import com.riding.todoback.bean.Small.InquireDetailBoardBean;
import com.riding.todoback.bean.test.SaveTemporaryMemoBean;
import com.riding.todoback.bean.Small.SaveCashBoardBean;
import com.riding.todoback.entity.BoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemoListService {

    SaveCashBoardBean saveCashBoardBean;
    SaveBoardBean saveBoardBean;
    SaveTemporaryMemoBean saveTemporaryMemoBean;
    InquireDetailBoardBean inquireDetailBoardBean;

    @Autowired
    public MemoListService(SaveCashBoardBean saveCashBoardBean, SaveBoardBean saveBoardBean, SaveTemporaryMemoBean saveTemporaryMemoBean, InquireDetailBoardBean inquireDetailBoardBean) {
        this.saveCashBoardBean = saveCashBoardBean;
        this.saveBoardBean = saveBoardBean;
        this.saveTemporaryMemoBean = saveTemporaryMemoBean;
        this.inquireDetailBoardBean = inquireDetailBoardBean;
    }

    // 메모장 데이터 저장
    public void saveBoardEntity(String input){
        saveBoardBean.exec(input);
    }

    // 메모장 preview 조회


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
