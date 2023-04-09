package com.riding.todoback.model.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestPreviewTodoAll {
    long id;
    String member_Id;
    String content;
    LocalDateTime uploadTime;
    LocalDateTime modifyTime;
}
