package com.lv.web.dto.messageboard;

import lombok.Data;

import java.io.Serializable;

/**
 * (TMessageBoard)实体类
 *
 * @author makejava
 * @since 2020-06-06 21:50:18
 */
@Data
public class MessageBoard implements Serializable {
    private static final long serialVersionUID = 297315341588793721L;

    /**
     * 留言板id
     */
    private Integer id;

    /**
     * 被留言的用户id
     */
    private Integer userId;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 被留言的用户id
     */
    private String headImgId;

    /**
     * 留言用户的id
     */
    private Integer leaveUserId;

}