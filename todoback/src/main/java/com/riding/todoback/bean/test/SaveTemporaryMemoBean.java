package com.riding.todoback.bean.test;

import com.riding.todoback.bean.Small.GenerateUniqueIdBean;
import com.riding.todoback.model.entity.test.TemporaryMemoEntity;
import com.riding.todoback.repository.BoardRepositoryJPA;
import com.riding.todoback.repository.test.TemporaryMemoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class SaveTemporaryMemoBean {

    GenerateUniqueIdBean generateUniqueIdBean;
    TemporaryMemoRepositoryJPA temporaryMemoRepositoryJPA;
    BoardRepositoryJPA boardRepositoryJPA;

    @Autowired
    public SaveTemporaryMemoBean(GenerateUniqueIdBean generateUniqueIdBean, TemporaryMemoRepositoryJPA temporaryMemoRepositoryJPA, BoardRepositoryJPA boardRepositoryJPA) {
        this.generateUniqueIdBean = generateUniqueIdBean;
        this.temporaryMemoRepositoryJPA = temporaryMemoRepositoryJPA;
        this.boardRepositoryJPA = boardRepositoryJPA;
    }

    // 스케쥴링은 나중에 하자
    // 스케쥴링해서 데이터 10초마다 저장
    public void exec(){
        // 아이디 생성
        long id = generateUniqueIdBean.exec();
        long id2 = 0L;

        // 시간 생성
        LocalDateTime time = LocalDateTime.now();

        // 데이터 가져오기
        String data = boardRepositoryJPA.findById(id2).get().getContent();

        // 데이터 저장하기
        TemporaryMemoEntity temporaryMemoEntity = new TemporaryMemoEntity(id, time, data);
        temporaryMemoRepositoryJPA.save(temporaryMemoEntity);

        // DB 데이터 갯수가 4개 이상이면 가장 오래된 데이터 삭제
        if(countData()>3){
            deleteOldestData();
        }
    }

    // DB에 총 데이터 갯수 구하기
    private long countData(){
        return temporaryMemoRepositoryJPA.count();
    }

    // 가장 오래된 데이터 삭제
    private void deleteOldestData() {

        // DB 전체 데이터를 시간순으로 정렬해서 로컬에 저장
        List<TemporaryMemoEntity> entityList = temporaryMemoRepositoryJPA.findAll(Sort.by(Sort.Direction.ASC, "regularTime"));

        // DB에 데이터 있을 때 정렬된 데이터의 첫번째 데이터 삭제
        if (entityList.size() > 0) {
            TemporaryMemoEntity temporaryMemoOldData = entityList.get(0);
            temporaryMemoRepositoryJPA.delete(temporaryMemoOldData);
        }
    }

}
