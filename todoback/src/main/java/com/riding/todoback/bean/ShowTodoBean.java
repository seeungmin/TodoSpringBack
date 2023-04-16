package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.GetTodoDAOsBean;
import com.riding.todoback.bean.Small.SaveTodoDTOsBean;
import com.riding.todoback.model.DTO.RequestPreviewTodoAll;
import com.riding.todoback.model.entity.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowTodoBean {

    GetTodoDAOsBean getTodoDAOsBean;
    SaveTodoDTOsBean saveTodoDTOsBean;

    @Autowired
    public ShowTodoBean(GetTodoDAOsBean getTodoDAOsBean, SaveTodoDTOsBean saveTodoDTOsBean) {
        this.getTodoDAOsBean = getTodoDAOsBean;
        this.saveTodoDTOsBean = saveTodoDTOsBean;
    }


    public List<RequestPreviewTodoAll> exec(){
        // 할 일 객체 전부 가져오기
        List<TodoEntity> todoEntities = getTodoDAOsBean.exec();

        // 할 일 DTO에 저장 후 반환
        return saveTodoDTOsBean.exec(todoEntities);
    }
}
