package com.riding.todoback.bean.Small;

import com.riding.todoback.model.DTO.RequestTodoInput;
import com.riding.todoback.model.entity.TodoEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
    }

    @Test
    void save_board() {
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