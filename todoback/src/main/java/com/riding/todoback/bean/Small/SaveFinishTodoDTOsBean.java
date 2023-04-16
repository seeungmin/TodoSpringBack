package com.riding.todoback.bean.Small;

import com.riding.todoback.model.DTO.RequestPreviewFinishTodoAll;
import com.riding.todoback.model.entity.FinishedTodoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SaveFinishTodoDTOsBean {
    // 다 한일 전체 DTO 객체에 저장
    public List<RequestPreviewFinishTodoAll> exec(List<FinishedTodoEntity> finishedTodoEntities){
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
