package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.GetCahBoardDAOsBean;
import com.riding.todoback.bean.Small.SaveCashBoardDTOsBean;
import com.riding.todoback.model.DTO.RequestPreviewCashBoardAll;
import com.riding.todoback.model.entity.CashBoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowPreviewCashBoardBean {

    GetCahBoardDAOsBean getCahBoardDAOsBean;
    SaveCashBoardDTOsBean saveCashBoardDTOsBean;

    @Autowired
    public ShowPreviewCashBoardBean(GetCahBoardDAOsBean getCahBoardDAOsBean, SaveCashBoardDTOsBean saveCashBoardDTOsBean) {
        this.getCahBoardDAOsBean = getCahBoardDAOsBean;
        this.saveCashBoardDTOsBean = saveCashBoardDTOsBean;
    }

    public List<RequestPreviewCashBoardAll> exec(){
        // 캐시메모 객체 전부 받아오기
        List<CashBoardEntity> cashBoardEntities = getCahBoardDAOsBean.exec();

        // 캐시메모 객체 전부 DTO 객체에 저장 및 반환
        return saveCashBoardDTOsBean.exec(cashBoardEntities);

    }
}
