package com.riding.todoback.bean.Small;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class NewKakaoOauthTokenDAOBean {

    // Kakao Oauth Token 받기
    public ResponseEntity<String> exec(HttpEntity<MultiValueMap<String, String>> httpEntity) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                httpEntity,
                String.class
        );
        return response;
    }
}
