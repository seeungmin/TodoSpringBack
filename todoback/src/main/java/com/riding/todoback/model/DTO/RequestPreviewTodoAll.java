package com.riding.todoback.model.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestPreviewTodoAll {
    long id;
    String userId;
    String content;
    LocalDateTime uploadTime;
    LocalDateTime modifyTime;
}
