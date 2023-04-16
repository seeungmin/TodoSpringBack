package com.riding.todoback.bean.Small;

import com.riding.todoback.model.DTO.RequestBoardInput;
import com.riding.todoback.model.DTO.RequestDetailBoardInquire;
import com.riding.todoback.model.DTO.RequestTodoInput;
import com.riding.todoback.model.entity.BoardEntity;
import com.riding.todoback.model.entity.CashBoardEntity;
import com.riding.todoback.model.entity.FinishedTodoEntity;
import com.riding.todoback.model.entity.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class NewObjectDAOBean {

    SaveCashBoardBean saveCashBoardBean;

    @Autowired
    public NewObjectDAOBean(SaveCashBoardBean saveCashBoardBean) {
        this.saveCashBoardBean = saveCashBoardBean;
    }

    // 할 일 객체 생성
    public TodoEntity exec(Long id, RequestTodoInput requestTodoInput) {
        // 내용 받기
        String input = requestTodoInput.getContent();

        // 시간 생성
        LocalDateTime uTime = LocalDateTime.now();
        LocalDateTime mTime = LocalDateTime.now();

        // 데이터 저장
        return new TodoEntity(id, "1", input, uTime,mTime);
    }

    // 다 한 일 객체 생성
    public FinishedTodoEntity exec(TodoEntity todoEntity){

        // 내용 받기
        FinishedTodoEntity finishedTodoEntity = new FinishedTodoEntity();
        finishedTodoEntity.setId(todoEntity.getId());
        finishedTodoEntity.setMember_Id(todoEntity.getMember_Id());
        finishedTodoEntity.setContent(todoEntity.getContent());
        finishedTodoEntity.setUploadTime(todoEntity.getUploadTime());
        finishedTodoEntity.setCompletionTime(LocalDateTime.now());

        return finishedTodoEntity;
    }

    // 메모 객체 생성
    public BoardEntity exec(Long id, RequestBoardInput requestBoardInput) {

        // 제목
        String title = requestBoardInput.getTitle();

        // 내용
        String content = requestBoardInput.getContent();

        // 시간 생성
        LocalDateTime uTime = LocalDateTime.now();
        LocalDateTime mTime = LocalDateTime.now();

        // 메모장 데이터 저장
        return new BoardEntity(id, "1", title, content, uTime, mTime);
    }

    // 캐시 메모 객체 생성
    public CashBoardEntity exec(Long id, BoardEntity boardEntity){
        // 제목
        String title = boardEntity.getTitle();

        //내용
        String input = saveCashBoardBean.exec(boardEntity.getContent());

        // 시간 생성
        LocalDateTime uTime = boardEntity.getUploadTime();
        LocalDateTime mTime = boardEntity.getModifyTime();


        // 스토리보드 데이터 저장
        return new CashBoardEntity(id, "1", title, input, uTime, mTime);
    }

    // 조회한 메모 객체 DTO 생성
    public RequestDetailBoardInquire exec(BoardEntity boardEntity){

        // DTO 객체에 메모 객체 넘기기
        RequestDetailBoardInquire requestDetailBoardInquire = new RequestDetailBoardInquire();
        requestDetailBoardInquire.setId(boardEntity.getId());
        requestDetailBoardInquire.setMember_Id(boardEntity.getMember_Id());
        requestDetailBoardInquire.setTitle(boardEntity.getTitle());
        requestDetailBoardInquire.setContent(boardEntity.getContent());
        requestDetailBoardInquire.setUploadTime(boardEntity.getUploadTime());
        requestDetailBoardInquire.setModifyTime(boardEntity.getModifyTime());

        return requestDetailBoardInquire;
    }

}
