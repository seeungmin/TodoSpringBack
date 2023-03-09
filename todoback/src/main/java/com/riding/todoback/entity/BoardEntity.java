package com.riding.todoback.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BoardEntity {
    @Id
    private long id;
    String content;
    LocalDateTime uploadTime;

    public String getContent() {
        return content;
    }
}
