package com.riding.todoback.repository;

import com.riding.todoback.model.entity.FinishedTodoEntity;
import com.riding.todoback.model.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinishedTodoRepositoryJPA extends JpaRepository<FinishedTodoEntity, Long> {
    List<FinishedTodoEntity> findByMemberId(String member_id);
}
