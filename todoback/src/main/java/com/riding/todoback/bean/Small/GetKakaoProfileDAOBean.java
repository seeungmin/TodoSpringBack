package com.riding.todoback.bean.Small;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.riding.todoback.model.DTO.KakaoProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class GetKakaoProfileDAOBean {

    // Kakao Profile 정보 가져오기
    public KakaoProfile exec(ResponseEntity<String> response){

        // Kakao Profile 타입으로 매핑
        ObjectMapper objectMapper = new ObjectMapper();
        KakaoProfile kakaoProfile = null;
        try {
            kakaoProfile = objectMapper.readValue(response.getBody(), KakaoProfile.class);
        }catch (JsonMappingException e){
            e.printStackTrace();
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return kakaoProfile;
    }
}
