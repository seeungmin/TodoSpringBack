package com.riding.todoback.controller;

import com.riding.todoback.model.DTO.RequestFinishTodoDelete;
import com.riding.todoback.model.DTO.RequestFinishTodoInput;
import com.riding.todoback.model.DTO.RequestPreviewFinishTodoAll;
import com.riding.todoback.service.FinishTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin("*")
public class FinishTodoController {

    FinishTodoService finishTodoService;

    @Autowired
    public FinishTodoController(FinishTodoService finishTodoService) {
        this.finishTodoService = finishTodoService;
    }


    // 다 한 일 조회
    @GetMapping("finishTodos/user/{userId}")
    @ResponseBody
    public List<RequestPreviewFinishTodoAll> getFinishTodos(@PathVariable String userId){
        return finishTodoService.getFinishTodosEntity(userId);
    }




    // 다 한 일 입력 후 저장
    @PostMapping("finishTodo")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> saveFinishTodo(@RequestBody RequestFinishTodoInput requestFinishTodoInput){
        Long id = finishTodoService.saveFinishTodoEntity(requestFinishTodoInput);

        // HTTP 상태 반환
        HttpStatus httpStatus = (id != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (id != null) ? "Create Success" : "Create Fail");
        requestMap.put("id", id);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }




    // 다 한 일 삭제
    @DeleteMapping("finishTodo")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteFinishTodo(@RequestBody RequestFinishTodoDelete requestFinishTodoDelete){
        Long id = finishTodoService.deleteFinishTodoEntity(requestFinishTodoDelete);

        // HTTP 상태 반환
        HttpStatus httpStatus = (id != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (id != null) ? "Delete Success" : "Delete Fail");
        requestMap.put("id", id);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
