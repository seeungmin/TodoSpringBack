package com.riding.todoback.controller;

import com.riding.todoback.model.RequestFinishTodoDelete;
import com.riding.todoback.model.RequestTodoDelete;
import com.riding.todoback.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class TodoListController {
    @Autowired
    TodoListService todoListService;

    // 할 일 입력 후 저장
    @GetMapping("todo/{input}")
    @ResponseBody
    public long todoInput(@PathVariable String input){
        return todoListService.saveTodoEntity(input);
    }

    @PostMapping("todo")
    @ResponseBody
    public long todoInput0(@RequestParam("content") String content){
        return todoListService.saveTodoEntity(content);
    }



    // 다 한 일 입력 후 저장
    @GetMapping("finishTodo/{id}")
    @ResponseBody
    public long finishedTodoInput(@PathVariable long id){
        todoListService.saveFinishedTodoEntity(id);
        return id;
    }

    @PostMapping("finishTodo0")
    @ResponseBody
    public long finishedTodoInput0(@RequestParam("id") long id){
        todoListService.saveFinishedTodoEntity(id);
        return id;
    }




    // 할 일 데이터 수정
    @GetMapping("modifyTodo/{id}")
    public void todoModify(@PathVariable long id, @RequestParam("input") String input ){
        todoListService.modifyTodoEntity(id, input);
    }

    @PostMapping("modifyTodo0")
    @ResponseBody
    public void todoModify0(@RequestParam("id") long id, @RequestParam("content") String content){
        todoListService.modifyTodoEntity(id, content);
    }




    // 휴지통 기능이 있어도 괜찮을거 같은데?
    // 할 일 삭제
    @PostMapping("todoDelete")
    @ResponseBody
    public ResponseEntity<String> todoDelete(@RequestBody RequestTodoDelete requestTodoDelete){
        boolean delete = todoListService.deleteTodoEntity(Long.parseLong(requestTodoDelete.getId()));

        if(delete){
            return ResponseEntity.ok("delete success");
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("fail");
        }
    }


    // 다 한 일 삭제
    @PostMapping("finishTodoDelete")
    @ResponseBody
    public ResponseEntity<String> finishedTodoDelete(@RequestBody RequestFinishTodoDelete requestFinishTodoDelete){
        boolean delete = todoListService.deleteFinishedTodoEntity(Long.parseLong(requestFinishTodoDelete.getId()));

        if(delete){
            return ResponseEntity.ok("delete success");
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("fail");
        }
    }
}
