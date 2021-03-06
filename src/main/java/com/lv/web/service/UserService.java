package com.lv.web.service;

import com.lv.web.dto.user.User;

public interface UserService {

    /**
     * 根据用户名 获取用户信息
     *
     * @param userName
     * @return
     */
    User getUserByMobile(String userName);

    /**
     * 新增用户信息
     *
     * @param user
     */
    void addUser(User user);

    /**
     * 通过 id 删除用户信息
     *
     * @param id
     */
    void del(String id);


    /**
     * 更新用户信息
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据用户id获取用户信息
     *
     * @param id
     * @return
     */
    User getUserById(Integer id);


}
