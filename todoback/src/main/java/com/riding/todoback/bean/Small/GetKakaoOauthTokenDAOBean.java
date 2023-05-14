package com.riding.todoback.bean.Small;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.riding.todoback.model.DTO.OAuthToken;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class GetKakaoOauthTokenDAOBean {

    // Kakao Oauth Token 정보 가져오기
    public OAuthToken exec(ResponseEntity<String> response){

        // OAuth Token 타입으로 매핑
        ObjectMapper objectMapper = new ObjectMapper();
        OAuthToken oAuthToken = null;
        try {
            oAuthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);
        }catch (JsonMappingException e){
            e.printStackTrace();
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return oAuthToken;
    }
}
