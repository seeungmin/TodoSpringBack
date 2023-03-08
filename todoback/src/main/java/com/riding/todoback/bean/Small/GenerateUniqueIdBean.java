package com.riding.todoback.bean.Small;

import org.springframework.stereotype.Component;

@Component
public class GenerateUniqueIdBean {

    // 해시로 Unique한 데이터 값 받기
    public long exec(){
        GenerateUniqueIdBean generateUniqueIdBean = new GenerateUniqueIdBean();
        return generateUniqueIdBean.hashCode();
    }

}
