package com.riding.todoback.bean.Small;

import com.riding.todoback.model.DTO.*;
import com.riding.todoback.model.entity.BoardEntity;
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

    // 입력할 다 한일 판별
    public boolean exec(TodoEntity todoEntity, RequestFinishTodoInput requestFinishTodoInput){

        if(todoEntity.getUserId().equals(requestFinishTodoInput.getUserId()))
            return true;
        return false;
    }

    // 삭제할 다 한일 판별
    public boolean exec(FinishedTodoEntity finishedTodoEntity, RequestFinishTodoDelete requestFinishTodoDelete){

        if(finishedTodoEntity.getUserId().equals(requestFinishTodoDelete.getUserId()))
            return true;
        return false;
    }

    // 조회할 메모 판별
    public boolean exec(BoardEntity boardEntity, String userId){

        if(boardEntity.getUserId().equals(userId))
            return true;
        return false;
    }

    // 수정할 메모 판별
    public boolean exec(BoardEntity boardEntity, RequestBoardModify requestBoardModify){

        if(boardEntity.getUserId().equals(requestBoardModify.getUserId()))
            return true;
        return false;
    }

    // 삭제할 메모 판별
    public boolean exec(BoardEntity boardEntity, RequestBoardDelete requestBoardDelete){

        if(boardEntity.getUserId().equals(requestBoardDelete.getUserId()))
            return true;
        return false;
    }



}