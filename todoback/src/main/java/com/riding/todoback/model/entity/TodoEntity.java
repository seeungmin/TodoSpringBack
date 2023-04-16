package com.riding.todoback.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TodoEntity {

    @Id
    private long id;
    String memberId;
    String content;
    LocalDateTime uploadTime;
    LocalDateTime modifyTime;
}
