package com.riding.todoback.repository;

import com.riding.todoback.model.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepositoryJPA extends JpaRepository<TodoEntity, Long> {
    List<TodoEntity> findByUserId(String userId);
}
