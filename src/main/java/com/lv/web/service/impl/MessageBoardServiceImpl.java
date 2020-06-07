package com.lv.web.service.impl;

import com.lv.web.dao.MessageBoardMapper;
import com.lv.web.dto.messageboard.MessageBoard;
import com.lv.web.service.MessageBoardService;
import com.lv.web.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (TMessageBoard)表服务实现类
 *
 * @author makejava
 * @since 2020-06-06 21:50:20
 */
@Service
public class MessageBoardServiceImpl implements MessageBoardService {
    @Autowired
    private MessageBoardMapper messageBoardMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MessageBoard queryById(Integer id) {
        return this.messageBoardMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<MessageBoard> queryAllByLimit(int offset, int limit) {
        return this.messageBoardMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param messageBoard 实例对象
     * @return 实例对象
     */
    @Override
    public MessageBoard insert(MessageBoard messageBoard) {
        messageBoard.setCreateTime(TimeUtil.dateToTime());
        this.messageBoardMapper.insert(messageBoard);
        return messageBoard;
    }

    /**
     * 修改数据
     *
     * @param messageBoard 实例对象
     * @return 实例对象
     */
    @Override
    public MessageBoard update(MessageBoard messageBoard) {
        this.messageBoardMapper.update(messageBoard);
        return this.queryById(messageBoard.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.messageBoardMapper.deleteById(id) > 0;
    }

    @Override
    public boolean deleteByLeaveUserId(Integer leaveUserId) {
        return this.messageBoardMapper.deleteByLeaveUserId(leaveUserId) > 0;
    }

    @Override
    public List<MessageBoard> queryAllByUserId(int userId) {
        return messageBoardMapper.queryAllByUserId(userId);
    }
}