package com.riding.todoback.controller;

import com.riding.todoback.model.DTO.RequestPreviewCashBoardAll;
import com.riding.todoback.service.CashBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin("*")
public class CashBoardController {

    CashBoardService cashBoardService;

    @Autowired
    public CashBoardController(CashBoardService cashBoardService) {
        this.cashBoardService = cashBoardService;
    }

    // 전채 메모 조회
    @GetMapping("cashBoards/user/{userId}")
    @ResponseBody
    public List<RequestPreviewCashBoardAll> getCashBoards(@PathVariable String userId){
        return cashBoardService.getCashBoardsEntity(userId);
    }
}
