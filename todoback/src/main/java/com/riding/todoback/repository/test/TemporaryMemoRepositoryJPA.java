package com.riding.todoback.repository.test;

import com.riding.todoback.entity.test.TemporaryMemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemporaryMemoRepositoryJPA extends JpaRepository<TemporaryMemoEntity, Long> {
}
