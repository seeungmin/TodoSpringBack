package com.riding.todoback.entity;

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
public class BoardEntity {
    @Id
    private long id;
    String member_Id;
    String title;
    String content;
    LocalDateTime uploadTime;
    LocalDateTime modifyTime;

}
