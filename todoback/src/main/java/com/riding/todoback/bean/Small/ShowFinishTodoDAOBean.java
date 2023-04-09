package com.riding.todoback.bean.Small;

import com.riding.todoback.entity.FinishedTodoEntity;
import com.riding.todoback.entity.TodoEntity;
import com.riding.todoback.model.DTO.RequestPreviewFinishTodoAll;
import com.riding.todoback.model.DTO.RequestPreviewTodoAll;
import com.riding.todoback.repository.FinishedTodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShowFinishTodoDAOBean {
    FinishedTodoRepositoryJPA finishedTodoRepositoryJPA;

    @Autowired
    public ShowFinishTodoDAOBean(FinishedTodoRepositoryJPA finishedTodoRepositoryJPA) {
        this.finishedTodoRepositoryJPA = finishedTodoRepositoryJPA;
    }

    public List<RequestPreviewFinishTodoAll> exec(){
        // finishTodo 데이터를 전부 List 로 저장
        List<FinishedTodoEntity> finishedTodoEntities = new ArrayList<>(finishedTodoRepositoryJPA.findAll());

        // finishTodo 에 있는 데이터를 옮겨서 저장할 리스트 저장
        List<RequestPreviewFinishTodoAll> requestPreviewFinishTodoAllList = new ArrayList<>();

        // 새로운 객체에 데이터를 저장하고 List 에 추가
        for (FinishedTodoEntity finishedTodoEntity: finishedTodoEntities) {
            RequestPreviewFinishTodoAll requestPreviewFinishTodoAll = new RequestPreviewFinishTodoAll();
            requestPreviewFinishTodoAll.setId(finishedTodoEntity.getId());
            requestPreviewFinishTodoAll.setMember_Id(finishedTodoEntity.getMember_Id());
            requestPreviewFinishTodoAll.setContent(finishedTodoEntity.getContent());
            requestPreviewFinishTodoAll.setUploadTime(finishedTodoEntity.getUploadTime());
            requestPreviewFinishTodoAll.setCompletionTime(finishedTodoEntity.getCompletionTime());
            requestPreviewFinishTodoAllList.add(requestPreviewFinishTodoAll);
        }

        // 데이터가 옮겨진 List 를 반환
        return requestPreviewFinishTodoAllList;
    }
}
