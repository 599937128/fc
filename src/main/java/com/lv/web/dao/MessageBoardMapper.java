package com.lv.web.dao;

import com.lv.web.dto.messageboard.MessageBoard;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (TMessageBoard)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-06 21:50:19
 */
@Repository
public interface MessageBoardMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MessageBoard queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<MessageBoard> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param messageBoard 实例对象
     * @return 对象列表
     */
    List<MessageBoard> queryAll(MessageBoard messageBoard);

    /**
     * 新增数据
     *
     * @param messageBoard 实例对象
     * @return 影响行数
     */
    int insert(MessageBoard messageBoard);

    /**
     * 修改数据
     *
     * @param messageBoard 实例对象
     * @return 影响行数
     */
    int update(MessageBoard messageBoard);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 根据留言id删除留言信息
     *
     * @param leaveUserId 留言用户id
     * @return 影响行数
     */
    int deleteByLeaveUserId(@Param("leaveUserId") int leaveUserId);

    /**
     * 获取被留言用户的留言信息
     *
     * @param userId 查询起始位置
     * @return 对象列表
     */
    List<MessageBoard> queryAllByUserId(@Param("userId") int userId);

}