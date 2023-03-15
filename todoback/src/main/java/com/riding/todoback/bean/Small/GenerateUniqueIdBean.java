package com.riding.todoback.bean.Small;

import org.springframework.stereotype.Component;

@Component
public class GenerateUniqueIdBean {

    // 해시로 Unique한 데이터 값 받기
    public long exec(){
        // 아이디 객체 생성
        GenerateUniqueIdBean generateUniqueIdBean = new GenerateUniqueIdBean();

        // 아이디 객체의 hash값으로 유니크한 아이디값 생성 후 반환
        return generateUniqueIdBean.hashCode();
    }

}
