package com.riding.todoback.repository.test;

import com.riding.todoback.model.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoyJPA extends JpaRepository<TodoEntity, Long> {

}
