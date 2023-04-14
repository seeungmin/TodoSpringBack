package com.riding.todoback.repository;

import com.riding.todoback.model.entity.FinishedTodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinishedTodoRepositoryJPA extends JpaRepository<FinishedTodoEntity, Long> {
}
