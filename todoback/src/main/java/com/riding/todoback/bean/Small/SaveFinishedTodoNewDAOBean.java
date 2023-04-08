package com.riding.todoback.bean.Small;

import com.riding.todoback.entity.FinishedTodoEntity;
import com.riding.todoback.entity.TodoEntity;
import com.riding.todoback.model.DTO.RequestFinishTodoInput;
import com.riding.todoback.repository.FinishedTodoRepositoryJPA;
import com.riding.todoback.repository.TodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class SaveFinishedTodoNewDAOBean {

    TodoRepositoryJPA todoRepositoryJPA;
    FinishedTodoRepositoryJPA finishedTodoRepositoryJPA;
    DeleteTodoDAOBean deleteTodoDAOBean;

    @Autowired
    public SaveFinishedTodoNewDAOBean(TodoRepositoryJPA todoRepositoryJPA, FinishedTodoRepositoryJPA finishedTodoRepositoryJPA, DeleteTodoDAOBean deleteTodoDAOBean) {
        this.todoRepositoryJPA = todoRepositoryJPA;
        this.finishedTodoRepositoryJPA = finishedTodoRepositoryJPA;
        this.deleteTodoDAOBean = deleteTodoDAOBean;
    }


    public void exec(RequestFinishTodoInput requestFinishTodoInput){

        // 아이디로 옮길 할 일 찾기
        long id = requestFinishTodoInput.getId();

        // 다 한일로 넘길 할 일 데이터 저장
        Optional<TodoEntity> data = todoRepositoryJPA.findById(id);

        // 다 한일 데이터 새로운 객체에 저장
        FinishedTodoEntity finishedTodoEntity = new FinishedTodoEntity();
        finishedTodoEntity.setId(data.get().getId());
        finishedTodoEntity.setMember_Id(data.get().getMember_Id());
        finishedTodoEntity.setContent(data.get().getContent());
        finishedTodoEntity.setUploadTime(data.get().getUploadTime());
        finishedTodoEntity.setCompletionTime(LocalDateTime.now());

        // 다 한일 저장
        finishedTodoRepositoryJPA.save(finishedTodoEntity);

        // 기존 할 일 삭제
        deleteTodoDAOBean.exec(data);

    }
}
