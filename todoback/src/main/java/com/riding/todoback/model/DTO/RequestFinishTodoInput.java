package com.riding.todoback.model.DTO;

import lombok.Data;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
public class RequestFinishTodoInput {
    private long id;
    String member_Id;
    String content;
    LocalDateTime uploadTime;
    LocalDateTime completionTime;
}
