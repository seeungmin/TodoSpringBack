package com.riding.todoback.bean.Small;

import com.riding.todoback.entity.BoardEntity;
import com.riding.todoback.entity.TodoEntity;
import com.riding.todoback.model.DTO.RequestBoardModify;
import com.riding.todoback.model.DTO.RequestTodoModify;
import com.riding.todoback.repository.BoardRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ModifyBoardDAOBean {
    BoardRepositoryJPA boardRepositoryJPA;

    @Autowired
    public ModifyBoardDAOBean(BoardRepositoryJPA boardRepositoryJPA) {
        this.boardRepositoryJPA = boardRepositoryJPA;
    }

    public boolean exec(RequestBoardModify requestBoardModify){

        // 바디 정보 가져오기
        long id = requestBoardModify.getId();
        String title = requestBoardModify.getTitle();
        String content = requestBoardModify.getContent();

        // 아이디로 수정할 할 일 찾기
        BoardEntity boardEntity = boardRepositoryJPA.findById(id).get();

        // 새로 받을 내용 작성
        boardEntity.setTitle(title);
        boardEntity.setContent(content);
        boardEntity.setModifyTime(LocalDateTime.now());

        // 새로운 데이터 기존 아이디에 저장
        if(boardRepositoryJPA.save(boardEntity) == null)
            return false;
        return true;
    }
}
