package com.riding.todoback.bean.test;

import org.springframework.stereotype.Component;

@Component
public class GenerateIdByEntityBean {
    public long exec(){
        return 0;
    }
    public long exec(int type){
        if(type ==0){
            return 0l;
        }
        return 1l;
    }
}
