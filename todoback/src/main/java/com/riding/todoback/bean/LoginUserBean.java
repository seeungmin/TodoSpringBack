package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.GetUserDAOBean;
import com.riding.todoback.model.DTO.KakaoProfile;
import com.riding.todoback.model.DTO.RequestUserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginUserBean {

    GetUserDAOBean getUserDAOBean;
    SaveUserBean saveUserBean;

    @Autowired
    public LoginUserBean(GetUserDAOBean getUserDAOBean, SaveUserBean saveUserBean) {
        this.getUserDAOBean = getUserDAOBean;
        this.saveUserBean = saveUserBean;
    }

    // 로그인
    public long exec(RequestUserInput requestUserInput){

        // 같은 아이디가 존재하면 해당되는 아이디의 고유 값 반환
        if(getUserDAOBean.exec(requestUserInput) != null)
            return requestUserInput.getId();

        // 아이디가 없으면 회원가입
        return saveUserBean.exec(requestUserInput);
    }

    // 로그인
    public long exec(KakaoProfile kakaoProfile){

        // 같은 아이디가 존재하면 해당되는 아이디의 고유 값 반환
        Long id = getUserDAOBean.exec(kakaoProfile);
        if(id != null)
            return id;

        // 아이디가 없으면 회원가입
        return saveUserBean.exec(kakaoProfile);
    }
}
