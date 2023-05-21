package com.riding.todoback.bean.Small;

import com.riding.todoback.model.entity.BoardEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class GetBoardDAOBeanTest {

    @Autowired GetBoardDAOBean getBoardDAOBean;
    @Test
    void find_board_one() {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId(1L);

        getBoardDAOBean.boardRepositoryJPA.save(boardEntity);

        assertThat(boardEntity.getId()).isEqualTo(getBoardDAOBean.exec(1L).getId());
    }
}