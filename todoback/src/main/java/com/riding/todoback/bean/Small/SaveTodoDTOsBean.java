package com.riding.todoback.bean.Small;

import com.riding.todoback.model.DTO.RequestPreviewTodoAll;
import com.riding.todoback.model.entity.TodoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SaveTodoDTOsBean {

    // 할 일 전체 DTO 객체에 저장
    public List<RequestPreviewTodoAll> exec(List<TodoEntity> todoEntities){
        // 할 일에 있는 데이터를 옮겨서 저장할 리스트 저장
        List<RequestPreviewTodoAll> requestPreviewTodoAllList = new ArrayList<>();

        // 새로운 객체에 데이터를 저장하고 List 에 추가
        for (TodoEntity todoEntity: todoEntities) {
            RequestPreviewTodoAll requestPreviewTodoAll = new RequestPreviewTodoAll();
            requestPreviewTodoAll.setId(todoEntity.getId());
            requestPreviewTodoAll.setUserId(todoEntity.getUserId());
            requestPreviewTodoAll.setContent(todoEntity.getContent());
            requestPreviewTodoAll.setUploadTime(todoEntity.getUploadTime());
            requestPreviewTodoAll.setModifyTime(todoEntity.getModifyTime());
            requestPreviewTodoAllList.add(requestPreviewTodoAll);
        }

        // 데이터가 옮겨진 List 를 반환
        return requestPreviewTodoAllList;
    }
}
