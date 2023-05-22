package com.riding.todoback.bean.Small;

import com.riding.todoback.model.entity.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SaveDAOBeanTest {

    @Autowired SaveDAOBean saveDAOBean;
    @Test
    void save_todo_entity() {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setId(1L);
        todoEntity.setUserId("1");
        todoEntity.setContent("테스트 내용");
        todoEntity.setUploadTime(LocalDateTime.now());
        todoEntity.setModifyTime(LocalDateTime.now());

        saveDAOBean.exec(todoEntity);

        TodoEntity test = saveDAOBean.todoRepositoryJPA.findById(1L).get();
        assertThat(test).isNotNull();
    }

    @Test
    void save_finish_todo_entity() {
        FinishedTodoEntity finishedTodoEntity = new FinishedTodoEntity();
        finishedTodoEntity.setId(1L);
        finishedTodoEntity.setUserId("1");
        finishedTodoEntity.setContent("테스트 내용");
        finishedTodoEntity.setUploadTime(LocalDateTime.now());
        finishedTodoEntity.setCompletionTime(LocalDateTime.now());

        saveDAOBean.exec(finishedTodoEntity);

        FinishedTodoEntity test = saveDAOBean.finishedTodoRepositoryJPA.findById(1L).get();
        assertThat(test).isNotNull();

    }

    @Test
    void save_board_entity() {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId(1L);
        boardEntity.setUserId("1");
        boardEntity.setTitle("테스트 제목");
        boardEntity.setContent("테스트 내용");
        boardEntity.setUploadTime(LocalDateTime.now());
        boardEntity.setModifyTime(LocalDateTime.now());

        saveDAOBean.exec(boardEntity);

        BoardEntity test = saveDAOBean.boardRepositoryJPA.findById(1L).get();
        assertThat(test).isNotNull();
    }

    @Test
    void save_cash_board_entity() {
        CashBoardEntity cashBoardEntity = new CashBoardEntity();
        cashBoardEntity.setId(1L);
        cashBoardEntity.setUserId("1");
        cashBoardEntity.setTitle("테스트 제목");
        cashBoardEntity.setCashData("테스트 내용");
        cashBoardEntity.setUploadTime(LocalDateTime.now());
        cashBoardEntity.setModifyTime(LocalDateTime.now());

        saveDAOBean.exec(cashBoardEntity);

        CashBoardEntity test = saveDAOBean.cashBoardRepositoryJPA.findById(1L).get();
        assertThat(test).isNotNull();
    }

    @Test
    void save_user_entity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setUserId("1");
        userEntity.setNickName("이승민");
        userEntity.setEmail("kk@tukorea.ac.kr");

        saveDAOBean.exec(userEntity);

        UserEntity test = saveDAOBean.userRepositoryJPA.findById(1L).get();
        assertThat(test).isNotNull();
    }
}