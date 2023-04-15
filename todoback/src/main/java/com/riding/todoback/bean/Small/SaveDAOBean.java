package com.riding.todoback.bean.Small;

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


@Component
public class SaveDAOBean {

    TodoRepositoryJPA todoRepositoryJPA;
    FinishedTodoRepositoryJPA finishedTodoRepositoryJPA;
    BoardRepositoryJPA boardRepositoryJPA;
    CashBoardRepositoryJPA cashBoardRepositoryJPA;

    @Autowired
    public SaveDAOBean(TodoRepositoryJPA todoRepositoryJPA, FinishedTodoRepositoryJPA finishedTodoRepositoryJPA, BoardRepositoryJPA boardRepositoryJPA, CashBoardRepositoryJPA cashBoardRepositoryJPA) {
        this.todoRepositoryJPA = todoRepositoryJPA;
        this.finishedTodoRepositoryJPA = finishedTodoRepositoryJPA;
        this.boardRepositoryJPA = boardRepositoryJPA;
        this.cashBoardRepositoryJPA = cashBoardRepositoryJPA;
    }

    // 할 일 저장하기
    public void exec(TodoEntity todoEntity){
        todoRepositoryJPA.save(todoEntity);
    }


    // 다 한 일 저장하기
    public void exec(FinishedTodoEntity finishedTodoEntity){
        finishedTodoRepositoryJPA.save(finishedTodoEntity);
    }

    // 메모 저장하기
    public void exec(BoardEntity boardEntity){
        boardRepositoryJPA.save(boardEntity);
    }

    // 캐시 메모 저장하기
    public void exec(CashBoardEntity cashBoardEntity){
        cashBoardRepositoryJPA.save(cashBoardEntity);
    }

}
