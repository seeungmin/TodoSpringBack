package com.riding.todoback.bean.Small;

import com.riding.todoback.model.entity.TodoEntity;
import com.riding.todoback.repository.TodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindByIdDAOBean {

    TodoRepositoryJPA todoRepositoryJPA;

    @Autowired
    public FindByIdDAOBean(TodoRepositoryJPA todoRepositoryJPA) {
        this.todoRepositoryJPA = todoRepositoryJPA;
    }

    // 아이디로 할 일 객체 찾기
    public TodoEntity exec(long id){
        return todoRepositoryJPA.findById(id).get();
    }
}
