package com.riding.todoback.bean.Small;

import com.riding.todoback.model.DTO.RequestPreviewCashBoardAll;
import com.riding.todoback.model.DTO.RequestPreviewFinishTodoAll;
import com.riding.todoback.model.entity.CashBoardEntity;
import com.riding.todoback.model.entity.FinishedTodoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SaveFinishTodoDTOsBeanTest {

    @Autowired SaveFinishTodoDTOsBean saveFinishTodoDTOsBean;

    @Test
    void finish_todo_DTOs_all() {

        List<FinishedTodoEntity> finishedTodoEntities = new ArrayList<>();

        FinishedTodoEntity finishedTodoEntity = new FinishedTodoEntity();
        finishedTodoEntity.setId(1L);
        finishedTodoEntity.setUserId("1");
        finishedTodoEntity.setContent("테스트 내용");
        finishedTodoEntity.setUploadTime(LocalDateTime.now());
        finishedTodoEntity.setCompletionTime(LocalDateTime.now());

        FinishedTodoEntity finishedTodoEntity2 = new FinishedTodoEntity();
        finishedTodoEntity2.setId(2L);
        finishedTodoEntity2.setUserId("2");
        finishedTodoEntity2.setContent("테스트 내용2");
        finishedTodoEntity2.setUploadTime(LocalDateTime.now());
        finishedTodoEntity2.setUploadTime(LocalDateTime.now());

        finishedTodoEntities.add(finishedTodoEntity);
        finishedTodoEntities.add(finishedTodoEntity2);

        List<RequestPreviewFinishTodoAll> test = saveFinishTodoDTOsBean.exec(finishedTodoEntities);

        assertThat(test.get(0).getContent()).isEqualTo("테스트 내용");
        assertThat(test.get(1).getContent()).isEqualTo("테스트 내용2");

    }

}