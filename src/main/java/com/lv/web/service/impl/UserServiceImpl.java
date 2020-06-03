package com.lv.web.service.impl;

import com.lv.web.dao.UserMapper;
import com.lv.web.dto.user.User;
import com.lv.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByMobile(String mobile) {
        User user = new User();
        user.setMobile(mobile);
        userMapper.queryAll(user);
        return null;
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void del(String id) {

    }
}
