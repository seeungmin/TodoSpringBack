package com.riding.todoback.bean.Small;

import com.riding.todoback.model.entity.BoardEntity;
import com.riding.todoback.model.entity.CashBoardEntity;
import com.riding.todoback.model.entity.FinishedTodoEntity;
import com.riding.todoback.model.entity.TodoEntity;
import com.riding.todoback.repository.BoardRepositoryJPA;
import com.riding.todoback.repository.CashBoardRepositoryJPA;
import com.riding.todoback.repository.FinishedTodoRepositoryJPA;
import com.riding.todoback.repository.TodoRepositoryJPA;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class DeleteDAOBeanTest {

    @Autowired DeleteDAOBean deleteDAOBean;


    @Test
    void delete_todo(){
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setId(1L);

        deleteDAOBean.todoRepositoryJPA.save(todoEntity);
        System.out.println("deleteDAOBean = " + deleteDAOBean.todoRepositoryJPA.findById(1L).get());

        deleteDAOBean.exec(todoEntity);
        assertThat(deleteDAOBean.todoRepositoryJPA.findById(todoEntity.getId())).isNotEqualTo(todoEntity);
    }

    @Test
    void delete_finish_todo() {
        FinishedTodoEntity finishedTodoEntity = new FinishedTodoEntity();
        finishedTodoEntity.setId(1L);

        deleteDAOBean.finishedTodoRepositoryJPA.save(finishedTodoEntity);
        System.out.println("deleteDAOBean = " + deleteDAOBean.finishedTodoRepositoryJPA.findById(1L).get());

        deleteDAOBean.exec(finishedTodoEntity);
        assertThat(deleteDAOBean.finishedTodoRepositoryJPA.findById(finishedTodoEntity.getId())).isNotEqualTo(finishedTodoEntity);
    }

    @Test
    void delete_memo() {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId(1L);

        deleteDAOBean.boardRepositoryJPA.save(boardEntity);
        System.out.println("deleteDAOBean = " + deleteDAOBean.boardRepositoryJPA.findById(1L).get());

        deleteDAOBean.exec(boardEntity);
        assertThat(deleteDAOBean.boardRepositoryJPA.findById(boardEntity.getId())).isNotEqualTo(boardEntity);
    }

    @Test
    void delete_cash_memo() {
        CashBoardEntity CashBoardEntity = new CashBoardEntity();
        CashBoardEntity.setId(1L);

        deleteDAOBean.cashBoardRepositoryJPA.save(CashBoardEntity);
        System.out.println("deleteDAOBean = " + deleteDAOBean.cashBoardRepositoryJPA.findById(1L).get());

        deleteDAOBean.exec(CashBoardEntity);
        assertThat(deleteDAOBean.cashBoardRepositoryJPA.findById(CashBoardEntity.getId())).isNotEqualTo(CashBoardEntity);
    }
}