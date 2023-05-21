package com.riding.todoback.bean.Small;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class GenerateUniqueIdBeanTest {

    @Autowired GenerateUniqueIdBean generateUniqueIdBean;

    @Test
    void user_unique_id() {
        long uniqueId = 0L;
        Long testId = 0L;

        for(int i = 0; i<10000; i++){
            uniqueId = generateUniqueIdBean.exec();
            testId = generateUniqueIdBean.exec();
            if(uniqueId == testId)
                break;
        }

        assertThat(uniqueId).isNotEqualTo(testId);
    }
}