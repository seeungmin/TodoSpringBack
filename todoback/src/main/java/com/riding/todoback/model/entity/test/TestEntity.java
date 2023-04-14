package com.riding.todoback.model.entity.test;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TestEntity {
    @Id
    private long id;
    String data;
}
