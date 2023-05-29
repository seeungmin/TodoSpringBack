package com.riding.todoback.bean.Small;

import com.riding.todoback.model.DTO.RequestFinishTodoDelete;
import com.riding.todoback.model.DTO.RequestTodoDelete;
import com.riding.todoback.model.DTO.RequestTodoModify;
import com.riding.todoback.model.entity.FinishedTodoEntity;
import com.riding.todoback.model.entity.TodoEntity;
import org.springframework.stereotype.Component;

@Component
public class CheckUserIdDAOBean {

    // 수정할 일 판별
    public boolean exec(TodoEntity todoEntity, RequestTodoModify requestTodoModify){

        if(todoEntity.getUserId().equals(requestTodoModify.getUserId()))
            return true;
        return false;
    }

    // 삭제할 일 판별
    public boolean exec(TodoEntity todoEntity, RequestTodoDelete requestTodoDelete){

        if(todoEntity.getUserId().equals(requestTodoDelete.getUserId()))
            return true;
        return false;
    }

    // 삭제할 다 한일 판별
    public boolean exec(FinishedTodoEntity finishedTodoEntity, RequestFinishTodoDelete requestFinishTodoDelete){

        if(finishedTodoEntity.getUserId().equals(requestFinishTodoDelete.getUserId()))
            return true;
        return false;
    }

}