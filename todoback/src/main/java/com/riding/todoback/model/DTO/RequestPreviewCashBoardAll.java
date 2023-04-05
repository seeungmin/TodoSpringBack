package com.riding.todoback.model.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestPreviewCashBoardAll {
    private long id;
    String cashData;
    LocalDateTime uploadTime;
}
