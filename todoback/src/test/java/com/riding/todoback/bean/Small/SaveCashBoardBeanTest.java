package com.riding.todoback.bean.Small;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SaveCashBoardBeanTest {

    @Autowired SaveCashBoardBean saveCashBoardBean;
    @Test
    void save_cash_board_algorithm_long() {
        String test = "테스트를 위한 메세지 입니다.";

        String result = saveCashBoardBean.exec(test);

        assertThat(result).isEqualTo("테스트를 위한 메세");
    }

    @Test
    void save_cash_board_algorithm_short() {
        String test = "테스트 메세지";

        String result = saveCashBoardBean.exec(test);

        assertThat(test).isEqualTo(result);
    }
}