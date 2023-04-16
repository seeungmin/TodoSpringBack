package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.GetFinishTodoDAOsBean;
import com.riding.todoback.bean.Small.SaveFinishTodoDTOsBean;
import com.riding.todoback.model.DTO.RequestPreviewFinishTodoAll;
import com.riding.todoback.model.entity.FinishedTodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowFinishTodoBean {

    GetFinishTodoDAOsBean getFinishTodoDAOsBean;
    SaveFinishTodoDTOsBean saveFinishTodoDTOsBean;

    @Autowired
    public ShowFinishTodoBean(GetFinishTodoDAOsBean getFinishTodoDAOsBean, SaveFinishTodoDTOsBean saveFinishTodoDTOsBean) {
        this.getFinishTodoDAOsBean = getFinishTodoDAOsBean;
        this.saveFinishTodoDTOsBean = saveFinishTodoDTOsBean;
    }


    // 다 한일 모든 객체 DTO로 반환
    public List<RequestPreviewFinishTodoAll> exec(){
        // 다 한 일 전부 찾기
        List<FinishedTodoEntity> finishedTodoEntities = getFinishTodoDAOsBean.exec();

        // 다 한 일 전부를 DTO에 저장 및 반환
        return saveFinishTodoDTOsBean.exec(finishedTodoEntities);
    }
}
