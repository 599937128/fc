package com.lv.web.dto.user;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 使用lombok 简化代码
 */
@Data
public class User {

    /**
     * id 主键
     */
    private Integer id;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 手机号
     */
    @NotNull(message = "手机号不能为空")
    private String mobile;
    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    private String pwd;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 用户头像id
     */
    private String headImgId;
}
