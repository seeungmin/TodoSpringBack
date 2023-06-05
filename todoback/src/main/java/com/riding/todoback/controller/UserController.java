package com.riding.todoback.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.riding.todoback.model.DTO.KakaoProfile;
import com.riding.todoback.model.DTO.OAuthToken;
import com.riding.todoback.model.DTO.RequestUserInput;
import com.riding.todoback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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
        // 로그인 아이디 받기
        Long id = userService.loginUserEntity(requestUserInput);

        // HTTP 상태 반환
        HttpStatus httpStatus = (id != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (id != null) ? "Login Success" : "Login Fail");
        requestMap.put("id", id);

        return ResponseEntity.status(httpStatus).body(requestMap);

    }

    // 카카오 로그인
    @GetMapping("auth/kakao/callback")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> kakaoCallBack(String code) throws JsonProcessingException {

        // 카카오 로그인 OAuth Token 받기
        OAuthToken oAuthToken = userService.getKakaoOauthToken(code);
        System.out.println("oAuthToken = " + oAuthToken);
        // 카카오 프로필 정보 받기
        KakaoProfile kakaoProfile = userService.getKakaoProfile(oAuthToken);

        // 카카오 로그인하기
        Long id = userService.loginUserEntity(kakaoProfile);

        // HTTP 상태 반환
        HttpStatus httpStatus = (id != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (id != null) ? "Login Success" : "Login Fail");
        requestMap.put("id", id);

        // 헤더 추가 및 Redirect:
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("http://localhost:3333/"));

        return ResponseEntity.status(httpStatus).headers(headers).body(requestMap);
    }
}
