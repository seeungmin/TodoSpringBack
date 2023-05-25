package com.riding.todoback.controller;

import com.riding.todoback.model.DTO.RequestDetailBoardInquire;
import com.riding.todoback.model.DTO.RequestPreviewCashBoardAll;
import com.riding.todoback.service.MemoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
public class BoardController {

    MemoListService memoListService;

    @Autowired
    public BoardController(MemoListService memoListService) {
        this.memoListService = memoListService;
    }

    // 전채 메모 preview 조회
    @GetMapping("cashBoard/list/{userId}")
    @ResponseBody
    public List<RequestPreviewCashBoardAll> allPreviewCashBoard(@PathVariable String userId){
        return memoListService.allCashBoardEntity(userId);
    }


    // 메모 detail 조회
    @GetMapping("board/{userId}/{id}")
    @ResponseBody
    public RequestDetailBoardInquire inquireDetailBoard(@PathVariable String userId, @PathVariable long id){
        return memoListService.inquireBoardEntity(id);
    }
}
