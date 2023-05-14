package com.riding.todoback.bean.Small;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

@Component
public class NewHttpDAOBean {

    // Kakao Oauth Token 받기 위한 HttpEntity 생성
    public HttpEntity<MultiValueMap<String, String>> exec(MultiValueMap<String, String> params, HttpHeaders httpHeaders){
        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, httpHeaders);
        return kakaoTokenRequest;
    }

    // Kakao profile 정보 받기 위한 HttpEntity 생성
    public HttpEntity<MultiValueMap<String, String>> exec(HttpHeaders httpHeaders){
        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(httpHeaders);
        return kakaoProfileRequest;
    }
}
