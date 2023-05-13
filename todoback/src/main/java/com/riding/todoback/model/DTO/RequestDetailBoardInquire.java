package com.riding.todoback.model.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestDetailBoardInquire {
    long id;
    String userId;
    String title;
    String content;
    LocalDateTime uploadTime;
    LocalDateTime modifyTime;
}
