package com.riding.todoback.repository;

import com.riding.todoback.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepositoryJPA extends JpaRepository<MemberEntity, Long> {
}
