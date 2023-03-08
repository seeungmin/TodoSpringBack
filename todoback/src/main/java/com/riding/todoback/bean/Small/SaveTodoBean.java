package com.riding.todoback.bean.Small;

import com.riding.todoback.entity.TodoEntity;
import com.riding.todoback.repository.TodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SaveTodoBean {

    TodoRepositoryJPA todoRepositoryJPA;
    GenerateUniqueIdBean generateUniqueIdBean;

    @Autowired
    public SaveTodoBean(TodoRepositoryJPA todoRepositoryJPA, GenerateUniqueIdBean generateUniqueIdBean) {
        this.todoRepositoryJPA = todoRepositoryJPA;
        this.generateUniqueIdBean = generateUniqueIdBean;
    }

    // 할 일 데이터 저장
    public void exec(String input, String input2){

        // 아이디 생성
        long id = generateUniqueIdBean.exec();

        // 시간 생성
        LocalDateTime time = LocalDateTime.now();

        // 데이터 저장
        TodoEntity todoEntity = new TodoEntity(id, time, input);
        todoRepositoryJPA.save(todoEntity);
    }
}
