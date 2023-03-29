package com.riding.todoback.bean;

import org.springframework.stereotype.Component;

@Component
public class SaveCashBoardBean {

    // 스티커보드 데이터 캐시로 받기
    public String exec(String input){
        // 10글자 이하 캐싱 예외처리
        if(input.length() < 11)
            return input.substring(0);

        // 10글자 이상 시 10글자 데이터 저장
        return input.substring(0,10);
    }

}
