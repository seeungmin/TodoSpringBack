package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.GenerateUniqueIdBean;
import com.riding.todoback.bean.Small.NewObjectDAOBean;
import com.riding.todoback.bean.Small.SaveDAOBean;
import com.riding.todoback.model.DTO.KakaoProfile;
import com.riding.todoback.model.DTO.RequestUserInput;
import com.riding.todoback.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveUserBean {

    SaveDAOBean saveDAOBean;
    NewObjectDAOBean newObjectDAOBean;
    GenerateUniqueIdBean generateUniqueIdBean;

    @Autowired
    public SaveUserBean(SaveDAOBean saveDAOBean, NewObjectDAOBean newObjectDAOBean, GenerateUniqueIdBean generateUniqueIdBean) {
        this.saveDAOBean = saveDAOBean;
        this.newObjectDAOBean = newObjectDAOBean;
        this.generateUniqueIdBean = generateUniqueIdBean;
    }

    // 회원가입
    public long exec(RequestUserInput requestUserInput){
        // 고유 값 생성
        long id = generateUniqueIdBean.exec();

        // 유저 저장할 객체 생성
        UserEntity userEntity = newObjectDAOBean.exec(id, requestUserInput);

        // 유저 저장
        saveDAOBean.exec(userEntity);

        return id;
    }

    // 회원가입
    public long exec(KakaoProfile kakaoProfile){
        // 고유 값 생성
        long id = generateUniqueIdBean.exec();

        // 유저 저장할 객체 생성
        UserEntity userEntity = newObjectDAOBean.exec(id, kakaoProfile);

        // 유저 저장
        saveDAOBean.exec(userEntity);

        return id;
    }
}
