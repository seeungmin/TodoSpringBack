package com.riding.todoback.bean.Small;

import com.riding.todoback.model.entity.CashBoardEntity;
import com.riding.todoback.model.entity.TodoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class GetTodoDAOBeanTest {

    @Autowired GetTodoDAOBean getTodoDAOBean;

    @Test
    void find_todo_one() {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setId(1L);

        getTodoDAOBean.todoRepositoryJPA.save(todoEntity);
        System.out.println("todoEntity.getClass() = " + todoEntity.getClass());
        assertThat(todoEntity.getId()).isEqualTo(getTodoDAOBean.exec(1L).getId());
    }
}