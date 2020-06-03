package com.lv.web.service.impl;

import com.lv.web.WebApplicationTests;
import com.lv.web.dto.user.User;
import com.lv.web.service.UserService;
import com.lv.web.util.TimeUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImplTest extends WebApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void getUserByMobile() {
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setMobile("13201452178");
        user.setCreateTime(TimeUtil.dateToTime());
        user.setName("hidsjids");
        user.setPwd("12345678");
        userService.addUser(user);
    }

    @Test
    public void del() {
    }
}
