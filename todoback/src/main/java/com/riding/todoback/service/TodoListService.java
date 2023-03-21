package com.riding.todoback.service;

import com.riding.todoback.bean.DeleteFinishedTodoBean;
import com.riding.todoback.bean.DeleteTodoBean;
import com.riding.todoback.bean.ModifyTodoBean;
import com.riding.todoback.bean.SaveTodoBean;
import com.riding.todoback.bean.SaveFinishedTodoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoListService {

    SaveTodoBean saveTodoBean;
    SaveFinishedTodoBean saveFinishedTodoBean;
    DeleteTodoBean deleteTodoBean;
    DeleteFinishedTodoBean deleteFinishedTodoBean;
    ModifyTodoBean modifyTodoBean;

    @Autowired
    public TodoListService(SaveTodoBean saveTodoBean, SaveFinishedTodoBean saveFinishedTodoBean, DeleteTodoBean deleteTodoBean, DeleteFinishedTodoBean deleteFinishedTodoBean, ModifyTodoBean modifyTodoBean) {
        this.saveTodoBean = saveTodoBean;
        this.saveFinishedTodoBean = saveFinishedTodoBean;
        this.deleteTodoBean = deleteTodoBean;
        this.deleteFinishedTodoBean = deleteFinishedTodoBean;
        this.modifyTodoBean = modifyTodoBean;
    }

    // 할 일 데이터 저장
    public long saveTodoEntity(String input){
        return saveTodoBean.exec(input);
    }

    // 다 한 일 데이터 저장
    public void saveFinishedTodoEntity(long id){
        saveFinishedTodoBean.exec(id);
    }

    // 할 일 데이터 수정
    public void modifyTodoEntity(long id, String content){
        modifyTodoBean.exec(id, content);
    }

    // 할 일 삭제
    public boolean deleteTodoEntity(long id){
        return deleteTodoBean.exec(id);
    }

    //다 한 일 삭제
    public boolean deleteFinishedTodoEntity(long id){
        return deleteFinishedTodoBean.exec(id);

    }

}
