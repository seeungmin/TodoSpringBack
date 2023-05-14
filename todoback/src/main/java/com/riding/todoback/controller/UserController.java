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
    public ResponseEntity<Map<String, Object>> kakaoCallBack(String code) throws JsonProcessingException {

        // 카카오 로그인 OAuth Token 받기
        OAuthToken oAuthToken = userService.GetKakaoOauthToken(code);

        // 카카오 프로필 정보 받기
        KakaoProfile kakaoProfile = userService.GetKakaoProfile(oAuthToken);

        // 카카오 로그인하기
        Long id = userService.loginUserEntity(kakaoProfile);

        // HTTP 상태 반환
        HttpStatus httpStatus = (id != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (id != null) ? "Login Success" : "Login Fail");
        requestMap.put("id", id);

        return ResponseEntity.status(httpStatus).body(requestMap);

    }
}
