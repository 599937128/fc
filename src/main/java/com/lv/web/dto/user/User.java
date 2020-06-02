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
    private String userName;
    /**
     * 密码
     */
    private String passWord;
}
