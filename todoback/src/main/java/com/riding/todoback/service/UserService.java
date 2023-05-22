package com.riding.todoback.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.riding.todoback.bean.GetKakaoOauthTokenBean;
import com.riding.todoback.bean.GetKakaoProfileBean;
import com.riding.todoback.bean.LoginUserBean;
import com.riding.todoback.bean.test.LogoutUserBean;
import com.riding.todoback.model.DTO.KakaoProfile;
import com.riding.todoback.model.DTO.OAuthToken;
import com.riding.todoback.model.DTO.RequestUserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    LoginUserBean loginUserBean;
    GetKakaoOauthTokenBean getKakaoOauthTokenBean;
    GetKakaoProfileBean getKakaoProfileBean;
    LogoutUserBean logoutUserBean;

    @Autowired
    public UserService(LoginUserBean loginUserBean,GetKakaoOauthTokenBean getKakaoOauthTokenBean, GetKakaoProfileBean getKakaoProfileBean, LogoutUserBean logoutUserBean) {
        this.loginUserBean = loginUserBean;
        this.getKakaoOauthTokenBean = getKakaoOauthTokenBean;
        this.getKakaoProfileBean = getKakaoProfileBean;
        this.logoutUserBean = logoutUserBean;
    }

    // 로그인
    public Long loginUserEntity(RequestUserInput requestUserInput){
        return loginUserBean.exec(requestUserInput);
    }

    // 카카오 로그인
    public Long loginUserEntity(KakaoProfile kakaoProfile){
        return loginUserBean.exec(kakaoProfile);
    }

    // 카카오 로그인 OAuth Token 받기
    public OAuthToken GetKakaoOauthToken(String code) throws JsonProcessingException {
        return getKakaoOauthTokenBean.exec(code);
    }

    // 카카오 프로필 정보 받기
    public KakaoProfile GetKakaoProfile(OAuthToken oAuthToken) throws JsonProcessingException{
        return getKakaoProfileBean.exec(oAuthToken);
    }

    /*// 카카오 로그아웃
    public void sss(OAuthToken oAuthToken) throws JsonProcessingException {
       logoutUserBean.exec(oAuthToken);
    }*/
}
