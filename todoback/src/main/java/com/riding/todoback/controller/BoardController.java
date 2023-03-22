package com.riding.todoback.controller;

import com.riding.todoback.entity.BoardEntity;
import com.riding.todoback.entity.CashBoardEntity;
import com.riding.todoback.model.RequestPreviewCashBoardAll;
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

    // 전채 메모 preview 조회
    @GetMapping("previewCashBoard")
    @ResponseBody
    public List<RequestPreviewCashBoardAll> allPreviewCashBoard(){
        return memoListService.allCashBoardEntity();
    }


    // 메모 detail 조회
    @GetMapping("detailBoard")
    @ResponseBody
    public BoardEntity inquireDetailBoard(@RequestParam("id") long id){
        return memoListService.inquireBoardEntity(id);
    }
}
