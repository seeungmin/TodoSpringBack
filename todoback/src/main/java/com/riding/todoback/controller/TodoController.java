package com.riding.todoback.controller;

import com.riding.todoback.model.DTO.*;
import com.riding.todoback.service.TodoService;
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
public class TodoController {

    TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    // 할 일 조회
    @GetMapping("todos/user/{userId}")
    @ResponseBody
    public List<RequestPreviewTodoAll> allPreviewTodo(@PathVariable String userId){
        return todoService.getTodosEntity(userId);
    }




    // 할 일 입력 후 저장
    @PostMapping("todo")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> todoInput(@RequestBody RequestTodoInput requestTodoInput){
        Long id = todoService.saveTodoEntity(requestTodoInput);

        // HTTP 상태 반환
        HttpStatus httpStatus = (id != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (id != null) ? "Create Success" : "Create Fail");
        requestMap.put("id", id);

        return ResponseEntity.status(httpStatus).body(requestMap);

    }




    // 할 일 데이터 수정
    @PutMapping("todo")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> todoModify(@RequestBody RequestTodoModify requestTodoModify){
        Long id = todoService.modifyTodoEntity(requestTodoModify);

        // HTTP 상태 반환
        HttpStatus httpStatus = (id != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (id != null) ? "Modify Success" : "Modify Fail");
        requestMap.put("id", id);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }




    // 할 일 삭제
    @DeleteMapping("todo")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> todoDelete(@RequestBody RequestTodoDelete requestTodoDelete){
        Long id = todoService.deleteTodoEntity(requestTodoDelete);

        // HTTP 상태 반환
        HttpStatus httpStatus = (id != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (id != null) ? "Delete Success" : "Delete Fail");
        requestMap.put("id", id);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
