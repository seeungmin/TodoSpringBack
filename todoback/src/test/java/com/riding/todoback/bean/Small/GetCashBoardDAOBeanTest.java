package com.riding.todoback.bean.Small;

import com.riding.todoback.model.entity.CashBoardEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class GetCashBoardDAOBeanTest {

    @Autowired GetCashBoardDAOBean getCashBoardDAOBean;

    @Test
    void find_cash_board_one() {
        CashBoardEntity cashBoardEntity = new CashBoardEntity();
        cashBoardEntity.setId(1L);

        getCashBoardDAOBean.cashBoardRepositoryJPA.save(cashBoardEntity);

        assertThat(cashBoardEntity.getId()).isEqualTo(getCashBoardDAOBean.exec(1L).getId());
    }
}