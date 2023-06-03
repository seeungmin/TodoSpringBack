package com.riding.todoback.service;

import com.riding.todoback.bean.DeleteFinishedTodoBean;
import com.riding.todoback.bean.SaveFinishedTodoBean;
import com.riding.todoback.bean.ShowFinishTodoBean;
import com.riding.todoback.model.DTO.RequestFinishTodoDelete;
import com.riding.todoback.model.DTO.RequestFinishTodoInput;
import com.riding.todoback.model.DTO.RequestPreviewFinishTodoAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinishTodoService {

    SaveFinishedTodoBean saveFinishedTodoBean;
    DeleteFinishedTodoBean deleteFinishedTodoBean;
    ShowFinishTodoBean showFinishTodoBean;

    @Autowired
    public FinishTodoService(SaveFinishedTodoBean saveFinishedTodoBean, DeleteFinishedTodoBean deleteFinishedTodoBean, ShowFinishTodoBean showFinishTodoBean) {
        this.saveFinishedTodoBean = saveFinishedTodoBean;
        this.deleteFinishedTodoBean = deleteFinishedTodoBean;
        this.showFinishTodoBean = showFinishTodoBean;
    }


    // 다 한 일 전체 조회
    public List<RequestPreviewFinishTodoAll> getFinishTodosEntity(String userId){
        return showFinishTodoBean.exec(userId);
    }


    // 다 한 일 데이터 저장
    public Long saveFinishTodoEntity(RequestFinishTodoInput requestFinishTodoInput){
        return saveFinishedTodoBean.exec(requestFinishTodoInput);
    }


    // 다 한 일 삭제
    public Long deleteFinishTodoEntity(RequestFinishTodoDelete requestFinishTodoDelete){
        return deleteFinishedTodoBean.exec(requestFinishTodoDelete);
    }
}
