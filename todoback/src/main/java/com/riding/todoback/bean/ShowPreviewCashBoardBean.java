package com.riding.todoback.bean;

import com.riding.todoback.entity.CashBoardEntity;
import com.riding.todoback.model.DTO.RequestPreviewCashBoardAll;
import com.riding.todoback.repository.CashBoardRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShowPreviewCashBoardBean {

    @Autowired
    CashBoardRepositoryJPA cashBoardRepositoryJPA;

    public List<RequestPreviewCashBoardAll> exec(){

        // cashBoard 데이터를 전부 List 로 저장
        List<CashBoardEntity> cashBoardEntityList = new ArrayList<>(cashBoardRepositoryJPA.findAll());

        // cashBoard 에 있는 데이터를 옮겨서 저장할 리스트 저장
        List<RequestPreviewCashBoardAll> requestPreviewCashBoardAllList = new ArrayList<>();

        // 새로운 객체에 데이터를 저장하고 List 에 추가
        for(CashBoardEntity cashBoardEntity : cashBoardEntityList){
            RequestPreviewCashBoardAll requestPreviewCashBoardAll = new RequestPreviewCashBoardAll();
            requestPreviewCashBoardAll.setId(cashBoardEntity.getId());
            requestPreviewCashBoardAll.setCashData(cashBoardEntity.getCashData());
            requestPreviewCashBoardAll.setUploadTime(cashBoardEntity.getUploadTime());
            requestPreviewCashBoardAllList.add(requestPreviewCashBoardAll);
        }

        // 데이터가 옮겨진 List 를 반환
        return requestPreviewCashBoardAllList;
    }
}
