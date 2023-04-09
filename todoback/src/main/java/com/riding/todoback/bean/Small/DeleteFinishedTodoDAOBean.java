package com.riding.todoback.bean.Small;

import com.riding.todoback.entity.FinishedTodoEntity;
import com.riding.todoback.model.DTO.RequestFinishTodoDelete;
import com.riding.todoback.repository.FinishedTodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteFinishedTodoDAOBean {
    FinishedTodoRepositoryJPA finishedTodoRepositoryJPA;

    @Autowired
    public DeleteFinishedTodoDAOBean(FinishedTodoRepositoryJPA finishedTodoRepositoryJPA) {
        this.finishedTodoRepositoryJPA = finishedTodoRepositoryJPA;
    }

    public boolean exec(RequestFinishTodoDelete requestFinishTodoDelete){
        // 고유 id 찾기
        long id = requestFinishTodoDelete.getId();

        // 다 한일 데이터 받기
        FinishedTodoEntity finishedTodoEntity = finishedTodoRepositoryJPA.findById(id).get();

        // 받은 데이터 삭제
        if(finishedTodoEntity == null)
            return false;
        finishedTodoRepositoryJPA.delete(finishedTodoEntity);
        return true;
    }
}
