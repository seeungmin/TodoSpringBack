package com.riding.todoback.repository;

import com.riding.todoback.entity.TemporaryMemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemporaryMemoRepositoryJPA extends JpaRepository<TemporaryMemoEntity, Long> {
}
