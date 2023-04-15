package com.riding.todoback.bean;

import com.riding.todoback.bean.Small.GenerateUniqueIdBean;
import com.riding.todoback.bean.Small.NewObjectDAOBean;
import com.riding.todoback.bean.Small.SaveDAOBean;
import com.riding.todoback.model.DTO.RequestTodoInput;
import com.riding.todoback.model.entity.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SaveTodoBean {


    SaveDAOBean saveDAOBean;
    NewObjectDAOBean newObjectDAOBean;
    GenerateUniqueIdBean generateUniqueIdBean;
    @Autowired
    public SaveTodoBean(SaveDAOBean saveDAOBean, NewObjectDAOBean newObjectDAOBean, GenerateUniqueIdBean generateUniqueIdBean) {
        this.saveDAOBean = saveDAOBean;
        this.newObjectDAOBean = newObjectDAOBean;
        this.generateUniqueIdBean = generateUniqueIdBean;
    }

    // 할 일 데이터 저장
    public long exec(RequestTodoInput requestTodoInput){
        // 아이디 생성
        long id = generateUniqueIdBean.exec();

        // 할 일 저장할 객체 생성
        TodoEntity todoEntity = newObjectDAOBean.exec(id, requestTodoInput);

        // 데이터 저장
        saveDAOBean.exec(todoEntity);

        return id;
    }
}
