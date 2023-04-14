package com.riding.todoback.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CashBoardEntity {
    @Id
    private long id;
    String member_Id;
    String title;
    String cashData;
    LocalDateTime uploadTime;
    LocalDateTime modifyTime;
}
