package com.riding.todoback.bean.Small;

import com.riding.todoback.model.DTO.KakaoProfile;
import com.riding.todoback.model.DTO.RequestUserInput;
import com.riding.todoback.model.entity.UserEntity;
import com.riding.todoback.repository.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserDAOBean {

    UserRepositoryJPA userRepositoryJPA;

    @Autowired
    public GetUserDAOBean(UserRepositoryJPA userRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
    }

    // 카카오톡 아이디로 유저 찾기
    public Long exec(RequestUserInput requestUserInput){

        // DTO로 카카오 아이디 찾기
        String userId = requestUserInput.getUserId();

        // 객체 찾기
        UserEntity byUserId = userRepositoryJPA.findByUserId(userId);

        // 유저가 존재하면 카카오 아이디 반환 아니면 null 반환
        if(byUserId == null){
            return null;
        }
        else {
            requestUserInput.setId(byUserId.getId());
            return requestUserInput.getId();
        }
    }

    // 카카오톡 아이디로 유저 찾기
    public Long exec(KakaoProfile kakaoProfile){

        // DTO로 카카오 아이디 찾기
        Long userId = kakaoProfile.getId();

        // 객체 찾기
        UserEntity byUserId = userRepositoryJPA.findByUserId(userId.toString());

        // 유저가 존재하면 카카오 아이디 반환 아니면 null 반환
        if(byUserId == null){
            return null;
        }
        else {
            return byUserId.getId();
        }
    }

}
