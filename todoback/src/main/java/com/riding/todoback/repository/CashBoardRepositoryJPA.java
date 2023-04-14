package com.riding.todoback.repository;

import com.riding.todoback.model.entity.CashBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashBoardRepositoryJPA extends JpaRepository<CashBoardEntity, Long> {
}
