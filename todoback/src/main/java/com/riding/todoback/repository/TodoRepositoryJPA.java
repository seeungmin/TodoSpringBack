package com.riding.todoback.repository;

import com.riding.todoback.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepositoryJPA extends JpaRepository<TodoEntity, Long> {
}
