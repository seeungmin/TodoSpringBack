package com.riding.todoback.bean.Small;

import com.riding.todoback.model.DTO.*;
import com.riding.todoback.model.entity.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
class NewObjectDAOBeanTest {

    @Autowired NewObjectDAOBean newObjectDAOBean;

    @Test
    void save_todo_Object_DAO() {

        long id = 1L;
        RequestTodoInput requestTodoInput = new RequestTodoInput();
        requestTodoInput.setUserId("1");
        requestTodoInput.setContent("테스트입니다.");

        TodoEntity todoEntity = newObjectDAOBean.exec(id, requestTodoInput);

        assertThat(todoEntity.getId()).isEqualTo(1L);
        assertThat(todoEntity.getUserId()).isEqualTo("1");
        assertThat(todoEntity.getContent()).isEqualTo("테스트입니다.");

    }

    @Test
    void save_finish_todo_Object_DAO() {

        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setId(1L);
        todoEntity.setUserId("1");
        todoEntity.setContent("테스트 내용");
        todoEntity.setUploadTime(LocalDateTime.now());
        todoEntity.setModifyTime(LocalDateTime.now());

        FinishedTodoEntity finishedTodoEntity = newObjectDAOBean.exec(todoEntity);

        assertThat(finishedTodoEntity.getId()).isEqualTo(1L);
        assertThat(finishedTodoEntity.getUserId()).isEqualTo("1");
        assertThat(finishedTodoEntity.getContent()).isEqualTo("테스트 내용");
    }

    @Test
    void save_board_Object_DAO() {

        long id = 1L;
        RequestBoardInput requestBoardInput = new RequestBoardInput();
        requestBoardInput.setUserId("1");
        requestBoardInput.setTitle("테스트 제목");
        requestBoardInput.setContent("테스트 내용");

        BoardEntity boardEntity = newObjectDAOBean.exec(id, requestBoardInput);

        assertThat(boardEntity.getId()).isEqualTo(1L);
        assertThat(boardEntity.getUserId()).isEqualTo("1");
        assertThat(boardEntity.getTitle()).isEqualTo("테스트 제목");
        assertThat(boardEntity.getContent()).isEqualTo("테스트 내용");
    }

    @Test
    void save_cash_board_Object_DAO() {
        Long id = 1L;
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setUserId("1");
        boardEntity.setTitle("테스트 제목");
        boardEntity.setContent("테스트내용123451111");
        boardEntity.setUploadTime(LocalDateTime.now());
        boardEntity.setModifyTime(LocalDateTime.now());

        CashBoardEntity cashBoardEntity = newObjectDAOBean.exec(id, boardEntity);

        assertThat(cashBoardEntity.getId()).isEqualTo(1L);
        assertThat(cashBoardEntity.getUserId()).isEqualTo("1");
        assertThat(cashBoardEntity.getTitle()).isEqualTo("테스트 제목");
        assertThat(cashBoardEntity.getCashData()).isEqualTo("테스트내용12345");
    }

    @Test
    void new_board_Object_DAO() {

        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId(1L);
        boardEntity.setUserId("1");
        boardEntity.setTitle("테스트 제목");
        boardEntity.setContent("테스트내용123451111");
        boardEntity.setUploadTime(LocalDateTime.now());
        boardEntity.setModifyTime(LocalDateTime.now());

        RequestDetailBoardInquire requestDetailBoardInquire = newObjectDAOBean.exec(boardEntity);

        assertThat(requestDetailBoardInquire.getId()).isEqualTo(1L);
        assertThat(requestDetailBoardInquire.getUserId()).isEqualTo("1");
        assertThat(requestDetailBoardInquire.getTitle()).isEqualTo("테스트 제목");
        assertThat(requestDetailBoardInquire.getContent()).isEqualTo("테스트내용123451111");
    }

    @Test
    void save_user_Object_DAO() {
        Long id = 1L;
        RequestUserInput requestUserInput = new RequestUserInput();
        requestUserInput.setUserId("1");
        requestUserInput.setNickName("이승민");
        requestUserInput.setEmail("hi@tukorea.com");

        UserEntity userEntity = newObjectDAOBean.exec(id, requestUserInput);

        assertThat(userEntity.getId()).isEqualTo(1L);
        assertThat(userEntity.getUserId()).isEqualTo("1");
        assertThat(userEntity.getEmail()).isEqualTo("hi@tukorea.com");
        assertThat(userEntity.getNickName()).isEqualTo("이승민");
    }

    @Test
    void save_user_kakao_Object_DAO() {

        Long id = 1L;

        KakaoProfile kakaoProfile = new KakaoProfile();
        KakaoProfile.KakaoAccount kakaoAccount = new KakaoProfile.KakaoAccount();
        KakaoProfile.KakaoAccount.Profile profile = new KakaoProfile.KakaoAccount.Profile();

        kakaoProfile.setKakao_account(kakaoAccount);
        kakaoProfile.kakao_account.setProfile(profile);
        kakaoProfile.setId(2L);
        kakaoAccount.setEmail("hi@tukorea.com");
        profile.setNickname("이승민");

        UserEntity userEntity = newObjectDAOBean.exec(id, kakaoProfile);

        assertThat(userEntity.getId()).isEqualTo(1L);
        assertThat(userEntity.getUserId()).isEqualTo("2");
        assertThat(userEntity.getEmail()).isEqualTo("hi@tukorea.com");
        assertThat(userEntity.getNickName()).isEqualTo("이승민");
    }
}