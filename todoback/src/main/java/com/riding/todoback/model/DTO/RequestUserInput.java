package com.riding.todoback.model.DTO;

import lombok.Data;

@Data
public class RequestUserInput {
    Long id;
    String userId;
    //String password;
    String nickName;
    String email;
}
