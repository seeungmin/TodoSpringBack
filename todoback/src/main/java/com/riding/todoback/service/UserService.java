package com.riding.todoback.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.riding.todoback.bean.GetKakaoOauthTokenBean;
import com.riding.todoback.bean.LoginUserBean;
import com.riding.todoback.model.DTO.OAuthToken;
import com.riding.todoback.model.DTO.RequestUserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    LoginUserBean loginUserBean;
    GetKakaoOauthTokenBean getKakaoOauthTokenBean;

    @Autowired
    public UserService(LoginUserBean loginUserBean,GetKakaoOauthTokenBean getKakaoOauthTokenBean) {
        this.loginUserBean = loginUserBean;
        this.getKakaoOauthTokenBean = getKakaoOauthTokenBean;
    }

    // 로그인
    public Long loginUserEntity(RequestUserInput requestUserInput){
        return loginUserBean.exec(requestUserInput);
    }

    // 카카오 로그인 OAuth Token 받기
    public OAuthToken GetKakaoOauthToken(String code) throws JsonProcessingException {
        return getKakaoOauthTokenBean.exec(code);
    }
}
