package com.riding.todoback.controller;

import com.riding.todoback.model.DTO.RequestBoardDelete;
import com.riding.todoback.model.DTO.RequestBoardInput;
import com.riding.todoback.model.DTO.RequestBoardModify;
import com.riding.todoback.model.DTO.RequestDetailBoardInquire;
import com.riding.todoback.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@CrossOrigin("*")
public class BoardController {
    BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    // 메모 조회
    @GetMapping("board/{id}/user/{userId}")
    @ResponseBody
    public RequestDetailBoardInquire getBoard(@PathVariable String userId, @PathVariable long id){
        return boardService.getBoardEntity(id, userId);
    }


    // 메모장 데이터 입력 저장 및 스토리보드 데이터 캐싱 후 저장
    @PostMapping("board")
    public ResponseEntity<Map<String, Object>> saveBoard(@RequestBody RequestBoardInput requestBoardInput){
        Long id = boardService.saveBoardEntity(requestBoardInput);

        // HTTP 상태 반환
        HttpStatus httpStatus = (id != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (id != null) ? "Create Success" : "Create Fail");
        requestMap.put("id", id);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }


    // 메모장 데이터 수정 및 스토리보드 데이터 캐싱 후 저장
    @PutMapping("board")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> modifyBoard(@RequestBody RequestBoardModify requestBoardModify){
        Long id = boardService.modifyBoardEntity(requestBoardModify);

        // HTTP 상태 반환
        HttpStatus httpStatus = (id != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (id != null) ? "Modify Success" : "Modify Fail");
        requestMap.put("id", id);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }


    // 메모와 해당 캐시메모 삭제
    @DeleteMapping("board")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteBoard(@RequestBody RequestBoardDelete requestBoardDelete){
        Long id = boardService.deleteBoardEntity(requestBoardDelete);

        // HTTP 상태 반환
        HttpStatus httpStatus = (id != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (id != null) ? "Delete Success" : "Delete Fail");
        requestMap.put("id", id);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }


    // 메모장 임시저장 데이터 저장
   /* @GetMapping("temporaryMemo")
    public void temporaryMemoInput(){
        memoListService.saveTemporaryMemoEntity();
    }*/
}
