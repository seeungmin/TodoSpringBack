package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.GenerateUniqueIdBean;
import com.riding.todoback.bean.Small.SaveBoardDTOBean;
import com.riding.todoback.bean.Small.SaveStoryBoardDTOBean;
import com.riding.todoback.model.DTO.RequestBoardInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveBoardBean {

    GenerateUniqueIdBean generateUniqueIdBean;
    SaveBoardDTOBean saveBoardDTOBean;
    SaveStoryBoardDTOBean saveStoryBoardDTOBean;

    @Autowired
    public SaveBoardBean(GenerateUniqueIdBean generateUniqueIdBean, SaveBoardDTOBean saveBoardDTOBean, SaveStoryBoardDTOBean saveStoryBoardDTOBean) {
        this.generateUniqueIdBean = generateUniqueIdBean;
        this.saveBoardDTOBean = saveBoardDTOBean;
        this.saveStoryBoardDTOBean = saveStoryBoardDTOBean;
    }

    // 아이디를 입력받고 쿼리문으로 데이터 찾아보는과정을 넣으면 되려나?
    // 메모장 데이터와 스토리보드 캐시 데이터 저장
    public boolean exec(RequestBoardInput requestBoardInput){

        long id = generateUniqueIdBean.exec();

        boolean s1 = saveBoardDTOBean.exec(id, requestBoardInput);

        boolean s2 = saveStoryBoardDTOBean.exec(id, requestBoardInput);

        if(s1 && s2)
            return true;
        return false;
    }

}
