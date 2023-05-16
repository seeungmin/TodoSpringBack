package com.riding.todoback.model.DTO;

import lombok.Data;

@Data
public class RequestTodoInput {
    String userId;
    String content;
}
