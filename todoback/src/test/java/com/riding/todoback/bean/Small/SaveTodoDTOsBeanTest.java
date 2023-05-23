package com.riding.todoback.bean.Small;

import com.riding.todoback.model.DTO.RequestPreviewFinishTodoAll;
import com.riding.todoback.model.DTO.RequestPreviewTodoAll;
import com.riding.todoback.model.entity.FinishedTodoEntity;
import com.riding.todoback.model.entity.TodoEntity;
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
class SaveTodoDTOsBeanTest {

    @Autowired SaveTodoDTOsBean saveTodoDTOsBean;

    @Test
    void odo_DTOs_all() {
        List<TodoEntity> todoEntities = new ArrayList<>();

        TodoEntity todoEntity1 = new TodoEntity();
        todoEntity1.setId(1L);
        todoEntity1.setUserId("1");
        todoEntity1.setContent("테스트 내용");
        todoEntity1.setUploadTime(LocalDateTime.now());
        todoEntity1.setModifyTime(LocalDateTime.now());

        TodoEntity todoEntity2 = new TodoEntity();
        todoEntity2.setId(2L);
        todoEntity2.setUserId("2");
        todoEntity2.setContent("테스트 내용2");
        todoEntity2.setUploadTime(LocalDateTime.now());
        todoEntity2.setUploadTime(LocalDateTime.now());

        todoEntities.add(todoEntity1);
        todoEntities.add(todoEntity2);

        List<RequestPreviewTodoAll> test = saveTodoDTOsBean.exec(todoEntities);

        assertThat(test.get(0).getContent()).isEqualTo("테스트 내용");
        assertThat(test.get(1).getContent()).isEqualTo("테스트 내용2");
    }
}