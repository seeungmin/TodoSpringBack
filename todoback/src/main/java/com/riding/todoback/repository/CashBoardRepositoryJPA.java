package com.riding.todoback.repository;

import com.riding.todoback.model.entity.CashBoardEntity;
import com.riding.todoback.model.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CashBoardRepositoryJPA extends JpaRepository<CashBoardEntity, Long> {
    List<CashBoardEntity> findByUserId(String userId);
}
