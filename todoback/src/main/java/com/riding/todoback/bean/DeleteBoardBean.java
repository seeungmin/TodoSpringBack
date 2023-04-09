package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.DeleteBoardDAOBean;
import com.riding.todoback.bean.Small.DeleteCashBoardDAOBean;
import com.riding.todoback.model.DTO.RequestBoardDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteBoardBean {
    DeleteBoardDAOBean deleteBoardDAOBean;
    DeleteCashBoardDAOBean deleteCashBoardDAOBean;

    @Autowired
    public DeleteBoardBean(DeleteBoardDAOBean deleteBoardDAOBean, DeleteCashBoardDAOBean deleteCashBoardDAOBean) {
        this.deleteBoardDAOBean = deleteBoardDAOBean;
        this.deleteCashBoardDAOBean = deleteCashBoardDAOBean;
    }

    public boolean exec(RequestBoardDelete requestBoardDelete){
        // 메모 데이터 삭제
        boolean s1 = deleteBoardDAOBean.exec(requestBoardDelete);

        // 캐시 메모 데이터 삭제
        boolean s2 = deleteCashBoardDAOBean.exec(requestBoardDelete);

        if(s1 && s2)
            return true;
        return false;
    }
}
