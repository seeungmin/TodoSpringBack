package com.riding.todoback.controller;

import com.riding.todoback.model.DTO.RequestBoardDelete;
import com.riding.todoback.model.DTO.RequestBoardInput;
import com.riding.todoback.model.DTO.RequestBoardModify;
import com.riding.todoback.service.MemoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@CrossOrigin("*")
public class MemoListController {
    MemoListService memoListService;

    @Autowired
    public MemoListController(MemoListService memoListService) {
        this.memoListService = memoListService;
    }

    // 메모장 데이터 입력 저장 및 스토리보드 데이터 캐싱 후 저장
    @PostMapping("board")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> boardInput(@RequestBody RequestBoardInput requestBoardInput){
        Long id = memoListService.saveBoardEntity(requestBoardInput);

        // HTTP 상태 반환
        HttpStatus httpStatus = (id != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (id != null) ? "Create Success" : "Create Fail");
        requestMap.put("id", id);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

    @PostMapping("modifyBoard")
    @ResponseBody
    public ResponseEntity<String> boardModify(@RequestBody RequestBoardModify requestBoardModify){
        boolean modify = memoListService.modifyBoardEntity(requestBoardModify);

        HttpStatus httpStatus = modify ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        return ResponseEntity.status(httpStatus).body(modify ? "Modify Success" : "Modify Fail");
    }

    @PostMapping("boardDelete")
    @ResponseBody
    public ResponseEntity<String> todoDelete(@RequestBody RequestBoardDelete requestBoardDelete){
        boolean delete = memoListService.deleteBoardEntity(requestBoardDelete);

        HttpStatus httpStatus = delete ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        return ResponseEntity.status(httpStatus).body(delete ? "Delete Success" : "Delete Fail");
    }

    // 메모장 임시저장 데이터 저장
   /* @GetMapping("temporaryMemo")
    public void temporaryMemoInput(){
        memoListService.saveTemporaryMemoEntity();
    }*/
}
