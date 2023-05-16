package com.riding.todoback.model.DTO;

import lombok.Data;

@Data
public class RequestBoardInput {
    String userId;
    String title;
    String content;
}
