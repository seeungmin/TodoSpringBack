package com.riding.todoback.bean.Small;

import com.riding.todoback.model.entity.FinishedTodoEntity;
import com.riding.todoback.model.entity.TodoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class GetTodoDAOsBeanTest {

    @Autowired GetTodoDAOsBean getTodoDAOsBean;
    @Test
    void exec() {
        TodoEntity todoEntity1 = new TodoEntity();
        todoEntity1.setUserId("122");
        todoEntity1.setId(111L);
        TodoEntity todoEntity2 = new TodoEntity();
        todoEntity2.setUserId("122");
        todoEntity2.setId(222L);

        getTodoDAOsBean.todoRepositoryJPA.save(todoEntity1);
        getTodoDAOsBean.todoRepositoryJPA.save(todoEntity2);

        assertThat(todoEntity1.getId()).isEqualTo(getTodoDAOsBean.exec("122").get(0).getId());
        assertThat(todoEntity2.getId()).isEqualTo(getTodoDAOsBean.exec("122").get(1).getId());
    }
}