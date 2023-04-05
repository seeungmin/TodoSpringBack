package com.riding.todoback.model.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestDetailBoardInquire {
    Long id;
    String content;
    LocalDateTime uploadTime;
}
