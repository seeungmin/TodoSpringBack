package com.riding.todoback.service.test;

import com.riding.todoback.bean.Small.GenerateUniqueIdBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    GenerateUniqueIdBean generateUniqueIdBean;

    public void testGenerateID(){
        generateUniqueIdBean.exec();
    }
    /*public void saveTestEntity(String input){
        long id = 1;
        TestEntity testEntity = new TestEntity(id, input);
        testRepositoyJPA.save(testEntity);
    }*/


}
