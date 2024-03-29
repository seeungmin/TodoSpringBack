package com.riding.todoback.bean.Small;

import com.riding.todoback.model.DTO.*;
import com.riding.todoback.model.entity.*;
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

        // 아이디 받기
        String userId= requestTodoInput.getUserId();

        // 시간 생성
        LocalDateTime uTime = LocalDateTime.now();
        LocalDateTime mTime = LocalDateTime.now();

        // 데이터 저장
        return new TodoEntity(id, userId, input, uTime,mTime);
    }

    // 다 한 일 객체 생성
    public FinishedTodoEntity exec(TodoEntity todoEntity){

        // 내용 받기
        FinishedTodoEntity finishedTodoEntity = new FinishedTodoEntity();
        finishedTodoEntity.setId(todoEntity.getId());
        finishedTodoEntity.setUserId(todoEntity.getUserId());
        finishedTodoEntity.setContent(todoEntity.getContent());
        finishedTodoEntity.setUploadTime(todoEntity.getUploadTime());
        finishedTodoEntity.setCompletionTime(LocalDateTime.now());

        return finishedTodoEntity;
    }

    // 메모 객체 생성
    public BoardEntity exec(Long id, RequestBoardInput requestBoardInput) {

        // 유저 아이디
        String userId = requestBoardInput.getUserId();

        // 제목
        String title = requestBoardInput.getTitle();

        // 내용
        String content = requestBoardInput.getContent();

        // 시간 생성
        LocalDateTime uTime = LocalDateTime.now();
        LocalDateTime mTime = LocalDateTime.now();

        // 메모장 데이터 저장
        return new BoardEntity(id, userId, title, content, uTime, mTime);
    }

    // 캐시 메모 객체 생성
    public CashBoardEntity exec(Long id, BoardEntity boardEntity){

        // 유저 아이디
        String userId = boardEntity.getUserId();

        // 제목
        String title = boardEntity.getTitle();

        //내용
        String input = saveCashBoardBean.exec(boardEntity.getContent());

        // 시간 생성
        LocalDateTime uTime = boardEntity.getUploadTime();
        LocalDateTime mTime = boardEntity.getModifyTime();


        // 스토리보드 데이터 저장
        return new CashBoardEntity(id, userId, title, input, uTime, mTime);
    }

    // 조회한 메모 객체 DTO 생성
    public RequestDetailBoardInquire exec(BoardEntity boardEntity){

        // DTO 객체에 메모 객체 넘기기
        RequestDetailBoardInquire requestDetailBoardInquire = new RequestDetailBoardInquire();
        requestDetailBoardInquire.setId(boardEntity.getId());
        requestDetailBoardInquire.setUserId(boardEntity.getUserId());
        requestDetailBoardInquire.setTitle(boardEntity.getTitle());
        requestDetailBoardInquire.setContent(boardEntity.getContent());
        requestDetailBoardInquire.setUploadTime(boardEntity.getUploadTime());
        requestDetailBoardInquire.setModifyTime(boardEntity.getModifyTime());

        return requestDetailBoardInquire;
    }

    // 유저 객체 생성
    public UserEntity exec(Long id, RequestUserInput requestUserInput) {

        // 아이디
        String userId = requestUserInput.getUserId();

        // 닉네임
        String nickName = requestUserInput.getNickName();

        // 이메일
        String email = requestUserInput.getEmail();


        // 메모장 데이터 저장
        return new UserEntity(id, userId, nickName, email);
    }

    // 유저 객체 생성
    public UserEntity exec(Long id, KakaoProfile kakaoProfile) {

        // 아이디
        Long userId = kakaoProfile.getId();

        // 닉네임
        String nickName = kakaoProfile.kakao_account.profile.getNickname();

        // 이메일
        String email = kakaoProfile.kakao_account.getEmail();

        // 메모장 데이터 저장
        return new UserEntity(id, userId.toString(), nickName, email);
    }

}
