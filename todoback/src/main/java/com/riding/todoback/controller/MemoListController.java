package com.riding.todoback.controller;

import com.riding.todoback.entity.BoardEntity;
import com.riding.todoback.service.MemoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@EnableScheduling
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

    /*@GetMapping("cashBoard/{input}")
    public void cashBoardInput(){
        memoListService.saveCashBoardEntity();
    }*/

    // 메모장 임시저장 데이터 저장
    @GetMapping("temporaryMemo")
    public void temporaryMemoInput(){
        memoListService.saveTemporaryMemoEntity();
    }
}
