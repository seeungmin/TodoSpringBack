package com.riding.todoback.bean.Small;

import com.riding.todoback.bean.Small.GenerateIdByEntityBean;
import com.riding.todoback.bean.Small.GenerateUniqueIdBean;
import com.riding.todoback.entity.BoardEntity;
import com.riding.todoback.entity.CashBoardEntity;
import com.riding.todoback.repository.BoardRepositoryJPA;
import com.riding.todoback.repository.CashBoardRepositoryJPA;
import com.riding.todoback.service.MemoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SaveCashBoardBean {

    @Autowired
    BoardRepositoryJPA boardRepositoryJPA;

    // 스티커보드 데이터 캐시로 받기
    // @Casheable 필요없음
    @Cacheable(value = "data")
    public BoardEntity exec(long id){
        return boardRepositoryJPA.findById(id).orElseThrow(()-> new NullPointerException("uu"));
    }

}
