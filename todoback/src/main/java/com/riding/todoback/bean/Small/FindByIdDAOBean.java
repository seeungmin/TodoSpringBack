package com.riding.todoback.bean.Small;

import com.riding.todoback.model.DTO.RequestBoardDelete;
import com.riding.todoback.model.DTO.RequestBoardModify;
import com.riding.todoback.model.DTO.RequestFinishTodoDelete;
import com.riding.todoback.model.entity.BoardEntity;
import com.riding.todoback.model.entity.CashBoardEntity;
import com.riding.todoback.model.entity.FinishedTodoEntity;
import com.riding.todoback.model.entity.TodoEntity;
import com.riding.todoback.repository.BoardRepositoryJPA;
import com.riding.todoback.repository.CashBoardRepositoryJPA;
import com.riding.todoback.repository.FinishedTodoRepositoryJPA;
import com.riding.todoback.repository.TodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindByIdDAOBean {

    TodoRepositoryJPA todoRepositoryJPA;
    FinishedTodoRepositoryJPA finishedTodoRepositoryJPA;
    BoardRepositoryJPA boardRepositoryJPA;
    CashBoardRepositoryJPA cashBoardRepositoryJPA;

    @Autowired
    public FindByIdDAOBean(TodoRepositoryJPA todoRepositoryJPA, FinishedTodoRepositoryJPA finishedTodoRepositoryJPA, BoardRepositoryJPA boardRepositoryJPA, CashBoardRepositoryJPA cashBoardRepositoryJPA) {
        this.todoRepositoryJPA = todoRepositoryJPA;
        this.finishedTodoRepositoryJPA = finishedTodoRepositoryJPA;
        this.boardRepositoryJPA = boardRepositoryJPA;
        this.cashBoardRepositoryJPA = cashBoardRepositoryJPA;
    }

    // 아이디로 할 일 객체 찾기
    public TodoEntity exec(long id){
        return todoRepositoryJPA.findById(id).get();
    }


    // 아이디로 다 한 일 객체 찾기
    public FinishedTodoEntity exec(RequestFinishTodoDelete requestFinishTodoDelete){
        long id = requestFinishTodoDelete.getId();

        return finishedTodoRepositoryJPA.findById(id).get();
    }


    // 아이디로 메모 객체 찾기
    public BoardEntity exec(RequestBoardModify requestBoardModify){
        long id = requestBoardModify.getId();

        return boardRepositoryJPA.findById(id).get();
    }


    // 아이디로 메모 객체 찾기
    public BoardEntity exec(RequestBoardDelete requestBoardDelete){
        long id = requestBoardDelete.getId();

        return boardRepositoryJPA.findById(id).get();
    }

    // 아이디로 캐시 메모 객체 찾기
    public CashBoardEntity exec(Long id, RequestBoardDelete requestBoardDelete){
        return cashBoardRepositoryJPA.findById(id).get();
    }

}
