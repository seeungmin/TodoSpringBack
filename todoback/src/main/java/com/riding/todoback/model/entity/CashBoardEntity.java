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
public class CashBoardEntity {
    @Id
    private long id;
    String memberId;
    String title;
    String cashData;
    LocalDateTime uploadTime;
    LocalDateTime modifyTime;
}
