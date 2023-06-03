package com.riding.todoback.service;

import com.riding.todoback.bean.ShowPreviewCashBoardBean;
import com.riding.todoback.model.DTO.RequestPreviewCashBoardAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashBoardService {

    ShowPreviewCashBoardBean showPreviewCashBoardBean;

    @Autowired
    public CashBoardService(ShowPreviewCashBoardBean showPreviewCashBoardBean) {
        this.showPreviewCashBoardBean = showPreviewCashBoardBean;
    }


    // 캐시 메모 전체 조회
    public List<RequestPreviewCashBoardAll> getCashBoardsEntity(String userId){
        return showPreviewCashBoardBean.exec(userId);
    }
}
