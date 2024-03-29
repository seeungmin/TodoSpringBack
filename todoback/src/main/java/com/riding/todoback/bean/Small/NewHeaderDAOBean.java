package com.riding.todoback.bean.Small;

import com.riding.todoback.model.DTO.OAuthToken;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class NewHeaderDAOBean {

    // Kakao Oauth Token 받기 위한 헤더 생성하기
    public HttpHeaders exec(String code){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

        return headers;
    }

    // Kakao profile 정보 받기 위한 헤더 생성하기
    public HttpHeaders exec(OAuthToken oAuthToken){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Bearer "+oAuthToken.getAccess_token());
        headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
        return headers;
    }
}
