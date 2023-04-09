package com.riding.todoback.bean.Small;

import com.riding.todoback.entity.BoardEntity;
import com.riding.todoback.model.DTO.RequestBoardDelete;
import com.riding.todoback.repository.BoardRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteBoardDAOBean {
    BoardRepositoryJPA boardRepositoryJPA;

    @Autowired
    public DeleteBoardDAOBean(BoardRepositoryJPA boardRepositoryJPA) {
        this.boardRepositoryJPA = boardRepositoryJPA;
    }

    public boolean exec(RequestBoardDelete requestBoardDelete){
        // 고유 아이디 받기
        long id = requestBoardDelete.getId();

        // 메모 데이터 받기
        BoardEntity boardEntity = boardRepositoryJPA.findById(id).get();

        // 받은 데이터 삭제
        if(boardEntity == null)
            return false;
        boardRepositoryJPA.delete(boardEntity);
        return true;
    }
}
