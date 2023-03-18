package com.riding.todoback.controller;

import com.riding.todoback.entity.BoardEntity;
import com.riding.todoback.entity.CashBoardEntity;
import com.riding.todoback.service.MemoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {

    MemoListService memoListService;

    @Autowired
    public BoardController(MemoListService memoListService) {
        this.memoListService = memoListService;
    }

    // 메모 preview 조회
    @GetMapping("previewCashBoard")
    @ResponseBody
    public List<CashBoardEntity> inquirePreviewCashBoard(){
        return memoListService.inquireCashBoardEntity();
    }


    /*@PostMapping("/postMethod")
    @ResponseBody
    public BoardEntity postMethod(@RequestBody BoardEntity boardEntity) {
        return boardEntity;
    }*/

    // 메모 detail 조회
    @GetMapping("detailBoard/{id}")
    @ResponseBody
    public BoardEntity inquireDetailBoard(@PathVariable long id){
        return memoListService.inquireBoardEntity(id);
    }
}
