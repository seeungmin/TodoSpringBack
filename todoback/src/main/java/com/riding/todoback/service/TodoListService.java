package com.riding.todoback.service;

import com.riding.todoback.bean.Small.SaveTodoBean;
import com.riding.todoback.bean.SaveFinishedTodoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoListService {

    SaveTodoBean saveTodoBean;
    SaveFinishedTodoBean saveFinishedTodoBean;

    @Autowired
    public TodoListService(SaveTodoBean saveTodoBean, SaveFinishedTodoBean saveFinishedTodoBean) {
        this.saveTodoBean = saveTodoBean;
        this.saveFinishedTodoBean = saveFinishedTodoBean;
    }

    // 할 일 데이터 저장
    public void saveTodoEntity(String input){
        saveTodoBean.exec(input);
    }

    // 다 한 일 데이터 저장
    public void saveFinishedTodoEntity(long id){
        saveFinishedTodoBean.exec(id);
    }
}
