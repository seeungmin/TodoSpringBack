package com.riding.todoback.bean.Small;

import com.riding.todoback.model.DTO.RequestTodoModify;
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
        
    }

    @Test
    void modify_cash_board() {
    }
}