package com.riding.todoback.controller;

import com.riding.todoback.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class TodoListController {
    @Autowired
    TodoListService todoListService;

    // 할 일 입력 후 저장
    @GetMapping("todo/{input}")
    public void todoInput(@PathVariable String input){
        todoListService.saveTodoEntity(input);
    }


    // 다 한 일 입력 후 저장
    @GetMapping("finishTodo/{id}")
    public void finishedTodoInput(@PathVariable long id){
        todoListService.saveFinishedTodoEntity(id);
    }

}
