package com.riding.todoback.model.DTO;

import lombok.Data;


@Data
public class RequestTodoModify {
    Long id;
    String userId;
    String content;
}
