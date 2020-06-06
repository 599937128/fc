package com.lv.web.dto.login;

import lombok.Data;

@Data
public class LoginForm {

    /**
     * 登陆名
     */
    private String mobile;
    /**
     * 图片验证码
     */
    private String validimage;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 登录模式
     */
    private String loginType;
}
