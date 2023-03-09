package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.GenerateUniqueIdBean;
import com.riding.todoback.entity.FinishedTodoEntity;
import com.riding.todoback.entity.TodoEntity;
import com.riding.todoback.repository.FinishedTodoRepositoryJPA;
import com.riding.todoback.repository.TodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class SaveFinishedTodoBean {

    TodoRepositoryJPA todoRepositoryJPA;
    FinishedTodoRepositoryJPA finishedTodoRepositoryJPA;
    GenerateUniqueIdBean generateUniqueIdBean;

    @Autowired
    public SaveFinishedTodoBean(TodoRepositoryJPA todoRepositoryJPA, FinishedTodoRepositoryJPA finishedTodoRepositoryJPA, GenerateUniqueIdBean generateUniqueIdBean) {
        this.todoRepositoryJPA = todoRepositoryJPA;
        this.finishedTodoRepositoryJPA = finishedTodoRepositoryJPA;
        this.generateUniqueIdBean = generateUniqueIdBean;
    }

    // 다 한일 데이터 저장
    public void exec(long id){

        // 다 한일로 넘길 할 일 데이터 저장
        Optional<TodoEntity> data = todoRepositoryJPA.findById(id);

        // 다 한일 데이터 새로운 객체에 저장
        FinishedTodoEntity finishedTodoEntity = new FinishedTodoEntity();
        finishedTodoEntity.setId(data.get().getId());
        finishedTodoEntity.setContent(data.get().getContent());
        finishedTodoEntity.setUploadTime(data.get().getUploadTime());
        finishedTodoEntity.setCompletionTime(LocalDateTime.now());

        // 다 한일 데이터 저장
        finishedTodoRepositoryJPA.save(finishedTodoEntity);

        // 할일에서 완료된 일로 바뀐 데이터 삭제
        TodoEntity todoEntity = data.get();
        todoRepositoryJPA.delete(todoEntity);
    }

}
