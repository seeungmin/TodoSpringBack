package com.riding.todoback.repository;

import com.riding.todoback.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepositoryJPA extends JpaRepository<BoardEntity, Long> {
}
