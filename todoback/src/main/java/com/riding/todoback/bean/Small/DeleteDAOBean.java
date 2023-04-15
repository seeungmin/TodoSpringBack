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
public class DeleteDAOBean {

    TodoRepositoryJPA todoRepositoryJPA;
    FinishedTodoRepositoryJPA finishedTodoRepositoryJPA;
    BoardRepositoryJPA boardRepositoryJPA;
    CashBoardRepositoryJPA cashBoardRepositoryJPA;

    @Autowired
    public DeleteDAOBean(TodoRepositoryJPA todoRepositoryJPA, FinishedTodoRepositoryJPA finishedTodoRepositoryJPA, BoardRepositoryJPA boardRepositoryJPA, CashBoardRepositoryJPA cashBoardRepositoryJPA) {
        this.todoRepositoryJPA = todoRepositoryJPA;
        this.finishedTodoRepositoryJPA = finishedTodoRepositoryJPA;
        this.boardRepositoryJPA = boardRepositoryJPA;
        this.cashBoardRepositoryJPA = cashBoardRepositoryJPA;
    }

    // 할 일 삭제
    public void exec(TodoEntity todoEntity){
        todoRepositoryJPA.delete(todoEntity);
    }

    // 다 한 일 삭제
    public void exec(FinishedTodoEntity finishedTodoEntity){
        finishedTodoRepositoryJPA.delete(finishedTodoEntity);
    }

    // 메모 삭제
    public void exec(BoardEntity boardEntity){
        boardRepositoryJPA.delete(boardEntity);
    }

    // 캐시 메모 삭제
    public void exec(CashBoardEntity cashBoardEntity){
        cashBoardRepositoryJPA.delete(cashBoardEntity);
    }
}
