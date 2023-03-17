package com.riding.todoback.controller;

import com.riding.todoback.entity.BoardEntity;
import com.riding.todoback.service.MemoListService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {

    MemoListService memoListService;

    @Autowired
    public BoardController(MemoListService memoListService) {
        this.memoListService = memoListService;
    }

    // 메모 preview 조회


    // 메모 detail 조회
    @PostMapping("detailBoard")
    public BoardEntity inquireDetailBoard(long id){
        return memoListService.inquireBoardEntity(id);
    }
}
