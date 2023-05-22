package com.riding.todoback.bean.Small;

import com.riding.todoback.model.DTO.RequestBoardInput;
import com.riding.todoback.model.DTO.RequestTodoInput;
import com.riding.todoback.model.entity.BoardEntity;
import com.riding.todoback.model.entity.FinishedTodoEntity;
import com.riding.todoback.model.entity.TodoEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
class NewObjectDAOBeanTest {

    @Autowired NewObjectDAOBean newObjectDAOBean;

    @Test
    void save_todo() {

        long id = 1L;
        RequestTodoInput requestTodoInput = new RequestTodoInput();
        requestTodoInput.setUserId("1");
        requestTodoInput.setContent("테스트입니다.");

        TodoEntity todoEntity = newObjectDAOBean.exec(id, requestTodoInput);

        assertThat(todoEntity.getId()).isEqualTo(1L);
        assertThat(todoEntity.getUserId()).isEqualTo("1");
        assertThat(todoEntity.getContent()).isEqualTo("테스트입니다.");

    }

    @Test
    void save_finish_todo() {

        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setId(1L);
        todoEntity.setUserId("1");
        todoEntity.setContent("테스트 내용");
        todoEntity.setUploadTime(LocalDateTime.now());
        todoEntity.setModifyTime(LocalDateTime.now());

        FinishedTodoEntity finishedTodoEntity = newObjectDAOBean.exec(todoEntity);

        assertThat(finishedTodoEntity.getId()).isEqualTo(1L);
        assertThat(finishedTodoEntity.getUserId()).isEqualTo("1");
        assertThat(finishedTodoEntity.getContent()).isEqualTo("테스트 내용");
    }

    @Test
    void save_board() {

        long id = 1L;
        RequestBoardInput requestBoardInput = new RequestBoardInput();
        requestBoardInput.setUserId("1");
        requestBoardInput.setTitle("테스트 제목");
        requestBoardInput.setContent("테스트 내용");

        BoardEntity boardEntity = newObjectDAOBean.exec(id, requestBoardInput);

        assertThat(boardEntity.getId()).isEqualTo(1L);
        assertThat(boardEntity.getUserId()).isEqualTo("1");
        assertThat(boardEntity.getTitle()).isEqualTo("테스트 제목");
        assertThat(boardEntity.getContent()).isEqualTo("테스트 내용");
    }

    @Test
    void save_cash_board() {
    }

    @Test
    void testExec3() {
    }

    @Test
    void testExec4() {
    }

    @Test
    void testExec5() {
    }
}