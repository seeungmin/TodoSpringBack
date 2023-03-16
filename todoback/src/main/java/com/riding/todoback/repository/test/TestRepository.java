package com.riding.todoback.repository.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {
    @Autowired
    RepositoyJPA testRepositoyJPA;


    /*public void save(TestEntity testEntity){
        testRepositoyJPA.save(testEntity);
        System.out.println("save entity ㅇ");

    }*/

}
