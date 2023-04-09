package com.riding.todoback.bean.Small;

import com.riding.todoback.entity.TodoEntity;
import com.riding.todoback.model.DTO.RequestPreviewTodoAll;
import com.riding.todoback.repository.TodoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShowTodoAllDAOBean {

    TodoRepositoryJPA todoRepositoryJPA;

    @Autowired
    public ShowTodoAllDAOBean(TodoRepositoryJPA todoRepositoryJPA) {
        this.todoRepositoryJPA = todoRepositoryJPA;
    }

    public List<RequestPreviewTodoAll> exec(){
        // todo 데이터를 전부 List 로 저장
        List<TodoEntity> todoEntities = new ArrayList<>(todoRepositoryJPA.findAll());

        // todo 에 있는 데이터를 옮겨서 저장할 리스트 저장
        List<RequestPreviewTodoAll> requestPreviewTodoAllList = new ArrayList<>();

        // 새로운 객체에 데이터를 저장하고 List 에 추가
        for (TodoEntity todoEntity: todoEntities) {
            RequestPreviewTodoAll requestPreviewTodoAll = new RequestPreviewTodoAll();
            requestPreviewTodoAll.setId(todoEntity.getId());
            requestPreviewTodoAll.setMember_Id(todoEntity.getMember_Id());
            requestPreviewTodoAll.setContent(todoEntity.getContent());
            requestPreviewTodoAll.setUploadTime(todoEntity.getUploadTime());
            requestPreviewTodoAll.setModifyTime(todoEntity.getModifyTime());
            requestPreviewTodoAllList.add(requestPreviewTodoAll);
        }

        // 데이터가 옮겨진 List 를 반환
        return requestPreviewTodoAllList;
    }
}
