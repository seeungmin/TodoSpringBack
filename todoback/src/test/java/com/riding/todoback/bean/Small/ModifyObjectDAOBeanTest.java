package com.riding.todoback.bean.Small;

import com.riding.todoback.model.DTO.RequestBoardModify;
import com.riding.todoback.model.DTO.RequestTodoModify;
import com.riding.todoback.model.entity.BoardEntity;
import com.riding.todoback.model.entity.CashBoardEntity;
import com.riding.todoback.model.entity.TodoEntity;
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
class ModifyObjectDAOBeanTest {

    @Autowired ModifyObjectDAOBean modifyObjectDAOBean;

    @Test
    void modify_todo() {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setId(1L);
        todoEntity.setUserId("1");
        todoEntity.setContent("이 내용은 테스트 입니다.");
        todoEntity.setModifyTime(LocalDateTime.now());
        todoEntity.setUploadTime(LocalDateTime.now());

        RequestTodoModify requestTodoModify = new RequestTodoModify();
        requestTodoModify.setId(1L);
        requestTodoModify.setContent("이 내용은 수정된 내용 입니다.");

        modifyObjectDAOBean.exec(todoEntity, requestTodoModify);

        assertThat(todoEntity.getContent()).isEqualTo(requestTodoModify.getContent());

    }

    @Test
    void modify_board() {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId(1L);
        boardEntity.setUserId("1");
        boardEntity.setTitle("테스트");
        boardEntity.setContent("이 내용은 테스트 입니다.");
        boardEntity.setModifyTime(LocalDateTime.now());
        boardEntity.setUploadTime(LocalDateTime.now());

        RequestBoardModify requestBoardModify = new RequestBoardModify();
        requestBoardModify.setId(1L);
        requestBoardModify.setTitle("테스트테스트");
        requestBoardModify.setContent("이 내용은 수정된 내용 입니다.");
        modifyObjectDAOBean.exec(boardEntity, requestBoardModify);

        assertThat(boardEntity.getContent()).isEqualTo(requestBoardModify.getContent());
    }

    @Test
    void modify_cash_board() {
        CashBoardEntity cashBoardEntity = new CashBoardEntity();
        cashBoardEntity.setId(1L);
        cashBoardEntity.setUserId("1");
        cashBoardEntity.setTitle("테스트");
        cashBoardEntity.setCashData("이 내용은 테스트 입니다.");
        cashBoardEntity.setModifyTime(LocalDateTime.now());
        cashBoardEntity.setUploadTime(LocalDateTime.now());

        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setTitle("제목 테스트");
        boardEntity.setContent("수정 완료한 내용");

        modifyObjectDAOBean.exec(cashBoardEntity, boardEntity);

        assertThat(cashBoardEntity.getCashData()).isEqualTo(boardEntity.getContent());
        assertThat(cashBoardEntity.getTitle()).isEqualTo(boardEntity.getTitle());
    }
}