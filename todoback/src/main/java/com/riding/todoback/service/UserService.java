package com.riding.todoback.service;

import com.riding.todoback.bean.LoginUserBean;
import com.riding.todoback.model.DTO.RequestUserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    LoginUserBean loginUserBean;

    @Autowired
    public UserService(LoginUserBean loginUserBean) {
        this.loginUserBean = loginUserBean;
    }

    /**
     *  로그인
     */
    public Long loginUserEntity(RequestUserInput requestUserInput){
        return loginUserBean.exec(requestUserInput);
    }
}
