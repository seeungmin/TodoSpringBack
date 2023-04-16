package com.riding.todoback.bean.Small;

import com.riding.todoback.model.entity.BoardEntity;
import com.riding.todoback.repository.BoardRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetBoardEntityBean {
    BoardRepositoryJPA boardRepositoryJPA;

    @Autowired
    public GetBoardEntityBean(BoardRepositoryJPA boardRepositoryJPA) {
        this.boardRepositoryJPA = boardRepositoryJPA;
    }

    // 메모 객체 찾기
    public BoardEntity exec(Long id){
        return boardRepositoryJPA.findById(id).get();
    }
}
