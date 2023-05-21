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
class GetFinishTodoDAOsBeanTest {

    @Autowired GetFinishTodoDAOsBean getFinishTodoDAOsBean;
    @Test
    void find_finish_todo_all() {
        FinishedTodoEntity finishedTodoEntity1 = new FinishedTodoEntity();
        finishedTodoEntity1.setUserId("122");
        finishedTodoEntity1.setId(111L);
        FinishedTodoEntity finishedTodoEntity2 = new FinishedTodoEntity();
        finishedTodoEntity2.setUserId("122");
        finishedTodoEntity2.setId(222L);

        getFinishTodoDAOsBean.finishedTodoRepositoryJPA.save(finishedTodoEntity1);
        getFinishTodoDAOsBean.finishedTodoRepositoryJPA.save(finishedTodoEntity2);

        assertThat(finishedTodoEntity1.getId()).isEqualTo(getFinishTodoDAOsBean.exec("122").get(0).getId());
        assertThat(finishedTodoEntity2.getId()).isEqualTo(getFinishTodoDAOsBean.exec("122").get(1).getId());
    }
}