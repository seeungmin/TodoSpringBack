package com.riding.todoback.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.riding.todoback.bean.GetKakaoOauthTokenBean;
import com.riding.todoback.bean.GetKakaoProfileBean;
import com.riding.todoback.bean.LoginUserBean;
import com.riding.todoback.model.DTO.KakaoProfile;
import com.riding.todoback.model.DTO.OAuthToken;
import com.riding.todoback.model.DTO.RequestUserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    LoginUserBean loginUserBean;
    GetKakaoOauthTokenBean getKakaoOauthTokenBean;
    GetKakaoProfileBean getKakaoProfileBean;

    @Autowired
    public UserService(LoginUserBean loginUserBean,GetKakaoOauthTokenBean getKakaoOauthTokenBean, GetKakaoProfileBean getKakaoProfileBean) {
        this.loginUserBean = loginUserBean;
        this.getKakaoOauthTokenBean = getKakaoOauthTokenBean;
        this.getKakaoProfileBean = getKakaoProfileBean;
    }

    // 로그인
    public Long loginUserEntity(RequestUserInput requestUserInput){
        return loginUserBean.exec(requestUserInput);
    }

    public Long loginUserEntity(KakaoProfile kakaoProfile){
        return loginUserBean.exec(kakaoProfile);
    }

    // 카카오 로그인 OAuth Token 받기
    public OAuthToken GetKakaoOauthToken(String code) throws JsonProcessingException {
        return getKakaoOauthTokenBean.exec(code);
    }

    public KakaoProfile GetKakaoProfile(OAuthToken oAuthToken) throws JsonProcessingException{
        return getKakaoProfileBean.exec(oAuthToken);
    }
}
