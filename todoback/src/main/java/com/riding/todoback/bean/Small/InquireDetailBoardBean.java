package com.riding.todoback.bean.Small;

import com.riding.todoback.entity.BoardEntity;
import com.riding.todoback.repository.BoardRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InquireDetailBoardBean {

    @Autowired
    BoardRepositoryJPA boardRepositoryJPA;

    public BoardEntity exec(long id){
        return boardRepositoryJPA.findById(id).get();
    }
}
