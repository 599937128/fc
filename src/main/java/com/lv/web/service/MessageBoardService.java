package com.lv.web.service;

import com.lv.web.dto.messageboard.MessageBoard;

import java.util.List;

/**
 * (TMessageBoard)表服务接口
 *
 * @author makejava
 * @since 2020-06-06 21:50:19
 */
public interface MessageBoardService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MessageBoard queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<MessageBoard> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param messageBoard 实例对象
     * @return 实例对象
     */
    MessageBoard insert(MessageBoard messageBoard);

    /**
     * 修改数据
     *
     * @param messageBoard 实例对象
     * @return 实例对象
     */
    MessageBoard update(MessageBoard messageBoard);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 通过用户留言id删除数据
     *
     * @param leaveUserId
     * @return 是否成功
     */
    boolean deleteByLeaveUserId(Integer leaveUserId);

    /**
     * 根据用户id查询留言信息
     *
     * @param userId 查询起始位置
     * @return 对象列表
     */
    List<MessageBoard> queryAllByUserId(int userId);

}