package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.GenerateUniqueIdBean;
import com.riding.todoback.bean.Small.SaveBoardDTOBean;
import com.riding.todoback.bean.Small.SaveCashBoardBean;
import com.riding.todoback.bean.Small.SaveStoryBoardDTOBean;
import com.riding.todoback.entity.BoardEntity;
import com.riding.todoback.entity.CashBoardEntity;
import com.riding.todoback.repository.BoardRepositoryJPA;
import com.riding.todoback.repository.CashBoardRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SaveBoardBean {

    SaveBoardDTOBean saveBoardDTOBean;
    SaveStoryBoardDTOBean saveStoryBoardDTOBean;

    @Autowired
    public SaveBoardBean(SaveBoardDTOBean saveBoardDTOBean, SaveStoryBoardDTOBean saveStoryBoardDTOBean) {
        this.saveBoardDTOBean = saveBoardDTOBean;
        this.saveStoryBoardDTOBean = saveStoryBoardDTOBean;
    }

    // 아이디를 입력받고 쿼리문으로 데이터 찾아보는과정을 넣으면 되려나?
    // 메모장 데이터와 스토리보드 캐시 데이터 저장
    public boolean exec(String title, String input){

        boolean s1 = saveBoardDTOBean.exec(title, input);

        boolean s2 = saveStoryBoardDTOBean.exec(title, input);

        if(s1 && s2)
            return true;
        return false;
    }

}
