package com.riding.todoback.bean.Small;

import com.riding.todoback.model.DTO.RequestPreviewCashBoardAll;
import com.riding.todoback.model.entity.CashBoardEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SaveCashBoardDTOsBean {
    // 캐시 메모 전체 DTO 객체에 저장
    public List<RequestPreviewCashBoardAll> exec(List<CashBoardEntity> cashBoardEntityList){
        // cashBoard 에 있는 데이터를 옮겨서 저장할 리스트 저장
        List<RequestPreviewCashBoardAll> requestPreviewCashBoardAllList = new ArrayList<>();

        // 새로운 객체에 데이터를 저장하고 List 에 추가
        for (CashBoardEntity cashBoardEntity : cashBoardEntityList) {
            RequestPreviewCashBoardAll requestPreviewCashBoardAll = new RequestPreviewCashBoardAll();
            requestPreviewCashBoardAll.setId(cashBoardEntity.getId());
            requestPreviewCashBoardAll.setUserId(cashBoardEntity.getUserId());
            requestPreviewCashBoardAll.setTitle(cashBoardEntity.getTitle());
            requestPreviewCashBoardAll.setCashData(cashBoardEntity.getCashData());
            requestPreviewCashBoardAll.setUploadTime(cashBoardEntity.getUploadTime());
            requestPreviewCashBoardAll.setModifyTime(cashBoardEntity.getModifyTime());
            requestPreviewCashBoardAllList.add(requestPreviewCashBoardAll);
        }

        return requestPreviewCashBoardAllList;
    }
}
