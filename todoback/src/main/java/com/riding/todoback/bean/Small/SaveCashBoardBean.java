package com.riding.todoback.bean.Small;

import org.springframework.stereotype.Component;

@Component
public class SaveCashBoardBean {

    // 스티커보드 데이터 캐시로 받기
    public String exec(String input){
        return input.substring(0,9);
    }

}
