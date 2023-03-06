package com.riding.todoback.bean.Small;

import org.springframework.stereotype.Component;

@Component
public class GenerateUniqueIdBean {

    // 해시로 Unique한 데이터 값 받기
    public long exec(){
        GenerateUniqueIdBean generateUniqueIdBean = new GenerateUniqueIdBean();
        return generateUniqueIdBean.hashCode();
    }
/*    public long exec(int type){
        if(type ==0){
            return 0l;
        }
        return 1l;
    }*/
}
