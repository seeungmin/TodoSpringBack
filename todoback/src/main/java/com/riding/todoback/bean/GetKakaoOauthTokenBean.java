package com.riding.todoback.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.riding.todoback.bean.Small.*;
import com.riding.todoback.model.DTO.OAuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

@Component
public class GetKakaoOauthTokenBean {

    NewHeaderDAOBean newHeaderDAOBean;
    NewBodyDAOBean newBodyDAOBean;
    NewHttpDAOBean newHttpDAOBean;
    GetKakaoOauthTokenDAOBean getKakaoOauthTokenDAOBean;
    NewKakaoOauthTokenDAOBean newKakaoOauthTokenDAOBean;

    @Autowired
    public GetKakaoOauthTokenBean(NewHeaderDAOBean newHeaderDAOBean, NewBodyDAOBean newBodyDAOBean, NewHttpDAOBean newHttpDAOBean, GetKakaoOauthTokenDAOBean getKakaoOauthTokenDAOBean, NewKakaoOauthTokenDAOBean newKakaoOauthTokenDAOBean) {
        this.newHeaderDAOBean = newHeaderDAOBean;
        this.newBodyDAOBean = newBodyDAOBean;
        this.newHttpDAOBean = newHttpDAOBean;
        this.getKakaoOauthTokenDAOBean = getKakaoOauthTokenDAOBean;
        this.newKakaoOauthTokenDAOBean = newKakaoOauthTokenDAOBean;
    }

    // 카카오 OAuth Token 가져오기
    public OAuthToken exec(String code) throws JsonProcessingException {

        // 헤더 생성하기
        HttpHeaders httpHeaders = newHeaderDAOBean.exec(code);

        // 바디 생성하기
        MultiValueMap<String, String> params = newBodyDAOBean.exec(code);

        // 헤더와 바디 합치기
        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = newHttpDAOBean.exec(params, httpHeaders);

        // 토큰 정보 가져오기
        ResponseEntity<String> response = newKakaoOauthTokenDAOBean.exec(kakaoTokenRequest);

        // 매핑 후 Token 반환
        return getKakaoOauthTokenDAOBean.exec(response);
    }
}
