package com.riding.todoback.controller;

import com.riding.todoback.entity.BoardEntity;
import com.riding.todoback.service.MemoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemoListController {
    MemoListService memoListService;

    @Autowired
    public MemoListController(MemoListService memoListService) {
        this.memoListService = memoListService;
    }

    // 메모장 데이터 입력 저장 및 스토리보드 데이터 캐싱 후 저장
    @GetMapping("board/{input}")
    public void boardInput(@PathVariable String input){
        memoListService.saveBoardEntity(input);
    }

    @PostMapping("board")
    public void boardInput0(@RequestParam("content") String content){
        memoListService.saveBoardEntity(content);
    }

    // 메모장 임시저장 데이터 저장
   /* @GetMapping("temporaryMemo")
    public void temporaryMemoInput(){
        memoListService.saveTemporaryMemoEntity();
    }*/
}
