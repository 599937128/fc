package com.lv.web.service.impl;

import com.lv.web.dao.UserMapper;
import com.lv.web.dto.user.User;
import com.lv.web.service.UserService;
import com.lv.web.util.TimeUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByMobile(String mobile) {
        return userMapper.queryByMobile(mobile);
    }

    @Override
    public void addUser(User user) {
        user.setCreateTime(TimeUtil.dateToTime());
        user.setPwd(DigestUtils.md5Hex(user.getPwd()).toUpperCase());
        userMapper.insert(user);
    }

    @Override
    public void del(String id) {

    }
}
