package com.riding.todoback.bean.Small;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Component
public class NewBodyDAOBean {

    // Kakao Oauth Token 받기 위한 바디 생성하기
    public MultiValueMap<String, String> exec(String code) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", "775bf4e000ccfe5e6184c3cfbaed0e77");
        params.add("redirect_uri", "http://localhost:8000/auth/kakao/callback");
        params.add("code", code);

        return params;
    }
}
