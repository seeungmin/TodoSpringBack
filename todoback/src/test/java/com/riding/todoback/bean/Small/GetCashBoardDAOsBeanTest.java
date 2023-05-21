package com.riding.todoback.bean.Small;

import com.riding.todoback.model.entity.CashBoardEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class GetCashBoardDAOsBeanTest {

    @Autowired GetCashBoardDAOsBean getCashBoardDAOsBean;

    @Test
    void find_cash_board_all() {
        CashBoardEntity cashBoardEntity1 = new CashBoardEntity();
        cashBoardEntity1.setUserId("122");
        cashBoardEntity1.setId(111L);
        CashBoardEntity cashBoardEntity2 = new CashBoardEntity();
        cashBoardEntity2.setUserId("122");
        cashBoardEntity2.setId(222L);

        getCashBoardDAOsBean.cashBoardRepositoryJPA.save(cashBoardEntity1);
        getCashBoardDAOsBean.cashBoardRepositoryJPA.save(cashBoardEntity2);

        assertThat(cashBoardEntity1.getId()).isEqualTo(getCashBoardDAOsBean.exec("122").get(0).getId());
        assertThat(cashBoardEntity2.getId()).isEqualTo(getCashBoardDAOsBean.exec("122").get(1).getId());
    }
}