package com.riding.todoback.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class FinishedTodoEntity {
    @Id
    private long id;
    String content;
    LocalDateTime uploadTime;
    LocalDateTime completionTime;

}
