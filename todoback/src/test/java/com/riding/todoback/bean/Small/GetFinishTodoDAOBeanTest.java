package com.riding.todoback.bean.Small;

import com.riding.todoback.model.entity.CashBoardEntity;
import com.riding.todoback.model.entity.FinishedTodoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class GetFinishTodoDAOBeanTest {

    @Autowired GetFinishTodoDAOBean getFinishTodoDAOBean;

    @Test
    void find_finish_todo_one() {
        FinishedTodoEntity finishedTodoEntity = new FinishedTodoEntity();
        finishedTodoEntity.setId(1L);

        getFinishTodoDAOBean.finishedTodoRepositoryJPA.save(finishedTodoEntity);

        assertThat(finishedTodoEntity.getId()).isEqualTo(getFinishTodoDAOBean.exec(1L).getId());
    }
}