package com.lv.web.service.impl;

import com.lv.web.WebApplicationTests;
import com.lv.web.dto.user.User;
import com.lv.web.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImplTest extends WebApplicationTests {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Test
    public void getUserByMobile() {
        User userByMobile = userService.getUserByMobile("13201452178");
        if (userByMobile.getPwd().equals(DigestUtils.md5Hex("12345678").toUpperCase())) {
            logger.info("hfdsihfisdhi---lllll");
        }
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setMobile("13201452178");
        user.setName("张三");
        user.setPwd("12345678");
        userService.addUser(user);
    }

    @Test
    public void del() {
    }
}
