package com.riding.todoback.controller;

import com.riding.todoback.model.DTO.*;
import com.riding.todoback.service.TodoListService;
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
public class TodoListController {

    @Autowired
    TodoListService todoListService;

    // 할 일 입력 후 저장
    @PostMapping("todo")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> todoInput(@RequestBody RequestTodoInput requestTodoInput){
        Long id = todoListService.saveTodoEntity(requestTodoInput);

        // HTTP 상태 반환
        HttpStatus httpStatus = (id != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (id != null) ? "Create Success" : "Create Fail");
        requestMap.put("id", id);

        return ResponseEntity.status(httpStatus).body(requestMap);

    }



    // 다 한 일 입력 후 저장
    @PostMapping("finishTodo")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> finishedTodoInput(@RequestBody RequestFinishTodoInput requestFinishTodoInput){
        Long id = todoListService.saveFinishedTodoEntity(requestFinishTodoInput);

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
        Long id = todoListService.modifyTodoEntity(requestTodoModify);

        // HTTP 상태 반환
        HttpStatus httpStatus = (id != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (id != null) ? "Modify Success" : "Modify Fail");
        requestMap.put("id", id);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }




    // 휴지통 기능이 있어도 괜찮을거 같은데?
    // 할 일 삭제
    @DeleteMapping("todo")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> todoDelete(@RequestBody RequestTodoDelete requestTodoDelete){
        Long id = todoListService.deleteTodoEntity(requestTodoDelete);

        // HTTP 상태 반환
        HttpStatus httpStatus = (id != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (id != null) ? "Delete Success" : "Delete Fail");
        requestMap.put("id", id);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }


    // 다 한 일 삭제
    @PostMapping("finishTodoDelete")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> finishedTodoDelete(@RequestBody RequestFinishTodoDelete requestFinishTodoDelete){
        Long id = todoListService.deleteFinishedTodoEntity(requestFinishTodoDelete);

        // HTTP 상태 반환
        HttpStatus httpStatus = (id != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (id != null) ? "Delete Success" : "Delete Fail");
        requestMap.put("id", id);

        return ResponseEntity.status(httpStatus).body(requestMap);

    }


    // 할 일 조회
    @GetMapping("previewTodo/{userId}")
    @ResponseBody
    public List<RequestPreviewTodoAll> allPreviewTodo(@PathVariable String userId){
        return todoListService.showTodoAllEntity(userId);
    }

    // 다 한 일 조회
    @GetMapping("previewFinishTodo/{userId}")
    @ResponseBody
    public List<RequestPreviewFinishTodoAll> allPreviewFinishTodo(@PathVariable String userId){
        return todoListService.showFinishTodoAllEntity(userId);
    }
}
