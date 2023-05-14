package com.riding.todoback.bean.Small;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class NewKakaoProfileDAOBean {

    // Kakao Profile 받기
    public ResponseEntity<String> exec(HttpEntity<MultiValueMap<String, String>> httpEntity) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                httpEntity,
                String.class
        );
        return response;
    }
}
