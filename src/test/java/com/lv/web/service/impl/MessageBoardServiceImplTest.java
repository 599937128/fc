package com.lv.web.service.impl;

import com.lv.web.WebApplicationTests;
import com.lv.web.dto.messageboard.MessageBoard;
import com.lv.web.service.MessageBoardService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class MessageBoardServiceImplTest extends WebApplicationTests {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageBoardService messageBoardService;

    @Test
    public void insert() {
        MessageBoard messageBoard = new MessageBoard();
        messageBoard.setLeaveUserId(6);
        messageBoard.setUserId(3);
        messageBoard.setContent("lifdsbn非常定慧寺偶发不能");
        messageBoardService.insert(messageBoard);
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void deleteByLeaveUserId() {
        messageBoardService.deleteByLeaveUserId(6);
    }

    @Test
    public void queryAllByUserId() {
        List<MessageBoard> messageBoards = messageBoardService.queryAllByUserId(3);
        logger.info("留言信息为--{}", messageBoards);

    }
}
