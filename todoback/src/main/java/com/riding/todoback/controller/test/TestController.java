package com.riding.todoback.controller.test;

import com.riding.todoback.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {
    @Autowired
    TestService testService;

    /*@GetMapping("test/{input}")
    public void testInput(@PathVariable String input){
        testService.saveTestEntity(input);
    }*/
}
