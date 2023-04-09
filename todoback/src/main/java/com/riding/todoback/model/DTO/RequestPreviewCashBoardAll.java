package com.riding.todoback.model.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestPreviewCashBoardAll {
    long id;
    String member_Id;
    String title;
    String cashData;
    LocalDateTime uploadTime;
    LocalDateTime modifyTime;
}
