package com.riding.todoback.repository;

import com.riding.todoback.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJPA extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserId(String userId);
}
