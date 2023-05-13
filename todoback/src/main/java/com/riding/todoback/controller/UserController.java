package com.riding.todoback.controller;

import com.riding.todoback.model.DTO.RequestTodoInput;
import com.riding.todoback.model.DTO.RequestUserInput;
import com.riding.todoback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
