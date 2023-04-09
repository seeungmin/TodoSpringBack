package com.riding.todoback.model.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestBoardModify {
    long id;
    String title;
    String content;
    LocalDateTime modifyTime;
}
