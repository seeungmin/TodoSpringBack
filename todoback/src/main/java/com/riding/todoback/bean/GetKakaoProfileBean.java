package com.riding.todoback.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.riding.todoback.bean.Small.*;
import com.riding.todoback.model.DTO.KakaoProfile;
import com.riding.todoback.model.DTO.OAuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

@Component
public class GetKakaoProfileBean {

    NewHeaderDAOBean newHeaderDAOBean;
    NewHttpDAOBean newHttpDAOBean;
    NewKakaoProfileDAOBean newKakaoProfileDAOBean;
    GetKakaoProfileDAOBean getKakaoProfileDAOBean;

    @Autowired
    public GetKakaoProfileBean(NewHeaderDAOBean newHeaderDAOBean, NewHttpDAOBean newHttpDAOBean, NewKakaoProfileDAOBean newKakaoProfileDAOBean, GetKakaoProfileDAOBean getKakaoProfileDAOBean) {
        this.newHeaderDAOBean = newHeaderDAOBean;
        this.newHttpDAOBean = newHttpDAOBean;
        this.newKakaoProfileDAOBean = newKakaoProfileDAOBean;
        this.getKakaoProfileDAOBean = getKakaoProfileDAOBean;
    }

    public KakaoProfile exec(OAuthToken oAuthToken) throws JsonProcessingException {

        // 헤더 생성하기
        HttpHeaders httpHeaders = newHeaderDAOBean.exec(oAuthToken);

        // 헤더와 바디 합치기
        HttpEntity<MultiValueMap<String, String>> httpEntity = newHttpDAOBean.exec(httpHeaders);

        // 카카오 프로필 정보 가져오기
        ResponseEntity<String> response = newKakaoProfileDAOBean.exec(httpEntity);

        // 매핑 후 Profile 정보 반환
        return getKakaoProfileDAOBean.exec(response);
    }
}
