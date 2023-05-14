package com.riding.todoback.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.riding.todoback.model.DTO.KakaoProfile;
import com.riding.todoback.model.DTO.OAuthToken;
import com.riding.todoback.model.DTO.RequestTodoInput;
import com.riding.todoback.model.DTO.RequestUserInput;
import com.riding.todoback.model.entity.UserEntity;
import com.riding.todoback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Controller
@CrossOrigin("*")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 로그인
    @PostMapping("login")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> userLogin(@RequestBody RequestUserInput requestUserInput){
        Long id = userService.loginUserEntity(requestUserInput);

        // HTTP 상태 반환
        HttpStatus httpStatus = (id != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (id != null) ? "Login Success" : "Login Fail");
        requestMap.put("id", id);

        return ResponseEntity.status(httpStatus).body(requestMap);

    }


    @GetMapping("auth/kakao/callback")
    @ResponseBody
    public void kakaoCallBack(String code) throws JsonProcessingException {

        OAuthToken oAuthToken = userService.GetKakaoOauthToken(code);
        System.out.println("oAuthToken.getAccess_token() = " + oAuthToken.getAccess_token());



        /*ObjectMapper objectMapper = new ObjectMapper();
        OAuthToken oAuthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);

        System.out.println("카카오 엑세스 토큰 = " + oAuthToken.getAccess_token());

        RestTemplate rt2 = new RestTemplate();
        HttpHeaders headers2 = new HttpHeaders();

        headers2.add("Authorization","Bearer "+oAuthToken.getAccess_token());
        headers2.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest =
                new HttpEntity<>(headers2);

        ResponseEntity<String> response2 = rt2.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoProfileRequest,
                String.class
        );*/
        /*ObjectMapper objectMapper2 = new ObjectMapper();
        KakaoProfile kakaoProfile = objectMapper2.readValue(response2.getBody(), KakaoProfile.class);

        RequestUserInput requestUserInput = new RequestUserInput();
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(kakaoProfile.getId().toString());
        userEntity.setUserEmail(kakaoProfile.getKakao_account().getEmail());

        memberService.join(member);

        System.out.println("카카오 아이디(번호) = " + kakaoProfile.getId());
        System.out.println("카카오 이메일 = " + kakaoProfile.getKakao_account().getEmail());
        System.out.println("카카오 프사 = " + kakaoProfile.kakao_account.profile.getNickname());

        return member;*/
    }
}
