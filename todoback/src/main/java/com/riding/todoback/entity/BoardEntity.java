package com.riding.todoback.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BoardEntity {
    @Id
    private long id;
    String content;

    public String getContent() {
        return content;
    }
}
