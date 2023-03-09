package com.riding.todoback.service;

import com.riding.todoback.bean.SaveBoardBean;
import com.riding.todoback.bean.test.SaveTemporaryMemoBean;
import com.riding.todoback.bean.Small.SaveCashBoardBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemoListService {

    SaveCashBoardBean saveCashBoardBean;
    SaveBoardBean saveBoardBean;
    SaveTemporaryMemoBean saveTemporaryMemoBean;

    @Autowired
    public MemoListService(SaveCashBoardBean saveCashBoardBean, SaveBoardBean saveBoardBean, SaveTemporaryMemoBean saveTemporaryMemoBean) {
        this.saveCashBoardBean = saveCashBoardBean;
        this.saveBoardBean = saveBoardBean;
        this.saveTemporaryMemoBean = saveTemporaryMemoBean;
    }

    // 메모장 데이터 저장
    public void saveBoardEntity(String input){
        saveBoardBean.exec(input);
    }

    // 임시저장 데이터 저장
    public void saveTemporaryMemoEntity(){
        saveTemporaryMemoBean.exec();
    }

}
