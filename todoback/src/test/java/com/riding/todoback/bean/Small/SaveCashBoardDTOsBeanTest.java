package com.riding.todoback.bean.Small;

import com.riding.todoback.model.DTO.RequestPreviewCashBoardAll;
import com.riding.todoback.model.entity.CashBoardEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SaveCashBoardDTOsBeanTest {

    @Autowired SaveCashBoardDTOsBean saveCashBoardDTOsBean;

    @Test
    void cash_board_DTOs_all() {

        List<CashBoardEntity> cashBoardEntityList = new ArrayList<>();

        CashBoardEntity cashBoardEntity1 = new CashBoardEntity();
        cashBoardEntity1.setId(1L);
        cashBoardEntity1.setUserId("1");
        cashBoardEntity1.setTitle("테스트 제목");
        cashBoardEntity1.setCashData("테스트 내용");
        cashBoardEntity1.setUploadTime(LocalDateTime.now());
        cashBoardEntity1.setModifyTime(LocalDateTime.now());

        CashBoardEntity cashBoardEntity2 = new CashBoardEntity();
        cashBoardEntity2.setId(2L);
        cashBoardEntity2.setUserId("2");
        cashBoardEntity2.setTitle("테스트 제목2");
        cashBoardEntity2.setCashData("테스트 내용2");
        cashBoardEntity2.setUploadTime(LocalDateTime.now());
        cashBoardEntity2.setModifyTime(LocalDateTime.now());

        cashBoardEntityList.add(cashBoardEntity1);
        cashBoardEntityList.add(cashBoardEntity2);

        List<RequestPreviewCashBoardAll> test = saveCashBoardDTOsBean.exec(cashBoardEntityList);

        assertThat(test.get(0).getCashData()).isEqualTo("테스트 내용");
        assertThat(test.get(1).getCashData()).isEqualTo("테스트 내용2");

    }
}