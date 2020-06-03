package com.lv.web.dto.user;

import lombok.Data;

@Data
public class User {

    /**
     * id 主键
     */
    private String id;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 创建时间
     */
    private String createTime;
}
