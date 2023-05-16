package com.riding.todoback.service;

import com.riding.todoback.bean.*;
import com.riding.todoback.model.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {

    SaveTodoBean saveTodoBean;
    SaveFinishedTodoBean saveFinishedTodoBean;
    DeleteTodoBean deleteTodoBean;
    DeleteFinishedTodoBean deleteFinishedTodoBean;
    ModifyTodoBean modifyTodoBean;
    ShowTodoBean showTodoBean;
    ShowFinishTodoBean showFinishTodoBean;

    @Autowired
    public TodoListService(SaveTodoBean saveTodoBean, SaveFinishedTodoBean saveFinishedTodoBean, DeleteTodoBean deleteTodoBean, DeleteFinishedTodoBean deleteFinishedTodoBean, ModifyTodoBean modifyTodoBean, ShowTodoBean showTodoBean, ShowFinishTodoBean showFinishTodoBean) {
        this.saveTodoBean = saveTodoBean;
        this.saveFinishedTodoBean = saveFinishedTodoBean;
        this.deleteTodoBean = deleteTodoBean;
        this.deleteFinishedTodoBean = deleteFinishedTodoBean;
        this.modifyTodoBean = modifyTodoBean;
        this.showTodoBean = showTodoBean;
        this.showFinishTodoBean = showFinishTodoBean;
    }

    // 할 일 데이터 저장
    public long saveTodoEntity(RequestTodoInput requestTodoInput){
        return saveTodoBean.exec(requestTodoInput);
    }

    // 다 한 일 데이터 저장
    public Long saveFinishedTodoEntity(RequestFinishTodoInput requestFinishTodoInput){
        return saveFinishedTodoBean.exec(requestFinishTodoInput);
    }

    // 할 일 데이터 수정
    public Long modifyTodoEntity(RequestTodoModify requestTodoModify){
        return modifyTodoBean.exec(requestTodoModify);
    }

    // 할 일 삭제
    public Long deleteTodoEntity(RequestTodoDelete requestTodoDelete){
        return deleteTodoBean.exec(requestTodoDelete);
    }

    // 다 한 일 삭제
    public Long deleteFinishedTodoEntity(RequestFinishTodoDelete requestFinishTodoDelete){
        return deleteFinishedTodoBean.exec(requestFinishTodoDelete);

    }

    // 할 일 전체 조회
    public List<RequestPreviewTodoAll> showTodoAllEntity(String userId){
        return showTodoBean.exec(userId);
    }

    // 다 한 일 전체 조회
    public List<RequestPreviewFinishTodoAll> showFinishTodoAllEntity(){
        return showFinishTodoBean.exec();
    }

}
